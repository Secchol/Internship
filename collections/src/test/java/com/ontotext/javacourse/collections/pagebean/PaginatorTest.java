package com.ontotext.javacourse.collections.pagebean;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PaginatorTest {

  private Paginator<String> paginator;

  @BeforeEach
  public void setUp() {
    List<String> testData = new ArrayList<>();
    for (int i = 1; i <= 16; i++) {
      testData.add("Item " + i);
    }
    paginator = new Paginator<>(testData, 5);
  }

  @Test
  void nextReturnsNextPageIfThereAreNextItems() {
    ArrayList<String> page = new ArrayList<>();
    page.add("Item 1");
    page.add("Item 2");
    page.add("Item 3");
    page.add("Item 4");
    page.add("Item 5");
    assertEquals(page, paginator.next());
  }

  @Test
  void nextWorksIfPageHasLessElementsThanPageSize() {
    ArrayList<String> page = new ArrayList<>();
    page.add("Item 16");
    for (int i = 0; i < 3; i++) {
      paginator.next();
    }
    assertEquals(page, paginator.next());
  }

  @Test
  void nextReturnsEmptyListIfThereAreNoNextElements() {
    for (int i = 0; i < 4; i++) {
      paginator.next();
    }
    assertEquals(0, paginator.next().size());
  }

  @Test
  void previousReturnsPreviousPage() {
    paginator.next();
    paginator.next();
    ArrayList<String> list = new ArrayList<>();
    list.add("Item 1");
    list.add("Item 2");
    list.add("Item 3");
    list.add("Item 4");
    list.add("Item 5");
    assertEquals(list, paginator.previous());
  }

  @Test
  void previousReturnsEmptyListIfThereIsNotAPreviousPage() {
    assertEquals(0, paginator.previous().size());
  }

  @Test
  void hasNextReturnsTrueIfHasNextPage() {
    assertTrue(paginator.hasNext());
  }

  @Test
  void hasNextReturnsFalseIfNoNextPage() {
    for (int i = 0; i < 4; i++) {
      paginator.next();
    }
    assertFalse(paginator.hasNext());
  }

  @Test
  void hasPreviousReturnsTrueIfThereIsPreviousPage() {
    paginator.next();
    paginator.next();
    assertTrue(paginator.hasPrevious());
  }

  @Test
  void hasPreviousReturnsFalseIfThereIsNoPreviousPage() {
    paginator.next();
    assertFalse(paginator.hasPrevious());
  }

  @Test
  void firstPageReturnsFirstPageAndMakesItCurrent() {
    paginator.next();
    paginator.next();
    ArrayList<String> list = new ArrayList<>();
    list.add("Item 1");
    list.add("Item 2");
    list.add("Item 3");
    list.add("Item 4");
    list.add("Item 5");
    assertEquals(list, paginator.firstPage());
    assertEquals(1, paginator.getCurrentPageNumber());
  }

  @Test
  void lastPageReturnsLastPageAndMakesItCurrent() {
    paginator.next();
    ArrayList<String> list = new ArrayList<>();
    list.add("Item 16");
    assertEquals(list, paginator.lastPage());
    assertEquals(4, paginator.getCurrentPageNumber());
  }

  @Test
  void getCurrentPageNumberReturnsCorrectPageNumber() {
    paginator.next();
    paginator.next();
    assertEquals(2, paginator.getCurrentPageNumber());
  }
}
