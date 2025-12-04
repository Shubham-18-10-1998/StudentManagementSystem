package main.java.com.Airtribe.StudentManagement.Driver;

import main.java.com.Airtribe.StudentManagement.Entities.Assignment.JavaAssignment;
import main.java.com.Airtribe.StudentManagement.Entities.Assignment.NodeAssignment;
import main.java.com.Airtribe.StudentManagement.Entities.Cohort.Cohort;
import main.java.com.Airtribe.StudentManagement.Entities.Collections.CourseList;
import main.java.com.Airtribe.StudentManagement.Entities.Course.Course;
import main.java.com.Airtribe.StudentManagement.Entities.Course.JavaCourse;
import main.java.com.Airtribe.StudentManagement.Entities.Course.NodeCourse;
import main.java.com.Airtribe.StudentManagement.Entities.Person.Student;
import main.java.com.Airtribe.StudentManagement.Util.COURSE_TYPE;

import java.util.Scanner;

import static main.java.com.Airtribe.StudentManagement.Util.CONSTANTS.*;
import static main.java.com.Airtribe.StudentManagement.Util.UtilityFunctions.DisplayLine;
import static main.java.com.Airtribe.StudentManagement.Util.UtilityFunctions.DisplayMessage;

public class CourseDriver {
    static Scanner scanner = new Scanner(System.in);

    public static void courseDriver(Cohort cohort) {
        DisplayMessage("If you wish to view all courses - 1");
        DisplayMessage("If you wish to all details for a specific course - 2");
        DisplayMessage("If you wish to create a new course - 3");
        DisplayMessage("If you wish to create a new assignment for a course - 4");
        DisplayMessage("If you wish to set course completion for a course - 5");
        DisplayMessage("if you wish to remove a course - 6");
        DisplayMessage("If you wish to go back to previous menu - 7");
        int innerChoice = scanner.nextInt();
        scanner.nextLine();//Clear Buffer
        switch (innerChoice) {
            case 1 :
                viewAllCourses(cohort);
                break;
            case 2 :
                viewCourse(cohort);
                break;
            case 3 :
                createCourse(cohort);
                break;
            case 4 :
                createNewAssignmentForCourse(cohort);
                break;
            case 5 :
                setCourseCompletionForCourse(cohort);
                break;
            case 6 :
                removeCourse(cohort);
                break;
            case 7 :
                DisplayMessage(BACK_TO_MAIN_MENU);
                break;
            default:
                DisplayMessage(INVALID_CHOICE);
        }
    }

    private static void viewAllCourses(Cohort cohort) {
        DisplayMessage("=== All Courses Available ===");
        cohort.getCourseList().Display();
        DisplayLine();
    }

    public static void createCourse(Cohort cohort){
        DisplayMessage("Enter the type of course you wish to create : ");
        DisplayMessage("1 - Java Course");
        DisplayMessage("2 - Node Course");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine(); //Clear Buffer
        switch(choice){
            case 1 :
                cohort.addCourse(new JavaCourse());
                DisplayMessage(SUCCESS_MESSAGE);
                break;
            case 2 :
                cohort.addCourse(new NodeCourse());
                DisplayMessage(SUCCESS_MESSAGE);
                break;
            default :
                DisplayMessage(INVALID_CHOICE);
        }
    }

    private static void createNewAssignmentForCourse(Cohort cohort) {
        DisplayMessage("Enter the course name for which you want to create an assignment:");
        String courseName = scanner.nextLine();
        
        if (cohort.getCourseList().doesExist(courseName)) {
            Course course = cohort.getCourseByName(courseName);
            
            DisplayMessage("Select the assignment type:");
            DisplayMessage("1 - Java Assignment");
            DisplayMessage("2 - Node Assignment");
            int assignmentType = scanner.nextInt();
            scanner.nextLine(); // Clear buffer
            
            DisplayMessage("Enter the assignment name:");
            String assignmentName = scanner.nextLine();
            
            if (assignmentType == 1) {
                if (course.getCourseType() == COURSE_TYPE.JAVA) {
                    JavaAssignment javaAssignment = new JavaAssignment(assignmentName);
                    course.setAssignments(javaAssignment);
                } else {
                    DisplayMessage("Cannot add Java assignment to a non-Java course.");
                }
            } else if (assignmentType == 2) {
                if (course.getCourseType() == COURSE_TYPE.NODE_JS) {
                    NodeAssignment nodeAssignment = new NodeAssignment(assignmentName);
                    course.setAssignments(nodeAssignment);
                } else {
                    DisplayMessage("Cannot add Node assignment to a non-Node course.");
                }
            } else {
                DisplayMessage("Invalid assignment type selected.");
            }
        } else {
            DisplayMessage("Course with name " + courseName + " not found.");
        }
    }

    public static void setCourseCompletionForCourse(Cohort cohort){
        CourseList courseListCohort = cohort.getCourseList();
        DisplayMessage("All the Courses currently in the cohort are as follows : ");
        courseListCohort.Display();

        DisplayMessage("Please enter the course_name you wish to set Completion status to complete for");
        String courseName = scanner.nextLine();

        if(!cohort.getCourseList().doesExist(courseName)){
            DisplayMessage("No course with given name found");
            return;
        }

        Course selectedCourse = cohort.getCourseByName(courseName);
        DisplayMessage("This action cannot be undone");
        DisplayMessage("If you wish to continue choose 1, or else this process will be terminated for any other input");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if(choice != 1){
            DisplayMessage(PROCESS_TERMINATED);
        }
        selectedCourse.setCourseCompletion(true);
        DisplayMessage(SUCCESS_MESSAGE);
    }

    public static void removeCourse(Cohort cohort){
        viewAllCourses(cohort);

        DisplayMessage("Enter the course name for course you wish to remove");
        String courseName = scanner.nextLine();

        if(!cohort.getCourseList().doesExist(courseName)){
            DisplayMessage("No such course exists to remove for courseList");
        }else{
            Course course = cohort.getCourseByName(courseName);
            DisplayMessage("Removing course from cohort collection");
            cohort.getCourseList().removeFromCourseList(course);

            DisplayMessage("Removing course from student course list if exists");
            for(Student student : cohort.getStudentList().getStudentList()){
                student.getCoursesList().removeFromCourseList(course);
            }
        }
    }

    public static void viewCourse(Cohort cohort){
        DisplayMessage("Please enter the course_name you of course you wish to view");
        String courseName = scanner.nextLine();

        if(!cohort.getCourseList().doesExist(courseName)){
            DisplayMessage("No course with given name found");
            return;
        }
        Course course = cohort.getCourseByName(courseName);
        DisplayMessage("Course Details for course with course_name : " + courseName);
        course.Display();
    }
}