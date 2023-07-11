package com.ontotext.javacourse.inputoutput.transferobject;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidParameterException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TransferObjectTest {

  private TransferObject transferObject;

  @BeforeEach
  public void setUp() {
    byte[] bytes = {5, 1, 10, 3, 20, 50};
    InputStream inputStream = new ByteArrayInputStream(bytes);
    OutputStream outputStream = new ByteArrayOutputStream();
    transferObject = new TransferObject(inputStream, outputStream);
  }

  @Test
  void transferReturnsCorrectOutputWithCorrectInput() {
    assertEquals(3, transferObject.transfer(3, 2));
  }

  @Test
  void transferThrowsExceptionIfInputStreamIsEmpty() {
    byte[] bytes = {};
    InputStream inputStream = new ByteArrayInputStream(bytes);
    OutputStream outputStream = new ByteArrayOutputStream();
    TransferObject transferObject = new TransferObject(inputStream, outputStream);
    assertThrows(InvalidParameterException.class, () -> transferObject.transfer(2, 3));
  }

  @Test
  void transferThrowsExceptionIfNumberOfBytesToTransferIsNegative() {
    assertThrows(InvalidParameterException.class, () -> transferObject.transfer(-1, 3));
  }

  @Test
  void transferThrowsExceptionIfOffsetIsNegative() {
    assertThrows(InvalidParameterException.class, () -> transferObject.transfer(20, -20));
  }
}
