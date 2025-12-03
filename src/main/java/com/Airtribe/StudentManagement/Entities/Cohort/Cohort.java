package main.java.com.Airtribe.StudentManagement.Entities.Cohort;

import main.java.com.Airtribe.StudentManagement.Entities.Collections.CourseList;
import main.java.com.Airtribe.StudentManagement.Entities.Collections.GraduateStudentList;
import main.java.com.Airtribe.StudentManagement.Entities.Collections.PersonList;
import main.java.com.Airtribe.StudentManagement.Entities.Collections.StudentList;
import main.java.com.Airtribe.StudentManagement.Entities.Course.Course;
import main.java.com.Airtribe.StudentManagement.Entities.Person.GraduateStudent;
import main.java.com.Airtribe.StudentManagement.Entities.Person.Person;
import main.java.com.Airtribe.StudentManagement.Entities.Person.Student;

import java.util.ArrayList;

import static main.java.com.Airtribe.StudentManagement.Util.UtilityFunctions.DisplayMessage;

public class Cohort {
    private final PersonList personList;
    private final StudentList studentList;
    private final GraduateStudentList graduateStudentList;
    private final CourseList courseList;

    public Cohort(){
        this.personList = new PersonList();
        this.studentList = new StudentList();
        this.graduateStudentList = new GraduateStudentList();
        this.courseList = new CourseList();
    }

    public void addPerson(Person person){
        if(personList.doesExist(person.getId())){
            DisplayMessage("Person already exists, and hence cannot be added");
        }else{
            this.personList.addToPersonList(person);
            DisplayMessage("Person has been added successfully");
        }
    }

    public void addStudent(Student student){
        if(studentList.doesExist(student.getId())){
            DisplayMessage("Student already exists, and hence cannot be added");
        }else{
            this.personList.removePerson(student.getId());
            this.studentList.addToStudentList(student);
            DisplayMessage("Student has been added successfully");
        }
    }

    public void addGraduateStudent(GraduateStudent graduateStudent){
        if(graduateStudentList.doesExist(graduateStudent.getId())){
            DisplayMessage("Graduate Student already exists, and hence cannot be added");
        }else{
            this.studentList.removeStudent(graduateStudent.getId());
            this.graduateStudentList.addToGraduateStudentList(graduateStudent);
            DisplayMessage("Graduate Student has been added successfully");
        }
    }

    public void addCourse(Course course){
        if(this.courseList.doesExist(course.getName())){
            DisplayMessage("Course already exists, and hence not added");
        }else{
            this.courseList.addToCourseList(course);
            DisplayMessage("Course added successfully");
        }
    }




}
