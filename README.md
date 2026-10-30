# GameCharacterSaveFiles

## Description

A Java console application that saves game character information in both XML and JSON formats and displays the contents of the generated files in the console.

## Features

- Create and store multiple game characters.
- Save character information in XML format.
- Save character information in JSON format.
- Read and display the contents of both files in the console.
- Escape special characters when writing text to XML and JSON.
- Use a `GameCharacter` class to organize character information.

## Implementation

- `Main.java` contains the main program logic, creates the characters, and handles file operations.
- `GameCharacter.java` defines the game character model, including its properties, constructor, accessor methods, and `toString()` method.
- `saveAsXml()` writes character information to an XML file.
- `saveAsJson()` writes character information to a JSON file.
- `readAndDisplayFile()` reads a file line by line and displays its contents in the console.
- `escapeXml()` and `escapeJSON()` handle special characters before saving text.

## Files Generated

The application generates two files:

- `characters.xml` — stores character information in XML format.
- `characters.json` — stores character information in JSON format.

Each character includes:

- Name
- Character class
- Level
- Health
- Attack power
- Gold

## How to Run

1. Open the project in your preferred Java IDE.
2. Make sure the JDK is installed and configured.
3. Run `Main.java`.
4. Check the console output to see the character information and the contents of the generated files.
5. Find `characters.xml` and `characters.json` in the application's working directory.

## Technologies

- Java
- Object-Oriented Programming (OOP)
- File I/O
- XML
- JSON
- `PrintWriter`
- `Scanner`
- Java Collections (`ArrayList` and `List`)