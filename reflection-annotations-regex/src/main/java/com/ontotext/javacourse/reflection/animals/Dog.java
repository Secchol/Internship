package com.ontotext.javacourse.reflection.animals;

import com.ontotext.javacourse.reflection.orderobjects.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** The Dog class defines a dog that has a name, weight and age. */
@Getter
@Setter
@AllArgsConstructor
@ToString
@Order(value = 3)
public class Dog extends Animal implements Mammal, Comparable<Animal> {
  private static final Logger LOGGER = LoggerFactory.getLogger(Dog.class);
  private String name;
  private int age;
  private double weight;

  @Override
  public void makeSound() {
    LOGGER.info("WOOOF");
  }

  private int returnAgeInDogYears(int age) {
    return age * 5;
  }
}
