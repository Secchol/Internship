package com.ontotext.javacourse.reflectionannotationsregex.instantiatebyname;

import java.util.logging.Logger;

/**
 * The class InstantiateDog class contains a instantiateDogClassByName method which instantiates a
 * class by its name and displays its parent and implemented interfaces.
 */
public final class InstantiateDog {

  private static final Logger LOGGER = Logger.getLogger(InstantiateDog.class.getName());

  private InstantiateDog() throws IllegalAccessException {
    throw new IllegalAccessException("InstantiateDog class is not meant to be instantiated");
  }

  /** instantiates a class by its name and displays its parent and implemented interfaces. */
  public static void instantiateDogClassByName() {
    try {
      Class<?> dogClass =
          Class.forName("com.ontotext.javacourse.reflectionannotationsregex.exampleclasses.Dog");
      Class<?> parentClass = dogClass.getSuperclass();
      LOGGER.info("Parent class: " + parentClass.getName());
      Class<?>[] interfaces = dogClass.getInterfaces();
      LOGGER.info("Interfaces:");
      for (Class<?> item : interfaces) {
        LOGGER.info(item.getName());
      }
    } catch (Exception ex) {
      LOGGER.info(ex.getMessage());
    }
  }
}
