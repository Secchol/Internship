package com.ontotext.javacourse.inputoutput.filewriter;

import com.ontotext.javacourse.inputoutput.reversefile.ReverseFile;
import java.io.File;

public class Runner {
  public static void main(String[] args) {
    File file =
        new File(
            "C:\\Users\\This\\Internship\\input-output\\src\\main\\java\\com\\ontotext\\javacourse\\inputoutput\\filewriter\\file");
    ReverseFile.reverseFileContent(file);
  }
}
