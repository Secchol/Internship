package com.ontotext.javacourse.inputoutput.filewriter;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import org.junit.jupiter.api.Test;

class FileWriterTest {

  @Test
  void writeToFileWorksWithCorrectInput() {
    String input = "test\ncode\n.";
    ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    try {
      File file =
          new File("C:\\Users\\This\\Internship\\input-output\\src\\main\\resources\\TestFile");
      FileWriter.writeToFile(file.getAbsolutePath());
      BufferedReader reader = new BufferedReader(new FileReader(file));
      assertEquals("test", reader.readLine());
      assertEquals("code", reader.readLine());
    } catch (Exception exception) {
      exception.printStackTrace();
    } finally {
      System.setIn(System.in);
    }
  }

  @Test
  void writeToFileThrowsExceptionWithEmtpyPathInput() {
    assertThrows(IllegalArgumentException.class, () -> FileWriter.writeToFile(""));
  }
}
