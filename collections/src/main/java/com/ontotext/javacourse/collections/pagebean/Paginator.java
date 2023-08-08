package com.ontotext.javacourse.collections.pagebean;

import java.util.*;
import java.util.function.Supplier;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The class gets a list of items and distributes it into pages. It provides methods which
 * manipulate the items.
 */
@Getter
public class Paginator<T> {

  private static final Scanner SCANNER = new Scanner(System.in);
  private static final Logger LOGGER = LoggerFactory.getLogger(Paginator.class);
  private final int pageSize;
  private final List<LinkedList<T>> list;
  private int currentPageIndex = -1;
  private final Map<String, Supplier<String>> commands =
      Map.of(
          "next()", () -> next().toString(),
          "previous()", () -> previous().toString(),
          "hasNext()", () -> Boolean.toString(hasNext()),
          "hasPrevious()", () -> Boolean.toString(hasPrevious()),
          "firstPage()", () -> firstPage().toString(),
          "lastPage()", () -> lastPage().toString(),
          "getCurrentPageNumber()", () -> String.valueOf(getCurrentPageNumber()));

  public Paginator(List<T> items, int pageSize) {
    this.pageSize = pageSize;
    this.list = new ArrayList<>();
    distributePages(items);
  }

  /**
   * Executes the next() method and starts taking input commands from the console and displays their
   * result.
   */
  public void start() {
    LOGGER.info(commands.get("next()").get());
    LOGGER.info("Enter command: ");
    String command = SCANNER.nextLine();
    while (!command.equals("end")) {
      executeCommand(command);
      LOGGER.info("Enter command: ");
      command = SCANNER.nextLine();
    }
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
    LOGGER.error("Invalid operation! There are no next items!");
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
    LOGGER.error("Invalid operation! There are no previous items!");
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

  private void executeCommand(String command) {
    if (!commands.containsKey(command)) {
      throw new IllegalArgumentException("Command is invalid!");
    }
    LOGGER.info(commands.get(command).get());
  }
}
