#!/bin/bash
#SIMBA_VER=42_1.3.3.1004
#SIMBA_VER=42_1.5.0.1001
SIMBA_VER=42_1.5.4.1008
SIMBA_URL=https://storage.googleapis.com/simba-bq-release/jdbc/SimbaJDBCDriverforGoogleBigQuery${SIMBA_VER}.zip
curl -o /tmp/SimbaJDBCDriverforGoogleBigQuery.zip "${SIMBA_URL}"
[ -d mount/drivers ] && rm -rf mount/drivers
mkdir -p mount/drivers
unzip /tmp/SimbaJDBCDriverforGoogleBigQuery.zip -d mount/drivers
