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

  private InstantiateClass() throws IllegalAccessException {
    throw new IllegalAccessException("InstantiateClass class is not meant to be instantiated");
  }

  /**
   * Instantiates a dog class and returns a classInfo object that contains information about its
   * parent class and interfaces.
   *
   * @return a classInfo object
   */
  public static ClassInfo instantiateClassByName() {
    try {
      Object dog = createDog("Donkey", 20, 120.20);
      Class<?> dogClass = getClass("com.ontotext.javacourse.reflection.animals.Dog");
      if (dog == null || dogClass == null) {
        throw new IllegalArgumentException("Cannot create dog!");
      }
      ClassInfo classInfo = DisplayClassInfo.returnClassInfo(dog);
      classInfo.setParentClass(getParentClass(dogClass));
      classInfo.setInterfaces(getClassInterfaces(dogClass));
      DisplayClassInfo.logClassInfo(classInfo);
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

  /**
   * Creates a dog class by a given name,age and weight.
   *
   * @param name the dog's name
   * @param age the dog's age
   * @param weight the dog's weight
   * @return the dog object
   */
  public static Object createDog(String name, int age, double weight) {
    try {
      Class<?> dogClass = getClass("com.ontotext.javacourse.reflection.animals.Dog");
      Constructor<?> dogConstructor =
          dogClass.getConstructor(String.class, int.class, double.class);
      return dogConstructor.newInstance(name, age, weight);
    } catch (Exception exception) {
      LOGGER.error(exception.getMessage());
    }
    return null;
  }

  /**
   * Creates a class by its name.
   *
   * @param name the name of the class
   * @return the class
   */
  public static Class<?> getClass(String name) {
    try {
      return Class.forName(name);
    } catch (Exception exception) {
      LOGGER.error(exception.getMessage());
    }
    return null;
  }
}
