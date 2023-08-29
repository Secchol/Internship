package com.ontotext.javacourse.designpatterns.singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** The Singleton class defines a class of which only a single instance can be created. */
public class Singleton {
  private static final Logger LOGGER = LoggerFactory.getLogger("Singleton");

  private static Singleton instance;

  private Singleton() {
    LOGGER.info("Singleton created.");
  }

  /**
   * Returns the instance and instantiates it if it hasn't been instantiated before.
   *
   * @return the instance
   */
  public static Singleton getInstance() {
    if (instance == null) {
      instance = new Singleton();
    }
    return instance;
  }
}
