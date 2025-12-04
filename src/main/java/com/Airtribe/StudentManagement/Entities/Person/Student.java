package main.java.com.Airtribe.StudentManagement.Entities.Person;

import main.java.com.Airtribe.StudentManagement.Entities.Collections.CourseList;
import main.java.com.Airtribe.StudentManagement.Entities.Course.Course;

import static main.java.com.Airtribe.StudentManagement.Util.UtilityFunctions.DisplayLine;

public class Student extends Person{

    private CourseList coursesList;

    public Student(Person old, CourseList courseList){
        super(old);
        this.setCourseList(courseList);
    }

    public Student(Student student){
        Person p = new Person();
        p.setName(student.getName());
        p.setEnrollmentService(student.getEnrollmentService());
        this(p, student.getCoursesList());
    }

    public CourseList getCoursesList() {
        return this.coursesList;
    }

    public void setCourseList(CourseList courseList) {
        this.coursesList = courseList;
    }

    public void assignCourse(Course course) {
        this.coursesList.addToCourseList(course);
    }

    public GraduateStudent graduateStudent() throws IllegalStateException{
        for(Course course : this.coursesList.getCourseList()){
            if(course.getCourseCompletion()){
                return new GraduateStudent(this);
            }
        }
        throw new IllegalStateException("The student hasn't completed any course to be able to graduate");
    }

    @Override
    public void Display(){
        super.Display();
        this.coursesList.Display();
        DisplayLine();
    }
}
