package main.java.com.Airtribe.StudentManagement.Entities;

import static main.java.com.Airtribe.StudentManagement.Util.InputValidator.discountAndScholarshipValidator;
import static main.java.com.Airtribe.StudentManagement.Util.InputValidator.feesValidator;
import static main.java.com.Airtribe.StudentManagement.Util.UtilityFunctions.DisplayMessage;

public class Enrollment {
    private double fees;
    private double discount;
    private double scholarship;
    private boolean paymentStatus;
    private boolean enrollmentStatus;

    public Enrollment() {
        this.fees = 100000;
        this.discount = 0;
        this.scholarship = 0;
        this.paymentStatus = false;
        this.enrollmentStatus = false;
    }

    public double getFees() {
        return (fees * (1 - ((this.getDiscount()/100) + (this.getScholarship()/100)) ));
    }

    public boolean setFees(double fees) {
        try{
            if(feesValidator(fees)){
                this.fees = fees;
            }
        }catch(Exception e){
            DisplayMessage(e.getMessage());
            return false;
        }
        return true;
    }

    public double getDiscount() {
        return discount;
    }

    public boolean setDiscount(double discount) {
        try{
            if(discountAndScholarshipValidator(discount, this.scholarship)) {
                this.discount = discount;
            }
        } catch (Exception e) {
            DisplayMessage(e.getMessage());
            return false;
        }
        return true;
    }

    public double getScholarship() {
        return scholarship;
    }

    public boolean setScholarship(double scholarship) {
        try{
            if(discountAndScholarshipValidator(this.discount, scholarship)){
                this.scholarship = scholarship;
            }
        } catch (Exception e) {
            DisplayMessage(e.getMessage());
            return false;
        }
        return true;
    }

    public boolean getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
        this.setEnrollmentStatus(this.paymentStatus);
    }

    public boolean getEnrollmentStatus() {
        return enrollmentStatus;
    }

    public void setEnrollmentStatus(boolean enrollmentStatus) {
        this.enrollmentStatus = enrollmentStatus;
    }
}
