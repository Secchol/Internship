package com.ontotext.javacourse.objects.robot.figures;

import com.ontotext.javacourse.objects.robot.OntoRobot;
import lombok.Getter;
import lombok.Setter;

/**
 * The Square class defines a square with a given length which is meant to be drawn. It takes x and y coordinates
 * which will be the top left point of the square.
 */
@Getter
@Setter
public class Square extends Dot {
    private int length;

    public Square(int x, int y, int length) {
        super(x, y);
        this.length = length;
    }

    /**
     * Draws a square using a given OntoRobot robot.
     *
     * @param robot the robot which to draw the figure with
     */
    @Override
    public void draw(OntoRobot robot) {
        drawRectangle(getX(), getY(), getLength(), getLength(), robot);
    }

    /**
     * Draws a rectangle with given length and width and coordinates of the top left point.
     *
     * @param x      the top left point ordinate
     * @param y      the top left point abscissa
     * @param length the length of the rectangle
     * @param width  the width of the rectangle
     * @param robot  the robot with which to draw the rectangle
     */
    protected void drawRectangle(int x, int y, int length, int width, OntoRobot robot) {
        Line leftSide = new Line(x, y, x - width + 1, y);
        Line bottomSide = new Line(leftSide.getSecondPointX(), leftSide.getSecondPointY() + 1, leftSide.getSecondPointX(), leftSide.getY() + length - 1);
        Line rightSide = new Line(bottomSide.getSecondPointX() + 1, bottomSide.getSecondPointY(), x, bottomSide.getSecondPointY());
        Line topSide = new Line(rightSide.getSecondPointX(), rightSide.getSecondPointY() - 1, leftSide.getX(), leftSide.getY() + 1);
        leftSide.draw(robot);
        bottomSide.draw(robot);
        rightSide.draw(robot);
        topSide.draw(robot);
    }
}
