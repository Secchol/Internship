package com.ontotext.javacourse.reflection.displayclassinfo;

import static org.junit.jupiter.api.Assertions.*;

import com.ontotext.javacourse.reflection.exampleclasses.Dog;
import org.junit.jupiter.api.Test;

class DisplayClassInfoTest {

  @Test
  void returnClassInfoWorksWithCorrectInput() {
    String[] expectedOutput =
        new String[] {
          "Class name: com.ontotext.javacourse.reflection.exampleclasses.Dog",
          "Method: public java.lang.String com.ontotext.javacourse.reflection.exampleclasses.Dog.getName()",
          "Method: public java.lang.String com.ontotext.javacourse.reflection.exampleclasses.Dog.toString()",
          "Method: public void com.ontotext.javacourse.reflection.exampleclasses.Dog.setName(java.lang.String)",
          "Method: public void com.ontotext.javacourse.reflection.exampleclasses.Dog.setAge(int)",
          "Method: public double com.ontotext.javacourse.reflection.exampleclasses.Dog.getWeight()",
          "Method: public void com.ontotext.javacourse.reflection.exampleclasses.Dog.setWeight(java.lang.Double)",
          "Method: public void com.ontotext.javacourse.reflection.exampleclasses.Dog.makeSound()",
          "Method: public int com.ontotext.javacourse.reflection.exampleclasses.Dog.getAge()",
          "Method: private int com.ontotext.javacourse.reflection.exampleclasses.Dog.returnAgeInDogYears(int)",
          "Field name: java.lang.String value: Murdzho",
          "Field name: int value: 20",
          "Field name: double value: 120.0"
        };
    Dog dog = new Dog("Murdzho", 20, 120);
    boolean hasIncorrectElements = false;
    String methodResult = DisplayClassInfo.returnClassInfo(dog);
    for (String item : expectedOutput) {
      if (!methodResult.contains(item)) {
        hasIncorrectElements = true;
      }
    }
    assertFalse(hasIncorrectElements);
  }
}
