package com.ontotext.javacourse.inputoutput.directorybrowser;

import static org.junit.jupiter.api.Assertions.*;

import com.ontotext.javacourse.inputoutput.utilityclasses.FileInfo;
import org.junit.jupiter.api.Test;

class DirectoryBrowserTest {

  @Test
  void listContentWorksWithFileInput() {
    FileInfo fileInfo =
        DirectoryBrowser.listContent(
            "C:\\Users\\This\\Internship\\input-output\\src\\main\\resources\\TestFile");
    assertEquals(0, fileInfo.getFolders().size());
    assertEquals(0, fileInfo.getFiles().size());
  }

  @Test
  void listContentWorksWithFolderInput() {
    FileInfo fileInfo =
        DirectoryBrowser.listContent(
            "C:\\Users\\This\\Internship\\input-output\\src\\main\\resources\\testFolder");
    assertEquals(1, fileInfo.getFolders().size());
    assertEquals(3, fileInfo.getFiles().size());
  }

  @Test
  void listContentThrowsExceptionWithInvalidPathInput() {
    assertThrows(IllegalArgumentException.class, () -> DirectoryBrowser.listContent("invalidPath"));
  }
}
