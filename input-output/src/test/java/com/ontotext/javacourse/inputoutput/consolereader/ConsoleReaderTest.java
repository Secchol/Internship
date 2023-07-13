package com.ontotext.javacourse.inputoutput.consolereader;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.InputMismatchException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class ConsoleReaderTest {

  @AfterEach
  void tearDown() {
    System.setIn(System.in);
  }

  @Test
  void readStringWorksWithCorrectInput() {
    String input = "basic input";
    setInputStreamValue(input);
    assertEquals(input, ConsoleReader.readString());
  }

  @Test
  void readIntWorksWithCorrectInput() {
    String input = "2024";
    setInputStreamValue(input);
    assertEquals(Integer.parseInt(input), ConsoleReader.readInt());
  }

  @Test
  void readIntThrowsExceptionWithInvalidInput() {
    String input = "###sdfsd";
    setInputStreamValue(input);
    assertThrows(InputMismatchException.class, () -> ConsoleReader.readInt());
  }

  @Test
  void readCharWorksWithCorrectInput() {
    String input = "a";
    setInputStreamValue(input);
    assertEquals(input.charAt(0), ConsoleReader.readChar());
  }

  @Test
  void readCharThrowsExceptionIfInputIsNotSingleCharacter() {
    String input = "wrong";
    setInputStreamValue(input);
    assertThrows(IllegalArgumentException.class, () -> ConsoleReader.readChar());
  }

  @Test
  void readFloatWorksWithCorrectInput() {
    String input = "2024.24";
    setInputStreamValue(input);
    assertEquals(Float.parseFloat(input), ConsoleReader.readFloat());
  }

  @Test
  void readFloatThrowsExceptionWithInvalidInput() {
    String input = "12.addd";
    setInputStreamValue(input);
    assertThrows(InputMismatchException.class, () -> ConsoleReader.readFloat());
  }

  private void setInputStreamValue(String inputStreamValue) {
    ByteArrayInputStream inputStream = new ByteArrayInputStream(inputStreamValue.getBytes());
    System.setIn(inputStream);
  }
}
