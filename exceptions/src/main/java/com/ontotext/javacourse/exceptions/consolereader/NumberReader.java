package com.ontotext.javacourse.exceptions.consolereader;

import java.security.InvalidParameterException;
import java.util.Scanner;
import org.codehaus.plexus.util.StringUtils;

/**
 * The NumberReader class contains a method which reads numbers in the 0-100 range and throws
 * exception when the read number is outside the range.
 */
public final class NumberReader {
  private NumberReader() throws IllegalAccessException {
    throw new IllegalAccessException("The NumberReader class is not meant to be instantiated");
  }

  /**
   * Reads number in the 0-100 range from console. If the given number is outside the given range
   * NumberOutsideOfRangeException is thrown else if the input is non-numeric
   * InvalidParameterException is thrown.
   */
  public static int read() {
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    if (!StringUtils.isNumeric(input)) {
      throw new InvalidParameterException("Input is non numeric.");
    }
    int number = Integer.parseInt(input);
    if (number < 0 || number > 100) {
      throw new NumberOutsideOfRangeException("The given number is not in the 0-100 range.");
    }
    return number;
  }
}
