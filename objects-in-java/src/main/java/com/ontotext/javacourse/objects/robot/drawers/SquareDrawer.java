package com.ontotext.javacourse.objects.robot.drawers;

import com.ontotext.javacourse.objects.robot.OntoRobot;
import com.ontotext.javacourse.objects.robot.figures.Figure;
import com.ontotext.javacourse.objects.robot.figures.Line;
import com.ontotext.javacourse.objects.robot.figures.Square;
import lombok.NoArgsConstructor;

/**
 * The SquareDrawer class provides draw method which can square a dot using a given OntoRobot robot.
 */
@NoArgsConstructor
public class SquareDrawer implements Drawer {
    /**
     * Draws a square using a given OntoRobot robot.
     *
     * @param robot the robot which to draw the figure with
     */
    @Override
    public void draw(Figure figure, OntoRobot robot) {
        Square square = (Square) figure;
        drawRectangle(square.getX(), square.getY(), square.getLength(), square.getLength(), robot);
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
        LineDrawer lineDrawer = new LineDrawer();
        lineDrawer.draw(leftSide, robot);
        lineDrawer.draw(bottomSide, robot);
        lineDrawer.draw(rightSide, robot);
        lineDrawer.draw(topSide, robot);
    }
}
