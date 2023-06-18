package com.ontotext.javacourse.objects.robot.drawers;

import com.ontotext.javacourse.objects.robot.OntoRobot;
import com.ontotext.javacourse.objects.robot.figures.*;
import lombok.NoArgsConstructor;

/**
 * The FigureDrawer class can draw a given figure using an OntoRobot robot.
 *
 * @param <T>
 */
@NoArgsConstructor
public class FigureDrawer<T extends Figure> {

  /**
   * Draws a given figure using OntoRobot robot.
   *
   * @param figure the figure to draw
   * @param robot the robot which to draw the figure with
   */
  public void draw(T figure, OntoRobot robot) {
    Drawer drawer = getDrawer(figure);
    if (drawer == null) {
      throw new NullPointerException("The given figure is not drawable!");
    }
    drawer.draw(figure, robot);
  }

  /**
   * Returns the specific drawer for the given figure.
   *
   * @param figure the figure which to get the drawer of
   * @return the specific figure drawer
   */
  private Drawer getDrawer(T figure) {
    if (figure instanceof Rectangle) {
      return new RectangleDrawer();
    } else if (figure instanceof Square) {
      return new SquareDrawer();
    } else if (figure instanceof Line) {
      return new LineDrawer();
    } else if (figure instanceof Dot) {
      return new DotDrawer();
    }
    return null;
  }
}
