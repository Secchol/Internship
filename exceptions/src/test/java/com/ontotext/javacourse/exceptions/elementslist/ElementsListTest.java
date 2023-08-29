package com.ontotext.javacourse.exceptions.elementslist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.ontotext.javacourse.exceptions.elementslist.exceptions.ListIsEmptyException;
import com.ontotext.javacourse.exceptions.elementslist.exceptions.ListIsFullException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ElementsListTest {

  private ElementsList list;

  @BeforeEach
  void setUp() {
    list = new ElementsList(5);
  }

  @Test
  void listIsEmptyOnCreation() {
    assertEquals(0, list.getCount());
  }

  @Test
  void addMethodIncreasesCount() {
    int item = 5;
    list.add(item);
    assertEquals(1, list.getCount());
  }

  @Test
  void addMethodThrowsExceptionIfListIsFull() {
    int item1 = 5;
    int item2 = 90;
    int item3 = 24;
    int item4 = 1;
    int item5 = -20;
    list.add(item1);
    list.add(item2);
    list.add(item3);
    list.add(item4);
    list.add(item5);
    int item6 = 30;
    assertThrows(ListIsFullException.class, () -> list.add(item6));
  }

  @Test
  void removeMethodDecreasesCount() {
    int item1 = 5;
    int item2 = 10;
    list.add(item1);
    list.add(item2);
    list.remove();
    list.remove();
    assertEquals(0, list.getCount());
  }

  @Test
  void removeMethodThrowsExceptionIfListIsEmpty() {
    assertThrows(ListIsEmptyException.class, () -> list.remove());
  }

  @Test
  void toStringMethodReturnsCorrectOutput() {
    int item1 = 5;
    int item2 = 10;
    int item3 = 15;
    list.add(item1);
    list.add(item2);
    list.add(item3);
    assertEquals("5 10 15", list.toString());
  }
}
