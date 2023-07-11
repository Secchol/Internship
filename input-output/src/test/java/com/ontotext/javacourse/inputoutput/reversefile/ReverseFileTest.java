package com.ontotext.javacourse.inputoutput.reversefile;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import org.junit.jupiter.api.Test;

class ReverseFileTest {

  @Test
  void testReverseFileContentReturnsCorrectOutputWithCorrectInput() {
    try {
      File testFile = File.createTempFile("test", ".txt");
      BufferedWriter writer = new BufferedWriter(new FileWriter(testFile));
      writer.write("Line 1\n");
      writer.write("Line 2\n");
      writer.write("Line 3\n");
      writer.close();
      File reversedFile = ReverseFile.reverseFileContent(testFile);
      BufferedReader reader = new BufferedReader(new FileReader(reversedFile));
      String line1 = reader.readLine();
      String line2 = reader.readLine();
      String line3 = reader.readLine();
      reader.close();
      assertEquals("3 eniL", line1);
      assertEquals("2 eniL", line2);
      assertEquals("1 eniL", line3);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  void testReverseFileThrowsExceptionIfInputIsNull() {
    assertThrows(NullPointerException.class, () -> ReverseFile.reverseFileContent(null));
  }
}
