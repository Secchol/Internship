package com.ontotext.javacourse.reflection.displayprivatefieldsandmethods;

import com.ontotext.javacourse.reflection.displayclassinfo.DisplayClassInfo;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * The DisplayDogPrivateFieldsAndCallMethods contains a method which instantiates and gets info
 * about Dog class and invokes its private methods.
 */
public final class DisplayPrivateInfo {
  private DisplayPrivateInfo() throws IllegalAccessException {
    throw new IllegalAccessException(
        "DisplayDogPrivateFieldsAndCallMethods class is not meant to be instantiated");
  }

  /**
   * Instantiates a dog class and returns a string with information about it and invokes its private
   * method.
   *
   * @return string with information about dog class.
   */
  public static String displayPrivateInfo() {
    StringBuilder info = new StringBuilder();
    try {
      Class<?> dogClass = Class.forName("com.ontotext.javacourse.reflection.exampleclasses.Dog");
      Constructor<?> dogConstructor =
          dogClass.getConstructor(String.class, int.class, double.class);
      Object dog = dogConstructor.newInstance("Donkey", 20, 120.20);
      info.append(DisplayClassInfo.returnClassInfo(dog));
      Field privateField = dogClass.getDeclaredField("age");
      privateField.setAccessible(true);
      int dogAge = Integer.parseInt(privateField.get(dog).toString());
      Method privateMethod = dogClass.getDeclaredMethod("returnAgeInDogYears", int.class);
      privateMethod.setAccessible(true);
      int privateMethodResult = Integer.parseInt(privateMethod.invoke(dog, dogAge).toString());
      info.append(String.format("Private method result is: %s", privateMethodResult));
      info.append(System.lineSeparator());
    } catch (Exception exception) {
      info.append(exception.getMessage());
      info.append(System.lineSeparator());
    }
    return info.toString();
  }
}
