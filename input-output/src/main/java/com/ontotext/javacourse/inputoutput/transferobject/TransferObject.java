package com.ontotext.javacourse.inputoutput.transferobject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidParameterException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * The TransferObject contains a method which transfers the content from a given InputStream to an
 * OutputStream.
 */
@Setter
@Getter
@AllArgsConstructor
public class TransferObject {
  private InputStream inputStream;
  private OutputStream outputStream;

  /**
   * Transfers the content from the InputStream to the OutputStream.
   *
   * @param numberOfBytes the number of bytes to transfer
   * @param offset the number of bytes to be skipped before the transferring begins
   * @return the number of bytes transferred
   */
  public int transfer(int numberOfBytes, int offset) {
    try {
      if (numberOfBytes < 0) {
        throw new InvalidParameterException("Number of bytes must be larger or equal to 0");
      }
      if (offset < 0) {
        throw new InvalidParameterException("Offset must be larger or equal to 0");
      }
      inputStream.skip(offset);
      byte[] bytes = inputStream.readNBytes(numberOfBytes);
      if (bytes.length == 0) {
        throw new InvalidParameterException("Input stream is empty");
      }
      outputStream.write(bytes);
      inputStream.close();
      outputStream.close();
      return bytes.length;
    } catch (IOException exception) {
      exception.printStackTrace();
      return -1;
    }
  }
}
