package com.ontotext.javacourse.collections.pagebean;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The class gets a list of items and distributes it into pages. It provides methods which
 * manipulate the items.
 */
public class Paginator<T> {
  private static final Logger LOGGER = LoggerFactory.getLogger(Paginator.class);
  private final int pageSize;
  private List<LinkedList<T>> list;
  private int currentPageIndex = -1;

  public Paginator(List<T> items, int pageSize) {
    this.pageSize = pageSize;
    distributePages(items);
  }

  /**
   * Returns the current page items.
   *
   * @return a list that contains the current page items
   */
  public List<T> next() {
    return list.get(++currentPageIndex).stream().toList();
  }

  /**
   * Returns the previous page items.
   *
   * @return a list that contains the previous page items.
   */
  public List<T> previous() {
    if (currentPageIndex > 0) {
      return list.get(--currentPageIndex).stream().toList();
    }
    LOGGER.info("Invalid operation! There are not any previous items!");
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
    return currentPageIndex;
  }

  private void distributePages(List<T> items) {
    list = new ArrayList<>();
    int currentIndex = 0;
    for (int i = 0; i < items.size() / pageSize; i++) {
      LinkedList<T> page = new LinkedList<>();
      for (int j = 0; j < pageSize; j++, currentIndex++) {
        page.add(items.get(currentIndex));
      }
      list.add(page);
    }

    LinkedList<T> remainingElements = new LinkedList<>();
    for (int i = currentIndex; i < items.size(); i++) {
      remainingElements.add(items.get(i));
    }
    if (remainingElements.stream().count() != 0) {
      list.add(remainingElements);
    }
  }
}
