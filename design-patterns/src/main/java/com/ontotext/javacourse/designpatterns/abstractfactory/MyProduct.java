package com.ontotext.javacourse.designpatterns.abstractfactory;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/** The MyProduct class defines a product which has a specific price. */
@NoArgsConstructor
@AllArgsConstructor
public class MyProduct implements Product {
  private double price;

  @Override
  public double getPrice() {
    return this.price;
  }
}
