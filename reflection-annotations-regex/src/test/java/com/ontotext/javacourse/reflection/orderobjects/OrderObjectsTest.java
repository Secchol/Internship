package com.ontotext.javacourse.reflection.orderobjects;

import static org.junit.jupiter.api.Assertions.*;

import com.ontotext.javacourse.reflection.utilityclasses.Animal;
import com.ontotext.javacourse.reflection.utilityclasses.Bird;
import com.ontotext.javacourse.reflection.utilityclasses.Cat;
import com.ontotext.javacourse.reflection.utilityclasses.Dog;
import org.junit.jupiter.api.Test;

class OrderObjectsTest {

  @Test
  void orderObjectsWorksWithCorrectInput() {
    Dog dog = new Dog("Murdzho", 20, 20.2);
    Cat cat = new Cat("Kat", 30, "Siamese");
    Bird bird = new Bird("BIRDIE", "blue", 200.20);
    Animal[] output = OrderObjects.orderObjects(dog, cat, bird);
    assertInstanceOf(Bird.class, output[0]);
    assertInstanceOf(Cat.class, output[1]);
    assertInstanceOf(Dog.class, output[2]);
  }

  @Test
  void orderObjectsReturnsEmptyArrayWithEmptyInput() {
    Animal[] output = OrderObjects.orderObjects();
    assertEquals(0, output.length);
  }
}