package com.ontotext.javacourse.objects.robot;

import com.ontotext.javacourse.objects.robot.figures.*;
import kareltherobot.Directions;
import kareltherobot.World;

public class Runner {
    public static void main(String[] args) {
        World.setSize(20, 20);
        World.setVisible(true);
        World.setDelay(0);
        Figure rectangleBase = new Rectangle(13, 5, 13, 7);
        Figure roofLeftSide = new Line(13, 5, 19, 11);
        Figure roofRightSide = new Line(13, 17, 19, 11);
        Square window = new Square(12, 7, 3);
        Dot windowDot = new Dot(11, 8);
        Rectangle door = new Rectangle(12, 12, 4, 5);
        Dot doorHandle = new Dot(9, 14);
        Square roofWindow = new Square(16, 10, 3);
        Dot roofWindowDot = new Dot(15, 11);
        OntoRobot robot = new OntoRobot(1, 1, Directions.East, 40, rectangleBase);
        OntoRobot robot2 = new OntoRobot(1, 1, Directions.East, 20, roofLeftSide);
        OntoRobot robot3 = new OntoRobot(1, 1, Directions.East, 20, roofRightSide);
        OntoRobot robot4 = new OntoRobot(1, 1, Directions.East, 20, window);
        OntoRobot robot5 = new OntoRobot(1, 1, Directions.East, 20, windowDot);
        OntoRobot robot6 = new OntoRobot(1, 1, Directions.East, 20, door);
        OntoRobot robot7 = new OntoRobot(1, 1, Directions.East, 20, doorHandle);
        OntoRobot robot8 = new OntoRobot(1, 1, Directions.East, 20, roofWindow);
        OntoRobot robot9 = new OntoRobot(1, 1, Directions.East, 20, roofWindowDot);
        OntoMasterRobot masterRobot = new OntoMasterRobot();
        masterRobot.addRobot(robot);
        masterRobot.addRobot(robot2);
        masterRobot.addRobot(robot3);
        masterRobot.addRobot(robot4);
        masterRobot.addRobot(robot5);
        masterRobot.addRobot(robot6);
        masterRobot.addRobot(robot7);
        masterRobot.addRobot(robot8);
        masterRobot.addRobot(robot9);

        masterRobot.drawHouse();
    }
}
