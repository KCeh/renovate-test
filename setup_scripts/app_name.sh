#!/bin/bash

#####
##### Project name
#####

echo
echo "STEP 3: APP NAME"
echo "**** Enter app name"
read -r APP_NAME

# Replace 'TemplateApp' with the entered app name in strings.xml
sed -i '' "s/TemplateApp/$APP_NAME/g" ui/src/main/res/values/strings.xml

# Replace 'New Project Template' with the entered app name in settings.gradle
sed -i '' "s/New Project Template/$APP_NAME/g" settings.gradle.kts

echo "<--- App name set to $APP_NAME"
