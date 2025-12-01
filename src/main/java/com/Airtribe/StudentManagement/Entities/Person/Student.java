package main.java.com.Airtribe.StudentManagement.Entities.Person;

import main.java.com.Airtribe.StudentManagement.Entities.Course.Course;

public class Student extends Person{

    private Course course;

    public Student(Person old, Course course){
        super(old);
        this.setCourse(course);
    }

    public Student(Student old){
        Person p = new Person();
        p.setName(old.getName());
        p.setEnrollmentService(old.getEnrollmentService());
        this(p, old.getCourse());
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public GraduateStudent graduateStudent() throws IllegalStateException{
        if(this.getCourse().getCourseCompletion()){
            return new GraduateStudent(this);
        }else{
            throw new IllegalStateException("The student hasn't completed the course to graduate");
        }
    }

    @Override
    public void Display(){
        super.Display();
        this.getCourse().Display();
    }
}
