package com.ontotext.javacourse.objects.robot.figures;

import lombok.Getter;
import lombok.Setter;

/**
 * The Rectangle class defines a rectangle with given length and width which is meant to be drawn.
 * It takes x and y coordinates which will be the top left point of the rectangle.
 */
@Getter
@Setter
public class Rectangle extends Square {
  private int width;

  public Rectangle(int x, int y, int length, int width) {
    super(x, y, length);
    this.width = width;
  }
}
