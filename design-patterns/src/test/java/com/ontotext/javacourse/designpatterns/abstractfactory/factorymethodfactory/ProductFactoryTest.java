package com.ontotext.javacourse.designpatterns.abstractfactory.factorymethodfactory;

import static org.junit.jupiter.api.Assertions.*;

import com.ontotext.javacourse.designpatterns.abstractfactory.Product;
import org.junit.jupiter.api.Test;

class ProductFactoryTest {

  @Test
  void createInstanceReturnsProductInstance() {
    ProductFactory factory = new ProductFactory();
    assertTrue(factory.createInstance() instanceof Product);
  }
}
