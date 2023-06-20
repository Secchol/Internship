package com.ontotext.javacourse.reflection.orderobjects;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OrderObjectsTest {

  @Test
  void orderObjectsReturnsCorrectOutput() {
    StringBuilder expectedOutput = new StringBuilder();
    expectedOutput.append("com.ontotext.javacourse.reflection.exampleclasses.Bird");
    expectedOutput.append(System.lineSeparator());
    expectedOutput.append("com.ontotext.javacourse.reflection.exampleclasses.Cat");
    expectedOutput.append(System.lineSeparator());
    expectedOutput.append("com.ontotext.javacourse.reflection.exampleclasses.Dog");
    String actualOutput = OrderObjects.orderObjects();
    assertEquals(expectedOutput.toString(), actualOutput.trim());
  }
}
