package com.ontotext.javacourse.objects.robot;

import kareltherobot.Directions;
import kareltherobot.World;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OntoRobotTest {

    private OntoRobot robot;

    @BeforeEach
    void setUp() {
        World.setSize(20, 20);
        World.setDelay(0);
        robot = new OntoRobot(1, 1, Directions.East, 2);
    }

    @Test
    void turnRightRobotChangesRobotDirection() {
        robot.turnRight();
        assertEquals(Directions.South, robot.getDirection());
    }

    @Test
    void turnLeftRobotChangesRobotDirection() {
        robot.turnLeft();
        assertEquals(Directions.North, robot.getDirection());
    }

    @Test
    void moveRobotMovesRobotToCorrectCoordinates() {
        robot.turnLeft();
        robot.move();
        robot.move();
        assertTrue(robot.getStreet() == 3 && robot.getAvenue() == 1);
    }

    @Test
    void moveToMovesRobotToCorrectCoordinates() {
        robot.moveTo(10, 15);
        assertTrue(robot.getStreet() == 10 && robot.getAvenue() == 15);
    }

    @Test
    void moveToDoesNotChangeRobotPositionWhenGivenStreetIsEqualToZero() {
        robot.moveTo(0, 15);
        assertTrue(robot.getStreet() == 1 && robot.getAvenue() == 1);
    }

    @Test
    void moveToDoesNotChangeRobotPositionWhenGivenStreetIsLessThanZero() {
        robot.moveTo(-20, 15);
        assertTrue(robot.getStreet() == 1 && robot.getAvenue() == 1);
    }

    @Test
    void moveToDoesNotChangeRobotPositionWhenGivenAvenueIsLessThanZero() {
        robot.moveTo(20, -15);
        assertTrue(robot.getStreet() == 1 && robot.getAvenue() == 1);
    }

    @Test
    void moveToDoesNotChangeRobotPositionWhenGivenAvenueIsEqualToZero() {
        robot.moveTo(20, 0);
        assertTrue(robot.getStreet() == 1 && robot.getAvenue() == 1);
    }
}