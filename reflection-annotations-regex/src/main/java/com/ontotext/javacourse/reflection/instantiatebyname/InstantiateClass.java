package com.ontotext.javacourse.reflection.instantiatebyname;

import com.ontotext.javacourse.reflection.displayclassinfo.DisplayClassInfo;
import com.ontotext.javacourse.reflection.utilityclasses.ClassInfo;
import java.lang.reflect.Constructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The class InstantiateDog class contains a instantiateDogClassByName method which instantiates a
 * dog class and returns a string that contains information about its parent and implemented
 * interfaces.
 */
public final class InstantiateClass {

  private static final Logger LOGGER = LoggerFactory.getLogger(InstantiateClass.class);

  /**
   * Instantiates a dog class and returns a classInfo object that contains information about its
   * parent class and interfaces.
   *
   * @return a classInfo object
   */
  public static ClassInfo instantiateClassByName() {
    try {
      Class<?> dogClass = Class.forName("com.ontotext.javacourse.reflection.utilityclasses.Dog");
      Constructor<?> dogConstructor =
          dogClass.getConstructor(String.class, int.class, double.class);
      Object dog = dogConstructor.newInstance("Donkey", 20, 120.20);
      ClassInfo classInfo = DisplayClassInfo.returnClassInfo(dog);
      classInfo.setParentClass(getParentClass(dogClass));
      classInfo.setInterfaces(getClassInterfaces(dogClass));
      DisplayClassInfo.logClassInfo(classInfo, dog);
      return classInfo;
    } catch (Exception exception) {
      LOGGER.error(exception.getMessage());
      return null;
    }
  }

  private static Class<?> getParentClass(Class<?> dogClass) {
    return dogClass.getSuperclass();
  }

  private static Class<?>[] getClassInterfaces(Class<?> dogClass) {
    return dogClass.getInterfaces();
  }
}
