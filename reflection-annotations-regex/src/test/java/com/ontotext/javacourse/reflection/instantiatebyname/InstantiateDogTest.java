package com.ontotext.javacourse.reflection.instantiatebyname;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InstantiateDogTest {

  @Test
  void instantiateDogClassByNameReturnsCorrectOutput() {
    String[] expectedOutput =
        new String[] {
          "Parent class: com.ontotext.javacourse.reflection.exampleclasses.Animal",
          "Interfaces:",
          "com.ontotext.javacourse.reflection.exampleclasses.Mammal"
        };
    boolean hasIncorrectElements = false;
    String actualOutput = InstantiateDog.instantiateDogClassByName();
    for (String item : expectedOutput) {
      if (!actualOutput.contains(item)) {
        hasIncorrectElements = true;
      }
    }
    assertFalse(hasIncorrectElements);
  }
}
