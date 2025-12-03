package main.java.com.Airtribe.StudentManagement.Entities.Assignment;

import main.java.com.Airtribe.StudentManagement.Util.COURSE_TYPE;

import static main.java.com.Airtribe.StudentManagement.Util.UtilityFunctions.DisplayMessage;

public class NodeAssignment extends Assignment {
    private static int NodeCount = 0;
    private int nodeVersion;

    NodeAssignment(String name){
        super(name);
        NodeAssignment.NodeCount++;
        super.setId(NodeCount);
        super.setCourseType(COURSE_TYPE.NODE_JS);
    }

    @Override
    public void DisplayAssignment(){
        super.DisplayAssignment();
        DisplayMessage("Node version is : " + this.nodeVersion);
    }
}
