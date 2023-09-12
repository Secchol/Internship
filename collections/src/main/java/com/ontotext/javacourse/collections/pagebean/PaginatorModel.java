package com.ontotext.javacourse.collections.pagebean;

import java.util.*;
import lombok.Getter;

/**
 * The class gets a list of items and distributes it into pages. It provides methods which
 * manipulate the items.
 */
@Getter
public class PaginatorModel<T> {
  private final int pageSize;
  private final List<List<T>> list;
  private int currentPageIndex = -1;

  /**
   * Sets the page size and distributes the given list items into pages.
   *
   * @param items the list to distribute into pages
   * @param pageSize the size of the page
   */
  public PaginatorModel(List<T> items, int pageSize) {
    this.pageSize = pageSize;
    this.list = new ArrayList<>();
    distributePages(items);
  }

  /**
   * Returns the current page items.
   *
   * @return a list that contains the current page items
   */
  public List<T> next() {
    if (hasNext()) {
      return list.get(++currentPageIndex).stream().toList();
    }
    return new ArrayList<>();
  }

  /**
   * Returns the previous page items.
   *
   * @return a list that contains the previous page items.
   */
  public List<T> previous() {
    if (hasPrevious()) {
      return list.get(--currentPageIndex).stream().toList();
    }
    return new ArrayList<>();
  }

  /**
   * Returns whether there is a next page.
   *
   * @return a bool that indicates whether there is a next page
   */
  public boolean hasNext() {
    return currentPageIndex + 1 < list.size();
  }

  /**
   * Returns whether there is a previous page.
   *
   * @return a bool that indicates whether there is a previous page
   */
  public boolean hasPrevious() {
    return currentPageIndex - 1 >= 0;
  }

  /**
   * Returns the first page and makes it the current one.
   *
   * @return the first page
   */
  public List<T> firstPage() {
    currentPageIndex = 0;
    return list.get(currentPageIndex);
  }

  /**
   * Returns the last page and makes it the current one.
   *
   * @return the last page
   */
  public List<T> lastPage() {
    currentPageIndex = list.size() - 1;
    return list.get(currentPageIndex);
  }

  /**
   * Returns the current page number.
   *
   * @return the current page number
   */
  public int getCurrentPageNumber() {
    return currentPageIndex + 1;
  }

  private void distributePages(List<T> items) {
    int currentIndex = 0;
    for (int i = 0; i < items.size() / pageSize; i++) {
      List<T> page = new LinkedList<>();
      for (int j = 0; j < pageSize; j++, currentIndex++) {
        page.add(items.get(currentIndex));
      }
      list.add(page);
    }
    List<T> remainingElements = new LinkedList<>();
    for (int i = currentIndex; i < items.size(); i++) {
      remainingElements.add(items.get(i));
    }
    if (remainingElements.stream().count() != 0) {
      list.add(remainingElements);
    }
  }
}
