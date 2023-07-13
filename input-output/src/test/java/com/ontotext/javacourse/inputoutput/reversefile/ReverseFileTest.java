package com.ontotext.javacourse.inputoutput.reversefile;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import org.junit.jupiter.api.Test;

class ReverseFileTest {

  @Test
  void testReverseFileContentReturnsCorrectOutputWithCorrectInput() {
    try {
      File file =
          new File("C:\\Users\\This\\Internship\\input-output\\src\\main\\resources\\TestFile");
      BufferedWriter writer = new BufferedWriter(new FileWriter(file));
      writer.write("Line 1" + System.lineSeparator());
      writer.write("Line 2" + System.lineSeparator());
      writer.write("Line 3" + System.lineSeparator());
      writer.close();
      File reversedFile = ReverseFile.reverseFileContent(file);
      if (reversedFile == null) {
        fail();
      }
      BufferedReader reader = new BufferedReader(new FileReader(reversedFile));
      String line1 = reader.readLine();
      String line2 = reader.readLine();
      String line3 = reader.readLine();
      String line4 = reader.readLine();
      String line5 = reader.readLine();
      reader.close();
      assertEquals("3 eniL", line1);
      assertEquals("", line2);
      assertEquals("2 eniL", line3);
      assertEquals("", line4);
      assertEquals("1 eniL", line5);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  void testReverseFileThrowsExceptionIfInputIsNull() {
    assertThrows(IllegalArgumentException.class, () -> ReverseFile.reverseFileContent(null));
  }
}
