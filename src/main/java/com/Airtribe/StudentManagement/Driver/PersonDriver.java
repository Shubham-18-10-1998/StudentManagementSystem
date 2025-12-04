package main.java.com.Airtribe.StudentManagement.Driver;

import main.java.com.Airtribe.StudentManagement.Entities.Cohort.Cohort;
import main.java.com.Airtribe.StudentManagement.Entities.Person.Person;
import main.java.com.Airtribe.StudentManagement.Entities.Person.Student;

import java.util.Scanner;

import static main.java.com.Airtribe.StudentManagement.Driver.EnrollmentDriver.enrollmentDriver;
import static main.java.com.Airtribe.StudentManagement.Util.CONSTANTS.*;
import static main.java.com.Airtribe.StudentManagement.Util.UtilityFunctions.DisplayLine;
import static main.java.com.Airtribe.StudentManagement.Util.UtilityFunctions.DisplayMessage;

public class PersonDriver {
    static Scanner scanner = new Scanner(System.in);

    public static void personDriver(Cohort cohort) {
        DisplayMessage("If you wish to add a new person - 1");
        DisplayMessage("If you wish to remove a person with given id - 2");
        DisplayMessage("If you wish to enroll a person to student status - 3");
        DisplayMessage("If you wish to update the name for a person - 4");
        DisplayMessage("If you wish to view details for a person - 5");
        DisplayMessage("If you wish to display all the people currently in the database - 6");
        DisplayMessage("If you wish to interact with the enrollment service for a person - 7");
        DisplayMessage("If you wish to go back to previous menu - 8");
        int innerChoice = scanner.nextInt();
        scanner.nextLine();//Clear Buffer
        switch (innerChoice) {
            case 1:
                addNewPerson(cohort);
                break;
            case 2:
                removePersonById(cohort);
                break;
            case 3:
                enrollPersonToStudent(cohort);
                break;
            case 4 :
                changeName(cohort);
                break;
            case 5 :
                displayPersonDetails(cohort);
                break;
            case 6:
                displayAllPeople(cohort);
                break;
            case 7:
                int personId;
                DisplayMessage("Enter the id for the person");
                personId = scanner.nextInt();
                scanner.nextLine(); //Clear Buffer
                if(cohort.getPersonList().doesExist(personId)){
                    Person person = cohort.getPersonById(personId);
                    enrollmentDriver(person);
                }else{
                    DisplayMessage("Person with given id doesn't exist, hence enrollment service cannot be interacted with");
                }
                break;
            case 8:
                DisplayMessage(BACK_TO_MAIN_MENU);
                break;
            default:
                DisplayMessage(INVALID_CHOICE);
        }
    }

    private static void addNewPerson(Cohort cohort) {
        DisplayMessage("Enter the name of the person:");
        String name = scanner.nextLine();
        
        Person newPerson = new Person(name);
        cohort.addPerson(newPerson);
        DisplayMessage("Person with ID: " + newPerson.getId() + " has been added successfully.");
    }

    private static void removePersonById(Cohort cohort) {
        DisplayMessage("Enter the ID of the person to remove:");
        int personId = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        
        cohort.getPersonList().removePerson(personId);
    }

    private static void enrollPersonToStudent(Cohort cohort) {
        DisplayMessage("Enter the ID of the person to enroll:");
        int personId = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        
        if (cohort.getPersonList().doesExist(personId)) {
            try {
                Person person = cohort.getPersonById(personId);
                Student student = person.enrollPerson();
                cohort.addStudent(student);
                DisplayMessage("Person has been successfully enrolled as a student.");
            } catch (IllegalStateException e) {
                DisplayMessage("Error: " + e.getMessage());
            }
        } else {
            DisplayMessage("Person with ID " + personId + " not found.");
        }
    }

    private static void displayAllPeople(Cohort cohort) {
        DisplayMessage("=== All People in Database ===");
        cohort.getPersonList().Display();
        DisplayLine();
    }

    public static void changeName(Cohort cohort){
        int personId;
        DisplayMessage("Enter the id for the person");
        personId = scanner.nextInt();
        scanner.nextLine(); //Clear Buffer
        if(!cohort.getPersonList().doesExist(personId)){
            DisplayMessage("Person with ID " + personId + " not found.");
            return;
        }
        Person person = cohort.getPersonById(personId);
        DisplayMessage("Please enter the new name : ");
        String name = scanner.nextLine();
        person.setName(name);
        DisplayMessage(SUCCESS_MESSAGE);
    }

    public static void displayPersonDetails(Cohort cohort){
        int personId;
        DisplayMessage("Enter the id for the person");
        personId = scanner.nextInt();
        scanner.nextLine(); //Clear Buffer
        if(!cohort.getPersonList().doesExist(personId)){
            DisplayMessage("Person with ID " + personId + " not found.");
            return;
        }
        Person person = cohort.getPersonById(personId);
        DisplayMessage("ALL details for person with id : " + personId);
        person.Display();
    }
}