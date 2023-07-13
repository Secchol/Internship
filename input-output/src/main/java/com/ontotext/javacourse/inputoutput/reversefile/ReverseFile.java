package com.ontotext.javacourse.inputoutput.reversefile;

import java.io.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** The ReverseFile class contains a method which takes a file and reverses its content. */
public class ReverseFile {
  private static final Logger LOGGER = LoggerFactory.getLogger(ReverseFile.class);

  private ReverseFile() throws IllegalAccessException {
    throw new IllegalAccessException("ReverseFile class is not meant to be instantiated");
  }

  /**
   * Reverses a given files contents.
   *
   * @param file the file to reverse content from
   * @return the file with its content reversed
   */
  public static File reverseFileContent(File file) {
    if (file == null) {
      throw new IllegalArgumentException("File is null!");
    }
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      StringBuilder fileContent = new StringBuilder();
      String currentLine = reader.readLine();
      while (currentLine != null) {
        fileContent.append(currentLine);
        fileContent.append(System.lineSeparator());
        currentLine = reader.readLine();
      }
      try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
        writer.write(fileContent.reverse().toString().trim());
      }
      return file;
    } catch (Exception exception) {
      LOGGER.error(exception.getMessage());
    }
    return null;
  }
}
