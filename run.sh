#!/bin/bash
docker run --rm -v ./mount:/app --entrypoint /app/entry.sh openjdk:11