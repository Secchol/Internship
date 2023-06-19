package com.ontotext.javacourse.reflection.displayclassinfo;

import com.ontotext.javacourse.reflection.exampleclasses.Dog;
import com.ontotext.javacourse.reflection.instantiatebyname.InstantiateDog;

public class Runner {

  public static void main(String[] args) {
    Dog dog = new Dog("Murdzhu", 20, 100);
    System.out.println(DisplayClassInfo.returnClassInfo(dog));
    System.out.println(InstantiateDog.instantiateDogClassByName());
  }
}
