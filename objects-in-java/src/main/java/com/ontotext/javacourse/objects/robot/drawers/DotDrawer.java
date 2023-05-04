package com.ontotext.javacourse.objects.robot.drawers;

import com.ontotext.javacourse.objects.robot.OntoRobot;
import com.ontotext.javacourse.objects.robot.figures.Dot;
import com.ontotext.javacourse.objects.robot.figures.Figure;
import lombok.NoArgsConstructor;

/**
 * The DotDrawer class provides draw method which can draw a dot using a given OntoRobot robot.
 */
@NoArgsConstructor
public class DotDrawer implements Drawer {
    /**
     * Draws dot using given OntoRobot robot.
     *
     * @param robot the robot which to draw the figure with
     */
    @Override
    public void draw(Figure figure, OntoRobot robot) {
        Dot dot = (Dot) figure;
        robot.moveTo(dot.getX(), dot.getY());
        robot.putBeeper();
    }
}
