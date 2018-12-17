#!/bin/bash
set -e

# On some boxes with low entropy, tomcat will stuck at start up. It often happens with docker-machine VMs on macos and cloud VM hosts.
# The dirty hack is to use /dev/urandom as entropy source, it is not recommemded as it reduces security.
# See: https://wiki.apache.org/tomcat/HowTo/FasterStartUp#Entropy_Source
export JAVA_OPTS="-Djava.security.egd=file:///dev/urandom $JAVA_OPTS"

# start tomcat
if [ -z "$@" ]; then
    exec $CATALINA_HOME/bin/catalina.sh run
else
    exec "$@"
fi
