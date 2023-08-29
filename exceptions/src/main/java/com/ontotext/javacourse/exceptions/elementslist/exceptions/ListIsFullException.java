package com.ontotext.javacourse.exceptions.elementslist.exceptions;

/**
 * The ListIsFullException defines an exception thrown when adding elements to a max capacity list.
 */
public class ListIsFullException extends RuntimeException {

  public ListIsFullException(String message) {
    super(message);
  }
}
