#!/bin/bash

#####
##### Project preparation
#####

echo
echo "STEP 1: CLEANUP"
echo "**** Cleaning empty directories and gradle... Please wait for it to complete."

#Delete all empty directories recursively
find . -type d -empty -delete

rm .github/pull_request_template.md

#Gradle clean
./gradlew clean >/dev/null

rm -rf media
rm modularization.md

echo "<--- Cleaning done"
