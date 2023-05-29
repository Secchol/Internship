package com.ontotext.javacourse.objects.robot;

import com.ontotext.javacourse.objects.robot.figures.*;
import kareltherobot.Directions;

/**
 * The OntoMasterRobot class has a drawHouse method which uses multiple OntoRobot robots to draw a
 * house.
 */
public class OntoMasterRobot {

  private OntoMasterRobot() throws IllegalAccessException {
    throw new IllegalAccessException("OntoMasterRobot class is not meant to be instantiated!");
  }

  /** Draws a house using OntoRobots. */
  public static void drawHouse() {
    drawHouseBase();
    drawHouseRoof();
  }

  /** Draws the base of the house. */
  private static void drawHouseBase() {
    Figure rectangleBase = new Rectangle(13, 5, 13, 7);
    Square window = new Square(12, 7, 3);
    Dot windowDot = new Dot(11, 8);
    Rectangle door = new Rectangle(12, 12, 4, 5);
    Dot doorHandle = new Dot(9, 14);
    OntoRobot robot1 = new OntoRobot(1, 1, Directions.East, 100);
    robot1.draw(rectangleBase);
    robot1.draw(window);
    robot1.draw(windowDot);
    robot1.draw(door);
    robot1.draw(doorHandle);
    robot1.setVisible(false);
  }

  /** Draws the roof and the roof window of the house. */
  private static void drawHouseRoof() {
    Figure roofLeftSide = new Line(13, 5, 19, 11);
    Figure roofRightSide = new Line(13, 17, 19, 11);
    Square roofWindow = new Square(16, 10, 3);
    Dot roofWindowDot = new Dot(15, 11);
    OntoRobot robot2 = new OntoRobot(1, 1, Directions.East, 100);
    robot2.draw(roofLeftSide);
    robot2.draw(roofRightSide);
    robot2.draw(roofWindow);
    robot2.draw(roofWindowDot);
    robot2.setVisible(false);
  }
}
