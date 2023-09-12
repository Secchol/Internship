package com.ontotext.javacourse.collections.hashdice;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

/** Defines a combination of the values of two dice that were both rolled simultaneously. */
@AllArgsConstructor
@EqualsAndHashCode
public class DiceRollCombination {
  private int firstDiceValue;

  private int secondDiceValue;
}
