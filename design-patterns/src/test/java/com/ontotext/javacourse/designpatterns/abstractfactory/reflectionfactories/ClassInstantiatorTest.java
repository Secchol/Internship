package com.ontotext.javacourse.designpatterns.abstractfactory.reflectionfactories;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.Test;

class ClassInstantiatorTest {

  @Test
  void createInstanceCorrectlyCreatesClass()
      throws ClassNotFoundException,
          InvocationTargetException,
          InstantiationException,
          IllegalAccessException,
          NoSuchMethodException {

    assertInstanceOf(
        GeographyReflectionFactory.class,
        ClassInstantiator.createInstance(
            "com.ontotext.javacourse.design-patterns.abstractfactory.reflectionfactories.GeographyReflectionFactory"));
  }

  @Test
  void createInstanceThrowsExceptionIfClassIsNotFound() {
    assertThrows(
        ClassNotFoundException.class, () -> ClassInstantiator.createInstance("incorrect.Name"));
  }
}
