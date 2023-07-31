package com.ontotext.javacourse.inputoutput.serialization;

import static org.junit.jupiter.api.Assertions.*;

import com.ontotext.javacourse.reflection.animals.Dog;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class ObjectManagerTest {
  private static final Logger LOGGER = LoggerFactory.getLogger(ObjectManagerTest.class);
  private static final UserDefinedObject USERDEFINEDOBJECT =
      new UserDefinedObject(10, "text", new Dog("D", 20, 120.24));

  @ParameterizedTest
  @ValueSource(
      strings = {
        "C:/Users/This/Internship/input-output/src/main/resources/TestFile",
        "C:/Users/This/Internship/input-output/src/main/resources/NonExistingFile"
      })
  void saveObjectAndGetObjectWorkWithCorrectInput(String path) {
    ObjectManager.saveObject(path, USERDEFINEDOBJECT);
    try {
      assertEquals(USERDEFINEDOBJECT, ObjectManager.getObject(path));
    } catch (Exception exception) {
      LOGGER.error(exception.getMessage());
    }
  }

  @Test
  void saveObjectsThrowsExceptionIfPathIsNull() {
    assertThrows(
        IllegalArgumentException.class, () -> ObjectManager.saveObject(null, USERDEFINEDOBJECT));
  }

  @Test
  void getObjectThrowsExceptionIfPathIsNull() {
    assertThrows(IllegalArgumentException.class, () -> ObjectManager.getObject(null));
  }

  @ParameterizedTest
  @EmptySource
  @ValueSource(strings = {"/wrongPath"})
  void getObjectThrowsExceptionIfPathIsNotFound(String path) {
    assertThrows(IOException.class, () -> ObjectManager.getObject(path));
  }
}
