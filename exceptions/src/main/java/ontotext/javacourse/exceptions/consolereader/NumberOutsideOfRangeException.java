package ontotext.javacourse.exceptions.consolereader;

/**
 * The NumberOutsideOfRangeException defines an exception thrown when a number outside the 0-100
 * range is given.
 */
public class NumberOutsideOfRangeException extends RuntimeException {
  public NumberOutsideOfRangeException(String message) {
    super(message);
  }
}
