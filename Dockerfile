FROM maven:3-jdk-8-alpine as builder

ARG LOCAL_MAVEN_MIRROR=http://maven.aliyun.com/nexus/content/groups/public/

# used to edit maven settings.xml
RUN apk add --no-cache xmlstarlet
# change default local repository location. parent image set ~/.m2 as volume, so data won't be persisted for following build cmds
RUN xmlstarlet ed --inplace -N 's=http://maven.apache.org/SETTINGS/1.0.0' \
	--subnode '/s:settings' --type elem -n localRepository -v '${user.home}/m2/repository' \
	/usr/share/maven/conf/settings.xml
RUN if test -n "$LOCAL_MAVEN_MIRROR"; then \
	xmlstarlet ed --inplace -N 's=http://maven.apache.org/SETTINGS/1.0.0' \
	--subnode '/s:settings/s:mirrors' --type elem -n mirror -v '' \
	/usr/share/maven/conf/settings.xml \
	&& xmlstarlet ed --inplace -N 's=http://maven.apache.org/SETTINGS/1.0.0' \
	--subnode '/s:settings/s:mirrors/s:mirror' --type elem -n id -v 'custom-mirror' \
	/usr/share/maven/conf/settings.xml \
	&& xmlstarlet ed --inplace -N 's=http://maven.apache.org/SETTINGS/1.0.0' \
	--subnode '/s:settings/s:mirrors/s:mirror' --type elem -n name -v 'custom-mirror' \
	/usr/share/maven/conf/settings.xml \
	&& xmlstarlet ed --inplace -N 's=http://maven.apache.org/SETTINGS/1.0.0' \
	--subnode '/s:settings/s:mirrors/s:mirror' --type elem -n url -v "$LOCAL_MAVEN_MIRROR" \
	/usr/share/maven/conf/settings.xml \
	&& xmlstarlet ed --inplace -N 's=http://maven.apache.org/SETTINGS/1.0.0' \
	--subnode '/s:settings/s:mirrors/s:mirror' --type elem -n mirrorOf -v 'central' \
	/usr/share/maven/conf/settings.xml \
	;fi

# copy lib/ and src/ seperately to leverage cache (lib/ rarely changes)
COPY ./lib /JAVAProject/lib
RUN mvn install:install-file -DgroupId=com.oracle -DartifactId=ojdbc6 -Dversion=11.2.0.4 -Dpackaging=jar -Dfile=/JAVAProject/lib/ojdbc6.jar

# if pom.xml is not updates, m2/ may be cached as well
COPY pom.xml /JAVAProject/pom.xml
RUN cd /JAVAProject \
	&& mvn dependency:resolve

# copy src/ and build, src changes constantly
COPY ./src /JAVAProject/src
RUN cd /JAVAProject \
	&& find /JAVAProject/src -type f -exec chmod 640 {} \; \
	&& mvn -DskipTests=true package

# ------------------------- 8< -------------------------

FROM tomcat:8-alpine

ENV CONTEXT_ROOT=/

RUN apk add --no-cache mysql-client bash

COPY docker-entry.sh /docker-entry.sh
RUN chmod +x /docker-entry.sh \
	&& rm -rf ${CATALINA_HOME}/webapps/*

COPY --from=builder /JAVAProject/target/*.war /usr/local/tomcat/webapps/ROOT.war

COPY Initial.sh /Initial.sh
RUN chmod +x /Initial.sh \
	&& /Initial.sh

EXPOSE 8080

ENTRYPOINT [ "/docker-entry.sh" ]
