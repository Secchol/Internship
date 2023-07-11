package com.ontotext.javacourse.inputoutput.consolereader;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.InputMismatchException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConsoleReaderTest {

  @BeforeEach
  void setUp() {
    System.setIn(new ByteArrayInputStream(new byte[0]));
  }

  @Test
  void readStringWorksWithCorrectInput() {
    String input = "basic input";
    ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    assertEquals(input, ConsoleReader.readString());
  }

  @Test
  void readIntWorksWithCorrectInput() {
    String input = "2024";
    ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    assertEquals(Integer.parseInt(input), ConsoleReader.readInt());
  }

  @Test
  void readIntThrowsExceptionWithInvalidInput() {
    String input = "###sdfsd";
    ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    assertThrows(InputMismatchException.class, () -> ConsoleReader.readInt());
  }

  @Test
  void readCharWorksWithCorrectInput() {
    String input = "a";
    ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    assertEquals(input.charAt(0), ConsoleReader.readChar());
  }

  @Test
  void readCharThrowsExceptionIfInputIsNotSingleCharacter() {
    String input = "wrong";
    ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    assertThrows(IllegalArgumentException.class, () -> ConsoleReader.readChar());
  }

  @Test
  void readFloatWorksWithCorrectInput() {
    String input = "2024.24";
    ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    assertEquals(Float.parseFloat(input), ConsoleReader.readFloat());
  }

  @Test
  void readFloatThrowsExceptionWithInvalidInput() {
    String input = "12.addd";
    ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    assertThrows(InputMismatchException.class, () -> ConsoleReader.readFloat());
  }
}
