package com.ontotext.javacourse.inputoutput.filewriter;

import com.ontotext.javacourse.inputoutput.consolereader.ConsoleReader;
import java.io.ByteArrayInputStream;

public class Runner {
  public static void main(String[] args) {

    ConsoleReader reader = new ConsoleReader();
    setInputStreamValue("1000\n");
    System.out.println(reader.readInt());
  }

  private static void setInputStreamValue(String inputStreamValue) {
    ByteArrayInputStream inputStream = new ByteArrayInputStream(inputStreamValue.getBytes());
    System.setIn(inputStream);
  }
}
