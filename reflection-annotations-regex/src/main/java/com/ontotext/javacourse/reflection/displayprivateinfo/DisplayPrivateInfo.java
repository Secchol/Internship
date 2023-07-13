package com.ontotext.javacourse.reflection.displayprivateinfo;

import com.ontotext.javacourse.reflection.displayclassinfo.DisplayClassInfo;
import com.ontotext.javacourse.reflection.instantiatebyname.InstantiateClass;
import com.ontotext.javacourse.reflection.utilityclasses.ClassInfo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The DisplayPrivateInfo contains a method which instantiates and gets info about Dog class and
 * invokes its private methods.
 */
public final class DisplayPrivateInfo {
  private static final Logger LOGGER = LoggerFactory.getLogger(DisplayPrivateInfo.class);

  private DisplayPrivateInfo() throws IllegalAccessException {
    throw new IllegalAccessException("DisplayPrivateInfo class is not meant to be instantiated");
  }

  /**
   * Instantiates a dog class and returns a classInfo object with information about its private
   * method and field values.
   *
   * @return a classInfo object
   */
  public static ClassInfo displayPrivateInfo() {
    try {
      Class<?> dogClass =
          InstantiateClass.getClass("com.ontotext.javacourse.reflection.animals.Dog");
      Object dog = InstantiateClass.createDog("Donkey", 20, 120.20);
      if (dog == null || dogClass == null) {
        throw new IllegalArgumentException("Cannot create dog!");
      }
      ClassInfo classInfo = DisplayClassInfo.returnClassInfo(dog);
      classInfo.setPrivateMethodResult(privateMethodResult(dog, dogClass));
      classInfo.setPrivateFieldResult(privateFieldResult(dog, dogClass));
      DisplayClassInfo.logClassInfo(classInfo);
      return classInfo;
    } catch (Exception exception) {
      LOGGER.error(exception.getMessage());
    }
    return null;
  }

  private static int privateMethodResult(Object dogInstance, Class<?> dogClass) {
    try {
      Method privateMethod = dogClass.getDeclaredMethod("returnAgeInDogYears", int.class);
      privateMethod.setAccessible(true);
      int dogAge = privateFieldResult(dogInstance, dogClass);
      return Integer.parseInt(privateMethod.invoke(dogInstance, dogAge).toString());
    } catch (Exception exception) {
      LOGGER.error(exception.getMessage());
    }
    return -1;
  }

  private static int privateFieldResult(Object dogInstance, Class<?> dogClass) {
    try {
      Field privateField = dogClass.getDeclaredField("age");
      privateField.setAccessible(true);
      return Integer.parseInt(privateField.get(dogInstance).toString());
    } catch (Exception exception) {
      LOGGER.error(exception.getMessage());
    }
    return -1;
  }
}
