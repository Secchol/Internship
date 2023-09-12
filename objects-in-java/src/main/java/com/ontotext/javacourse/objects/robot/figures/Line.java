package com.ontotext.javacourse.objects.robot.figures;

import lombok.Getter;
import lombok.Setter;

/**
 * The Line class defines a line which is meant to be drawn. It takes two x and two y coordinates
 * which indicate the two points of the line.
 */
@Getter
@Setter
public class Line extends Dot {
  private int secondPointX;
  private int secondPointY;

  public Line(int x, int y, int secondPointX, int secondPointY) {
    super(x, y);
    this.secondPointX = secondPointX;
    this.secondPointY = secondPointY;
  }
}
