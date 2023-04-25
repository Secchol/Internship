package com.ontotext.javacourse.objects.robot;

import java.util.ArrayList;
import java.util.List;

public class OntoMasterRobot {
    private List<OntoRobot> robots;

    public OntoMasterRobot() {
        this.robots = new ArrayList<>();
    }

    /**
     * Adds new robot to the robots list.
     *
     * @param robot the robot to add
     */
    public void addRobot(OntoRobot robot) {
        this.robots.add(robot);
    }

    /**
     * Draws a house using the robots inside the OntoMasterRobot.
     */
    public void drawHouse() {
        for (OntoRobot robot : robots) {
            robot.draw();
            robot.setVisible(false);
        }
    }
}
