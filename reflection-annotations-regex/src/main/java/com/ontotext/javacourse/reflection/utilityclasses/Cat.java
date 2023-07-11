package com.ontotext.javacourse.reflection.utilityclasses;

import com.ontotext.javacourse.reflection.orderobjects.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** The Cat class defines a cat which has a name, age and breed. */
@Getter
@Setter
@AllArgsConstructor
@ToString
@Order(value = 2)
public class Cat extends Animal implements Comparable<Animal> {
  private static final Logger LOGGER = LoggerFactory.getLogger(Cat.class);
  private final String name;
  private final int age;
  private final String breed;

  public void meow() {
    LOGGER.info("Meow!");
  }

  public void sleep() {
    LOGGER.info("The cat is sleeping.");
  }

  public void eat() {
    LOGGER.info("The cat is eating.");
  }

  public void play() {
    LOGGER.info("The cat is playing.");
  }
}
