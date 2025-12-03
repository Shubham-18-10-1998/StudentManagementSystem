package main.java.com.Airtribe.StudentManagement.Entities.Course;

import main.java.com.Airtribe.StudentManagement.Entities.Assignment.JavaAssignment;
import main.java.com.Airtribe.StudentManagement.Util.COURSE_TYPE;

public class JavaCourse extends Course {
    private static int count;

    public JavaCourse(){
        super(COURSE_TYPE.JAVA);
        count++;
        super.setId(count);
        super.setName(super.getCourseType().toString() + "_" + super.getId());
        super.setAssignments(new JavaAssignment("intro_assignment_java"));
    }
}
