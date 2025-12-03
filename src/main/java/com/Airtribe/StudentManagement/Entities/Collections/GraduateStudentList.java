package main.java.com.Airtribe.StudentManagement.Entities.Collections;

import main.java.com.Airtribe.StudentManagement.Entities.Person.GraduateStudent;
import main.java.com.Airtribe.StudentManagement.Interfaces.SearchableWithID;

import java.util.ArrayList;
import java.util.List;

import static main.java.com.Airtribe.StudentManagement.Util.UtilityFunctions.DisplayMessage;

public class GraduateStudentList implements SearchableWithID {
    private final List<GraduateStudent> graduateStudentList;

    public GraduateStudentList(){
        graduateStudentList = new ArrayList<>();
    }

    public void addToGraduateStudentList(GraduateStudent graduateStudent){
        this.graduateStudentList.add(graduateStudent);
    }

    public void removeGraduateStudent(int graduateStudentID){
        boolean flag = this.graduateStudentList.removeIf(graduateStudent -> graduateStudent.getId() == graduateStudentID);
        if(flag){
            DisplayMessage("Operation performed Successfully");
        }else{
            DisplayMessage("No such value found to Delete");
        }
    }

    @Override
    public boolean doesExist(int id) {
        for(GraduateStudent gs : graduateStudentList){
            if(gs.getId() == id){
                DisplayMessage("Graduate Student Found !");
                gs.Display();
                return true;
            }
        }
        DisplayMessage("Graduate Student with given id not found");
        return false;
    }

}
