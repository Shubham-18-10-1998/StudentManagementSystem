package main.java.com.Airtribe.StudentManagement.Driver;

import main.java.com.Airtribe.StudentManagement.Entities.Cohort.Cohort;
import main.java.com.Airtribe.StudentManagement.Entities.Collections.CourseList;
import main.java.com.Airtribe.StudentManagement.Entities.Course.Course;
import main.java.com.Airtribe.StudentManagement.Entities.Person.Student;

import java.util.Scanner;

import static main.java.com.Airtribe.StudentManagement.Util.CONSTANTS.*;
import static main.java.com.Airtribe.StudentManagement.Util.UtilityFunctions.DisplayLine;
import static main.java.com.Airtribe.StudentManagement.Util.UtilityFunctions.DisplayMessage;

public class StudentDriver {
    static Scanner scanner = new Scanner(System.in);

    public static void studentDriver(Cohort cohort) {
        DisplayMessage("If you wish to graduate a student - 1");
        DisplayMessage("If you wish to remove a student with given id - 2");
        DisplayMessage("If you wish to change the name for  a student with given id - 3");
        DisplayMessage("If you wish to assign a course to the student - 4");
        DisplayMessage("If you wish to display all the students currently in the database - 5");
        DisplayMessage("If you wish to display all the details for a students currently in the database - 6");
        DisplayMessage("If you wish to go back to previous menu - 7");
        int innerChoice = scanner.nextInt();
        scanner.nextLine();//Clear Buffer
        switch (innerChoice) {
            case 1:
                graduateStudent(cohort);
                break;
            case 2:
                removeStudentById(cohort);
                break;
            case 3:
                changeStudentName(cohort);
                break;
            case 4 :
                assignCourseToStudent(cohort);
                break;
            case 5:
                displayAllStudents(cohort);
                break;
            case 6:
                displayAllStudentDetails(cohort);
                break;
            case 7:
                DisplayMessage(BACK_TO_MAIN_MENU);
                break;
            default:
                DisplayMessage(INVALID_CHOICE);
        }
    }

    private static void graduateStudent(Cohort cohort) {
        DisplayMessage("Enter the ID of the student to graduate:");
        int studentId = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        
        if (cohort.getStudentList().doesExist(studentId)) {
            try {
                Student student = cohort.getStudentById(studentId);
                cohort.addGraduateStudent(student.graduateStudent());
                DisplayMessage("Student has been successfully graduated.");
            } catch (IllegalStateException e) {
                DisplayMessage("Error: " + e.getMessage());
            }
        } else {
            DisplayMessage("Student with ID " + studentId + " not found.");
        }
    }

    private static void removeStudentById(Cohort cohort) {
        DisplayMessage("Enter the ID of the student to remove:");
        int studentId = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        
        cohort.getStudentList().removeStudent(studentId);
    }

    private static void changeStudentName(Cohort cohort) {
        DisplayMessage("Enter the ID of the student:");
        int studentId = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        
        if (cohort.getStudentList().doesExist(studentId)) {
            Student student = cohort.getStudentById(studentId);
            DisplayMessage("Enter the new name:");
            String newName = scanner.nextLine();
            student.setName(newName);
            DisplayMessage("Student name has been updated successfully.");
        } else {
            DisplayMessage("Student with ID " + studentId + " not found.");
        }
    }

    public static void assignCourseToStudent(Cohort cohort){
        DisplayMessage("Enter the ID of the student:");
        int studentId = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        if(!cohort.getStudentList().doesExist(studentId)){
            DisplayMessage("No student with given id found. Please try again later with valid input");
            return;
        }
        Student student = cohort.getStudentById(studentId);

        CourseList courseListCohort = cohort.getCourseList();
        DisplayMessage("All the Courses currently in the cohort are as follows : ");
        courseListCohort.Display();
        DisplayMessage("If you wish to create a new course, please use the Course Menu, Thank you!");
        DisplayMessage("If you wish to continue press 1, for all other inputs current process will be terminated");
        int input = scanner.nextInt();
        scanner.nextLine(); //Clear Buffer
        if(input != 1){
            DisplayMessage(PROCESS_TERMINATED);
            return;
        }
        DisplayMessage("Please enter the course_name you wish to assign to the selected student with id :" + studentId);
        String courseName = scanner.nextLine();
        if(!courseListCohort.doesExist(courseName)){
            DisplayMessage("No such course exists to assign to student");
            return;
        }
        Course selectedCourse = cohort.getCourseByName(courseName);
        student.assignCourse(selectedCourse);
        DisplayMessage(SUCCESS_MESSAGE);
    }

    private static void displayAllStudents(Cohort cohort) {
        DisplayMessage("=== All Students in Database ===");
        cohort.getStudentList().Display();
        DisplayLine();
    }

    private static void displayAllStudentDetails(Cohort cohort) {
        DisplayMessage("Enter the ID of the student:");
        int studentId = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        if (cohort.getStudentList().doesExist(studentId)) {
            DisplayMessage("=== Student Details ===");
            Student student = cohort.getStudentById(studentId);
            student.Display();
        } else {
            DisplayMessage("Student with ID " + studentId + " not found.");
        }
    }
}