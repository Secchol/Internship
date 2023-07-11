package com.ontotext.javacourse.reflection.utilityclasses;

import com.ontotext.javacourse.reflection.orderobjects.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** The Bird class defines a bird which has color, wingspan and species. */
@Getter
@Setter
@AllArgsConstructor
@ToString
@Order(value = 1)
public class Bird extends Animal implements Comparable<Animal> {
  private static final Logger LOGGER = LoggerFactory.getLogger(Bird.class);
  private final String species;
  private final String color;
  private final double wingspan;

  public void chirp() {
    LOGGER.info("Chirp chirp!");
  }

  public void fly() {
    LOGGER.info("The bird is flying.");
  }

  public void eat() {
    LOGGER.info("The bird is eating.");
  }

  public void buildNest() {
    LOGGER.info("The bird is building a nest.");
  }
}
