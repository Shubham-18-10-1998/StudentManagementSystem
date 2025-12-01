package main.java.com.Airtribe.StudentManagement.Entities.Person;

import main.java.com.Airtribe.StudentManagement.Entities.Course.Course;
import main.java.com.Airtribe.StudentManagement.Service.EnrollmentService;

import java.util.Scanner;

import static main.java.com.Airtribe.StudentManagement.Util.UtilityFunctions.DisplayMessage;

public class Person {
    private static int count = 0;
    private int id;
    private String name;
    public EnrollmentService enrollmentService;

    public Person(){};

    public Person(Person old){
        this.id = old.id;
        this.name = old.name;
        this.enrollmentService = old.enrollmentService;
    }

    public Person(String name){
        this.id = ++count;
        this.name = name;
        this.enrollmentService = new EnrollmentService();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EnrollmentService getEnrollmentService() {
        return enrollmentService;
    }

    public void setEnrollmentService(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }


    public Student enrollPerson() throws IllegalStateException{
        if(this.enrollmentService.getPaymentStatus()){
            return new Student(this, null);
        }else{
            throw new IllegalStateException("The person hasn't completed the payment, and hence cant be enrolled");
        }
    }

    public void Display(){
        DisplayMessage("The id is : " + this.getId());
        DisplayMessage(("The name is : " + this.getName()));
    }


}
