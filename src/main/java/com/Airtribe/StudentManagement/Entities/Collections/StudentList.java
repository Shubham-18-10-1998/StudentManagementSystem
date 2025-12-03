package main.java.com.Airtribe.StudentManagement.Entities.Collections;

import main.java.com.Airtribe.StudentManagement.Entities.Person.Student;
import main.java.com.Airtribe.StudentManagement.Interfaces.SearchableWithID;

import java.util.ArrayList;
import java.util.List;

import static main.java.com.Airtribe.StudentManagement.Util.UtilityFunctions.DisplayMessage;

public class StudentList implements SearchableWithID {

    private final List<Student> studentList;

    public StudentList(){
        studentList = new ArrayList<>();
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void addToStudentList(Student student){
        this.studentList.add(student);
    }

    public void removeStudent(int studentID){
        boolean flag = this.studentList.removeIf(student -> student.getId() == studentID);
        if(flag){
            DisplayMessage("Operation performed Successfully");
        }else{
            DisplayMessage("No such value found to Delete");
        }
    }

    @Override
    public boolean doesExist(int id) {
        for(Student student : studentList){
            if(student.getId() == id){
                DisplayMessage("Student has been found!");
                student.Display();
                return true;
            }
        }
        DisplayMessage("Student with given id has not been found");
        return false;
    }

    public void Display(){
        for(Student student : this.studentList){
            student.Display();
        }
    }
}
