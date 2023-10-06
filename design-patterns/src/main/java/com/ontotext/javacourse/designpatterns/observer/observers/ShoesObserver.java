package com.ontotext.javacourse.designpatterns.observer.observers;

/** Defines an observer that gets notified if a shoe is sold or if a new shoe is added. */
public interface ShoesObserver {
  void update(StateChange stateChange);
}
