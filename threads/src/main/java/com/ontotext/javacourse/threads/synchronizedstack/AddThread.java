package com.ontotext.javacourse.threads.synchronizedstack;

import java.util.Collection;
import lombok.AllArgsConstructor;

/** AddThread class defines a thread that adds a given element to elementsList when executed. */
@AllArgsConstructor
public class AddThread extends Thread {
  private final Collection<Object> elementsToAdd;
  private final SynchronizedElementsList elementsList;

  @Override
  public void run() {
    for (Object item : elementsToAdd) {
      elementsList.add(item);
    }
  }
}
