package com.ontotext.javacourse.inputoutput.consolereader;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.InputMismatchException;
import org.junit.jupiter.api.Test;

class ConsoleReaderTest {

  private ConsoleReader consoleReader;

  private void setUp(String value) {
    setInputStreamValue(value);
    consoleReader = new ConsoleReader();
  }

  @Test
  void readStringWorksWithCorrectInput() {
    setUp("basic input\n");
    assertEquals("basic input", consoleReader.readString());
  }

  @Test
  void readIntWorksWithCorrectInput() {
    setUp("2024");
    assertEquals(Integer.parseInt("2024"), consoleReader.readInt());
  }

  @Test
  void readIntThrowsExceptionWithInvalidInput() {
    setUp("###sdfsd\n");
    assertThrows(InputMismatchException.class, () -> consoleReader.readInt());
  }

  @Test
  void readCharWorksWithCorrectInput() {
    setUp("a\n");
    assertEquals('a', consoleReader.readChar());
  }

  @Test
  void readCharThrowsExceptionIfInputIsNotSingleCharacter() {
    setUp("wrong\n");
    assertThrows(IllegalArgumentException.class, consoleReader::readChar);
  }

  @Test
  void readFloatWorksWithCorrectInput() {
    setUp("2024.24\n");
    assertEquals(Float.parseFloat("2024.24\n"), consoleReader.readFloat());
  }

  @Test
  void readFloatThrowsExceptionWithInvalidInput() {
    setUp("12.addd\n");
    assertThrows(InputMismatchException.class, () -> consoleReader.readFloat());
  }

  private void setInputStreamValue(String inputStreamValue) {
    ByteArrayInputStream inputStream = new ByteArrayInputStream(inputStreamValue.getBytes());
    System.setIn(inputStream);
  }
}
