package com.ontotext.javacourse.objects.robot.figures;

import com.ontotext.javacourse.objects.robot.OntoRobot;
import lombok.Getter;
import lombok.Setter;

/**
 * The Line class defines a line which is meant to be drawn. It takes two x and two y coordinates which indicate
 * the two points of the line.
 */
@Getter
@Setter
public class Line extends Dot {
    private int secondPointX;
    private int secondPointY;

    public Line(int x, int y, int secondPointX, int secondPointY) {
        super(x, y);
        this.secondPointX = secondPointX;
        this.secondPointY = secondPointY;
    }

    /**
     * Draws a line using a given OntoRobot robot.
     *
     * @param robot the robot which to draw the figure with
     */
    @Override
    public void draw(OntoRobot robot) {
        int distanceX = Math.abs(getSecondPointX() - getX());
        int distanceY = Math.abs(getSecondPointY() - getY());
        int directionX = getX() < getSecondPointX() ? 1 : -1;
        int directionY = getY() < getSecondPointY() ? 1 : -1;
        int error = distanceX - distanceY;
        int currentX = getX();
        int currentY = getY();
        robot.moveTo(currentX, currentY);
        while (currentX != getSecondPointX() || currentY != getSecondPointY()) {
            if (currentX == robot.getStreet() && currentY == robot.getAvenue()) {
                robot.putBeeper();
            }

            if (2 * error > -distanceY) {
                error -= distanceY;
                currentX += directionX;
                robot.moveTo(currentX, currentY);
            }
            if (2 * error < distanceX) {
                error += distanceX;
                currentY += directionY;
                robot.moveTo(currentX, currentY);
            }
        }
        robot.putBeeper();
    }
}


