package com.ontotext.javacourse.collections.hashdice;

import lombok.AllArgsConstructor;

/** Defines a combination of the values of two dice that were both rolled simultaneously. */
@AllArgsConstructor
public class DiceRollCombination {
  private int firstDiceValue;

  private int secondDiceValue;

  @Override
  public int hashCode() {
    return this.firstDiceValue ^ secondDiceValue;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof DiceRollCombination combination)) {
      return false;
    }
    return this.firstDiceValue == combination.firstDiceValue
        && this.secondDiceValue == combination.secondDiceValue;
  }
}
