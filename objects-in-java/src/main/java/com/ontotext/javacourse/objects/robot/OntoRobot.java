package com.ontotext.javacourse.objects.robot;

import com.ontotext.javacourse.objects.robot.figures.*;
import kareltherobot.Directions;
import kareltherobot.UrRobot;
import kareltherobot.World;
import lombok.Getter;
import lombok.Setter;


public class OntoRobot extends UrRobot {

    private final Figure figure;
    @Getter
    @Setter
    private int street;
    @Getter
    @Setter
    private int avenue;
    @Getter
    @Setter
    private Directions.Direction direction;

    public OntoRobot(int street, int avenue, Direction direction, int beepers, Figure figure) {
        super(street, avenue, direction, beepers);
        this.setStreet(street);
        this.setAvenue(avenue);
        this.setDirection(direction);
        this.figure = figure;
    }

    /**
     * Draws given robot figure using beepers
     */
    public void draw() {
        if (this.figure instanceof Rectangle) {
            drawRectangle();
        } else if (this.figure instanceof Square) {
            drawSquare();
        } else if (this.figure instanceof Line) {
            drawLine((Line) this.figure);
        } else if (this.figure instanceof Dot) {
            drawDot();
        }
    }

    private void drawSquare() {
        Square square = (Square) figure;
        Line leftSide = new Line(square.getX(), square.getY(), square.getX() - square.getLength() + 1, square.getY());
        Line bottomSide = new Line(leftSide.getSecondPointX(), leftSide.getSecondPointY() + 1, leftSide.getSecondPointX(), leftSide.getY() + square.getLength() - 1);
        Line rightSide = new Line(bottomSide.getSecondPointX() + 1, bottomSide.getSecondPointY(), square.getX(), bottomSide.getSecondPointY());
        Line topSide = new Line(rightSide.getSecondPointX(), rightSide.getSecondPointY() - 1, leftSide.getX(), leftSide.getY() + 1);
        drawLine(leftSide);
        drawLine(bottomSide);
        drawLine(rightSide);
        drawLine(topSide);
    }

    private void drawRectangle() {
        Rectangle rectangle = (Rectangle) figure;
        Line leftSide = new Line(rectangle.getX(), rectangle.getY(), rectangle.getX() - rectangle.getWidth() + 1, rectangle.getY());
        Line bottomSide = new Line(leftSide.getSecondPointX(), leftSide.getSecondPointY() + 1, leftSide.getSecondPointX(), leftSide.getY() + rectangle.getLength() - 1);
        Line rightSide = new Line(bottomSide.getSecondPointX() + 1, bottomSide.getSecondPointY(), rectangle.getX(), bottomSide.getSecondPointY());
        Line topSide = new Line(rightSide.getSecondPointX(), rightSide.getSecondPointY() - 1, leftSide.getX(), leftSide.getY() + 1);
        drawLine(leftSide);
        drawLine(bottomSide);
        drawLine(rightSide);
        drawLine(topSide);
    }

    private void drawLine(Line line) {
        int distanceX = Math.abs(line.getSecondPointX() - line.getX());
        int distanceY = Math.abs(line.getSecondPointY() - line.getY());
        int directionX = line.getX() < line.getSecondPointX() ? 1 : -1;
        int directionY = line.getY() < line.getSecondPointY() ? 1 : -1;
        int error = distanceX - distanceY;
        int currentX = line.getX();
        int currentY = line.getY();
        moveTo(currentX, currentY);
        while (currentX != line.getSecondPointX() || currentY != line.getSecondPointY()) {
            if (currentX == this.street && currentY == this.avenue) {
                putBeeper();
            }

            if (2 * error > -distanceY) {
                error -= distanceY;
                currentX += directionX;
                moveTo(currentX, currentY);
            }
            if (2 * error < distanceX) {
                error += distanceX;
                currentY += directionY;
                moveTo(currentX, currentY);
            }
        }
        putBeeper();
    }

    private void drawDot() {
        this.moveTo(figure.getX(), figure.getY());
        this.putBeeper();
    }

    /**
     * Turns KarelJ robot to the right
     */
    public void turnRightRobot() {
        turnLeft();
        fixDirectionTurnLeft();
        turnLeft();
        fixDirectionTurnLeft();
        turnLeft();
        fixDirectionTurnLeft();
    }

    /**
     * Turns KarelJ robot to the left
     */
    public void turnLeftRobot() {
        turnLeft();
        fixDirectionTurnLeft();
    }

    /**
     * Moves KarelJ robot 1 position in the direction that he is facing
     */
    public void moveRobot() {
        move();
        if (this.direction.equals(Directions.North)) {
            this.street++;
        } else if (this.direction.equals(Directions.South)) {
            this.street--;
        } else if (this.direction.equals(Directions.East)) {
            this.avenue++;
        } else if (this.direction.equals(Directions.West)) {
            this.avenue--;
        }
    }

    /**
     * Moves KarelJ robot to a given street and venue
     *
     * @param street destination street
     * @param avenue destination avenue
     */
    public void moveTo(int street, int avenue) {
        if (street <= 0 || avenue <= 0) {
            World.signalError("Street and avenue must be larger than zero!", "OutOfBounds");
            return;
        }
        if (this.street > street) {
            turnSouth();
            while (this.street > street) {
                moveRobot();
            }
        } else if (this.street < street) {
            turnNorth();
            while (this.street < street) {
                moveRobot();
            }
        }

        if (this.avenue > avenue) {
            turnWest();
            while (this.avenue > avenue) {
                moveRobot();
            }
        } else if (this.avenue < avenue) {
            turnEast();
            while (this.avenue < avenue) {
                moveRobot();
            }
        }
    }

    /**
     * Keeps track of KarelJ robot direction when turning left
     */
    private void fixDirectionTurnLeft() {
        if (this.direction.equals(Directions.East)) {
            this.direction = Directions.North;
        } else if (this.direction.equals(North)) {
            this.direction = Directions.West;
        } else if (this.direction.equals(West)) {
            this.direction = Directions.South;
        } else if (this.direction.equals(Directions.South)) {
            this.direction = Directions.East;
        }
    }

    private void turnNorth() {
        if (this.direction.equals(East)) {
            turnLeftRobot();
        } else if (this.direction.equals(West)) {
            turnRightRobot();
        } else if (this.direction.equals(South)) {
            turnLeftRobot();
            turnLeftRobot();
        }
    }

    private void turnSouth() {
        if (this.direction.equals(East)) {
            turnRightRobot();
        } else if (this.direction.equals(West)) {
            turnLeftRobot();
        } else if (this.direction.equals(North)) {
            turnLeftRobot();
            turnLeftRobot();
        }
    }

    private void turnEast() {
        if (this.direction.equals(North)) {
            turnRightRobot();
        } else if (this.direction.equals(South)) {
            turnLeftRobot();
        } else if (this.direction.equals(West)) {
            turnLeftRobot();
            turnLeftRobot();
        }
    }

    private void turnWest() {
        if (this.direction.equals(South)) {
            turnRightRobot();
        } else if (this.direction.equals(North)) {
            turnLeftRobot();
        } else if (this.direction.equals(East)) {
            turnLeftRobot();
            turnLeftRobot();
        }
    }
}
