package main.java.com.Airtribe.StudentManagement.Driver;

import main.java.com.Airtribe.StudentManagement.Entities.Cohort.Cohort;
import main.java.com.Airtribe.StudentManagement.Entities.Person.GraduateStudent;

import java.util.Scanner;

import static main.java.com.Airtribe.StudentManagement.Util.CONSTANTS.*;
import static main.java.com.Airtribe.StudentManagement.Util.UtilityFunctions.DisplayLine;
import static main.java.com.Airtribe.StudentManagement.Util.UtilityFunctions.DisplayMessage;

public class GraduateStudentDriver {
    static Scanner scanner = new Scanner(System.in);
    public static void graduateStudentDriver(Cohort cohort) {
        DisplayMessage("If you wish to change the name of a graduate student - 1");
        DisplayMessage("If you wish to remove a graduate student with given id - 2");
        DisplayMessage("If you wish to set placement status for graduate student in the database - 3");
        DisplayMessage("If you wish to set organisation for a graduate student in the database - 4");
        DisplayMessage("If you wish to display all details for a graduate student in the database - 5");
        DisplayMessage("If you wish to display all the graduate student in the database - 7");
        DisplayMessage("If you wish to go back to previous menu - 7");
        int innerChoice = scanner.nextInt();
        scanner.nextLine();//Clear Buffer
        switch (innerChoice) {
            case 1:
                changeGraduateStudentName(cohort);
                break;
            case 2:
                removeGraduateStudentById(cohort);
                break;
            case 3 :
                setPlacementStatus(cohort);
                break;
            case 4 :
                setOrganisation(cohort);
                break;
            case 5:
                displayGraduateStudentDetails(cohort);
                break;
            case 6:
                displayAllGraduateStudents(cohort);
                break;
            case 7:
                DisplayMessage(BACK_TO_MAIN_MENU);
                break;
            default:
                DisplayMessage(INVALID_CHOICE);
        }
    }

    private static void changeGraduateStudentName(Cohort cohort) {
        DisplayMessage("Enter the ID of the graduate student:");
        int gsId = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        
        if (cohort.getGraduateStudentList().doesExist(gsId)) {
            GraduateStudent gs = cohort.getGraduateStudentById(gsId);
            DisplayMessage("Enter the new name:");
            String newName = scanner.nextLine();
            gs.setName(newName);
            DisplayMessage("Graduate student name has been updated successfully.");
        } else {
            DisplayMessage("Graduate student with ID " + gsId + " not found.");
        }
    }

    private static void removeGraduateStudentById(Cohort cohort) {
        DisplayMessage("Enter the ID of the graduate student to remove:");
        int gsId = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        
        cohort.getGraduateStudentList().removeGraduateStudent(gsId);
    }

    private static void displayAllGraduateStudents(Cohort cohort) {
        DisplayMessage("=== All Graduate Students in Database ===");
        cohort.getGraduateStudentList().Display();
        DisplayLine();
    }

    private static void displayGraduateStudentDetails(Cohort cohort) {
        DisplayMessage("Enter the ID of the graduate student:");
        int gsId = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        
        if (cohort.getGraduateStudentList().doesExist(gsId)) {
            DisplayMessage("Graduate student details retrieved above.");
        } else {
            DisplayMessage("Graduate student with ID " + gsId + " not found.");
        }
    }

    private static void setPlacementStatus(Cohort cohort){
        DisplayMessage("Enter the ID of the graduate student:");
        int gsId = scanner.nextInt();
        scanner.nextLine(); // Clear Buffer

        if (cohort.getGraduateStudentList().doesExist(gsId)) {
            GraduateStudent gs = cohort.getGraduateStudentById(gsId);
            DisplayMessage("Enter the status for placement");
            DisplayMessage("1 - true");
            DisplayMessage("2 - true");
            int input = scanner.nextInt();
            scanner.nextLine(); //Clear buffer
            switch(input){
                case 1 :
                    gs.setPlacementStatus(true);
                    DisplayMessage(SUCCESS_MESSAGE);
                    break;
                case 2 :
                    gs.setPlacementStatus(false);
                    DisplayMessage(SUCCESS_MESSAGE);
                    break;
                default :
                    DisplayMessage(INVALID_CHOICE);
            }
        } else {
            DisplayMessage("Graduate student with ID " + gsId + " not found.");
        }
    }

    private static void setOrganisation(Cohort cohort){
        DisplayMessage("Enter the ID of the graduate student:");
        int gsId = scanner.nextInt();
        scanner.nextLine(); // Clear Buffer

        if (cohort.getGraduateStudentList().doesExist(gsId)) {
            GraduateStudent gs = cohort.getGraduateStudentById(gsId);
            DisplayMessage("Enter the name of the Organisation");
            String organisation = scanner.nextLine();
            gs.setOrganisation(organisation);
            DisplayMessage(SUCCESS_MESSAGE);
        } else {
            DisplayMessage("Graduate student with ID " + gsId + " not found.");
        }
    }
}