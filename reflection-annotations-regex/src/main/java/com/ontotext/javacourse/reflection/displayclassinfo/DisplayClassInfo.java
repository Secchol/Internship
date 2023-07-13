package com.ontotext.javacourse.reflection.displayclassinfo;

import com.ontotext.javacourse.reflection.utilityclasses.ClassInfo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The ClassInfo class contains a method that takes an instance of a class and returns information
 * about the object including method signature, fields along with their type and value.
 */
public final class DisplayClassInfo {

  private static final Logger LOGGER = LoggerFactory.getLogger(DisplayClassInfo.class);

  private DisplayClassInfo() throws IllegalAccessException {
    throw new IllegalAccessException("ClassInfo class is not meant to be instantiated");
  }

  /**
   * Returns a ClassInfo object that contains information about a class's methods and fields.
   *
   * @param instance the instance to display the information of
   */
  public static ClassInfo returnClassInfo(Object instance) {
    Class<?> instanceClass = instance.getClass();
    String className = getInstanceClassName(instanceClass);
    Method[] methods = getInstanceMethods(instanceClass);
    Field[] fields = getInstanceFields(instanceClass);
    return new ClassInfo(className, fields, methods, null, null, -1, -1);
  }

  /**
   * Returns a ClassInfo object that contains information about a class's methods and fields and
   * logs it.
   *
   * @param instance the instance to display the information of
   * @return the classInfo object
   */
  public static ClassInfo returnAndLogClassInfo(Object instance) {
    ClassInfo classInfo = returnClassInfo(instance);
    logClassInfo(classInfo);
    return classInfo;
  }
  /**
   * Logs all the information about a given classInfo object.
   *
   * @param classInfo the object to display the information of
   */
  
  public static void logClassInfo(ClassInfo classInfo) {
    LOGGER.info(classInfo.toString().replace(", ", "\n"));
  }

  private static String getInstanceClassName(Class<?> instanceClass) {
    return instanceClass.getName();
  }

  private static Method[] getInstanceMethods(Class<?> instanceClass) {
    return instanceClass.getDeclaredMethods();
  }

  private static Field[] getInstanceFields(Class<?> instanceClass) {
    return instanceClass.getDeclaredFields();
  }
}
