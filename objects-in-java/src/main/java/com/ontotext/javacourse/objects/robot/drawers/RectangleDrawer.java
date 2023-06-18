package com.ontotext.javacourse.objects.robot.drawers;

import com.ontotext.javacourse.objects.robot.OntoRobot;
import com.ontotext.javacourse.objects.robot.figures.Figure;
import com.ontotext.javacourse.objects.robot.figures.Rectangle;
import lombok.NoArgsConstructor;

/**
 * The RectangleDrawer class provides draw method which can draw a rectangle using a given OntoRobot
 * robot.
 */
@NoArgsConstructor
public class RectangleDrawer extends SquareDrawer {

  /**
   * Draws a rectangle using a given OntoRobot robot.
   *
   * @param robot the robot which to draw the figure with
   */
  @Override
  public void draw(Figure figure, OntoRobot robot) {
    Rectangle rectangle = (Rectangle) figure;
    super.drawRectangle(
        rectangle.getX(), rectangle.getY(), rectangle.getLength(), rectangle.getWidth(), robot);
  }
}
