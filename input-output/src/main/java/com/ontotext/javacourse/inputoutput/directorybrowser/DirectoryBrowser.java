package com.ontotext.javacourse.inputoutput.directorybrowser;

import com.ontotext.javacourse.inputoutput.utilityclasses.FileInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The DirectoryBrowser class contains a method which takes a path and displays a message which
 * determines if the path points to a file or a folder.
 */
public final class DirectoryBrowser {

  private static final Logger LOGGER = LoggerFactory.getLogger(DirectoryBrowser.class);

  private DirectoryBrowser() throws IllegalAccessException {
    throw new IllegalAccessException("DirectoryBrowser class is not meant to be instantiated");
  }

  /**
   * Displays the content of a folder or file in the file system.
   *
   * @param path the path to the file or folder
   * @return FileInfo object that contains information about the file or folder
   */
  public static FileInfo listContent(String path) {
    File file = new File(path);
    if (file.isFile()) {
      LOGGER.info("The path points to a file: {}", file.getName());
      return new FileInfo(new ArrayList<>(), new ArrayList<>());
    } else if (file.isDirectory()) {
      LOGGER.info("The path {} points to a folder: {}", file.getAbsolutePath(), file.getName());
      FileInfo fileInfo = new FileInfo(getFolders(file), getFiles(file));
      LOGGER.info(fileInfo.toString().replace(", ", System.lineSeparator()));
      return fileInfo;
    }
    throw new IllegalArgumentException("The path is invalid!");
  }

  private static List<File> getFolders(File file) {
    File[] allFiles = file.listFiles();
    if (allFiles == null) {
      return new ArrayList<>();
    }
    List<File> folders = new ArrayList<>();
    for (File item : allFiles) {
      if (item.isDirectory()) {
        folders.add(item);
      }
    }
    return folders;
  }

  private static List<File> getFiles(File file) {
    File[] allFiles = file.listFiles();
    if (allFiles == null) {
      return new ArrayList<>();
    }
    List<File> files = new ArrayList<>();
    for (File item : allFiles) {
      if (item.isFile()) {
        files.add(item);
      }
    }
    return files;
  }
}
