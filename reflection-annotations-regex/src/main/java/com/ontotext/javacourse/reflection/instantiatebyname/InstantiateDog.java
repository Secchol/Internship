package com.ontotext.javacourse.reflection.instantiatebyname;

/**
 * The class InstantiateDog class contains a instantiateDogClassByName method which instantiates a
 * class by its name and returns a string that contains information about its parent and implemented
 * interfaces.
 */
public final class InstantiateDog {

  private InstantiateDog() throws IllegalAccessException {
    throw new IllegalAccessException("InstantiateDog class is not meant to be instantiated");
  }

  /**
   * instantiates a class by its name and returns a string that contains information about its
   * parent and implemented interfaces.
   */
  public static String instantiateDogClassByName() {
    StringBuilder dogInfo = new StringBuilder();
    try {
      Class<?> dogClass = Class.forName("com.ontotext.javacourse.reflection.exampleclasses.Dog");
      Class<?> parentClass = dogClass.getSuperclass();
      dogInfo.append(String.format("Parent class: %s", parentClass.getName()));
      dogInfo.append(System.lineSeparator());
      Class<?>[] interfaces = dogClass.getInterfaces();
      dogInfo.append("Interfaces:");
      dogInfo.append(System.lineSeparator());
      for (Class<?> item : interfaces) {
        dogInfo.append(item.getName());
        dogInfo.append(System.lineSeparator());
      }
    } catch (Exception ex) {
      dogInfo.append(ex.getMessage());
    }
    return dogInfo.toString();
  }
}
