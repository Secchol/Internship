package com.ontotext.javacourse.objects.robot;

import com.ontotext.javacourse.objects.robot.figures.Dot;
import kareltherobot.Directions;
import kareltherobot.World;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OntoRobotTest {

    private static final Dot dot = new Dot(5, 6);
    private OntoRobot robot;

    @BeforeEach
    void setUp() {
        World.setSize(20, 20);
        World.setDelay(0);
        robot = new OntoRobot(1, 1, Directions.East, 2, dot);
    }

    @Test
    void turnRightRobotChangesRobotDirection() {
        robot.turnRightRobot();
        assertEquals(robot.getDirection(),Directions.South);
    }

    @Test
    void turnLeftRobotChangesRobotDirection() {
        robot.turnLeftRobot();
        assertEquals(robot.getDirection(),Directions.North);
    }

    @Test
    void moveRobotMovesRobotToCorrectCoordinates() {
        robot.turnLeftRobot();
        robot.moveRobot();
        robot.moveRobot();
        assertTrue(robot.getStreet() == 3 && robot.getAvenue() == 1);
    }

    @Test
    void moveToMovesRobotToCorrectCoordinates() {
        robot.moveTo(10, 15);
        assertTrue(robot.getStreet() == 10 && robot.getAvenue() == 15);
    }
}