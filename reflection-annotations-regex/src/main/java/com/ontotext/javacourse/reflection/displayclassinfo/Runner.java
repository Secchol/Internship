package com.ontotext.javacourse.reflection.displayclassinfo;

import com.ontotext.javacourse.reflection.exampleclasses.Dog;
import com.ontotext.javacourse.reflection.orderobjects.OrderObjects;

public class Runner {
  public static void main(String[] args) {
    Dog dog = new Dog("Murdzho", 20, 120);
    System.out.println(OrderObjects.orderObjects());
  }
}
