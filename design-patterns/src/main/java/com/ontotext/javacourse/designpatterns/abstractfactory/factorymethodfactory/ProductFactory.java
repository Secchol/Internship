package com.ontotext.javacourse.designpatterns.abstractfactory.factorymethodfactory;

import com.ontotext.javacourse.designpatterns.abstractfactory.MyProduct;
import com.ontotext.javacourse.designpatterns.abstractfactory.Product;

/** The ProductFactory class contains a method which creates a new instance of a product. */
public class ProductFactory implements Factory {
  @Override
  public Product createInstance() {
    return new MyProduct();
  }
}
