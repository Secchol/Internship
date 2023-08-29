package com.ontotext.javacourse.collections.pagebean;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PaginatorModelTest {

  private PaginatorModel<String> paginatorModel;

  @BeforeEach
  public void setUp() {
    List<String> testData = new ArrayList<>();
    for (int i = 1; i <= 16; i++) {
      testData.add("Item " + i);
    }
    paginatorModel = new PaginatorModel<>(testData, 5);
  }

  @Test
  void nextReturnsNextPageIfThereAreNextItems() {
    ArrayList<String> page = new ArrayList<>();
    page.add("Item 1");
    page.add("Item 2");
    page.add("Item 3");
    page.add("Item 4");
    page.add("Item 5");
    assertEquals(page, paginatorModel.next());
  }

  @Test
  void nextWorksIfPageHasLessElementsThanPageSize() {
    ArrayList<String> page = new ArrayList<>();
    page.add("Item 16");
    for (int i = 0; i < 3; i++) {
      paginatorModel.next();
    }
    assertEquals(page, paginatorModel.next());
  }

  @Test
  void nextReturnsEmptyListIfThereAreNoNextElements() {
    for (int i = 0; i < 4; i++) {
      paginatorModel.next();
    }
    assertEquals(0, paginatorModel.next().size());
  }

  @Test
  void previousReturnsPreviousPage() {
    paginatorModel.next();
    paginatorModel.next();
    ArrayList<String> list = new ArrayList<>();
    list.add("Item 1");
    list.add("Item 2");
    list.add("Item 3");
    list.add("Item 4");
    list.add("Item 5");
    assertEquals(list, paginatorModel.previous());
  }

  @Test
  void previousReturnsEmptyListIfThereIsNoPreviousPage() {
    assertEquals(0, paginatorModel.previous().size());
  }

  @Test
  void hasNextReturnsTrueIfHasNextPage() {
    assertTrue(paginatorModel.hasNext());
  }

  @Test
  void hasNextReturnsFalseIfNoNextPage() {
    for (int i = 0; i < 4; i++) {
      paginatorModel.next();
    }
    assertFalse(paginatorModel.hasNext());
  }

  @Test
  void hasPreviousReturnsTrueIfThereIsPreviousPage() {
    paginatorModel.next();
    paginatorModel.next();
    assertTrue(paginatorModel.hasPrevious());
  }

  @Test
  void hasPreviousReturnsFalseIfThereIsNoPreviousPage() {
    paginatorModel.next();
    assertFalse(paginatorModel.hasPrevious());
  }

  @Test
  void firstPageReturnsFirstPageAndMakesItCurrent() {
    paginatorModel.next();
    paginatorModel.next();
    ArrayList<String> list = new ArrayList<>();
    list.add("Item 1");
    list.add("Item 2");
    list.add("Item 3");
    list.add("Item 4");
    list.add("Item 5");
    assertEquals(list, paginatorModel.firstPage());
    assertEquals(1, paginatorModel.getCurrentPageNumber());
  }

  @Test
  void lastPageReturnsLastPageAndMakesItCurrent() {
    paginatorModel.next();
    ArrayList<String> list = new ArrayList<>();
    list.add("Item 16");
    assertEquals(list, paginatorModel.lastPage());
    assertEquals(4, paginatorModel.getCurrentPageNumber());
  }

  @Test
  void getCurrentPageNumberReturnsCorrectPageNumber() {
    paginatorModel.next();
    paginatorModel.next();
    assertEquals(2, paginatorModel.getCurrentPageNumber());
  }
}
