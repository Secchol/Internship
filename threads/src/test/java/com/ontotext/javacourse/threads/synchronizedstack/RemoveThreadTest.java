package com.ontotext.javacourse.threads.synchronizedstack;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.Test;

class RemoveThreadTest {
  private SynchronizedElementsList elementsList;
  private Thread removeThread;

  void setUp(int elementsToRemove) {
    elementsList = new SynchronizedElementsList(5);
    RemoveRunnable removeRunnable = new RemoveRunnable(elementsList, elementsToRemove);
    removeThread = new Thread(removeRunnable);
  }

  @Test
  void removeThreadRemovesElementsFromList() {
    setUp(4);
    for (int i = 0; i < 5; i++) {
      elementsList.add(i);
    }
    removeThread.start();
    Awaitility.await()
        .atMost(20, TimeUnit.MILLISECONDS)
        .pollInterval(5, TimeUnit.MILLISECONDS)
        .until(() -> elementsList.getCount() == 1);
    assertEquals(1, elementsList.getCount());
  }

  @Test
  void removeThreadWaitsForElementToBeAddedIfListIsEmpty() {
    setUp(3);
    elementsList.add(1);
    removeThread.start();
    Awaitility.await()
        .atMost(20, TimeUnit.MILLISECONDS)
        .pollInterval(5, TimeUnit.MILLISECONDS)
        .until(() -> elementsList.getCount() == 0);
    AddRunnable addRunnable = new AddRunnable(List.of(3, 4, 5), elementsList);
    Thread addThread = new Thread(addRunnable);
    addThread.start();
    Awaitility.await()
        .atMost(20, TimeUnit.MILLISECONDS)
        .pollInterval(5, TimeUnit.MILLISECONDS)
        .until(() -> elementsList.getCount() == 1);
    assertEquals(1, elementsList.getCount());
  }
}
