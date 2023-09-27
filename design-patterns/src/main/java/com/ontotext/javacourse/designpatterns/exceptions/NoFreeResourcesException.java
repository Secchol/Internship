package com.ontotext.javacourse.designpatterns.exceptions;

/**
 * The NoFreeResourcesException class defines an exception which is thrown when there are no more
 * free resources in an object pool.
 */
public class NoFreeResourcesException extends RuntimeException {
  public NoFreeResourcesException(String message) {
    super(message);
  }
}
