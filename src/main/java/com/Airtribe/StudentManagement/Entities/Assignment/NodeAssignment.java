package main.java.com.Airtribe.StudentManagement.Entities.Assignment;

import static main.java.com.Airtribe.StudentManagement.Util.UtilityFunctions.DisplayMessage;

public class NodeAssignment extends Assignment {
    private static int NodeCount = 0;
    private int nodeVersion;

    NodeAssignment(String name){
        super(name);
        NodeAssignment.NodeCount++;
        super.setId(NodeCount);
    }

    @Override
    public void DisplayAssignment(){
        super.DisplayAssignment();
        DisplayMessage("Node version is : " + this.nodeVersion);
    }
}
