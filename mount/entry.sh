#!/bin/bash
JAVA_ARGS=()
# Tweak/comment following for debug logs
#JAVA_ARGS+=(-Djavax.net.debug=ssl -Djava.security.debug=certpath)

cd /app
javac -cp ".:drivers/*" SSLTest.java && \
env GOOGLE_APPLICATION_CREDENTIALS=/app/test_creds.json java -cp ".:drivers/*" "${JAVA_ARGS[@]}" SSLTest