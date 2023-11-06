package com.ontotext.javacourse.threads.synchronizedstack;

import lombok.AllArgsConstructor;

/**
 * The RemoveRunnable class defines a runnable that removes the last element from elementsList a
 * given amount of times when executed.
 */
@AllArgsConstructor
public class RemoveRunnable implements Runnable {
  private final SynchronizedElementsList elementsList;
  private int elementsToRemoveCount;

  @Override
  public void run() {
    for (int i = 0; i < elementsToRemoveCount; i++) {
      elementsList.remove();
    }
  }
}
