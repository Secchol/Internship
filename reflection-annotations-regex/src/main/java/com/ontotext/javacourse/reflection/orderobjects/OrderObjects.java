package com.ontotext.javacourse.reflection.orderobjects;

import com.ontotext.javacourse.reflection.exampleclasses.Animal;
import com.ontotext.javacourse.reflection.exampleclasses.Bird;
import com.ontotext.javacourse.reflection.exampleclasses.Cat;
import com.ontotext.javacourse.reflection.exampleclasses.Dog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
  public static String orderObjects() {
    List<Animal> animals = new ArrayList<>();
    animals.add(new Dog("Bob", 20, 120.2));
    animals.add(new Bird("pterodactyl", "red", 200.20));
    animals.add(new Cat("Kitty", 30, "siamese"));
    Comparator<Animal> animalComparator =
        (animal1, animal2) -> {
          Order firstOrder = animal1.getClass().getAnnotation(Order.class);
          Order secondOrder = animal2.getClass().getAnnotation(Order.class);
          if (firstOrder != null && secondOrder != null) {
            return Integer.compare(firstOrder.value(), secondOrder.value());
          }
          return 0;
        };
    Collections.sort(animals, animalComparator);
    StringBuilder orderedList = new StringBuilder();
    for (Animal animal : animals) {
      orderedList.append(animal.getClass().getName());
      orderedList.append(System.lineSeparator());
    }
    return orderedList.toString();
  }
}
