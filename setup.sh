#!/bin/bash

function join_by { local IFS="$1"; shift; echo "$*"; }

echo "************************************"
echo "**** INFINUM TEMPLATE APP SETUP ****"
echo "************************************"
echo
echo "DISCLAIMER: This script cleans the app, modifies the template app package name and app name, after the script if finished changes without git cannot be reversed."
echo "Press any key to continue..."
read -r

# Cleanup gradle project and empty directories
./setup_scripts/cleanup.sh

# Rename App package name
./setup_scripts/rename_package.sh

# Set App name
./setup_scripts/app_name.sh

# Remove setup related scripts
rm -rf setup_scripts
rm setup.sh

echo
echo "STEP 4: GIT"
# Add and/or commit all the changes done through the setup
if [ -d ".git" ]; then
  GIT_OPTION=""
  echo "**** Add setup changes to Git?"
  while [[ ! ${GIT_OPTION} =~ ^(1|2|3) ]]; do
    echo "Please select one of the following options:"
    echo "     [1] add and commit"
    echo "     [2] only add"
    echo "     [3] no git actions"
    read -r GIT_OPTION
  done
  if [[ ${GIT_OPTION} =~ ^(1|2) ]]; then
    git add . -A
  fi
  if [[ ${GIT_OPTION} =~ ^(1) ]]; then
    echo "Enter commit message"
    read -r GIT_MESSAGE
      git commit -m "$GIT_MESSAGE"
    echo "If you wish to revert the changes do 'git reset --hard HEAD~1'"
  elif [[ ${GIT_OPTION} =~ ^(2) ]]; then
      echo "If you wish to revert the changes do 'git reset --hard HEAD'"
  else
    echo "If you wish to revert the changes do 'git reset --hard && git clean -xdf'"
  fi
  echo "<--- Git done"
else
  echo "If you wish to revert the changes clone the template repository again."
fi

echo
echo "Complete"
