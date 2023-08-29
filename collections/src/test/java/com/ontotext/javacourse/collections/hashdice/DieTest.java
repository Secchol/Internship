package com.ontotext.javacourse.collections.hashdice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DieTest {

  @ParameterizedTest
  @ValueSource(ints = {0, -20})
  void setSidesThrowsExceptionIfSidesAreLessThanOrEqualToZero(int sides) {
    assertThrows(IllegalArgumentException.class, () -> new Die(sides));
  }

  @Test
  void rollDieReturnsIntegerInCorrectRange() {
    Die die = new Die(10);
    assertTrue(die.rollDie() >= 1 && die.rollDie() <= die.getSides());
  }
}
