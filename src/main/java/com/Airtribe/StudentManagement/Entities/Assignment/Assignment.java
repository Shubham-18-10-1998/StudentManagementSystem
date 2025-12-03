package main.java.com.Airtribe.StudentManagement.Entities.Assignment;

import main.java.com.Airtribe.StudentManagement.Interfaces.Gradable;
import main.java.com.Airtribe.StudentManagement.Util.COURSE_TYPE;
import main.java.com.Airtribe.StudentManagement.Util.GRADES;

import static main.java.com.Airtribe.StudentManagement.Util.UtilityFunctions.DisplayMessage;

public abstract class Assignment implements Gradable {
    private int id;
    private String name;
    private GRADES grade;
    private COURSE_TYPE courseType;

    Assignment(){
        this.grade = GRADES.F;
    }

    Assignment(String name){
        this();
        this.id = 0;
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public COURSE_TYPE getCourseType() {
        return courseType;
    }

    public void setCourseType(COURSE_TYPE courseType) {
        this.courseType = courseType;
    }

    @Override
    public GRADES getGrade() {
        return grade;
    }

    public void setGrade(GRADES grade) {
        this.grade = grade;
    }

    public void showGrade(){
        this.DisplayGrade();
        DisplayMessage(String.valueOf(this.grade));
    }

    public void DisplayAssignment(){
        DisplayMessage("id is " + getId());
        DisplayMessage("Name is " + getName());
        this.showGrade();
    }
}
