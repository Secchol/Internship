package com.ontotext.javacourse.objects.robot.drawers;

import com.ontotext.javacourse.objects.robot.OntoRobot;
import com.ontotext.javacourse.objects.robot.figures.Figure;
import com.ontotext.javacourse.objects.robot.figures.Line;
import lombok.NoArgsConstructor;

/**
 * The LineDrawer class provides draw method which can draw a line using a given OntoRobot robot.
 */
@NoArgsConstructor
public class LineDrawer implements Drawer {
  /**
   * Draws a line using a given OntoRobot robot.
   *
   * @param robot the robot which to draw the figure with
   */
  @Override
  public void draw(Figure figure, OntoRobot robot) {
    Line line = (Line) figure;
    int distanceX = Math.abs(line.getSecondPointX() - line.getX());
    int distanceY = Math.abs(line.getSecondPointY() - line.getY());
    int directionX = line.getX() < line.getSecondPointX() ? 1 : -1;
    int directionY = line.getY() < line.getSecondPointY() ? 1 : -1;
    int error = distanceX - distanceY;
    int currentX = line.getX();
    int currentY = line.getY();
    robot.moveTo(currentX, currentY);
    while (currentX != line.getSecondPointX() || currentY != line.getSecondPointY()) {
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
