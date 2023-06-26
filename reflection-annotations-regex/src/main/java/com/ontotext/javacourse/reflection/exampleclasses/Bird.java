package com.ontotext.javacourse.reflection.exampleclasses;

import com.ontotext.javacourse.reflection.orderobjects.Order;
import org.jetbrains.annotations.NotNull;

/** The Bird class defines a bird which has color, wingspan and species. */
@Order(value = 1)
public class Bird extends Animal implements Comparable<Animal> {
  private final String species;
  private final String color;
  private final double wingspan;

  public Bird(String species, String color, double wingspan) {
    this.species = species;
    this.color = color;
    this.wingspan = wingspan;
  }

  public void chirp() {
    System.out.println("Chirp chirp!");
  }

  public void fly() {
    System.out.println("The bird is flying.");
  }

  public void eat() {
    System.out.println("The bird is eating.");
  }

  public void buildNest() {
    System.out.println("The bird is building a nest.");
  }

  public String getSpecies() {
    return species;
  }

  public String getColor() {
    return color;
  }

  public double getWingspan() {
    return wingspan;
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
