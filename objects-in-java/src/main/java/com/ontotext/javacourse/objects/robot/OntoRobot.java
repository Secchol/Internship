package com.ontotext.javacourse.objects.robot;

import com.ontotext.javacourse.objects.robot.drawers.FigureDrawer;
import com.ontotext.javacourse.objects.robot.figures.Figure;
import kareltherobot.Directions;
import kareltherobot.UrRobot;
import lombok.Getter;
import lombok.Setter;


/**
 * The OntoRobot class extends the KarelJ robot with the turnRight, moveTo and draw methods.
 */
@Getter
@Setter
public class OntoRobot extends UrRobot {

    private int street;

    private int avenue;

    private Directions.Direction direction;

    public OntoRobot(int street, int avenue, Direction direction, int beepers) {
        super(street, avenue, direction, beepers);
        this.setStreet(street);
        this.setAvenue(avenue);
        this.setDirection(direction);
    }

    /**
     * Draws given robot figure using beepers.
     */
    public void draw(Figure figure) {
        FigureDrawer<Figure> drawer = new FigureDrawer<>();
        drawer.draw(figure, this);
    }

    /**
     * Turns KarelJ robot to the right.
     */
    public void turnRight() {
        turnLeft();
        turnLeft();
        turnLeft();
    }

    /**
     * Turns KarelJ robot to the left.
     */
    @Override
    public void turnLeft() {
        super.turnLeft();
        synchronizeTurnLeftDirection();
    }

    /**
     * Moves KarelJ robot 1 position in the direction that he is facing.
     */
    @Override
    public void move() {
        super.move();
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
     * Moves KarelJ robot to a given street and avenue.
     *
     * @param street destination street
     * @param avenue destination avenue
     */
    public void moveTo(int street, int avenue) {
        if (street <= 0 || avenue <= 0) {

            return;
        }
        if (this.street > street) {
            turnToDirection(Directions.South);
            while (this.street > street) {
                move();
            }
        } else if (this.street < street) {
            turnToDirection(Directions.North);
            while (this.street < street) {
                move();
            }
        }
        if (this.avenue > avenue) {
            turnToDirection(Directions.West);
            while (this.avenue > avenue) {
                move();
            }
        } else if (this.avenue < avenue) {
            turnToDirection(Directions.East);
            while (this.avenue < avenue) {
                move();
            }
        }
    }

    /**
     * Keeps track of KarelJ robot direction when turning left.
     */
    private void synchronizeTurnLeftDirection() {
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

    /**
     * Turns robot to a given direction.
     *
     * @param direction the direction which to turn the robot to
     */
    private void turnToDirection(Directions.Direction direction) {
        while (!this.direction.equals(direction)) {
            this.turnLeft();
        }
    }

}
