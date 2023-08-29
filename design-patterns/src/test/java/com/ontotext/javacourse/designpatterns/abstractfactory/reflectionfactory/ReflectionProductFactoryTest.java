package com.ontotext.javacourse.designpatterns.abstractfactory.reflectionfactory;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReflectionProductFactoryTest {

  @Test
  void createInstanceReturnsProductInstance() {
    ReflectionProductFactory factory = new ReflectionProductFactory();
    assertNotNull(
        factory.createInstance("com.ontotext.javacourse.designpatterns.abstractfactory.MyProduct"));
  }
}
