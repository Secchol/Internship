package com.ontotext.javacourse.inputoutput.filewriter;

import java.io.ByteArrayInputStream;

public class Runner {
  public static void main(String[] args) {
    FileWriter.writeToFile(
        "C:\\Users\\This\\Internship\\input-output\\src\\main\\java\\com\\ontotext\\javacourse\\inputoutput\\filewriter\\file");
    String input = "20\n30\n.";
    ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);
    FileWriter.writeToFile(
        "C:\\Users\\This\\Internship\\input-output\\src\\main\\java\\com\\ontotext\\javacourse\\inputoutput\\filewriter\\file");
    System.setIn(inputStream);
  }
}
