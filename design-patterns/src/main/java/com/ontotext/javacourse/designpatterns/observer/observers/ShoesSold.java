package com.ontotext.javacourse.designpatterns.observer.observers;

import lombok.Getter;

/**
 * The ShoesSold class is an observer that keeps track of the shoes sold and gets notified if a shoe
 * is sold.
 */
@Getter
public class ShoesSold implements ShoesObserver {
  private int shoesSoldCount;

  @Override
  public void update(StateChange stateChange) {
    if (stateChange == StateChange.SHOE_SOLD) {
      this.shoesSoldCount++;
    }
  }
}
