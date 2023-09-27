package com.ontotext.javacourse.designpatterns.abstractfactory.reflectionfactories;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * The ClassInstantiator class contains a method that creates instances of classes using their class
 * name.
 */
public final class ClassInstantiator {
  private ClassInstantiator() throws IllegalAccessException {
    throw new IllegalAccessException("ClassInstantiator class is not meant to be instantiated!");
  }

  /**
   * Instantiates a class by a given class name.
   *
   * @param className the class name of the class to instantiate
   * @return the instance of the class
   * @throws ClassNotFoundException if the class is not found
   * @throws InstantiationException if the class cannot be instantiated
   * @throws IllegalAccessException if the constructor is not accessible
   * @throws NoSuchMethodException if the class does not have a base constructor
   * @throws InvocationTargetException if exception from the constructor is thrown
   */
  public static Object createInstance(String className)
      throws ClassNotFoundException,
          InstantiationException,
          IllegalAccessException,
          NoSuchMethodException,
          InvocationTargetException {
    Class<?> clazz = Class.forName(className);
    Constructor<?> constructor = clazz.getDeclaredConstructor();
    return constructor.newInstance();
  }
}
