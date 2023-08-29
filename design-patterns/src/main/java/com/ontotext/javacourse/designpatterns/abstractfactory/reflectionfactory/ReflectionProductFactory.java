package com.ontotext.javacourse.designpatterns.abstractfactory.reflectionfactory;

import com.ontotext.javacourse.designpatterns.abstractfactory.Product;
import java.lang.reflect.Constructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The ReflectionProductFactory contains is a Reflection factory that creates a product instance by
 * a given class name.
 */
public class ReflectionProductFactory implements ReflectionFactory {
  private static final Logger LOGGER = LoggerFactory.getLogger("ReflectionProductFactory");

  @Override
  public Product createInstance(String className) {
    try {
      Class<?> productClass = Class.forName(className);
      Constructor<?> constructor = productClass.getConstructor();
      return (Product) constructor.newInstance();
    } catch (Exception ex) {
      LOGGER.error(ex.getMessage());
    }
    return null;
  }
}
