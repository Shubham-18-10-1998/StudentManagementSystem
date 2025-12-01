package main.java.com.Airtribe.StudentManagement.Entities.Assignment;

import static main.java.com.Airtribe.StudentManagement.Util.UtilityFunctions.DisplayMessage;

public class JavaAssignment extends Assignment {
    private static int JavaCount = 0;
    private int JavaVersion;

    JavaAssignment(String name){
        super(name);
        JavaAssignment.JavaCount++;
        super.setId(JavaCount);
    }

    @Override
    public void DisplayAssignment(){
        super.DisplayAssignment();
        DisplayMessage("java version is : " + this.JavaVersion);
    }
}
