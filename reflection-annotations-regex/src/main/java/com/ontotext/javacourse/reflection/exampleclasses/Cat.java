package com.ontotext.javacourse.reflection.exampleclasses;

import com.ontotext.javacourse.reflection.orderobjects.Order;

/** The Cat class defines a cat which has a name, age and breed. */
@Order(value = 2)
public class Cat extends Animal {
  private final String name;
  private final int age;
  private final String breed;

  public Cat(String name, int age, String breed) {
    this.name = name;
    this.age = age;
    this.breed = breed;
  }

  public void meow() {
    System.out.println("Meow!");
  }

  public void sleep() {
    System.out.println("The cat is sleeping.");
  }

  public void eat() {
    System.out.println("The cat is eating.");
  }

  public void play() {
    System.out.println("The cat is playing.");
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public String getBreed() {
    return breed;
  }
}
