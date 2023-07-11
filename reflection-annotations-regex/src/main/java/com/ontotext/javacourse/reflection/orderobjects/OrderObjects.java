package com.ontotext.javacourse.reflection.orderobjects;

import com.ontotext.javacourse.reflection.utilityclasses.Animal;
import java.util.Arrays;

/**
 * The OrderObjects class contains a method which orders the Animal classes based on their
 * annotation value.
 */
public final class OrderObjects {
  private OrderObjects() throws IllegalAccessException {
    throw new IllegalAccessException("OrderObjects class is not meant to be instantiated");
  }

  /**
   * Creates animals instances and orders them in order specified by their annotations.
   *
   * @return the animals ordered.
   */
  public static Animal[] orderObjects(Animal... animals) {
    Arrays.sort(animals);
    return animals;
  }
}
