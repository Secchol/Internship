package com.ontotext.javacourse.designpatterns.observer;

import com.ontotext.javacourse.designpatterns.observer.observers.ShoesObserver;

/** Defines a shoe store subject which can have observers attached to it. */
public interface ShoeShopSubject {
  void addObserver(ShoesObserver observer);

  void removeObserver(ShoesObserver observer);
}
