package com.ontotext.javacourse.designpatterns.abstractfactory.factorymethodfactory;

import com.ontotext.javacourse.designpatterns.abstractfactory.Product;

/** Defines a factory which creates a product instance. */
public interface Factory {
  Product createInstance();
}
