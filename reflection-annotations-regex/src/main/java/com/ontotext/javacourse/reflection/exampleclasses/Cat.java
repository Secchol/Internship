package com.ontotext.javacourse.reflection.exampleclasses;

import com.ontotext.javacourse.reflection.orderobjects.Order;
import org.jetbrains.annotations.NotNull;

/** The Cat class defines a cat which has a name, age and breed. */
@Order(value = 2)
public class Cat extends Animal implements Comparable<Animal> {
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

  @Override
  public int compareTo(@NotNull Animal otherAnimal) {
    Order firstOrder = this.getClass().getAnnotation(Order.class);
    Order secondOrder = otherAnimal.getClass().getAnnotation(Order.class);
    if (firstOrder != null && secondOrder != null) {
      return Integer.compare(firstOrder.value(), secondOrder.value());
    }
    return 0;
  }
}
