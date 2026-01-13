# Address Book Application

This is a small Java console application that reads an address book file and answers a few questions about its contents.

---

## Problem Description

Given an address book file, the application answers the following questions:

1. How many males are in the address book?
2. Who is the oldest person?
3. How many days older is Bill McKnight than Paul Robinson?

---

## Requirements

- Java 11 or newer
- Gradle (the Gradle wrapper included in this repository is required to build, test, and run the application)

---

## Project Structure

```
src/main/java
 └── ai/inpowered/addressbook
     ├── domain
     │   ├── Person.java
     │   └── Gender.java
     ├── application
     │   ├── reader
     │   │   └── AddressBookReader.java
     │   └── service
     │       ├── AddressBookService.java
     │       └── DefaultAddressBookService.java
     └── infrastructure
         └── reader
             ├── FileAddressBookReader.java
             └── PersonLineParser.java

src/main/resources
 └── addressbook.txt

src/test/java
 └── (tests)
```

---

## Input File

Each line of the input file must follow this format:

```
Name, Gender, DateOfBirth
```

Example:

```
Bill McKnight, Male, 16/03/77
Paul Robinson, Male, 15/01/85
```

A sample file is provided at:

```
src/main/resources/addressbook.txt
```

---

## Build and Test

Run all tests using Gradle:

```bash
./gradlew test
```

On Windows:

```powershell
gradlew test
```

---

## Run the Application

Run the application using Gradle, providing the path to the address book file as an argument:

```bash
./gradlew run --args="src/main/resources/addressbook.txt"
```

On Windows:

```powershell
gradlew run --args="src/main/resources/addressbook.txt"
```

---

## Output

The application prints:

- Number of males
- Oldest person
- How many days older Bill McKnight is than Paul Robinson

Example output:

```
Number of males: 3
Oldest person: Wes Jackson
Bill McKnight is 2862 days older than Paul Robinson
```
