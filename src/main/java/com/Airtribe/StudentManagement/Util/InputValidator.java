package main.java.com.Airtribe.StudentManagement.Util;

import main.java.com.Airtribe.StudentManagement.Exceptions.InvalidFeesException;

public class InputValidator {

    public static boolean discountAndScholarshipValidator(double discount, double scholarship){
        boolean valid = false;
        if( (discount >= 0 && discount <= 100) && (scholarship >= 0 && scholarship <= 100)){
            if((discount + scholarship <= 100)) {
                valid = true;
            }else{
                throw new ArithmeticException("The discount + scholarship exceeds 100%)");
            }
        }else{
            throw new IllegalArgumentException("The value provided should a positive numeric value less than 100");
        }
        return valid;
    }


    public static boolean feesValidator(double fees){
        if(fees >= 0){
            return true;
        }else{
            throw new InvalidFeesException();
        }
    }


}
