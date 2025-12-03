package main.java.com.Airtribe.StudentManagement.Driver;

import main.java.com.Airtribe.StudentManagement.Entities.Person.Person;

import java.util.Scanner;

import static main.java.com.Airtribe.StudentManagement.Util.CONSTANTS.*;
import static main.java.com.Airtribe.StudentManagement.Util.UtilityFunctions.DisplayMessage;

public class EnrollmentDriver {

    public static void enrollmentDriver(Person person){
        Scanner scanner = new Scanner(System.in);
        DisplayMessage("To view fees - 1");
        DisplayMessage("To view scholarship - 2");
        DisplayMessage("To view discount - 3");
        DisplayMessage("To view payment-status - 4");
        DisplayMessage("To view enrollment-status - 5");
        DisplayMessage("To change the fees - 6");
        DisplayMessage("To change scholarship percentage- 7");
        DisplayMessage("To change discount percentage - 8");
        DisplayMessage("To change payment status - 9");
        DisplayMessage("To change enrollment status - 10");
        DisplayMessage("To return to previous menu - 11");
        int menuSelection = scanner.nextInt();
        scanner.nextLine(); //Clear Buffer
        switch(menuSelection){
            case 1 :
                viewFees(person);
                break;
            case 2 :
                viewScholarship(person);
                break;
            case 3 :
                viewDiscount(person);
                break;
            case 4 :
                viewPaymentStatus(person);
                break;
            case 5 :
                viewEnrollmentStatus(person);
                break;
            case 6 :
                changeFees(person);
                break;
            case 7 :
                changeScholarship(person);
                break;
            case 8 :
                changeDiscount(person);
                break;
            case 9 :
                changePaymentStatus(person);
                break;
            case 10 :
                changeEnrollmentStatus(person);
                break;
            case 11 :
                DisplayMessage(BACK_TO_MAIN_MENU);
                break;
            default :
                DisplayMessage(INVALID_CHOICE);

        }
    }

    public static void viewFees(Person person){
        DisplayMessage("The fees for the selected person is - " + person.getEnrollmentService().getFees());
    }

    public static void viewScholarship(Person person){
        DisplayMessage("The scholarship for the selected person is - " + person.getEnrollmentService().getScholarship());
    }

    public static void viewDiscount(Person person){
        DisplayMessage("The discount for the selected person is - " + person.getEnrollmentService().getDiscount());
    }

    public static void viewPaymentStatus(Person person){
        DisplayMessage("The payment status for the selected person is - " + person.getEnrollmentService().getPaymentStatus());
    }

    public static void viewEnrollmentStatus(Person person){
        DisplayMessage("The enrollment status for the selected person is - " + person.getEnrollmentService().getEnrollmentStatus());
    }

    public static void changeFees(Person person){
        DisplayMessage("Please enter the new fees you wish to change to - ");
        Scanner scanner = new Scanner(System.in);
        double fees = scanner.nextDouble();
        scanner.nextLine();// Clear Buffer
        person.getEnrollmentService().setFees(fees);
    }

    public static void changeScholarship(Person person){
        DisplayMessage("Please enter the scholarship percentage you wish to change to - ");
        Scanner scanner = new Scanner(System.in);
        double scholarship = scanner.nextDouble();
        scanner.nextLine();// Clear Buffer
        person.getEnrollmentService().setScholarship(scholarship);
    }

    public static void changeDiscount(Person person){
        DisplayMessage("Please enter the discount percentage you wish to change to - ");
        Scanner scanner = new Scanner(System.in);
        double discount = scanner.nextDouble();
        scanner.nextLine();// Clear Buffer
        person.getEnrollmentService().setDiscount(discount);
    }

    public static void changePaymentStatus(Person person){
        DisplayMessage("Please choose the payment status you wish to update to - ");
        DisplayMessage("1 - true");
        DisplayMessage("2 - false");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch(choice){
            case 1 :
                person.getEnrollmentService().setPaymentStatus(true);
                DisplayMessage(SUCCESS_MESSAGE);
                break;
            case 2 :
                person.getEnrollmentService().setPaymentStatus(false);
                DisplayMessage(SUCCESS_MESSAGE);
                break;
            default :
                DisplayMessage(INVALID_CHOICE);
        }
    }

    public static void changeEnrollmentStatus(Person person){
        DisplayMessage("Please choose the enrollment status you wish to update to - ");
        DisplayMessage("1 - true");
        DisplayMessage("2 - false");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch(choice){
            case 1 :
                person.getEnrollmentService().setEnrollmentStatus(true);
                DisplayMessage(SUCCESS_MESSAGE);
                break;
            case 2 :
                person.getEnrollmentService().setEnrollmentStatus(false);
                DisplayMessage(SUCCESS_MESSAGE);
                break;
            default :
                DisplayMessage(INVALID_CHOICE);
        }
    }

}
