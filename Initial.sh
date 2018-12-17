#!/bin/bash
set -ex

WEBAPP_BASE=$CATALINA_HOME/webapps
WAR_FILE=${WEBAPP_BASE}/ROOT.war
UNPACK_DIR=${WEBAPP_BASE}/ROOT

# determine context root path
if [[ "x${CONTEXT_ROOT}x" == "xx" || "$CONTEXT_ROOT" == "/" ]]; then
    CONTEXT_PATH=ROOT
else
    CONTEXT_PATH=${CONTEXT_ROOT}
fi
WEBAPP_DIR=${WEBAPP_BASE}/${CONTEXT_PATH}

require_env() {
    local ENV_NAME="$1"
    # if docker provides secret, secret wins env
    if [[ -r "/run/secrets/$ENV_NAME" ]]; then
        eval $ENV_NAME=$(cat /run/secrets/$ENV_NAME)
    fi

    eval ENV_VALUE=\$$ENV_NAME

    if [ -z "$ENV_VALUE" ]; then
        echo "Missing required environment variable: $ENV_NAME"
        exit 1
    fi
}

init_run() {
    echo "Unpacking war ..."
    mkdir -p "$UNPACK_DIR"
    unzip -qo -x "$WAR_FILE" -d "$UNPACK_DIR"
    rm -f "$WAR_FILE"
}

# if webapp directory does not exist, it's first run
if [ ! -d "$WEBAPP_DIR" ]; then
    init_run
fi