package com.ontotext.javacourse.inputoutput.utilityclasses;

import java.io.File;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * The FileInfo class defines an object which contains information about a file and its directories.
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public class FileInfo {
  private List<File> folders;
  private List<File> files;
}
