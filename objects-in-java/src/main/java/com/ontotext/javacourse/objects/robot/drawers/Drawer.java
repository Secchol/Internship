package com.ontotext.javacourse.objects.robot.drawers;

import com.ontotext.javacourse.objects.robot.OntoRobot;
import com.ontotext.javacourse.objects.robot.figures.Figure;

/**
 * The Drawer interface provides a draw method which can draw a given figure using an OntoRobot
 * robot.
 */
public interface Drawer {
  void draw(Figure figure, OntoRobot robot);
}
