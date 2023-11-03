package com.ontotext.javacourse.threads.synchronizedstack;

import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The SynchronizedElementsList is a collection that contains methods to add and remove elements. If
 * the list is full when add operation is executed it waits for space to free up and if the list is
 * empty when remove operation is called it waits for an element to be added.
 */
@ToString
public class SynchronizedElementsList {
  private static final Logger LOGGER = LoggerFactory.getLogger(SynchronizedElementsList.class);
  private final Object[] elements;
  private int count;

  public SynchronizedElementsList(int length) {
    elements = new Object[length];
    count = 0;
  }

  public int getCount() {
    return count;
  }

  /**
   * Adds new element to elementList. Waits for an element to be removed if the list is full.
   *
   * @param element the element to add
   */
  public synchronized void add(Object element) {
    while (getCount() == elements.length) {
      try {
        LOGGER.info("Waiting for free space.");
        wait();
      } catch (InterruptedException exception) {
        Thread.currentThread().interrupt();
      }
    }
    int currentIndex = getCount();
    elements[currentIndex] = element;
    count++;
    notifyAll();
  }

  /**
   * Removes element from elementsList. Waits for an element to be added to the list if it is empty.
   */
  public synchronized void remove() {
    while (getCount() == 0) {
      try {
        LOGGER.info("Waiting for element to be available for removal.");
        wait();
      } catch (InterruptedException exception) {
        Thread.currentThread().interrupt();
      }
    }
    int lastElementIndex = getCount() - 1;
    elements[lastElementIndex] = null;
    count--;
    notifyAll();
  }
}
