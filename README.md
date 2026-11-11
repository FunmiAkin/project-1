# Project 1: Academic Advisement and Faculty Management System

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

## Starter project structure

```text
project-1/
├── README.md
└── src/
    └── project1/
        ├── AdvisingRecord.java
        ├── FacultyMember.java
        ├── Main.java
        └── Student.java
```

`Main.java` is the console application entry point. The Java files use the `project1` package.

## Starter classes

- `Student`
- `FacultyMember`
- `AdvisingRecord`

## Selected method prototypes

```java
void assignAdvisor(FacultyMember advisor);
Student[] getAdvisees();
void completeAdvisingForm(AdvisingRecord record);
```

These methods are abstract declarations only. Full business logic remains to be implemented.

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
