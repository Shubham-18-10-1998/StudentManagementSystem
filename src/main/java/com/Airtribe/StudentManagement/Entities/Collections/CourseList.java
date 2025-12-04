package main.java.com.Airtribe.StudentManagement.Entities.Collections;

import main.java.com.Airtribe.StudentManagement.Entities.Course.Course;
import main.java.com.Airtribe.StudentManagement.Interfaces.SearchableWithName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static main.java.com.Airtribe.StudentManagement.Util.UtilityFunctions.DisplayLine;
import static main.java.com.Airtribe.StudentManagement.Util.UtilityFunctions.DisplayMessage;

public class CourseList implements SearchableWithName{
    private final List<Course> courseList;

    public CourseList(){
        courseList = new ArrayList<>();
    }

    public void addToCourseList(Course course){
        this.courseList.add(course);
    }

    public void removeFromCourseList(Course course){
        boolean flag = this.courseList.removeIf(course1  -> Objects.equals(course1.getName(), course.getName()));
        if(flag){
            DisplayMessage("Operation performed Successfully");
        }else{
            DisplayMessage("No such value found to Delete");
        }
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    @Override
    public boolean doesExist(String name) {
        for(Course course : this.courseList){
            if(Objects.equals(course.getName(), name)){
                DisplayMessage("Course Found!");
                return true;
            }
        }
        DisplayMessage("Course not Found!");
        return false;
    }

    public void Display(){
        if(this.courseList.isEmpty()){
            DisplayMessage("The student has no courses assigned to them currently");
            return;
        }
        for(Course course : this.courseList){
            if(course == null){
                DisplayMessage("This course has been removed, Sorry");
            }else{
                course.Display();
            }
        }
        DisplayLine();
    }
}
