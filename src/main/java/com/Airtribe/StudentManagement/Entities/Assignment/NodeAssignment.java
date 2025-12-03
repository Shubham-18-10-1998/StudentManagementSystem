package main.java.com.Airtribe.StudentManagement.Entities.Assignment;

import main.java.com.Airtribe.StudentManagement.Util.COURSE_TYPE;

import static main.java.com.Airtribe.StudentManagement.Util.UtilityFunctions.DisplayMessage;

public class NodeAssignment extends Assignment {
    private static int NodeCount = 0;
    private double nodeVersion;

    public NodeAssignment(String name){
        super(name);
        NodeAssignment.NodeCount++;
        super.setId(NodeCount);
        super.setCourseType(COURSE_TYPE.NODE_JS);
        this.nodeVersion = 25.2;
    }

    @Override
    public void DisplayAssignment(){
        super.DisplayAssignment();
        DisplayMessage("Node version is : " + this.nodeVersion);
    }
}
