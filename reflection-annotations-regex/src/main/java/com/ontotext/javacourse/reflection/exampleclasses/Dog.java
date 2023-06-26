package com.ontotext.javacourse.reflection.exampleclasses;

import com.ontotext.javacourse.reflection.orderobjects.Order;
import org.jetbrains.annotations.NotNull;

/** The Dog class defines a dog that has a name, weight and age. */
@Order(value = 3)
public class Dog extends Animal implements Mammal, Comparable<Animal> {
  private String name;
  private int age;
  private double weight;

  public Dog(String name, int age, double weight) {
    setName(name);
    setAge(age);
    setWeight(weight);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(Double weight) {
    this.weight = weight;
  }

  @Override
  public void makeSound() {
    System.out.println("WOOOF");
  }

  /**
   * Returns information about dog.
   *
   * @return string information about the dog.
   */
  @Override
  public String toString() {
    StringBuilder dogInfo = new StringBuilder();
    dogInfo.append("Name: ");
    dogInfo.append(getName());
    dogInfo.append("Age: ");
    dogInfo.append(getAge());
    dogInfo.append("Weight: ");
    dogInfo.append(getWeight());
    return dogInfo.toString();
  }

  /**
   * Returns the dog age in dog years.
   *
   * @return the age of the dog in dog years
   */
  private int returnAgeInDogYears(int age) {
    return age * 5;
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
