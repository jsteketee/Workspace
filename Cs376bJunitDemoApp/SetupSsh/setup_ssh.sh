#!/bin/bash

# Script to generate an RSA key for SSH access to
# the student's assignment submission server account
# and copy the submit_lab.sh script to the
# ~/workspace directory which should be set as the
# Eclipse workspace directory

# (c)2016 David Read
# Version 01.00.00 (August 17, 2016)

# Generates the RSA keypair, configures SSH options
# and uploads the public key to the server for deployment
# Note that an account, keys@www2.monead.com should exist
# with a public key installed related to the private key
# keys_id_rsa used by this script to upload the student's
# generated key

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

SshDir=~/.ssh
WorkspaceDir=~/workspace
KeyFile=cs376b_id_rsa
LogFile="rsasetup_$1.log"
RemoteAddress="keys@cs376b.monead.com"
SubmitScript=submit_lab.sh

echo "This script sets up an RSA key and SSH configuration for submitting lab assignments"

# Make sure network connection is setup and working
curl -s http://monead.com/connection-check.html|grep "Internet Connection Verified" >/dev/null
if [[ $? -ne 0 ]]; then
	error "Unable to access the Internet. Please setup the network connection"
fi

# Verify the user id was supplied on the command line
if [[ "$#" -ne 1 ]]; then
 error "You must supply your user id"
fi

# Verify that there is no existing ssh config file
if [[ -f $SshDir/config ]]; then
 error "There is already an SSH config file. This script will not overwrite it"
fi

# Verify that the .ssh directory exists
if [[ ! -d "$SshDir" ]]; then
 mkdir $SshDir
 chmod 700 $SshDir
fi

if [[ ! -d "$SshDir" ]]; then
 error "The directory $SshDir was not created successfully"
fi

# Generate the RSA keypair
echo "Generate an RSA keypair for submitting lab assignments."
echo ""
echo "*******************************************************"
echo "* Remember to choose a password that you can remember *"
echo "*******************************************************"
echo ""

ssh-keygen -f $KeyFile 2>&1 | tee $LogFile

if [[ ! -f $KeyFile ]]; then
 error "The private key ($KeyFile) was not created successfully. Check log: $LogFile"
fi

if [[ ! -f $KeyFile.pub ]]; then
 error "The public key ($KeyFile.pub) was not created successfully. Check log: $LogFile"
fi

# Copy the keys and configuration to the SSH directory
echo ""
echo "Installing key and configuration"

cp -f $KeyFile $KeyFile.pub config keys_id_rsa $SshDir 2>&1 | tee >$LogFile

# Add the proper username into the config file for the RSA key
echo " User $1" >>$SshDir/config

if [[ ! -f $SshDir/$KeyFile ]]; then
 error "The private key ($KeyFile) was not copied successfully. Check log: $LogFile"
fi

if [[ ! -f $SshDir/$KeyFile.pub ]]; then
 error "The public key ($KeyFile.pub) was not copied successfully. Check log: $LogFile"
fi

if [[ ! -f $SshDir/config ]]; then
 error "The SSH config file was not copied successfully. Check log: $LogFile"
fi

if [[ ! -f $SshDir/keys_id_rsa ]]; then
 error "The keys RSA ID file was not copied successfully. Check log: $LogFile"
fi

chmod 600 $SshDir/$KeyFile $SshDir/$KeyFile.pub $SshDir/config

# Upload the student's key to the submission server

scp -o PasswordAuthentication=no $KeyFile.pub $RemoteAddress:$1_$KeyFile.pub 2>&1 >$LogFile

if [[ $? -ne 0 ]]; then
 error "Unable to copy $KeyFile.pub to $RemoteAddress."
fi

if [[ ! -d $WorkspaceDir ]]; then
	mkdir $WorkspaceDir
fi

cp -f $SubmitScript $WorkspaceDir/$SubmitScript

if [[ ! -f $WorkspaceDir/$SubmitScript ]]; then
	error "Unable to setup the submit script in $WorkspaceDir/$SubmitScript"
fi

echo ""
echo "Your key has been setup."
echo "Let your instructor know it has been uploaded to the server"
