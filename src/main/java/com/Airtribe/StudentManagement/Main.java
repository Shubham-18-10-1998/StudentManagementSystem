package main.java.com.Airtribe.StudentManagement;

import main.java.com.Airtribe.StudentManagement.Entities.Cohort.Cohort;
import main.java.com.Airtribe.StudentManagement.Entities.Course.Course;
import main.java.com.Airtribe.StudentManagement.Entities.Course.JavaCourse;
import main.java.com.Airtribe.StudentManagement.Entities.Course.NodeCourse;
import main.java.com.Airtribe.StudentManagement.Entities.Person.Person;

import java.util.Scanner;

import static main.java.com.Airtribe.StudentManagement.Driver.CourseDriver.courseDriver;
import static main.java.com.Airtribe.StudentManagement.Driver.GraduateStudentDriver.graduateStudentDriver;
import static main.java.com.Airtribe.StudentManagement.Driver.PersonDriver.personDriver;
import static main.java.com.Airtribe.StudentManagement.Driver.StudentDriver.studentDriver;
import static main.java.com.Airtribe.StudentManagement.Util.UtilityFunctions.DisplayLine;
import static main.java.com.Airtribe.StudentManagement.Util.UtilityFunctions.DisplayMessage;

public class Main {
    public static void main(String[] args) {
        Cohort cohort = new Cohort();
        DisplayMessage("A new Cohort has been created for the demo");

        Course javaCourse = new JavaCourse();
        cohort.addCourse(javaCourse);
        DisplayMessage("A new java course has been created for the demo");

        Course nodeCourse = new NodeCourse();
        cohort.addCourse(nodeCourse);
        DisplayMessage("A new node course has been created for the demo");

        Person p1 = new Person("person_1");
        cohort.addPerson(p1);
        DisplayMessage("A new person p1 with id - 1 has been created for the demo");

        DisplayLine();
        DisplayLine();

        Scanner scanner = new Scanner(System.in);

        boolean flag = true;

        while(flag){
            DisplayMessage("Please select an input in accordance with the action you seek to perform:");
            DisplayMessage("For Person based operations - 1");
            DisplayMessage("For Student based operations - 2");
            DisplayMessage("For Graduate student based operations - 3");
            DisplayMessage("For Course based operations - 4");
            DisplayMessage("To exit application - 5");

            int choice = scanner.nextInt();
            scanner.nextLine();//Clear Buffer

            switch (choice) {
                case 1 :
                    personDriver(cohort);
                    break;
                case 2 :
                    studentDriver(cohort);
                    break;
                case 3 :
                    graduateStudentDriver(cohort);
                    break;
                case 4 :
                    courseDriver(cohort);
                    break;
                case 5 :
                    DisplayMessage("Thank you for using the application!");
                    flag = false;
                    break;
                default :
                    DisplayMessage("Please choose an input from the list to proceed further");
            }

        }
    }
}