package com.ontotext.javacourse.inputoutput.consolereader;

import java.util.Scanner;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The ConsoleReader class contains methods that read string, char, float and integer from the
 * console.
 */
@NoArgsConstructor
public class ConsoleReader {

  private static final Logger LOGGER = LoggerFactory.getLogger(ConsoleReader.class);
  private final Scanner scanner = new Scanner(System.in);

  /**
   * Reads a string from the console.
   *
   * @return the given string
   */
  public String readString() {
    LOGGER.info("Enter a string:");
    return scanner.nextLine();
  }

  /**
   * Reads an integer from the console.
   *
   * @return the given integer
   */
  public int readInt() {
    LOGGER.info("Enter an integer:");
    return scanner.nextInt();
  }

  /**
   * Reads a character from the console.
   *
   * @return the given character
   */
  public char readChar() {
    LOGGER.info("Enter a character:");
    String input = scanner.nextLine();
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
  public float readFloat() {
    LOGGER.info("Enter a float:");
    return scanner.nextFloat();
  }
}
