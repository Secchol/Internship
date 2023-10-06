package com.ontotext.javacourse.designpatterns.observer.observers;

import lombok.Getter;

/**
 * The ShoesAvailable class is an observer that keeps track of the available shoes and gets notified
 * if a new shoe is added or if a shoe is sold.
 */
@Getter
public class ShoesAvailable implements ShoesObserver {
  private int shoesAvailableCount;

  @Override
  public void update(StateChange stateChange) {
    if (stateChange == StateChange.SHOE_ADDED) {
      this.shoesAvailableCount++;
    } else if (stateChange == StateChange.SHOE_SOLD) {
      this.shoesAvailableCount--;
    }
  }
}
