package com.ontotext.javacourse.reflection.displayprivatefieldsandmethods;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DisplayPrivateInfoTest {

  @Test
  void displayPrivateInfoReturnsCorrectOutput() {
    String[] expectedOutput =
        new String[] {
          "Class name: com.ontotext.javacourse.reflection.exampleclasses.Dog",
          "Method: public java.lang.String com.ontotext.javacourse.reflection.exampleclasses.Dog.getName()",
          "Method: public java.lang.String com.ontotext.javacourse.reflection.exampleclasses.Dog.toString()",
          "Method: public void com.ontotext.javacourse.reflection.exampleclasses.Dog.setName(java.lang.String)",
          "Method: private int com.ontotext.javacourse.reflection.exampleclasses.Dog.returnAgeInDogYears(int)",
          "Method: public int com.ontotext.javacourse.reflection.exampleclasses.Dog.getAge()",
          "Method: public double com.ontotext.javacourse.reflection.exampleclasses.Dog.getWeight()",
          "Method: public void com.ontotext.javacourse.reflection.exampleclasses.Dog.setWeight(java.lang.Double)",
          "Method: public void com.ontotext.javacourse.reflection.exampleclasses.Dog.setAge(int)",
          "Method: public void com.ontotext.javacourse.reflection.exampleclasses.Dog.makeSound()",
          "Field name: java.lang.String value: Donkey",
          "Field name: int value: 20",
          "Field name: double value: 120.2",
          "Private method result is: 100"
        };
    boolean hasIncorrectElements = false;
    String actualOutput = DisplayPrivateInfo.displayPrivateInfo();
    for (String item : expectedOutput) {
      if (!actualOutput.contains(item)) {
        hasIncorrectElements = true;
      }
    }
    assertFalse(hasIncorrectElements);
  }
}
