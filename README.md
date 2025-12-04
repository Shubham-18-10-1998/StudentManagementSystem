# Student Management System

A comprehensive Java-based application for managing the complete student lifecycle from enrollment through graduation and placement tracking. This system provides functionality to manage persons, students, graduate students, courses, and assignments with a hierarchical organizational structure and robust enrollment management.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Project Structure](#project-structure)
- [Installation & Setup](#installation--setup)
- [Usage Guide](#usage-guide)
- [Core Components](#core-components)
- [Fee Calculation System](#fee-calculation-system)
- [Error Handling](#error-handling)
- [Troubleshooting](#troubleshooting)
- [Contributing](#contributing)
- [FAQ](#faq)
- [License](#license)

## Overview

The Student Management System (SMS) is designed to streamline educational institution operations by providing a unified platform for:

- **Personnel Management**: Register and manage persons within the institution
- **Student Lifecycle**: Track students from enrollment to graduation
- **Career Tracking**: Monitor graduate placement status and details
- **Course Administration**: Manage Java and Node.js courses with assignments
- **Financial Management**: Handle fees, discounts, scholarships, and payment tracking

### Tech Stack

| Component | Technology |
|-----------|-----------|
| **Language** | Java 25+ |
| **Database** | In-Memory (ArrayList) |
| **Design Patterns** | MVC, Service, Factory |

## Features

### ✅ Person Management
- Add/remove persons with auto-generated IDs
- Search persons by ID
- Enroll persons as students
- Update person information
- View all persons in database

### ✅ Student Management
- Enroll students with automatic course list
- Assign courses to students
- Graduate students to graduate status
- Update student names
- Remove students from system
- Display all students

### ✅ Graduate Student Management
- Track placement status (placed/not placed)
- Record organization/company details
- Remove graduates from system
- View graduate student details

### ✅ Course Management
- Two course types: **Java Course** and **Node.js Course**
- Auto-incremented IDs per type
- Create multiple courses
- Add type-specific assignments
- Mark courses as complete

### ✅ Enrollment & Financial Management
- **Default fee**: ₹100,000
- **Discount**: 0-100%
- **Scholarship**: 0-100%
- **Validation**: Combined discount + scholarship ≤ 100%
- **Calculation**: `Final Amount = Fees × (1 - Discount% - Scholarship%)`
- **Payment tracking**: Mark payments as completed/pending

## Project Structure

```
src/main/java/com/Airtribe/StudentManagement/
│
├── Main.java                              # Entry point with CLI menu
│
├── Entities/
│   ├── Person/
│   │   ├── Person.java                   # Base person entity
│   │   ├── Student.java                  # Student extending Person
│   │   └── GraduateStudent.java          # Graduate extending Student
│   │
│   ├── Course/
│   │   ├── Course.java                   # Abstract course base
│   │   ├── JavaCourse.java               # Java course implementation
│   │   └── NodeCourse.java               # Node.js course implementation
│   │
│   ├── Assignment/
│   │   ├── Assignment.java               # Abstract assignment base
│   │   ├── JavaAssignment.java           # Java assignment implementation
│   │   └── NodeAssignment.java           # Node assignment implementation
│   │
│   ├── Collections/
│   │   ├── PersonList.java               # Person collection manager
│   │   ├── StudentList.java              # Student collection manager
│   │   ├── GraduateStudentList.java      # Graduate collection manager
│   │   └── CourseList.java               # Course collection manager
│   │
│   ├── Cohort/
│   │   └── Cohort.java                   # Central container for all lists
│   │
│   └── Enrollment.java                   # Enrollment & fee management
│
├── Service/
│   └── EnrollmentService.java            # Enrollment operations service
│
├── Driver/
│   ├── PersonDriver.java                 # Person operations menu
│   ├── StudentDriver.java                # Student operations menu
│   ├── GraduateStudentDriver.java        # Graduate student menu
│   ├── CourseDriver.java                 # Course operations menu
│   └── EnrollmentDriver.java             # Enrollment operations menu
│
├── Interfaces/
│   ├── SearchableWithID.java             # ID-based search interface
│   ├── SearchableWithName.java           # Name-based search interface
│   └── Gradable.java                     # Grading interface
│
├── Util/
│   ├── CONSTANTS.java                    # Constant messages
│   ├── COURSE_TYPE.java                  # Course type enum
│   ├── GRADES.java                       # Grade enum (A-F)
│   ├── InputValidator.java               # Input validation logic
│   └── UtilityFunctions.java             # Display utilities
│
└── Exceptions/
    └── InvalidFeesException.java         # Custom fee exception
```

## Installation & Setup

### Prerequisites

- Java JDK 17+ (recommended: 25+)
- Any IDE (IntelliJ IDEA, VS Code, Eclipse) or terminal

### Quick Start

```bash
# Clone/Navigate to repository
cd StudentManagement

# Create output directory
mkdir -p out

# Compile
javac -d out src/main/java/com/Airtribe/StudentManagement/**/*.java

# Run
java -cp out main.java.com.Airtribe.StudentManagement.Main
```

### Using IntelliJ IDEA

1. Open the project folder
2. IntelliJ will recognize it as a Java project
3. Configure JDK 25+ if needed
4. Run Main.java directly

## Usage Guide

### Main Menu

```
Please select an input in accordance with the action you seek to perform:
For Person based operations - 1
For Student based operations - 2
For Graduate student based operations - 3
For Course based operations - 4
To exit application - 5
```

### Menu 1: Person Operations

```
If you wish to add a new person - 1
If you wish to remove a person with given id - 2
If you wish to enroll a person to student status - 3
If you wish to update the name for a person - 4
If you wish to view details for a person - 5
If you wish to display all the people currently in the database - 6
If you wish to interact with the enrollment service for a person - 7
If you wish to go back to previous menu - 8
```

**Example: Add Person**
```
Select: 1
Enter the name of the person:
→ John Doe
Person with ID: 1 has been added successfully.
```

**Example: Enroll Person as Student**
```
Select: 3
Enter the ID of the person to enroll:
→ 1
Person has been successfully enrolled as a student.
```

### Menu 2: Student Operations

```
If you wish to graduate a student - 1
If you wish to remove a student with given id - 2
If you wish to change the name for a student with given id - 3
If you wish to assign a course to the student - 4
If you wish to display all the students currently in the database - 5
If you wish to display all the details for a students currently in the database - 6
If you wish to go back to previous menu - 7
```

**Example: Assign Course**
```
Select: 4
Enter the ID of the student:
→ 1
All the Courses currently in the cohort are as follows:
  Course 1: JAVA_1 (Java)
  Course 2: NODE_JS_1 (Node.js)
Enter course name:
→ JAVA_1
Operation performed successfully!
```

### Menu 3: Graduate Student Operations

```
If you wish to change the name of a graduate student - 1
If you wish to remove a graduate student with given id - 2
If you wish to set placement status for graduate student - 3
If you wish to set organisation for a graduate student - 4
If you wish to display all details for a graduate student - 5
If you wish to display all the graduate student in the database - 6
If you wish to go back to previous menu - 7
```

**Example: Update Placement Status**
```
Select: 3
Enter the ID of the graduate student:
→ 1
Enter the status for placement
1 - true
2 - false
→ 1
Operation performed successfully!
```

### Menu 4: Course Operations

```
If you wish to view all courses - 1
If you wish to all details for a specific course - 2
If you wish to create a new course - 3
If you wish to create a new assignment for a course - 4
If you wish to set course completion for a course - 5
If you wish to remove a course - 6
If you wish to go back to previous menu - 7
```

**Example: Create Assignment**
```
Select: 4
Enter the course name:
→ JAVA_1
Select the assignment type:
1 - Java Assignment
2 - Node Assignment
→ 1
Enter the assignment name:
→ Arrays and Collections
Assignment added to course successfully
```

## Core Components

### Entity Hierarchy

```
Person (Base)
  ├─ ID (auto-increment)
  ├─ Name
  ├─ EnrollmentService
  │
  └─→ Student (Extends Person)
       ├─ CourseList
       │
       └─→ GraduateStudent (Extends Student)
            ├─ Placement Status
            └─ Organisation
```

### Course & Assignment Hierarchy

```
Course (Abstract)
  ├─ JavaCourse (ID auto-increment)
  │   └─ JavaAssignment
  │
  └─ NodeCourse (ID auto-increment)
      └─ NodeAssignment
```

### Key Classes

| Class | Purpose |
|-------|---------|
| [`Person`](src/main/java/com/Airtribe/StudentManagement/Entities/Person/Person.java) | Base entity with auto-increment ID |
| [`Student`](src/main/java/com/Airtribe/StudentManagement/Entities/Person/Student.java) | Extends Person, manages courses |
| [`GraduateStudent`](src/main/java/com/Airtribe/StudentManagement/Entities/Person/GraduateStudent.java) | Extends Student, tracks placement |
| [`Course`](src/main/java/com/Airtribe/StudentManagement/Entities/Course/Course.java) | Abstract base for Java/Node courses |
| [`Enrollment`](src/main/java/com/Airtribe/StudentManagement/Entities/Enrollment.java) | Manages fees and payments |
| [`Cohort`](src/main/java/com/Airtribe/StudentManagement/Entities/Cohort/Cohort.java) | Central container for all lists |
| [`EnrollmentService`](src/main/java/com/Airtribe/StudentManagement/Service/EnrollmentService.java) | Handles enrollment operations |

## Fee Calculation System

### Complete Example

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

### Calculation Formula

$$\text{Final Amount} = \text{Fees} \times (1 - \frac{\text{Discount\%}}{100} - \frac{\text{Scholarship\%}}{100})$$

### Validation Rules

| Rule | Constraint | Example |
|------|-----------|---------|
| **Fees** | Must be > 0 | ✓ 100,000 ✗ -100,000 |
| **Discount** | 0-100% | ✓ 50% ✗ 150% |
| **Scholarship** | 0-100% | ✓ 30% ✗ 200% |
| **Combined** | ≤ 100% | ✓ 60%+40%=100% ✗ 60%+50%=110% |

## Error Handling

### Custom Exceptions

**InvalidFeesException** - Thrown when fee validation fails

### Common Errors & Solutions

```
✗ Invalid fees amount: negative value
  Solution: Ensure fees > 0

✗ Invalid discount amount: > 100%
  Solution: Discount must be between 0-100

✗ Combined discount + scholarship exceeds 100%
  Solution: Keep combined value ≤ 100%

✗ Cannot add Java assignment to Node course
  Solution: Use appropriate assignment type for course

✗ Person not found with given ID
  Solution: Verify ID exists before operation

✗ Payment not completed - cannot enroll
  Solution: Mark payment as done before enrolling
```

## Troubleshooting

### Issue 1: ClassNotFoundException

```bash
# Recompile all files
javac -d out src/main/java/com/Airtribe/StudentManagement/**/*.java

# Run with proper classpath
java -cp out main.java.com.Airtribe.StudentManagement.Main
```

### Issue 2: Scanner Input Not Reading

```java
// CORRECT: Always clear buffer after nextInt()
int choice = scanner.nextInt();
scanner.nextLine();  // ← Important!
```

### Issue 3: NullPointerException

```java
// Check existence before using
if (cohort.personList.doesExist(id)) {
    Person person = cohort.getPersonById(id);
}
```

### Issue 4: Fee Calculation Error

```java
// CORRECT: Subtract deductions
finalAmount = fees - discount - scholarship;

// WRONG: Don't add them!
finalAmount = fees + discount + scholarship;
```

### Issue 5: Combined Discount/Scholarship Exceeds 100%

```
✗ Discount 60% + Scholarship 50% = 110% (exceeds limit)
✓ Discount 60% + Scholarship 40% = 100% (valid)
```

## Contributing

### Code Standards

- Use meaningful variable names
- Single responsibility per method
- Add comments for complex logic
- No magic numbers (use constants)
- Follow Java naming conventions

### Git Workflow

```bash
# Create feature branch
git checkout -b feature/your-feature

# Make changes and commit
git add .
git commit -m "Add your feature description"

# Push and create pull request
git push origin feature/your-feature
```

## FAQ

**Q: What is the default fee?**  
A: ₹100,000 (modifiable via `setFees()`)

**Q: Can I apply both discount and scholarship?**  
A: Yes, but combined cannot exceed 100%

**Q: What happens when a student graduates?**  
A: They're promoted from Student to GraduateStudent class

**Q: Are assignment IDs auto-incremented per type?**  
A: Yes, JavaAssignments and NodeAssignments have separate counters

**Q: Is the system thread-safe?**  
A: No, add synchronization for multi-threaded access

**Q: How many students can the system handle?**  
A: Theoretically unlimited (limited by RAM). For production, use database backend.

## Future Enhancements

- [ ] Database integration (MySQL/PostgreSQL)
- [ ] REST API (Spring Boot)
- [ ] Web UI (React/Angular)
- [ ] Attendance tracking
- [ ] Online assignment submission
- [ ] Performance analytics
- [ ] Docker containerization
- [ ] Cloud deployment (AWS/GCP)

## Known Issues & Fixes

✅ **FIXED**: main() method signature  
✅ **FIXED**: Fees calculation logic (was adding instead of subtracting)  
✅ **FIXED**: Person enrollment order of operations  
✅ **FIXED**: Graduate student menu numbering  

## License

MIT License - See LICENSE file for details

## Support

For issues, questions, or suggestions, please open a GitHub issue.

---

**Author**: [Shubham Saini](https://github.com/Shubham-18-10-1998)  
**Last Updated**: 2025