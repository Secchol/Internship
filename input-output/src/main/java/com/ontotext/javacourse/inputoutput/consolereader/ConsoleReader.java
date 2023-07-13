package com.ontotext.javacourse.inputoutput.consolereader;

import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The ConsoleReader class contains methods that read string,char,float and integer from the
 * console.
 */
public final class ConsoleReader {

  private static final Scanner SCANNER = new Scanner(System.in);
  private static final Logger LOGGER = LoggerFactory.getLogger(ConsoleReader.class);

  private ConsoleReader() throws IllegalAccessException {
    throw new IllegalAccessException("ConsoleReader class is not meant to be instantiated");
  }
  /**
   * Reads a string from the console.
   *
   * @return the given string
   */
  public static String readString() {
    LOGGER.info("Enter a string:");
    return SCANNER.nextLine();
  }
  /**
   * Reads an integer from the console.
   *
   * @return the given integer
   */
  public static int readInt() {
    LOGGER.info("Enter an integer:");
    return SCANNER.nextInt();
  }
  /**
   * Reads a character from the console.
   *
   * @return the given character
   */
  public static char readChar() {
    LOGGER.info("Enter a character:");
    String input = readString();
    if (input.length() > 1) {
      throw new IllegalArgumentException("The given input is not a single character!");
    }
    return input.charAt(0);
  }
  /**
   * Reads a float from the console.
   *
   * @return the given float
   */
  public static float readFloat() {
    LOGGER.info("Enter a float:");
    return SCANNER.nextFloat();
  }
}
