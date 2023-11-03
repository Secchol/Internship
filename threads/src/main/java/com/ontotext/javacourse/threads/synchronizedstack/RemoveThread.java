package com.ontotext.javacourse.threads.synchronizedstack;

import lombok.AllArgsConstructor;

/**
 * The RemoveThread class defines a thread that removes the last element from elementsList when
 * executed.
 */
@AllArgsConstructor
public class RemoveThread extends Thread {
  private final SynchronizedElementsList elementsList;
  private int elementsToRemoveCount;

  @Override
  public void run() {
    for (int i = 0; i < elementsToRemoveCount; i++) {
      elementsList.remove();
    }
  }
}
