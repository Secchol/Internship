package com.ontotext.javacourse.collections.hashdice;

import java.util.Random;
import lombok.Getter;

/** The Die class defines a die with given sides. */
@Getter
public class Die {
  private final Random random = new Random();
  private int sides;

  public Die(int sides) {
    setSides(sides);
  }

  public void setSides(int sides) {
    if (sides <= 0) {
      throw new IllegalArgumentException("Die sides must be more than zero!");
    }
    this.sides = sides;
  }

  /**
   * Rolls the dice.
   *
   * @return the number that the die fell on
   */
  public int rollDie() {
    return random.nextInt(1, sides + 1);
  }
}
