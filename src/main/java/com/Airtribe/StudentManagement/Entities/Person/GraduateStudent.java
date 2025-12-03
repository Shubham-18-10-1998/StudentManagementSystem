package main.java.com.Airtribe.StudentManagement.Entities.Person;

import static main.java.com.Airtribe.StudentManagement.Util.UtilityFunctions.DisplayLine;
import static main.java.com.Airtribe.StudentManagement.Util.UtilityFunctions.DisplayMessage;

public class GraduateStudent extends Student{

    private boolean placementStatus;
    private String organisation;

    GraduateStudent(Student s){
        super(s);
    }

    public boolean getPlacementStatus() {
        return placementStatus;
    }

    public void setPlacementStatus(boolean placed) {
        placementStatus = placed;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public void Display(){
        super.Display();
        DisplayMessage("The placement status is : " + this.getPlacementStatus());
        DisplayMessage("The organisation is : " + this.getOrganisation());
        DisplayLine();
    }
}
