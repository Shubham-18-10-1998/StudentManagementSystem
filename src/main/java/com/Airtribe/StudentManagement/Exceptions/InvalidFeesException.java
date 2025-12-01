package main.java.com.Airtribe.StudentManagement.Exceptions;

public class InvalidFeesException extends IllegalArgumentException {
    private static final String DEFAULT_MESSAGE = "Fees should be a positive value!";

    public InvalidFeesException(String message) {
        super(message);
    }

    public InvalidFeesException(){
        super(DEFAULT_MESSAGE);
    }
}
