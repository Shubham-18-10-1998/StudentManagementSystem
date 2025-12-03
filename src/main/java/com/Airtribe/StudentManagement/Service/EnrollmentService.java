package main.java.com.Airtribe.StudentManagement.Service;

import main.java.com.Airtribe.StudentManagement.Entities.Enrollment;

import static main.java.com.Airtribe.StudentManagement.Util.CONSTANTS.RETRY_MESSAGE;
import static main.java.com.Airtribe.StudentManagement.Util.CONSTANTS.SUCCESS_MESSAGE;
import static main.java.com.Airtribe.StudentManagement.Util.UtilityFunctions.DisplayMessage;

public class EnrollmentService {
    Enrollment enrollment;

    public EnrollmentService(){
        enrollment = new Enrollment();
    }

    public void setDiscount(double discount){
        boolean status = this.enrollment.setDiscount(discount);
        if(status){
            DisplayMessage(SUCCESS_MESSAGE);
        }else{
            DisplayMessage(RETRY_MESSAGE);
        }
    }

    public void setScholarship(double scholarship){
        boolean status = this.enrollment.setScholarship(scholarship);
        if(status){
            DisplayMessage(SUCCESS_MESSAGE);
        }else{
            DisplayMessage(RETRY_MESSAGE);
        }
    }

    public void setFees(double fees){
        boolean status = this.enrollment.setFees(fees);
        if(status){
            DisplayMessage(SUCCESS_MESSAGE);
        }else{
            DisplayMessage(RETRY_MESSAGE);
        }
    }

    public boolean getEnrollmentStatus(){
        return this.enrollment.getEnrollmentStatus();
    }

    public boolean getPaymentStatus(){
        return this.enrollment.getPaymentStatus();
    }

    public Enrollment getEnrollment(){
        return this.enrollment;
    }

    public void setPaymentStatus(boolean status){
        this.enrollment.setPaymentStatus(status);
    }

    public void setEnrollmentStatus(boolean status){
        this.getEnrollment().setEnrollmentStatus(status);
    }

    public double getDiscount(){
        return this.getEnrollment().getDiscount();
    }

    public double getFees(){
        return this.getEnrollment().getFees();
    }

    public double getScholarship(){
        return this.getEnrollment().getScholarship();
    }


}
