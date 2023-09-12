package com.ontotext.javacourse.objects.robot.figures;

import lombok.Getter;
import lombok.Setter;

/**
 * The Square class defines a square with a given length which is meant to be drawn. It takes x and
 * y coordinates which will be the top left point of the square.
 */
@Getter
@Setter
public class Square extends Dot {
  private int length;

  public Square(int x, int y, int length) {
    super(x, y);
    this.length = length;
  }
}
