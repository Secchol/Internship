package com.ontotext.javacourse.threads.synchronizedstack;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AddThreadTest {
  private SynchronizedElementsList elementsList;

  @BeforeEach
  void setUp() {
    elementsList = new SynchronizedElementsList(5);
  }

  @Test
  void addThreadAddsElementsToList() {
    AddThread addThread = new AddThread(List.of(1, 2, 3), elementsList);
    addThread.start();
    try {
      sleep(10);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    assertEquals(3, elementsList.getCount());
  }

  @Test
  void addThreadWaitsForFreeSpaceIfListIsFull() {
    AddThread addThread = new AddThread(List.of(1, 2, 3, 4, 5, 6), elementsList);
    addThread.start();
    try {
      sleep(10);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    RemoveThread removeThread = new RemoveThread(elementsList, 1);
    removeThread.start();
    try {
      sleep(10);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    assertEquals(5, elementsList.getCount());
  }
}
