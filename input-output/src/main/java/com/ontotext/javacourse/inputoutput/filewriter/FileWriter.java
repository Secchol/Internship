package com.ontotext.javacourse.inputoutput.filewriter;

import java.io.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The FileWriter class contains a method that can read text from the console and write it to a
 * given file.
 */
public class FileWriter {
  private static final Logger LOGGER = LoggerFactory.getLogger(FileWriter.class);

  private FileWriter() throws IllegalAccessException {
    throw new IllegalAccessException("FileWriter class is not meant to be instantiated");
  }

  /**
   * Reads text from the console and writes it to a given file.
   *
   * @param path the path of the file in which to write text
   */
  public static void writeToFile(String path) {
    if (path.isEmpty()) {
      throw new IllegalArgumentException("Path is not valid!");
    }
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(path))) {
      String input = reader.readLine();
      while (!".".equals(input)) {
        writer.write(input);
        writer.newLine();
        input = reader.readLine();
      }
    } catch (Exception exception) {
      LOGGER.error(exception.getMessage());
    }
  }
}
