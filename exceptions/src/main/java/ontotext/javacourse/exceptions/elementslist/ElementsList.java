package ontotext.javacourse.exceptions.elementslist;

import ontotext.javacourse.exceptions.elementslist.exceptions.ListIsEmptyException;
import ontotext.javacourse.exceptions.elementslist.exceptions.ListIsFullException;

/**
 * The ElementsList class defines a collection of items. The length of the list is fixed and cannot
 * be changed. It provides methods for adding and removing elements and returning a string
 * representation of the elements.
 */
public class ElementsList {

  private final Object[] elements;
  private int count;

  public ElementsList(int length) {
    elements = new Object[length];
    count = 0;
  }

  public int getCount() {
    return this.count;
  }

  /**
   * Adds new element to elementList.
   *
   * @param element the element to add
   * @throws ListIsFullException if the elementsList is full
   */
  public void add(Object element) {
    if (elements.length == getCount()) {
      throw new ListIsFullException("List is full.");
    }
    int currentIndex = getCount();
    elements[currentIndex] = element;
    count++;
  }

  /**
   * Removes element from elementsList.
   *
   * @throws ListIsEmptyException if the list is empty
   */
  public void remove() {
    if (getCount() == 0) {
      throw new ListIsEmptyException("List is empty.");
    }
    int lastElementIndex = getCount() - 1;
    elements[lastElementIndex] = null;
    count--;
  }

  /**
   * Returns string representation of elementsList elements separated by " ".
   *
   * @return the string representation of elementsList
   */
  @Override
  public String toString() {
    StringBuilder listElements = new StringBuilder();
    for (int i = 0; i < getCount(); i++) {
      listElements.append(elements[i]);
      listElements.append(" ");
    }
    return listElements.toString().trim();
  }
}
