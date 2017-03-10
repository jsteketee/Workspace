#!/bin/bash

# Script to allow CS387B students to upload labs to the submission server
# It is expected that this script will be in the workspace directory
# which contains each of the students Eclipse projects
# (c)2016 David Read
# Version 01.00.00 (August 17, 2016)

# Function for error reporting - exits script if error occurs
function error() {
 echo 2>&1
 echo "*******************************************************" 2>&1
 echo "* THE SCRIPT FAILED - SEE ERROR MESSAGE BELOW"  2>&1
 echo "*" 2>&1
 echo "* $1" 2>&1
 echo "*******************************************************" 2>&1
 exit 1
}

echo "This script copies a project directory to the submission server"

# Make sure network connection is setup and working
curl -s http://monead.com/connection-check.html|grep "Internet Connection Verified" >/dev/null
if [[ $? -ne 0 ]]; then
	error "Unable to access the Internet. Please setup the network connection"
fi

#pwd | grep "workspace$"

# Verify that the script is being run in the correct directory
#if [[ $? -ne 0 ]]; then
# error "This script must be run from your workspace directory"
#fi


if [[ "$#" -ne 2 ]]; then
 error "You must supply your user id and the project directory name"
fi

KeyFile=~/.ssh/cs376b_id_rsa
LogFile="labload_$1_$2.log"
RemoteAddress="$1@cs376b.monead.com:."
Timestamp=`date +%F-%H-%M-%S`
TarFile="$1_$2.$Timestamp.tar.gz"

# Load the private key if it hasn't been loaded already
ssh-add -l |grep -q "cs376b" || ssh-add $KeyFile

# Verify that the key is loaded
if [[ `ssh-add -l |grep -c "cs376b"` == 0 ]]; then
 error "Private key not loaded"
fi

# Verify the supplied project name is a directory not a symbolic link
if [[ -L "$2" ]]; then
 error "$2 is a symbolic link - those are not supported"
fi

# Verify that the supplied project directory exists
if [[ ! -d "$2" ]]; then
 error "The directory $2 cannot be found in `pwd`"
fi

echo "Compressing project directory: $2"

# Compress the project
`tar cvzf "$TarFile" $2 >$LogFile 2>&1`

# Verify that tar worked
if [[ $? -ne 0 ]]; then
 error "Unable to compress directory $2. Check log: $LogFile"
fi

echo "Uploading the compressed directory to the server"

`scp "$TarFile" $RemoteAddress >$LogFile 2>&1`

# Verify that scp worked
if [[ $? -ne 0 ]]; then
 error "Unable to copy $TarFile to $RemoteAddress. Check log: $LogFile"
fi

echo
echo "$TarFile uploaded."
echo "Please notify your instructor that you have uploaded your lab"
