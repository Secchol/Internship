package com.ontotext.javacourse.reflection.exampleclasses;

import com.ontotext.javacourse.reflection.orderobjects.Order;

/** The Bird class defines a bird which has color, wingspan and species. */
@Order(value = 1)
public class Bird extends Animal {
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
}
