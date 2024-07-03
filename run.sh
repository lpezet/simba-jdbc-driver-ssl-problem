#!/bin/bash
docker run --rm -v ./mount:/app --entrypoint /app/entry.sh openjdk:11
#docker run --rm -it -v ./mount:/app --entrypoint bash openjdk:14