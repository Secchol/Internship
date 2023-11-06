package com.ontotext.javacourse.threads.synchronizedstack;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.awaitility.Awaitility;
import org.junit.jupiter.api.Test;

class AddThreadTest {
  private SynchronizedElementsList elementsList;
  private Thread addThread;

  void setUp(Collection<Object> addElements) {
    elementsList = new SynchronizedElementsList(5);
    AddRunnable addRunnable = new AddRunnable(addElements, elementsList);
    addThread = new Thread(addRunnable);
  }

  @Test
  void addThreadAddsElementsToList() {
    setUp(List.of(1, 2, 3));
    addThread.start();
    Awaitility.await()
        .atMost(20, TimeUnit.MILLISECONDS)
        .pollInterval(5, TimeUnit.MILLISECONDS)
        .until(() -> elementsList.getCount() == 3);
    assertEquals(3, elementsList.getCount());
  }

  @Test
  void addThreadWaitsForFreeSpaceIfListIsFull() {
    setUp(List.of(1, 2, 3, 4, 5, 6));
    addThread.start();
    Awaitility.await()
        .atMost(20, TimeUnit.MILLISECONDS)
        .pollInterval(5, TimeUnit.MILLISECONDS)
        .until(() -> elementsList.getCount() == 5);
    RemoveRunnable removeRunnable = new RemoveRunnable(elementsList, 1);
    Thread removeThread = new Thread(removeRunnable);
    removeThread.start();
    Awaitility.await()
        .atMost(20, TimeUnit.MILLISECONDS)
        .pollInterval(5, TimeUnit.MILLISECONDS)
        .until(() -> elementsList.getCount() == 5);
    assertEquals(5, elementsList.getCount());
  }
}
