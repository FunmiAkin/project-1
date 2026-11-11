# Project 1: Academic Advisement and Faculty Management System

## Instructions for this Assignment

1. All Java files you create must go into the `src/project1` folder. Keep the `README.md` file in the project root.

2. Some classes and files have been provided as starter code, while others have intentionally been left out. Using what you have learned in class, complete the project by adding the missing classes and implementing the required relationships and functionality.

3. The starter code is intentionally incomplete. The provided classes are only part of the design; determine what additional classes, attributes, methods, and relationships are needed to create a complete application.

4. Apply the object-oriented programming concepts covered in class, including encapsulation, constructors, inheritance, method overloading, method overriding, polymorphism, and arrays of objects.

5. Do not use AI coding tools to complete this assignment. If you have difficulty, reach out to your Teaching Assistant or Professor for help.

## Project overview

Develop a Java application that simulates university academic advising and faculty management activities.

## System users

- System administrator
- Faculty member

## Required features

### System administrator

- Log in using a username and password.
- Add, view, and update student records.
- Add, view, and update faculty records.
- Create and manage faculty accounts.
- Assign students to faculty advisors.
- Reassign students when necessary.

### Faculty member

- Log in using individual credentials.
- View personal information, contact details, and office hours.
- View assigned advisees.
- View student rosters for assigned courses.
- Retrieve student academic transcripts using a student ID.
- Complete academic advising forms.

## Academic advising forms

Each advising form should include:

- Student information
- Approved courses
- Alternate course selections
- Academic advising notes
- Faculty advisor information

## File management

The application must:

- Save completed advising forms to files.
- Maintain student, faculty, course, and advising records.
- Allow authorized users to retrieve previously saved records.

## System rule

Faculty members must access only the students and academic information assigned to their advising responsibilities.

## Shared assignment requirements

The completed application must demonstrate:

- Encapsulation with private fields and appropriate accessors
- Default and parameterized constructors where appropriate
- Inheritance
- Method overloading
- Method overriding
- Polymorphism
- Arrays of objects
- Automatic loading of initial records from multiple data files
- Persistent saving of added and updated records
- Error handling for missing files, invalid records, duplicate IDs, read errors, and write errors

The console application is mandatory. A Java Swing or JavaFX graphical interface is optional.
