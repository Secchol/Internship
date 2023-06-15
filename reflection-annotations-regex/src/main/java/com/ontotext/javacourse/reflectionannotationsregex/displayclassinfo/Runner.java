package com.ontotext.javacourse.reflectionannotationsregex.displayclassinfo;

import com.ontotext.javacourse.reflectionannotationsregex.displayprivatefieldsandmethods.DisplayDogPrivateFieldsAndCallMethods;
import com.ontotext.javacourse.reflectionannotationsregex.exampleclasses.Dog;
import com.ontotext.javacourse.reflectionannotationsregex.instantiatebyname.InstantiateDog;
import java.util.logging.Logger;

public class Runner {
  private static final Logger LOGGER = Logger.getLogger(DisplayClassInfo.class.getName());

  public static void main(String[] args) {
    Dog dog = new Dog("Murdzhu", 20, 100);
    DisplayClassInfo.displayClassInfo(dog);
    //    String name = dog.getClass().getName();
    //    System.out.println(name);
    //    try {
    //      Class<?> classObj = Class.forName(name);
    //      Constructor<?> constructor = classObj.getDeclaredConstructor();
    //      Object instance = constructor.newInstance("Nada", 22, 232);
    //      Class<?> parent = classObj.getSuperclass();
    //      LOGGER.info("Parent: " + parent.getName());
    //      Class<?>[] interfaces = classObj.getInterfaces();
    //      for (Class<?> item : interfaces) {
    //        LOGGER.info(item.getName());
    //      }
    //
    //    } catch (ClassNotFoundException exception) {
    //      LOGGER.info("Class not found " + name);
    //    } catch (Exception exception) {
    //      LOGGER.info(exception.getMessage());
    //    }
    InstantiateDog.instantiateDogClassByName();
    DisplayDogPrivateFieldsAndCallMethods.displayPrivateFieldsAndCallPrivateMethods();
  }
}
