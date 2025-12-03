package main.java.com.Airtribe.StudentManagement;

import main.java.com.Airtribe.StudentManagement.Entities.Cohort.Cohort;
import main.java.com.Airtribe.StudentManagement.Entities.Course.Course;
import main.java.com.Airtribe.StudentManagement.Entities.Course.JavaCourse;
import main.java.com.Airtribe.StudentManagement.Entities.Course.NodeCourse;
import main.java.com.Airtribe.StudentManagement.Entities.Person.Person;

import java.util.Scanner;

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

        Scanner scanner = new Scanner(System.in);

        boolean flag = true;

        while(flag){
            DisplayMessage("Please select an input in accordance with the action you seek to perform:");
            DisplayMessage("For Person based operations - 1");
            DisplayMessage("For Student based operations - 2");
            DisplayMessage("For Graduate student based operations - 3");
            DisplayMessage("For Course based operations - 4");
            DisplayMessage("To exit application - 5");

            int choice = scanner.nextInt(), innerChoice;

            switch (choice) {
                case 1 :
                    DisplayMessage("If you wish to add a new person - 1");
                    DisplayMessage("If you wish to remove a person with given id - 2");
                    DisplayMessage("If you wish to enroll a person to student status - 3");
                    DisplayMessage("If you wish to display all the people currently in the database - 4");
                    DisplayMessage("If you wish to go to previous menu : 5");
                    innerChoice = scanner.nextInt();
                    //PersonDriver(int innerChoice, Cohort c);
                    break;
                case 2 :
                    DisplayMessage("If you wish to graduate a student - 1");
                    DisplayMessage("If you wish to remove a student with given id - 2");
                    DisplayMessage("If you wish to change the name for  a student with given id - 3");
                    DisplayMessage("If you wish to display all the students currently in the database - 5");
                    DisplayMessage("If you wish to display all the details for a students currently in the database - 6");
                    DisplayMessage("If you wish to go to previous menu : 7");
                    innerChoice = scanner.nextInt();
                    //StudentDriver(int innerChoice, Cohort c);

                case 5 :
                    DisplayMessage("Thank you for using the application!");
                    flag = false;
                default :
                    DisplayMessage("Please choose an input from the list to proceed further");

            }



        }
    }
}