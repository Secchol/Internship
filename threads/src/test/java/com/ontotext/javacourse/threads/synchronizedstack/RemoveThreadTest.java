package com.ontotext.javacourse.threads.synchronizedstack;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RemoveThreadTest {
  private SynchronizedElementsList elementsList;

  @BeforeEach
  void setUp() {
    elementsList = new SynchronizedElementsList(5);
  }

  @Test
  void removeThreadRemovesElementsFromList() {
    for (int i = 0; i < 5; i++) {
      elementsList.add(i);
    }
    RemoveThread removeThread = new RemoveThread(elementsList, 4);
    removeThread.start();
    try {
      sleep(10);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    assertEquals(1, elementsList.getCount());
  }

  @Test
  void removeThreadWaitsForElementToBeAddedIfListIsEmpty() {
    elementsList.add(1);
    RemoveThread removeThread = new RemoveThread(elementsList, 3);
    removeThread.start();
    try {
      sleep(10);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    AddThread addThread = new AddThread(List.of(3, 4, 5), elementsList);
    addThread.start();
    try {
      sleep(10);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    assertEquals(1, elementsList.getCount());
  }
}
