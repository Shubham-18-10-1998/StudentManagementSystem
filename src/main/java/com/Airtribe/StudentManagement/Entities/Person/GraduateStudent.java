package main.java.com.Airtribe.StudentManagement.Entities.Person;

import static main.java.com.Airtribe.StudentManagement.Util.UtilityFunctions.DisplayMessage;

public class GraduateStudent extends Student{

    private boolean isPlaced;
    private String organisation;

    GraduateStudent(Student s){
        super(s);
    }

    public boolean isPlaced() {
        return isPlaced;
    }

    public void setPlaced(boolean placed) {
        isPlaced = placed;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public void Display(){
        super.Display();
        DisplayMessage("The placement status is : " + this.isPlaced());
        DisplayMessage("The organisation is : " + this.getOrganisation());
    }
}
