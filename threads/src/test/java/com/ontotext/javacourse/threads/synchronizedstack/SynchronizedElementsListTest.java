package com.ontotext.javacourse.threads.synchronizedstack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SynchronizedElementsListTest {

  private SynchronizedElementsList elementsList;

  @BeforeEach
  void setUp() {
    elementsList = new SynchronizedElementsList(5);
  }

  @Test
  void addAddsElementsToList() {
    for (int i = 0; i < 5; i++) {
      elementsList.add(i);
    }
    assertEquals(5, elementsList.getCount());
  }

  @Test
  void removeDeletesElementsFromList() {
    for (int i = 0; i < 5; i++) {
      elementsList.add(i);
    }
    for (int i = 0; i < 4; i++) {
      elementsList.remove();
    }
    assertEquals(1, elementsList.getCount());
  }
}
