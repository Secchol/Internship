package com.ontotext.javacourse.threads.synchronizedstack;

import java.util.Collection;
import lombok.AllArgsConstructor;

/**
 * AddRunnable class defines a runnable that adds a list of elements to elementsList when executed.
 */
@AllArgsConstructor
public class AddRunnable implements Runnable {
  private final Collection<Object> elementsToAdd;
  private final SynchronizedElementsList elementsList;

  @Override
  public void run() {
    for (Object item : elementsToAdd) {
      elementsList.add(item);
    }
  }
}
