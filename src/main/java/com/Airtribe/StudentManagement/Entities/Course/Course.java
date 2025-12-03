package main.java.com.Airtribe.StudentManagement.Entities.Course;

import main.java.com.Airtribe.StudentManagement.Entities.Assignment.Assignment;
import main.java.com.Airtribe.StudentManagement.Util.COURSE_TYPE;

import java.util.ArrayList;
import java.util.List;

import static main.java.com.Airtribe.StudentManagement.Util.UtilityFunctions.DisplayLine;
import static main.java.com.Airtribe.StudentManagement.Util.UtilityFunctions.DisplayMessage;

public abstract class Course {

    private int id;
    private String name;
    private COURSE_TYPE CourseType;
    private final List<Assignment> assignments;
    private boolean courseCompletion;

    public Course(COURSE_TYPE course_type){
        this.setCourseType(course_type);
        assignments = new ArrayList<>();
        this.courseCompletion = false;
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
        return CourseType;
    }

    public void setCourseType(COURSE_TYPE courseType) {
        CourseType = courseType;
    }

    public void listAssignments() {
        if(this.assignments.isEmpty()){
            DisplayMessage("There are no assignments currently assigned to the course");
            return;
        }
        for(Assignment assignment : this.assignments){
            assignment.DisplayAssignment();
            DisplayLine();
        }
    }

    public void setAssignments(Assignment assignment) {
        if(assignment.getCourseType() == this.getCourseType()){
            assignments.add(assignment);
            DisplayMessage("Assignment added to course successfully");
        }else{
            DisplayMessage("Assignment is not compatible with course.");
        }
    }

    public boolean getCourseCompletion() {
        return courseCompletion;
    }

    public void setCourseCompletion(boolean courseCompletion) {
        this.courseCompletion = courseCompletion;
    }

    public void Display(){
        DisplayMessage("The Course id : " + getId());
        DisplayMessage("The Course name is : " + getName());
        DisplayMessage("The associated assignments are : ");
        this.listAssignments();
        DisplayLine();
    }
}
