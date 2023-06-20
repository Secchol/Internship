package com.ontotext.javacourse.reflection.displayclassinfo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * The ClassInfo class contains a method that takes an instance of a class and returns information
 * about the object including method signature, fields along with their type and value.
 */
public final class DisplayClassInfo {

  private DisplayClassInfo() throws IllegalAccessException {
    throw new IllegalAccessException("ClassInfo class is not meant to be instantiated");
  }

  /**
   * Takes a class instance and returns a string that contains information about the class methods
   * and fields.
   *
   * @param instance the instance to display the information of
   */
  public static String returnClassInfo(Object instance) {
    StringBuilder classInfo = new StringBuilder();
    Class<?> instanceClass = instance.getClass();
    classInfo.append(String.format("Class name: %s", instanceClass.getName()));
    classInfo.append(System.lineSeparator());

    Method[] instanceMethods = instanceClass.getDeclaredMethods();
    for (Method method : instanceMethods) {
      classInfo.append(String.format("Method: %s", method));
      classInfo.append(System.lineSeparator());
    }

    Field[] instanceFields = instanceClass.getDeclaredFields();
    for (Field field : instanceFields) {
      field.setAccessible(true);
      try {
        Object value = field.get(instance);
        classInfo.append(
            String.format("Field name: %s value: %s", field.getType().getName(), value));
        classInfo.append(System.lineSeparator());
      } catch (IllegalAccessException exception) {
        classInfo.append(exception.getMessage());
      }
    }
    return classInfo.toString();
  }
}
