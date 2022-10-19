#!/bin/bash

# This script assumes the student's repo has been cloned manually. The student
# should have logged onto https://git.techelevator.com/, found their repo, and cloned it.

# The script prompts the user for their name and email to configure their git settings.
# The script then continues with configuring their diff tool settings.

# INSTRUCTORS: set the `upstream_repo` variable with your instructor repo.
# The script uses this value to set it as an upstream for the student.
# The URL should look something like: "https://git.techelevator.com/campuses/nlr/jan-2022/java-green/instructor-code"

upstream_repo="https://git.techelevator.com/niantic/remote/oct-2022/java/instructor-code"

echo
read -r -p "Enter your name (First Last): " name
read -r -p "Enter your email: " email

echo
echo "Setting Up Global Configuration Settings"

git config --global user.name "${name}"
git config --global user.email "${email}"

echo "Setting up Git Editors and Tools..."

git config --global core.editor "code -w -n"
git config --global diff.tool code
git config --global difftool.code.cmd "code -w -d \$LOCAL \$REMOTE"

echo
echo "Configuring Upstream..."

git remote add upstream "${upstream_repo}"
git config branch.main.mergeOptions "--no-edit"

echo "Done."
