# CODSOFT--
# Student Management System

This Java program implements a simple Student Management System using serialization for data persistence.

## Overview

The Student Management System allows users to perform the following operations:

- Add a new student with their name, roll number, and grade.
- Remove a student based on their roll number.
- Search for a student by their roll number.
- Display all students currently stored in the system.

## Classes

### `Student`

- Represents a student with properties such as name, roll number, and grade.

#### Methods:

- `public Student(String name, int rollNumber, String grade)`: Constructor to initialize a student object.
  
- Getter and setter methods for `name`, `rollNumber`, and `grade`.

### `StudentManagementSystem`

- Manages the collection of `Student` objects and provides methods to manipulate student data and persist it to a file (`student.dat`).

#### Methods:

- `public void addStudent(Student student)`: Adds a new student to the system.
  
- `public void removeStudent(Student student)`: Removes a student from the system.
  
- `public Student searchStudent(int rollNumber)`: Searches for a student by their roll number.
  
- `public void displayAllStudents()`: Displays details of all students currently stored in the system.

- `private void loadStudents()`: Loads student data from the file (`student.dat`) using `ObjectInputStream`.
  
- `private void saveStudents()`: Saves student data to the file (`student.dat`) using `ObjectOutputStream`.

### `Main`

- Contains the main method to run the Student Management System.

#### Features:

- Displays a menu-driven interface for users to interact with the system.
  
- Uses `Scanner` for user input to perform operations like adding, removing, searching, and displaying students.

#### How to Use:

1. **Compile the Program:**
   ```bash
   javac Main.java
