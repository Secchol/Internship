package com.ontotext.javacourse.reflectionannotationsregex.displayclassinfo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Logger;

/**
 * The ClassInfo class contains a method that takes an instance of a class and displays information
 * about the object including method signature, fields along with their type and value.
 */
public final class DisplayClassInfo {
  private static final Logger LOGGER = Logger.getLogger(DisplayClassInfo.class.getName());

  private DisplayClassInfo() throws IllegalAccessException {
    throw new IllegalAccessException("ClassInfo class is not meant to be instantiated");
  }

  /**
   * Takes a class instance and displays information about the class methods and fields.
   *
   * @param instance the instance to display the information of
   */
  public static void displayClassInfo(Object instance) {
    Class<?> instanceClass = instance.getClass();
    LOGGER.info("Class name: " + instanceClass.getName());

    Method[] instanceMethods = instanceClass.getDeclaredMethods();
    for (Method method : instanceMethods) {
      LOGGER.info("Method: " + method.toString());
    }

    Field[] instanceFields = instanceClass.getDeclaredFields();
    for (Field field : instanceFields) {
      field.setAccessible(true);
      try {
        Object value = field.get(instance);
        LOGGER.info(
            "Field name: "
                + field.getName()
                + " "
                + field.getType().getName()
                + " value: "
                + value);
      } catch (IllegalAccessException exception) {
        LOGGER.info(exception.getMessage());
      }
    }
  }
}
