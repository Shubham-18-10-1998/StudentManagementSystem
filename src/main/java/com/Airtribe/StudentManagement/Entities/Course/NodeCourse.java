package main.java.com.Airtribe.StudentManagement.Entities.Course;

import main.java.com.Airtribe.StudentManagement.Util.COURSE_TYPE;

public class NodeCourse extends Course {
    private static int count = 0;

    public NodeCourse() {
        super(COURSE_TYPE.NODE_JS);
        count++;
        super.setId(count);
        super.setName(super.getCourseType().toString() + "_" + super.getId());

    }
}
