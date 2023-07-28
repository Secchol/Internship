package com.ontotext.javacourse.inputoutput.serialization;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The ObjectManager class contains methods which can write and read object from input and output
 * streams.
 */
public final class ObjectManager {
  private static final Logger LOGGER = LoggerFactory.getLogger(ObjectManager.class);

  private ObjectManager() throws IllegalAccessException {
    throw new IllegalAccessException("ObjectManager class is not meant to be instantiated");
  }

  /**
   * Writes a given UserDefinedObject to an ObjectOutputStream.
   *
   * @param path the path which points to the file
   * @param o the UserDefinedObject to write
   */
  public static void saveObject(String path, UserDefinedObject o) {
    if (path == null) {
      throw new IllegalArgumentException("Path cannot be null!");
    }
    try (ObjectOutputStream objectOutputStream =
        new ObjectOutputStream(new FileOutputStream(path))) {
      File file = new File(path);
      if (!file.exists()) {
        Files.createFile(Paths.get(path));
      }
      objectOutputStream.writeObject(o);
    } catch (IOException exception) {
      LOGGER.error(exception.getMessage());
    }
  }

  /**
   * Reads a UserDefinedObject from a given file path.
   *
   * @param path the path to read from
   * @return the read UserDefinedObject
   * @throws IOException if an i/o error occurs
   * @throws ClassNotFoundException if the class of the serializable object is not found
   */
  public static UserDefinedObject getObject(String path)
      throws IOException, ClassNotFoundException {
    if (path == null) {
      throw new IllegalArgumentException("Path cannot be null!");
    }
    try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(path))) {
      return (UserDefinedObject) objectInputStream.readObject();
    } catch (FileNotFoundException exception) {
      throw new IOException("File is not found: " + path);
    }
  }
}
