# Student Management System

A comprehensive Java-based application for managing the complete lifecycle of students, from enrollment through graduation and placement tracking. This system provides functionality to manage persons, students, graduate students, courses, and assignments with a hierarchical organizational structure and robust enrollment management.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Architecture](#architecture)
- [Project Structure](#project-structure)
- [Installation & Setup](#installation--setup)
- [Usage Guide](#usage-guide)
- [Core Components](#core-components)
- [API Reference](#api-reference)
- [Fee Calculation System](#fee-calculation-system)
- [Examples](#examples)
- [Error Handling](#error-handling)
- [Database Schema](#database-schema)
- [Troubleshooting](#troubleshooting)
- [Known Issues & Fixes](#known-issues--fixes)
- [Future Enhancements](#future-enhancements)
- [Contributing Guidelines](#contributing-guidelines)
- [FAQ](#faq)
- [License](#license)
- [Support](#support)

## Overview

The Student Management System (SMS) is designed to streamline educational institution operations by providing a unified platform for:

- **Personnel Management**: Register and manage persons within the institution
- **Student Lifecycle**: Track students from enrollment to graduation
- **Career Tracking**: Monitor graduate placement status and details
- **Course Administration**: Manage Java and Node.js courses with assignments
- **Financial Management**: Handle fees, discounts, scholarships, and payment tracking
- **Performance Monitoring**: Grade assignments and track student progress

### Key Highlights

✨ **Auto-incrementing IDs**: Unique identification for all entities  
✨ **Hierarchical Structure**: Person → Student → GraduateStudent progression  
✨ **Dual Course Support**: Java and Node.js specialized courses  
✨ **Comprehensive Enrollment**: Complete fee management with validations  
✨ **CLI Interface**: User-friendly menu-driven interaction  
✨ **Robust Validation**: Input validation for all operations  

### Technology Stack

| Component | Technology |
|-----------|-----------|
| **Language** | Java 25+ |
| **Build Tool** | Maven/Gradle (Optional) |
| **Database** | In-Memory (ArrayList) - Future: MySQL/PostgreSQL |
| **Design Patterns** | MVC, Singleton, Factory, Observer |
| **Package Manager** | N/A |

## Features

### ✅ Person Management

- ✓ Add new persons with auto-generated unique IDs
- ✓ Remove persons from database by ID
- ✓ Search persons by ID
- ✓ Enroll persons as students with automatic enrollment service
- ✓ Display all registered persons
- ✓ Update person information (name)
- ✓ Interact with enrollment service for financial operations

**Menu Options:**
```
1. Add new person
2. Remove person by ID
3. Enroll person as student
4. Display all persons
5. Interact with enrollment service
6. Back to main menu
```

### ✅ Student Management

- ✓ Enroll persons as students with automatic course list
- ✓ Assign courses to students
- ✓ Graduate students to graduate student status
- ✓ Update student information and names
- ✓ Remove students from system
- ✓ View all students in database
- ✓ Display detailed student information

**Menu Options:**
```
1. Assign course to student
2. Remove student by ID
3. Change student name
4. Display all students
5. Display all students (detailed)
6. Graduate student
7. Back to main menu
```

### ✅ Graduate Student Management

- ✓ Manage graduate student records
- ✓ Update graduate student information
- ✓ Track placement status (placed/not placed)
- ✓ Record organization/company name for placement
- ✓ Remove graduate students from database
- ✓ Display all graduate students
- ✓ View detailed graduate student placement information

**Menu Options:**
```
1. Change graduate student name
2. Remove graduate student by ID
3. Display all graduate students
4. Display graduate student details (by ID)
5. Update placement status
6. Update organization/company
7. Back to main menu
```

### ✅ Course Management

- ✓ Two course types: **Java Course** and **Node.js Course**
- ✓ Auto-incrementing course IDs per type
- ✓ Create and manage multiple courses
- ✓ Add assignments to courses (type-specific)
- ✓ Mark courses as complete
- ✓ Display all available courses
- ✓ View course details including assignments

**Menu Options:**
```
1. View all courses
2. Create new assignment for course
3. Back to main menu
```

### ✅ Assignment Management

- ✓ Java-specific assignments with version tracking
- ✓ Node.js-specific assignments with version tracking
- ✓ Grade assignments (A, B, C, D, E, F)
- ✓ Default grade: F (not graded)
- ✓ Display assignment details
- ✓ Validate assignment type matches course type
- ✓ Auto-incrementing assignment IDs per type

### ✅ Enrollment & Financial Management

**Core Features:**
- ✓ Automatic enrollment upon student creation
- ✓ Configurable default fees: ₹100,000
- ✓ Discount System: Apply 0-100% discount
- ✓ Scholarship System: Apply 0-100% scholarship
- ✓ Validation: Combined discount + scholarship ≤ 100%
- ✓ Final Amount Calculation: Automatically computes after deductions
- ✓ Payment Status Tracking: Mark payments as completed/pending
- ✓ Enrollment Status: Track active/inactive enrollments
- ✓ Fee Validation: Input validator for fee amounts
- ✓ Dynamic Fee Adjustment: Modify fees for individual students
- ✓ Deduction Breakdown: View detailed fee breakdown

**Fee Calculation Formula:**
```
Final Amount = Original Fees - Discount Amount - Scholarship Amount
Final Amount = Fees × (1 - Discount% - Scholarship%)
```

## Architecture

### Hierarchical Entity Model

```
Cohort (Central Container)
│
├── PersonList
│   └── Person (Base Entity)
│       ├── ID (auto-increment)
│       ├── Name
│       └── EnrollmentService
│           └── Enrollment
│
├── StudentList
│   └── Student (Extends Person)
│       ├── CourseList
│       ├── Enrollment
│       └── ...Person properties
│
├── GraduateStudentList
│   └── GraduateStudent (Extends Student)
│       ├── Placement Status
│       ├── Organisation Name
│       └── ...Student properties
│
└── CourseList
    ├── JavaCourse (Auto-increment ID)
    │   └── Assignments (JavaAssignment)
    │
    └── NodeCourse (Auto-increment ID)
        └── Assignments (NodeAssignment)

Assignment Hierarchy:
Assignment (Abstract + Gradable Interface)
├── JavaAssignment (Version tracking)
│   ├── ID (Java-specific auto-increment)
│   ├── Name
│   ├── Grade (A-F)
│   └── Version
│
└── NodeAssignment (Version tracking)
    ├── ID (Node-specific auto-increment)
    ├── Name
    ├── Grade (A-F)
    └── Version
```

### Design Patterns Used

| Pattern | Usage | Benefit |
|---------|-------|---------|
| **Hierarchical Inheritance** | Person → Student → GraduateStudent | Code reuse, type safety |
| **Abstract Classes** | Course, Assignment | Polymorphism, extensibility |
| **Collections Pattern** | PersonList, StudentList, etc. | Centralized data management |
| **Service Pattern** | EnrollmentService | Business logic separation |
| **Driver Pattern** | PersonDriver, StudentDriver, etc. | Menu operation handling |
| **Singleton** | Cohort | Single instance container |

### Architecture Principles

1. **Separation of Concerns**: Each class has single responsibility
2. **Encapsulation**: Private fields with public getters/setters
3. **Abstraction**: Abstract base classes for extensibility
4. **Polymorphism**: Method overriding and interface implementation
5. **DRY Principle**: Reusable utility functions and validation logic
6. **Composition**: Using EnrollmentService and Collections for data management

## Project Structure

```
StudentManagement/
│
├── src/main/java/com/Airtribe/StudentManagement/
│   │
│   ├── Main.java                              # Entry point with CLI menu
│   │
│   ├── Entities/
│   │   ├── Person/
│   │   │   ├── Person.java                   # Base person entity
│   │   │   ├── Student.java                  # Student extending Person
│   │   │   └── GraduateStudent.java          # Graduate extending Student
│   │   │
│   │   ├── Course/
│   │   │   ├── Course.java                   # Abstract course base
│   │   │   ├── JavaCourse.java               # Java course implementation
│   │   │   └── NodeCourse.java               # Node.js course implementation
│   │   │
│   │   ├── Assignment/
│   │   │   ├── Assignment.java               # Abstract assignment base
│   │   │   ├── JavaAssignment.java           # Java assignment implementation
│   │   │   └── NodeAssignment.java           # Node assignment implementation
│   │   │
│   │   ├── Collections/
│   │   │   ├── PersonList.java               # Person collection manager
│   │   │   ├── StudentList.java              # Student collection manager
│   │   │   ├── GraduateStudentList.java      # Graduate collection manager
│   │   │   └── CourseList.java               # Course collection manager
│   │   │
│   │   ├── Cohort/
│   │   │   └── Cohort.java                   # Central container for all lists
│   │   │
│   │   └── Enrollment/
│   │       └── Enrollment.java               # Enrollment & fee management
│   │
│   ├── Service/
│   │   └── EnrollmentService.java            # Enrollment operations service
│   │
│   ├── Driver/
│   │   ├── PersonDriver.java                 # Person operations driver
│   │   ├── StudentDriver.java                # Student operations driver
│   │   ├── GraduateStudentDriver.java        # Graduate student driver
│   │   ├── CourseDriver.java                 # Course operations driver
│   │   └── EnrollmentDriver.java             # Enrollment operations driver
│   │
│   ├── Interfaces/
│   │   ├── SearchableWithID.java             # ID-based search interface
│   │   ├── SearchableWithName.java           # Name-based search interface
│   │   └── Gradable.java                     # Grading interface
│   │
│   ├── Util/
│   │   ├── CONSTANTS.java                    # Constant messages & strings
│   │   ├── COURSE_TYPE.java                  # Course type enum (JAVA, NODE_JS)
│   │   ├── GRADES.java                       # Grade enum (A, B, C, D, E, F)
│   │   ├── InputValidator.java               # Input validation logic
│   │   └── UtilityFunctions.java             # Display utilities
│   │
│   └── Exceptions/
│       └── InvalidFeesException.java         # Custom exception for fee errors
│
├── out/                                       # Compiled output directory
├── .idea/                                     # IntelliJ IDEA configuration
├── StudentManagement.iml                      # IntelliJ IDEA project file
├── README.md                                  # This file
└── .gitignore                                 # Git ignore file
```

## Installation & Setup

### Prerequisites

| Requirement | Minimum Version | Recommended |
|------------|-----------------|-------------|
| Java JDK | 17 | 25+ |
| RAM | 512 MB | 2 GB |
| Storage | 100 MB | 500 MB |
| OS | Windows/macOS/Linux | Windows 10+/macOS 10.15+/Ubuntu 20.04+ |
| IDE | Any text editor | IntelliJ IDEA / VS Code / Eclipse |

### Step-by-Step Installation

#### 1. Clone the Repository

```bash
git clone https://github.com/shubhamsaini/StudentManagement.git
cd StudentManagement
```

#### 2. Verify Java Installation

```bash
# Check Java version
java -version

# Check JavaC version
javac -version
```

**Expected output:**
```
java version "25" 2024-09-17
Java(TM) SE Runtime Environment (build 25+37-2362)
Java HotSpot(TM) 64-Bit Server VM (build 25+37-2362, mixed mode, sharing)
```

#### 3. Create Output Directory

```bash
mkdir -p out
```

#### 4. Compile the Project

```bash
# Option 1: Compile all files at once (macOS/Linux)
javac -d out src/main/java/com/Airtribe/StudentManagement/**/*.java

# Option 2: Compile all files at once (Windows)
javac -d out src\main\java\com\Airtribe\StudentManagement\**\*.java

# Option 3: Compile with explicit file listing
javac -d out \
  "src/main/java/com/Airtribe/StudentManagement/Main.java" \
  "src/main/java/com/Airtribe/StudentManagement/Entities/Person/*.java" \
  "src/main/java/com/Airtribe/StudentManagement/Entities/Course/*.java" \
  "src/main/java/com/Airtribe/StudentManagement/Entities/Assignment/*.java" \
  "src/main/java/com/Airtribe/StudentManagement/Entities/Collections/*.java" \
  "src/main/java/com/Airtribe/StudentManagement/Entities/Cohort/*.java" \
  "src/main/java/com/Airtribe/StudentManagement/Entities/Enrollment/*.java" \
  "src/main/java/com/Airtribe/StudentManagement/Service/*.java" \
  "src/main/java/com/Airtribe/StudentManagement/Driver/*.java" \
  "src/main/java/com/Airtribe/StudentManagement/Interfaces/*.java" \
  "src/main/java/com/Airtribe/StudentManagement/Util/*.java" \
  "src/main/java/com/Airtribe/StudentManagement/Exceptions/*.java"
```

#### 5. Run the Application

```bash
java -cp out main.java.com.Airtribe.StudentManagement.Main
```

#### 6. Verify Installation

You should see:
```
A new Cohort has been created for the demo
A new java course has been created for the demo
A new node course has been created for the demo
A new person p1 with id - 1 has been created for the demo

=== MAIN MENU ===
Please select an input in accordance with the action you seek to perform:
For Person based operations - 1
For Student based operations - 2
For Graduate student based operations - 3
For Course based operations - 4
To exit application - 5
```

### Using IntelliJ IDEA

1. **Open Project**
   - File → Open → Select StudentManagement folder
   - IntelliJ will recognize it as a Java project

2. **Configure JDK**
   - File → Project Structure → Project
   - Select JDK 25+ from list (or download if not available)

3. **Compile**
   - Build → Build Project (Ctrl+F9 / Cmd+F9)

4. **Run**
   - Right-click on Main.java
   - Select "Run Main.main()" or press Shift+F10

### Using VS Code

1. **Install Extensions**
   - Extension Pack for Java
   - Language Support for Java (Red Hat)

2. **Open Folder**
   - File → Open Folder → Select StudentManagement

3. **Run**
   - Click Run button in Main.java

## Usage Guide

### Main Menu

When you start the application:

```
=== MAIN MENU ===
Please select an input in accordance with the action you seek to perform:
For Person based operations - 1
For Student based operations - 2
For Graduate student based operations - 3
For Course based operations - 4
To exit application - 5
```

### Menu 1: Person Operations

```
=== PERSON OPERATIONS ===
If you wish to add a new person - 1
If you wish to remove a person with given id - 2
If you wish to enroll a person to student status - 3
If you wish to display all the people currently in the database - 4
If you wish to interact with the enrollment service for a person - 5
If you wish to go back to previous menu - 6
```

#### 1.1 Add New Person

```
Select: 1
Enter the name of the person:
→ John Doe
[Output] Person with ID: 1 has been added successfully.
```

#### 1.2 Remove Person by ID

```
Select: 2
Enter the ID of the person to remove:
→ 1
[Output] Person with ID 1 has been removed successfully.
```

#### 1.3 Enroll Person as Student

```
Select: 3
Enter the ID of the person to enroll:
→ 1
[Output] Person has been successfully enrolled as a student with ID: 1
[Output] Person removed from Person database (moved to Student database).
```

**Important:** Payment must be completed before enrollment!

#### 1.4 Display All Persons

```
Select: 4
[Output] 
=== All People in Database ===
ID: 1, Name: person_1
ID: 2, Name: Alice Johnson
ID: 3, Name: Bob Smith
```

#### 1.5 Interact with Enrollment Service

```
Select: 5
Enter the id for the person:
→ 1
[Displays Enrollment Menu]
```

### Menu 2: Student Operations

```
=== STUDENT OPERATIONS ===
If you wish to assign course to student - 1
If you wish to remove a student with given id - 2
If you wish to change the name for a student with given id - 3
If you wish to display all the students currently in the database - 4
If you wish to display all the details for students currently in the database - 5
If you wish to graduate student - 6
If you wish to go back to previous menu - 7
```

#### 2.1 Assign Course to Student

```
Select: 1
Enter the ID of the student:
→ 1
Enter the course name:
→ Java Fundamentals
[Output] Course has been assigned successfully to the student.
```

#### 2.2 Remove Student

```
Select: 2
Enter the ID of the student to remove:
→ 1
[Output] Student with ID 1 has been removed successfully.
```

#### 2.3 Change Student Name

```
Select: 3
Enter the ID of the student:
→ 1
Enter the new name:
→ Jane Doe
[Output] Student name has been updated successfully.
```

#### 2.4 Display All Students

```
Select: 4
[Output]
=== All Students in Database ===
ID: 1, Name: John Doe
ID: 2, Name: Alice Johnson
```

#### 2.5 Display Student Details

```
Select: 5
[Output] [Same as 2.4]
```

#### 2.6 Graduate Student

```
Select: 6
Enter the ID of the student to graduate:
→ 1
[Output] Student has been successfully graduated.
```

### Menu 3: Graduate Student Operations

```
=== GRADUATE STUDENT OPERATIONS ===
If you wish to change the name of a graduate student - 1
If you wish to remove a graduate student with given id - 2
If you wish to display all the graduate students in the database - 3
If you wish to display all details for a graduate student in the database - 4
If you wish to update placement status for a graduate student - 5
If you wish to update organization/company for a graduate student - 6
If you wish to go back to previous menu - 7
```

#### 3.1 Change Graduate Student Name

```
Select: 1
Enter the ID of the graduate student:
→ 1
Enter the new name:
→ Dr. John Doe
[Output] Graduate student name has been updated successfully.
```

#### 3.5 Update Placement Status

```
Select: 5
Enter the ID of the graduate student:
→ 1
Enter placement status (true for placed, false for not placed):
→ true
[Output] Placement status updated successfully.
```

#### 3.6 Update Organization/Company

```
Select: 6
Enter the ID of the graduate student:
→ 1
Enter the organization/company name:
→ Google India
[Output] Organization updated successfully.
```

### Menu 4: Course Operations

```
=== COURSE OPERATIONS ===
If you wish to view all courses - 1
If you wish to create a new assignment for a course - 2
If you wish to go back to previous menu - 3
```

#### 4.1 View All Courses

```
Select: 1
[Output]
=== All Courses ===
Course ID: 1 - Java Fundamentals (Type: JAVA)
  Assignment: Fundamentals (Grade: F)
  Assignment: OOP (Grade: A)

Course ID: 1 - Node Development (Type: NODE_JS)
  Assignment: Express Basics (Grade: A)
```

#### 4.2 Create Assignment for Course

```
Select: 2
Enter the course name for which you want to create an assignment:
→ Java Fundamentals

Select the assignment type:
1 - Java Assignment
2 - Node Assignment
→ 1

Enter the assignment name:
→ Arrays and Collections
[Output] Assignment created successfully with ID: 1
```

### Enrollment Service Menu

```
=== ENROLLMENT MENU ===
To update the fees - 1
To apply a discount - 2
To apply a scholarship - 3
To view current enrollment details - 4
To view deduction breakdown - 5
To mark payment as done - 6
To go back to previous menu - 7
```

#### Enrollment Example

```
Select: 1
Enter the new fees:
→ 100000
✓ Fees updated to: ₹100000.0

Select: 2
Enter the discount percentage (0-100):
→ 10
✓ Discount applied: 10.0%

Select: 3
Enter the scholarship percentage (0-100):
→ 5
✓ Scholarship applied: 5.0%

Select: 4
[Output]
╔═══════════════════════════════════════╗
║     ENROLLMENT DETAILS                ║
╠═══════════════════════════════════════╣
║ Original Fees:        ₹100000.00
║ Discount (10.0%):       -₹10000.00
║ Scholarship (5.0%):     -₹5000.00
╠═══════════════════════════════════════╣
║ Final Amount:         ₹85000.00
║ Payment Status:       PENDING
║ Enrollment Status:    ACTIVE
╚═══════════════════════════════════════╝

Select: 6
✓ Payment marked as completed
```

## Core Components

### Entity Classes

#### Person.java

**Properties:**
```java
private static int count = 0;           // Auto-increment counter
private int id;                         // Unique identifier
private String name;                    // Person's name
public EnrollmentService enrollmentService;  // Enrollment service
```

**Key Methods:**
```java
public Person(String name)              // Constructor with name
public int getId()                      // Get person ID
public String getName()                 // Get person name
public void setName(String name)        // Update name
public Student enrollPerson()           // Promote to Student
public void Display()                   // Display person info
```

**Key Features:**
- Auto-generated unique ID starting from 1
- Linked to EnrollmentService
- Foundational entity for hierarchy
- Can be promoted to Student status

---

#### Student.java

**Extends:** Person

**Properties:**
```java
private CourseList coursesList;         // List of enrolled courses
private Enrollment enrollment;          // Enrollment details
```

**Key Methods:**
```java
public Student(Person old, CourseList courseList)  // Create from Person
public CourseList getCoursesList()                  // Get courses
public void setCourseList(CourseList courseList)    // Set courses
public void addCourse(Course course)                // Add single course
public GraduateStudent graduateStudent()            // Promote to Graduate
public void Display()                               // Display student info
```

**Key Features:**
- Inherits all Person properties
- Manages list of enrolled courses
- Automatic enrollment creation
- Can be promoted to GraduateStudent

---

#### GraduateStudent.java

**Extends:** Student

**Properties:**
```java
private boolean placementStatus;        // true = placed, false = not placed
private String organisation;            // Company/Organization name
```

**Key Methods:**
```java
public GraduateStudent(Student s)                   // Create from Student
public boolean isPlaced()                           // Get placement status
public void setPlaced(boolean placed)               // Set placement status
public String getOrganisation()                     // Get company name
public void setOrganisation(String org)             // Set company name
public void Display()                               // Display details
```

**Key Features:**
- Final stage of student lifecycle
- Tracks placement status
- Records organization details
- Inherits all Student and Person properties

---

#### Course.java (Abstract)

**Properties:**
```java
private int id;                         // Auto-increment per type
private String name;                    // Course name
private COURSE_TYPE courseType;         // Type: JAVA or NODE_JS
private List<Assignment> assignments;   // Course assignments
private boolean isCompleted;            // Completion flag
```

**Implementations:**
- `JavaCourse` - Java course (auto-increment from 1)
- `NodeCourse` - Node.js course (auto-increment from 1)

**Key Methods:**
```java
public void setAssignments(Assignment a)            // Add assignment
public List<Assignment> getAssignments()            // Get all assignments
public void markCompletion()                        // Mark as complete
public boolean isCompleted()                        // Check completion
public void Display()                               // Display course
```

---

#### Assignment.java (Abstract + Gradable Interface)

**Properties:**
```java
private int id;                         // Auto-increment per type
private String name;                    // Assignment name
private GRADES grade;                   // Grade: A-F (default: F)
private COURSE_TYPE courseType;         // Type: JAVA or NODE_JS
```

**Implementations:**
- `JavaAssignment` - Java-specific (auto-increment from 1)
- `NodeAssignment` - Node-specific (auto-increment from 1)

**Key Methods:**
```java
public void setGrade(GRADES grade)                  // Set grade
public GRADES getGrade()                            // Get grade
public int getId()                                  // Get ID
public String getName()                             // Get name
public void DisplayAssignment()                     // Display info
```

---

#### Enrollment.java

**Properties:**
```java
private double fees;                    // Default: 100,000
private double discount;                // 0-100%
private double scholarship;             // 0-100%
private double finalAmount;             // Calculated final amount
private boolean isPaymentDone;          // Payment status
private boolean isEnrolled;             // Enrollment status
```

**Key Methods:**
```java
// Fee Management
public double getFees()
public void setFees(double fees) throws InvalidFeesException

// Discount & Scholarship
public void setDiscount(double discount) throws InvalidFeesException
public void setScholarship(double scholarship) throws InvalidFeesException

// Calculation
public void calculateFinalAmount()      // Main calculation method
public double getFinalAmountValue()      // Get final amount

// Payment
public void markPaymentDone()
public void markPaymentPending()
public boolean getPaymentStatus()

// Validation
public boolean isValidated()            // Check if valid
public String getDeductionBreakdown()   // Get breakdown

// Display
public void displayEnrollmentDetails()  // Show formatted details
```

**Fee Calculation Formula:**
```
Final Amount = Fees - (Fees × Discount%) - (Fees × Scholarship%)
Final Amount = Fees × (1 - Discount% - Scholarship%)
```

---

### Collection Classes

#### PersonList.java

```java
private final List<Person> personList;

// Key Methods
public void addPerson(Person person)
public void removePerson(int id)
public Person getPersonById(int id)
public boolean doesExist(int id)
public void Display()
```

#### StudentList.java

```java
private final List<Student> studentList;

// Key Methods
public void addStudent(Student student)
public void removeStudent(int id)
public Student getStudentById(int id)
public boolean doesExist(int id)
public void Display()
```

#### GraduateStudentList.java

```java
private final List<GraduateStudent> graduateStudentList;

// Key Methods
public void addGraduateStudent(GraduateStudent gs)
public void removeGraduateStudent(int id)
public GraduateStudent getGraduateStudentById(int id)
public boolean doesExist(int id)
public void Display()
```

#### CourseList.java

```java
private final List<Course> courseList;

// Key Methods
public void addCourse(Course course)
public void removeCourse(int id)
public Course getCourseByName(String name)
public boolean doesExist(String name)
public void Display()
```

---

### Service Classes

#### EnrollmentService.java

```java
public Enrollment createEnrollment(double fees) throws InvalidFeesException
public void validateFees(double fees) throws InvalidFeesException
public double calculateFinalAmount(double fees, double discount, double scholarship)
public boolean getPaymentStatus()
```

#### Cohort.java

**Central Hub - Contains All Lists:**

```java
public PersonList personList;
public StudentList studentList;
public GraduateStudentList graduateStudentList;
public CourseList courseList;

// Key Methods
public void addPerson(Person person)
public void addStudent(Student student)
public void addGraduateStudent(GraduateStudent gs)
public void addCourse(Course course)

public Person getPersonById(int id)
public Student getStudentById(int id)
public GraduateStudent getGraduateStudentById(int id)
public Course getCourseByName(String name)
```

---

### Utility Classes

#### InputValidator.java

```java
public static boolean validateFees(double fees)
public static boolean validateDiscount(double discount)
public static boolean validateScholarship(double scholarship)
public static boolean validateCombined(double discount, double scholarship)
```

**Validation Rules:**
- Fees must be > 0
- Discount: 0-100%
- Scholarship: 0-100%
- Combined: ≤ 100%

#### UtilityFunctions.java

```java
public static void DisplayMessage(String message)
public static void DisplayLine()
public static void DisplayError(String error)
```

#### Enums

**COURSE_TYPE.java:**
```java
public enum COURSE_TYPE {
    JAVA, NODE_JS
}
```

**GRADES.java:**
```java
public enum GRADES {
    A, B, C, D, E, F
}
```

#### CONSTANTS.java

```java
public static final String BACK_TO_MAIN_MENU = "Going back to previous menu...";
public static final String INVALID_CHOICE = "Invalid choice! Please select a valid option.";
// ... other constants
```

---

## API Reference

### Person API

```java
// Create
Person person = new Person("John Doe");

// Get
int id = person.getId();
String name = person.getName();
EnrollmentService service = person.getEnrollmentService();

// Update
person.setName("Jane Doe");

// Operations
Student student = person.enrollPerson();

// Display
person.Display();
```

### Student API

```java
// Create
Student student = new Student(person, courseList);

// Get
int id = student.getId();
String name = student.getName();
CourseList courses = student.getCoursesList();
Enrollment enrollment = student.enrollment;

// Update
student.setName("New Name");
student.setCourseList(newCourseList);
student.addCourse(course);

// Operations
GraduateStudent graduate = student.graduateStudent();

// Display
student.Display();
```

### GraduateStudent API

```java
// Create
GraduateStudent graduate = new GraduateStudent(student);

// Get
boolean placed = graduate.isPlaced();
String company = graduate.getOrganisation();

// Update
graduate.setPlaced(true);
graduate.setOrganisation("Google India");
graduate.setName("Dr. John Doe");

// Display
graduate.Display();
```

### Course API

```java
// Create
Course course = new JavaCourse();  // or NodeCourse()

// Add Assignment
JavaAssignment assignment = new JavaAssignment("Arrays");
course.setAssignments(assignment);

// Operations
course.markCompletion();

// Get
List<Assignment> assignments = course.getAssignments();
boolean completed = course.isCompleted();

// Display
course.Display();
```

### Assignment API

```java
// Create
JavaAssignment assignment = new JavaAssignment("Assignment 1");
// or
NodeAssignment assignment = new NodeAssignment("Assignment 1");

// Update
assignment.setGrade(GRADES.A);

// Get
GRADES grade = assignment.getGrade();
int id = assignment.getId();
String name = assignment.getName();

// Display
assignment.DisplayAssignment();
```

### Enrollment API

```java
// Create
Enrollment enrollment = new Enrollment();
// or
Enrollment enrollment = new Enrollment(100000);

// Fee Management
enrollment.setFees(100000);
double fees = enrollment.getFees();

// Discount/Scholarship
enrollment.setDiscount(10);      // 10%
enrollment.setScholarship(5);    // 5%

// Calculate
enrollment.calculateFinalAmount();
double finalAmount = enrollment.getFinalAmountValue();

// Validation
boolean valid = enrollment.isValidated();
String breakdown = enrollment.getDeductionBreakdown();

// Payment
enrollment.markPaymentDone();
boolean paid = enrollment.getPaymentStatus();

// Display
enrollment.displayEnrollmentDetails();
```

### Cohort API

```java
// Create
Cohort cohort = new Cohort();

// Person Operations
cohort.addPerson(person);
Person p = cohort.getPersonById(1);
personList.Display();

// Student Operations
cohort.addStudent(student);
Student s = cohort.getStudentById(1);
cohort.studentList.Display();

// Graduate Operations
cohort.addGraduateStudent(graduate);
GraduateStudent g = cohort.getGraduateStudentById(1);
cohort.graduateStudentList.Display();

// Course Operations
cohort.addCourse(course);
Course c = cohort.getCourseByName("Java Fundamentals");
cohort.courseList.Display();
```

---

## Fee Calculation System

### Complete Fee Breakdown Example

```
╔═══════════════════════════════════════╗
║     ENROLLMENT DETAILS                ║
╠═══════════════════════════════════════╣
║ Original Fees:        ₹100000.00
║ Discount (10.0%):       -₹10000.00
║ Scholarship (5.0%):     -₹5000.00
╠═══════════════════════════════════════╣
║ Final Amount:         ₹85000.00
║ Payment Status:       PENDING
║ Enrollment Status:    ACTIVE
╚═══════════════════════════════════════╝
```

### Calculation Steps

**Step 1: Calculate Discount Amount**
```
Discount Amount = Original Fees × (Discount % / 100)
Discount Amount = 100,000 × (10 / 100)
Discount Amount = ₹10,000
```

**Step 2: Calculate Scholarship Amount**
```
Scholarship Amount = Original Fees × (Scholarship % / 100)
Scholarship Amount = 100,000 × (5 / 100)
Scholarship Amount = ₹5,000
```

**Step 3: Calculate Final Amount**
```
Final Amount = Original Fees - Discount Amount - Scholarship Amount
Final Amount = 100,000 - 10,000 - 5,000
Final Amount = ₹85,000
```

### Validation Rules

| Rule | Constraint | Example |
|------|-----------|---------|
| **Fees** | Must be > 0 | ✓ 100,000 ✗ -100,000 |
| **Discount** | 0-100% | ✓ 50% ✗ 150% |
| **Scholarship** | 0-100% | ✓ 30% ✗ 200% |
| **Combined** | ≤ 100% | ✓ 60%+40%=100% ✗ 60%+50%=110% |

### Error Handling

```java
try {
    enrollment.setFees(100000);
    enrollment.setDiscount(10);
    enrollment.setScholarship(5);
    enrollment.calculateFinalAmount();
} catch (InvalidFeesException e) {
    System.out.println("Error: " + e.getMessage());
}
```

**Possible Errors:**
```
✗ Invalid fees amount: -100000
✗ Invalid discount amount: 150
✗ Invalid scholarship amount: 200
✗ Combined discount (60%) and scholarship (50%) cannot exceed 100%. Total: 110%
```

---

## Examples

### Example 1: Complete Student Lifecycle

```java
// Step 1: Create person
Person person = new Person("John Doe");
cohort.addPerson(person);
System.out.println("Person created with ID: " + person.getId());

// Step 2: Configure enrollment
Enrollment enrollment = person.getEnrollmentService().createEnrollment(100000);
enrollment.setDiscount(10);
enrollment.setScholarship(5);
enrollment.markPaymentDone();

// Step 3: Enroll as student
Student student = person.enrollPerson();
cohort.addStudent(student);
System.out.println("Student enrolled with ID: " + student.getId());

// Step 4: Assign courses
CourseList courseList = new CourseList();
Course javaCourse = new JavaCourse();
courseList.addCourse(javaCourse);
student.setCourseList(courseList);

// Step 5: Create assignments
JavaAssignment assignment1 = new JavaAssignment("Fundamentals");
assignment1.setGrade(GRADES.A);
javaCourse.setAssignments(assignment1);

// Step 6: Complete course
javaCourse.markCompletion();

// Step 7: Graduate
GraduateStudent graduate = student.graduateStudent();
cohort.addGraduateStudent(graduate);

// Step 8: Record placement
graduate.setPlaced(true);
graduate.setOrganisation("Google India");

// Step 9: Display
graduate.Display();
enrollment.displayEnrollmentDetails();
```

**Output:**
```
Person created with ID: 1
Student enrolled with ID: 1
Graduate Student ID: 1
Name: John Doe
Placement Status: Placed
Organization: Google India
Course Completed: Java Fundamentals
Final Grade: A

╔═══════════════════════════════════════╗
║     ENROLLMENT DETAILS                ║
╠═══════════════════════════════════════╣
║ Original Fees:        ₹100000.00
║ Discount (10.0%):       -₹10000.00
║ Scholarship (5.0%):     -₹5000.00
╠═══════════════════════════════════════╣
║ Final Amount:         ₹85000.00
║ Payment Status:       COMPLETED
║ Enrollment Status:    ACTIVE
╚═══════════════════════════════════════╝
```

### Example 2: Fee Management

```java
// Create enrollment
Enrollment enrollment = new Enrollment();

// Apply discounts
enrollment.setFees(100000);
enrollment.setDiscount(20);      // 20% discount
enrollment.setScholarship(10);   // 10% scholarship

// View breakdown
System.out.println(enrollment.getDeductionBreakdown());

// Calculate
enrollment.calculateFinalAmount();
System.out.println("Final Amount: ₹" + enrollment.getFinalAmountValue());

// Process payment
enrollment.markPaymentDone();
enrollment.displayEnrollmentDetails();
```

**Output:**
```
Discount: ₹20000.00 | Scholarship: ₹10000.00 | Total Deduction: ₹30000.00
Final Amount: ₹70000.00

╔═══════════════════════════════════════╗
║     ENROLLMENT DETAILS                ║
╠═══════════════════════════════════════╣
║ Original Fees:        ₹100000.00
║ Discount (20.0%):       -₹20000.00
║ Scholarship (10.0%):    -₹10000.00
╠═══════════════════════════════════════╣
║ Final Amount:         ₹70000.00
║ Payment Status:       COMPLETED
║ Enrollment Status:    ACTIVE
╚═══════════════════════════════════════╝
```

### Example 3: Course and Assignment Management

```java
// Create courses
Course javaCourse = new JavaCourse();
Course nodeCourse = new NodeCourse();

cohort.addCourse(javaCourse);
cohort.addCourse(nodeCourse);

// Create Java assignments
JavaAssignment javaAss1 = new JavaAssignment("Fundamentals");
JavaAssignment javaAss2 = new JavaAssignment("OOP");

javaAss1.setGrade(GRADES.A);
javaAss2.setGrade(GRADES.B);

javaCourse.setAssignments(javaAss1);
javaCourse.setAssignments(javaAss2);

// Create Node assignment
NodeAssignment nodeAss = new NodeAssignment("Express Basics");
nodeAss.setGrade(GRADES.A);
nodeCourse.setAssignments(nodeAss);

// Display all
cohort.courseList.Display();
```

**Output:**
```
=== All Courses ===
Course ID: 1 - JavaCourse (Type: JAVA)
  Assignment ID: 1 - Fundamentals (Grade: A)
  Assignment ID: 2 - OOP (Grade: B)

Course ID: 1 - NodeCourse (Type: NODE_JS)
  Assignment ID: 1 - Express Basics (Grade: A)
```

---

## Error Handling

### Exception Hierarchy

```
Exception
└── InvalidFeesException
    ├── Invalid fees amount
    ├── Invalid discount amount
    ├── Invalid scholarship amount
    └── Combined deduction exceeds 100%
```

### Error Scenarios

#### 1. Invalid Fees

```java
try {
    enrollment.setFees(-1000);
} catch (InvalidFeesException e) {
    System.out.println("Error: " + e.getMessage());
    // Output: Invalid fees amount: -1000
}
```

#### 2. Invalid Discount

```java
try {
    enrollment.setDiscount(150);  // > 100%
} catch (InvalidFeesException e) {
    System.out.println("Error: " + e.getMessage());
    // Output: Invalid discount amount: 150
}
```

#### 3. Combined Exceeds 100%

```java
try {
    enrollment.setDiscount(60);
    enrollment.setScholarship(50);  // Total = 110%
} catch (InvalidFeesException e) {
    System.out.println("Error: " + e.getMessage());
    // Output: Combined discount (60%) and scholarship (50%) cannot exceed 100%.
}
```

#### 4. Entity Not Found

```java
if (!cohort.personList.doesExist(999)) {
    System.out.println("Person with ID 999 not found.");
}
```

#### 5. Type Mismatch (Assignment vs Course)

```java
Course nodeCourse = new NodeCourse();
JavaAssignment javaAss = new JavaAssignment("Test");

// Type validation needed
if (nodeCourse.getCourseType() != javaAss.getCourseType()) {
    System.out.println("Cannot add Java assignment to Node course");
}
```

---

## Database Schema

### Logical Entity Relationships

```
Person (1) ─── (1) EnrollmentService
  │
  ├─ ID
  ├─ Name
  └─ Enrollment
      ├─ Fees
      ├─ Discount
      ├─ Scholarship
      ├─ Final Amount
      └─ Payment Status
       │
       └─→ (1) Student
            │
            ├─ CourseList
            │   └─ (many) Course
            │       └─ (many) Assignment
            │
            └─→ (1) GraduateStudent
                 ├─ Placement Status
                 └─ Organisation
```

### Relational Schema (Future Implementation)

```sql
-- Person Table
CREATE TABLE Person (
    PersonID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100) NOT NULL,
    Type VARCHAR(20),
    CreatedDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Enrollment Table
CREATE TABLE Enrollment (
    EnrollmentID INT PRIMARY KEY AUTO_INCREMENT,
    PersonID INT NOT NULL UNIQUE REFERENCES Person(PersonID),
    Fees DOUBLE DEFAULT 100000,
    Discount DOUBLE DEFAULT 0,
    Scholarship DOUBLE DEFAULT 0,
    FinalAmount DOUBLE,
    PaymentStatus VARCHAR(20),
    IsEnrolled BOOLEAN DEFAULT TRUE,
    EnrollmentDate TIMESTAMP,
    FOREIGN KEY (PersonID) REFERENCES Person(PersonID)
);

-- Student Table
CREATE TABLE Student (
    StudentID INT PRIMARY KEY REFERENCES Person(PersonID),
    EnrollmentDate DATE NOT NULL,
    Status VARCHAR(20),
    FOREIGN KEY (StudentID) REFERENCES Person(PersonID)
);

-- Course Table
CREATE TABLE Course (
    CourseID INT PRIMARY KEY AUTO_INCREMENT,
    CourseName VARCHAR(100) NOT NULL,
    CourseType VARCHAR(20),
    IsCompleted BOOLEAN DEFAULT FALSE,
    CreatedDate TIMESTAMP
);

-- Assignment Table
CREATE TABLE Assignment (
    AssignmentID INT PRIMARY KEY AUTO_INCREMENT,
    CourseID INT NOT NULL REFERENCES Course(CourseID),
    AssignmentName VARCHAR(100) NOT NULL,
    AssignmentType VARCHAR(20),
    Grade VARCHAR(1),
    Version DOUBLE,
    FOREIGN KEY (CourseID) REFERENCES Course(CourseID)
);

-- StudentCourse Junction Table
CREATE TABLE StudentCourse (
    StudentID INT NOT NULL REFERENCES Student(StudentID),
    CourseID INT NOT NULL REFERENCES Course(CourseID),
    EnrollmentDate DATE,
    CompletionDate DATE,
    PRIMARY KEY (StudentID, CourseID),
    FOREIGN KEY (StudentID) REFERENCES Student(StudentID),
    FOREIGN KEY (CourseID) REFERENCES Course(CourseID)
);

-- GraduateStudent Table
CREATE TABLE GraduateStudent (
    GraduateID INT PRIMARY KEY REFERENCES Student(StudentID),
    PlacementStatus BOOLEAN,
    Organisation VARCHAR(100),
    PlacementDate DATE,
    FOREIGN KEY (GraduateID) REFERENCES Student(StudentID)
);
```

---

## Troubleshooting

### Common Issues & Solutions

#### Issue 1: ClassNotFoundException

**Error:**
```
Exception in thread "main" java.lang.ClassNotFoundException: 
main.java.com.Airtribe.StudentManagement.Main
```

**Solutions:**
```bash
# 1. Verify classpath includes compiled classes
java -cp .:out main.java.com.Airtribe.StudentManagement.Main

# 2. Recompile the project
javac -d out src/main/java/com/Airtribe/StudentManagement/**/*.java

# 3. Check Main.java has correct package declaration
# Should be: package main.java.com.Airtribe.StudentManagement;
```

---

#### Issue 2: Scanner Input Not Reading Properly

**Error:**
```
Exception in thread "main" java.util.InputMismatchException
```

**Solution:**
```java
// ✓ CORRECT: Always clear buffer after nextInt()
int choice = scanner.nextInt();
scanner.nextLine();  // ← Clear the newline character

String name = scanner.nextLine();  // Now reads correctly
```

**Wrong Way:**
```java
// ❌ WRONG: No buffer clear
int choice = scanner.nextInt();
String name = scanner.nextLine();  // Reads empty line instead of input
```

---

#### Issue 3: NullPointerException

**Error:**
```
Exception in thread "main" java.lang.NullPointerException
    at PersonDriver.addNewPerson(PersonDriver.java:...)
```

**Solution:**
```java
// ✓ CORRECT: Always check existence before using
if (cohort.personList.doesExist(id)) {
    Person person = cohort.getPersonById(id);
    // Safe to use person
} else {
    DisplayMessage("Person not found");
}

// ❌ WRONG: Assuming object exists
Person person = cohort.getPersonById(999);  // Returns null if not found
person.setName("Test");  // NullPointerException!
```

---

#### Issue 4: Person Not Found After Enrollment

**Problem:** After enrolling a person, they can't be found in PersonList

**Solution:**
```java
// Person is removed from PersonList when enrolled as Student
// This is the CORRECT behavior

// To use them, access from StudentList instead:
Student student = cohort.getStudentById(id);

// Original person ID is preserved:
student.getId();  // Same ID as original person
```

---

#### Issue 5: Fee Calculation Error

**Problem:** Final amount is higher than original fee after applying discounts

**Solution:**
```java
// ✓ CORRECT: Subtract deductions
finalAmount = fees - discountAmount - scholarshipAmount;

// ❌ WRONG: Adding deductions
finalAmount = fees + discountAmount + scholarshipAmount;  // Wrong!

// Example:
// Original: ₹100,000
// Discount 10%: ₹10,000
// Scholarship 5%: ₹5,000

// ✓ Correct: 100,000 - 10,000 - 5,000 = ₹85,000
// ❌ Wrong: 100,000 + 10,000 + 5,000 = ₹115,000
```

---

#### Issue 6: Combined Discount/Scholarship Exceeds 100%

**Error:**
```
Combined discount (60%) and scholarship (50%) cannot exceed 100%. Total: 110%
```

**Solution:**
```java
// Keep combined value ≤ 100%

// ✓ Valid combinations:
enrollment.setDiscount(60);
enrollment.setScholarship(40);  // Total = 100% ✓

enrollment.setDiscount(50);
enrollment.setScholarship(30);  // Total = 80% ✓

// ❌ Invalid combinations:
enrollment.setDiscount(60);
enrollment.setScholarship(50);  // Total = 110% ✗
```

---

#### Issue 7: Payment Not Completed

**Problem:** Student can't be enrolled because payment is not marked as done

**Solution:**
```java
// Step 1: Configure enrollment
Enrollment enrollment = person.getEnrollmentService().createEnrollment(100000);
enrollment.setDiscount(10);
enrollment.setScholarship(5);

// Step 2: Mark payment as done
enrollment.markPaymentDone();  // ← Required before enrollment

// Step 3: Now can enroll
Student student = person.enrollPerson();  // Works now!
```

---

#### Issue 8: Assignment Type Mismatch

**Error:**
```
Cannot add Java assignment to Node course
```

**Solution:**
```java
// ✓ CORRECT: Match assignment type with course type
Course javaCourse = new JavaCourse();
JavaAssignment javaAss = new JavaAssignment("Test");
javaCourse.setAssignments(javaAss);  // Works!

// ❌ WRONG: Type mismatch
Course nodeCourse = new NodeCourse();
JavaAssignment javaAss = new JavaAssignment("Test");
nodeCourse.setAssignments(javaAss);  // Error!

// Use correct assignment type:
NodeAssignment nodeAss = new NodeAssignment("Test");
nodeCourse.setAssignments(nodeAss);  // Works!
```

---

### Debug Tips

#### 1. Enable Debug Output

```java
// Add debug messages to track execution
DisplayMessage("[DEBUG] Starting enrollment process");
DisplayMessage("[DEBUG] Person ID: " + person.getId());
DisplayMessage("[DEBUG] Current fees: " + enrollment.getFees());
```

#### 2. Check Object State

```java
// Verify object properties before using
System.out.println("Person exists: " + cohort.personList.doesExist(id));
System.out.println("Student exists: " + cohort.studentList.doesExist(id));

Person p = cohort.getPersonById(id);
if (p != null) {
    System.out.println("Person name: " + p.getName());
} else {
    System.out.println("Person not found!");
}
```

#### 3. Print Stack Traces

```java
try {
    // Operation
} catch (Exception e) {
    e.printStackTrace();  // Shows full error trace
}
```

#### 4. Add Breakpoints (IntelliJ/Eclipse)

```
1. Click on line number to add breakpoint (red dot)
2. Run in Debug mode (Shift+F9)
3. Step through code (F10)
4. Inspect variables in Debug panel
```

---

## Known Issues & Fixes

### ✅ FIXED: main() Method Signature

**Issue:** `main()` without `String[] args` parameter  
**Status:** ✅ FIXED  
**Fix Applied:** Changed to `public static void main(String[] args)`

---

### ✅ FIXED: Fees Calculation Logic

**Issue:** Using `+` instead of `-` for calculating final amount  
**Status:** ✅ FIXED  
**Fix Applied:** Changed to correct formula: `finalAmount = fees - discount - scholarship`

---

### ✅ FIXED: Person Enrollment Issue

**Issue:** Person not found after enrollment  
**Status:** ✅ FIXED  
**Root Cause:** Order of operations in PersonDriver.enrollPersonToStudent()  
**Fix Applied:** 
1. Check payment status first
2. Get person reference
3. Enroll to create student
4. Add to StudentList
5. Remove from PersonList

---

### ✅ FIXED: Missing break; Statement in StudentDriver

**Issue:** Fall-through in switch case 4  
**Status:** ✅ FIXED  
**Fix Applied:** Added `break;` after case 4

---

### ✅ FIXED: Graduate Student Menu Display

**Issue:** Menu displayed "7" twice instead of "6" and "7"  
**Status:** ✅ FIXED  
**Fix Applied:** Corrected menu option numbering

---

## Future Enhancements

### Phase 2: Database Integration
- [ ] MySQL/PostgreSQL connection
- [ ] JDBC implementation
- [ ] Entity persistence
- [ ] Query optimization
- [ ] Backup & recovery

### Phase 3: REST API Development
- [ ] Spring Boot setup
- [ ] RESTful endpoints
- [ ] JSON serialization
- [ ] API authentication (JWT)
- [ ] API documentation (Swagger)

### Phase 4: Web UI
- [ ] React/Angular frontend
- [ ] Admin dashboard
- [ ] Student portal
- [ ] Real-time notifications
- [ ] Responsive design

### Phase 5: Advanced Features
- [ ] Attendance tracking
- [ ] Online assignment submission
- [ ] Automated grading
- [ ] Performance analytics
- [ ] Placement drive management
- [ ] Email notifications
- [ ] SMS alerts
- [ ] Certificate generation

### Phase 6: Enterprise Integration
- [ ] Docker containerization
- [ ] CI/CD pipeline (GitHub Actions)
- [ ] Cloud deployment (AWS/Azure/GCP)
- [ ] Load balancing
- [ ] Security hardening
- [ ] Performance monitoring

### Phase 7: Analytics & Reporting
- [ ] Advanced reporting engine
- [ ] BI dashboards
- [ ] Data export (Excel/PDF)
- [ ] Batch processing
- [ ] Statistical analysis

---

## Contributing Guidelines

### Getting Started

1. **Fork the Repository**
   ```bash
   git clone https://github.com/shubhamsaini/StudentManagement.git
   cd StudentManagement
   ```

2. **Create Feature Branch**
   ```bash
   git checkout -b feature/your-feature-name
   ```

3. **Make Changes**
   - Follow code standards (see below)
   - Add comments for complex logic
   - Test thoroughly

4. **Commit Changes**
   ```bash
   git add .
   git commit -m "Add your feature description"
   ```

5. **Push to Branch**
   ```bash
   git push origin feature/your-feature-name
   ```

6. **Submit Pull Request**
   - Describe changes clearly
   - Reference any related issues
   - Wait for review

### Code Standards

#### Naming Conventions

```java
// ✓ Classes: PascalCase
public class StudentManagementSystem { }

// ✓ Methods: camelCase
public void addNewStudent() { }

// ✓ Constants: UPPER_SNAKE_CASE
public static final double DEFAULT_FEES = 100000;

// ✓ Variables: camelCase
private String studentName;

// ✓ Booleans: is/has prefix
private boolean isPlaced;
private boolean hasEnrolled;
```

#### Code Style

```java
// 1. Use meaningful names
❌ String s = "John";
✅ String studentName = "John";

// 2. Single responsibility per method
❌ public void createAndGradeAssignment() { }
✅ public void createAssignment() { }
✅ public void gradeAssignment() { }

// 3. Add JavaDoc comments
/**
 * Calculates final enrollment amount after applying discounts and scholarships.
 * @param fees Original enrollment fee
 * @param discount Discount percentage (0-100)
 * @param scholarship Scholarship percentage (0-100)
 * @return Final amount to be paid
 * @throws InvalidFeesException if parameters are invalid
 */
public double calculateFinalAmount(double fees, double discount, double scholarship)

// 4. Handle exceptions properly
try {
    enrollment.setFees(amount);
} catch (InvalidFeesException e) {
    logger.error("Invalid fee amount: " + amount, e);
    throw e;
}

// 5. Use constants instead of magic numbers
❌ if (discount > 100) { }
✅ if (discount > MAX_DISCOUNT_PERCENTAGE) { }
```

#### Testing

```java
// Add unit tests for new methods
@Test
public void testFeeCalculation() {
    Enrollment enrollment = new Enrollment();
    enrollment.setFees(100000);
    enrollment.setDiscount(10);
    enrollment.setScholarship(5);
    enrollment.calculateFinalAmount();
    
    double expected = 85000;
    assertEquals(expected, enrollment.getFinalAmountValue(), 0.01);
}
```

### Pull Request Checklist

- [ ] Code follows style guide
- [ ] Comments added for complex logic
- [ ] Tests written/updated
- [ ] README updated if needed
- [ ] No debug prints left
- [ ] Compiles without warnings
- [ ] Functionality tested manually

---

## FAQ

### General Questions

**Q: What is the default enrollment fee?**  
A: The default enrollment fee is ₹100,000. This can be modified using `setFees()` method.

---

**Q: Can I apply both discount and scholarship?**  
A: Yes, you can apply both. However, their combined value cannot exceed 100%.

**Example:**
```
✓ 60% discount + 40% scholarship = 100% total reduction
✓ 50% discount + 30% scholarship = 80% total reduction
✗ 60% discount + 50% scholarship = 110% (exceeds limit)
```

---

**Q: What happens when a student is graduated?**  
A: When a student is graduated, they are promoted from the `Student` class to `GraduateStudent` class. They can now track placement status and record their organization details.

---

**Q: Can I have courses without assignments?**  
A: Yes, courses are independent. You can create courses without assignments.

---

**Q: Are assignment IDs auto-incremented per type?**  
A: Yes. JavaAssignments have their own counter starting from 1, and NodeAssignments have their own counter starting from 1.

---

### Technical Questions

**Q: What package structure is used?**  
A: `main.java.com.Airtribe.StudentManagement` with sub-packages:
- Entities
- Service
- Driver
- Interfaces
- Util
- Exceptions

---

**Q: How can I extend the system?**  
A: The system uses abstract classes (Course, Assignment) and interfaces that you can extend. Follow existing patterns for consistency.

---

**Q: Can I use this with a database?**  
A: Currently, data is stored in-memory. To use a database, implement a persistence layer using JDBC or Hibernate.

---

**Q: Is the system thread-safe?**  
A: No. For multi-threaded access, add synchronization to collection operations.

---

### Operational Questions

**Q: How do I backup data?**  
A: Data is currently in-memory. Export collections to file (CSV/JSON) or implement database persistence.

---

**Q: Can I delete a person with active enrollments?**  
A: Currently yes, but it's recommended to implement constraints preventing this.

---

**Q: How many students can the system handle?**  
A: Theoretically unlimited (limited by RAM). For production with thousands of records, use a database backend.

---

**Q: Can I modify enrolled fees after payment?**  
A: Yes, using `setFees()`, but track amendments separately for audit purposes.

---

**Q: What about data recovery?**  
A: No current backup mechanism. Data is lost on application exit. Implement database or file-based backup.

---

## License

This project is licensed under the **MIT License**.

```
MIT License

Copyright (c) 2024 Shubham Saini

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"),