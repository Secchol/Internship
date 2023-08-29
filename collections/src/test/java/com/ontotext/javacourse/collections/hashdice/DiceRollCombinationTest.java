package com.ontotext.javacourse.collections.hashdice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DiceRollCombinationTest {

  @Test
  void testEqualsReturnsTrueIfObjectsAreEqual() {
    DiceRollCombination firstCombination = new DiceRollCombination(5, 5);
    DiceRollCombination secondCombination = new DiceRollCombination(5, 5);
    assertEquals(firstCombination, secondCombination);
  }

  @Test
  void testEqualsReturnsFalseIfObjectsAreNotEqual() {
    DiceRollCombination firstCombination = new DiceRollCombination(10, 20);
    DiceRollCombination secondCombination = new DiceRollCombination(5, 5);
    assertNotEquals(firstCombination, secondCombination);
  }
}
