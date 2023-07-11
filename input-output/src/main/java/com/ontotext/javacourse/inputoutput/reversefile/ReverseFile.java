package com.ontotext.javacourse.inputoutput.reversefile;

import java.io.*;
import java.util.Scanner;

/** The ReverseFile class contains a method which takes a file and reverses its content. */
public class ReverseFile {
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
      throw new NullPointerException("File is null!");
    }
    try (Scanner scanner = new Scanner(file)) {
      StringBuffer fileContent = new StringBuffer();
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        if (!line.equals("")) {
          fileContent.append(line + "\n");
        }
      }
      try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
        writer.write(fileContent.reverse().toString().trim());
      }
      return file;
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    }
  }
}
