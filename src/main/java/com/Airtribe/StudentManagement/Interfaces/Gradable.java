package main.java.com.Airtribe.StudentManagement.Interfaces;

import main.java.com.Airtribe.StudentManagement.Util.GRADES;

import static main.java.com.Airtribe.StudentManagement.Util.UtilityFunctions.DisplayMessage;

public interface Gradable {
    public GRADES getGrade();

    public default void DisplayGrade(){
        DisplayMessage("The grade acquired is : ");
    }
}
