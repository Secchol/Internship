package com.ontotext.javacourse.designpatterns.abstractfactory.reflectionfactory;

import com.ontotext.javacourse.designpatterns.abstractfactory.Product;

/** Defines a factory that creates a product instance by a given class name using reflection. */
public interface ReflectionFactory {
  Product createInstance(String className);
}
