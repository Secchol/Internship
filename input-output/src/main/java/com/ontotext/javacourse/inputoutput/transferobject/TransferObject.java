package com.ontotext.javacourse.inputoutput.transferobject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidParameterException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The TransferObject contains a method which transfers the content from a given InputStream to an
 * OutputStream.
 */
@Setter
@Getter
@AllArgsConstructor
public class TransferObject {
  private static final Logger LOGGER = LoggerFactory.getLogger(TransferObject.class);
  private InputStream inputStream;
  private OutputStream outputStream;

  /**
   * Transfers the content from the InputStream to the OutputStream.
   *
   * @param numberOfBytes the number of bytes to transfer at a time
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
      int bytesTransffered = 0;
      while (bytes.length != 0) {
        bytesTransffered += bytes.length;
        outputStream.write(bytes);
        bytes = inputStream.readNBytes(numberOfBytes);
      }
      inputStream.close();
      outputStream.close();
      return bytesTransffered;
    } catch (IOException exception) {
      LOGGER.error(exception.getMessage());
    }
    return -1;
  }
}
