package com.ontotext.javacourse.designpatterns.exceptions;

/**
 * The MissingFieldException class defines an exception which is thrown when an object is missing a
 * required field.
 */
public class MissingFieldException extends RuntimeException {
  public MissingFieldException(String message) {
    super(message);
  }
}
