package com.ontotext.javacourse.exceptions.elementslist.exceptions;

/**
 * The ListIsEmptyException defines an exception which is thrown when calling the remove method on
 * an empty list.
 */
public class ListIsEmptyException extends RuntimeException {
  public ListIsEmptyException(String message) {
    super(message);
  }
}
