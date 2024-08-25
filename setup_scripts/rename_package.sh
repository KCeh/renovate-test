#!/bin/bash

#####
##### Package name
#####

MAIN_JAVA_PATH="/src/main/java"
MAIN_KOTLIN_PATH="/src/main/kotlin"

FILE_TYPES=(.xml .pro .gradle .java .kt .kts)

MODULE_PATHS=(
  "app"
  "ui"
  "common/kotlin"
  "common/android"
  "domain/logic"
  "domain/models"
  "sources/backend/bridge"
  "sources/backend/data"
  "sources/preferences/bridge"
  "sources/preferences/data"
  "sources/room/bridge"
  "sources/room/data"
)

echo
echo "STEP 2: PACKAGE NAME"
echo "**** Enter new package name"
read -r newPackageName

IFS=. read -r -a PARTS <<< "$newPackageName"

NEW_PATH=$(IFS=/ ; echo "${PARTS[*]}")

# Rename all the package names in file contents for files with the FILE_TYPES suffixes
for type in "${FILE_TYPES[@]}"; do
    find . -type f -name "*$type" -exec sed -i "" "s/com.infinum.template/$newPackageName/g" {} +
done

# Rename all subpackages in the MODULE_PATHS in either "/src/main/java" or "/src/main/kotlin" to the NEW_PATH
for modulePath in "${MODULE_PATHS[@]}"; do
    # Remove the build folder
    rm -rf "$modulePath/build"
    currentModule=$modulePath$MAIN_JAVA_PATH
    if [ ! -d "$currentModule" ]; then
      currentModule=$modulePath$MAIN_KOTLIN_PATH
      if [ ! -d "$currentModule" ]; then
        # This module doesn't contain the package name, skip it
        continue
      fi
    fi
    # Create a temporary directory
    mkdir setupTmp
    # Move the code from the template package name to the temporary folder
    mv "$currentModule/com/infinum/template"/* "setupTmp/"
    previousPath=$PWD
    cd "$currentModule" || exit
    # Remove the template package name folders
    rm -rf "com"
    # Create the new package name folders
    mkdir -p "$NEW_PATH"
    cd "$previousPath" || exit
    # Move the code from the temporary folder to the new package name
    mv setupTmp/* "$currentModule/$NEW_PATH/"
    rm -rf setupTmp
done

echo "<--- Package renamed to $newPackageName"
