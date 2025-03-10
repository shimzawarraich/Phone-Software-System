# Mobile Phone Application Using Java

## Overview
This project is a basic implementation of a mobile phone, featuring essential applications such as Settings, Contacts, Notes, Calculator, and Banking. Developed entirely in Java, the project implements Object-Oriented Programming (OOP) principles, incorporates debugging techniques, and accounts for various edge cases to ensure reliability. The development of the project was a collaborative effort between two developers, each independently developing specific applications before integrating them into the unified main phone class.

## Important Information
- Upon running the program, you'll be prompted to enter a password. The default password for this program is **"Password"**. This password is used throughout the entire program.

## Applications

### Contacts App
The Contacts app is a simple implementation of a contacts app typically found on a mobile phone. Upon entering the app, users are presented with the following options:
- Create a new contact
- View an existing contact
- Delete a contact

**Features:**
- Users can create a new contact, which stores the contact’s name and associated phone numbers in a text file.
- Multiple phone numbers can be saved under a single contact name.
- Users can view previously created contacts by reading from the stored text file. If the user attempts to view a nonexistent contact, an error message will appear.
- Contacts can be deleted, but only if the contact exists. If the contact does not exist, an error message will be shown.

### Settings App
The Settings app allows for basic customization and user preferences. It includes the following functionalities:
- **Changing Console Text Color:** Users can select from color options such as red, blue, and green to modify the console text color.
- **Updating the Phone Password:** Users can change the phone's password, which is stored in a text file. The original password ("Password") is overwritten with the new password upon update.

### Notes App
The Notes app is similar to the notes application found on most smartphones. Upon entering the app, users are prompted to enter the phone password. Once authenticated, users can choose one of the following options:
- Create a new note
- View an existing note
- Delete a note

**Features:**
- Notes are stored in a text file, with each note named based on the title provided by the user.
- Users can create, view, and delete notes with ease.
- If a user attempts to view or delete a note that does not exist, an error message will be displayed.

## Running the Program
1. Clone the repository or download the project files to your local machine.
2. Ensure that you have Java installed on your computer.
3. Compile and run the program using your preferred IDE or command-line interface.
4. Upon launching, you will be prompted to enter the default password "Password." You can change this password through the Settings app.
5. Choose from the available apps (Contacts, Settings, Notes) to start using the features.


