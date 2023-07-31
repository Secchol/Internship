package com.ontotext.javacourse.inputoutput.consolereader;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.InputMismatchException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConsoleReaderTest {

  private ConsoleReader consoleReader;

  @BeforeEach
  void setUp() {
    consoleReader = new ConsoleReader();
  }

  @Test
  void readStringWorksWithCorrectInput() {
    String input = "basic input";
    setInputStreamValue(input);
    assertEquals(input, consoleReader.readString());
  }

  @Test
  void readIntWorksWithCorrectInput() {
    String input = "2024";
    setInputStreamValue(input);
    assertEquals(Integer.parseInt(input), consoleReader.readInt());
  }

  @Test
  void readIntThrowsExceptionWithInvalidInput() {
    String input = "###sdfsd";
    setInputStreamValue(input);
    assertThrows(InputMismatchException.class, () -> consoleReader.readInt());
  }

  @Test
  void readCharWorksWithCorrectInput() {
    String input = "a";
    setInputStreamValue(input);
    assertEquals(input.charAt(0), consoleReader.readChar());
  }

  @Test
  void readCharThrowsExceptionIfInputIsNotSingleCharacter() {
    String input = "wrong";
    setInputStreamValue(input);
    assertThrows(IllegalArgumentException.class, consoleReader::readChar);
  }

  @Test
  void readFloatWorksWithCorrectInput() {
    String input = "2024.24";
    setInputStreamValue(input);
    assertEquals(Float.parseFloat(input), consoleReader.readFloat());
  }

  @Test
  void readFloatThrowsExceptionWithInvalidInput() {
    String input = "12.addd";
    setInputStreamValue(input);
    assertThrows(InputMismatchException.class, () -> consoleReader.readFloat());
  }

  private void setInputStreamValue(String inputStreamValue) {
    ByteArrayInputStream inputStream = new ByteArrayInputStream(inputStreamValue.getBytes());
    System.setIn(inputStream);
  }
}
