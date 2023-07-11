package com.ontotext.javacourse.reflection.utilityclasses;

import com.ontotext.javacourse.reflection.orderobjects.Order;
import org.jetbrains.annotations.NotNull;

/** Defines an abstract animal class. */
public abstract class Animal implements Comparable<Animal> {
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
