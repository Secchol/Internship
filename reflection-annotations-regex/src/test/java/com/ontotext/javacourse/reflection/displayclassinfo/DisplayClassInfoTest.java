package com.ontotext.javacourse.reflection.displayclassinfo;

import static org.junit.jupiter.api.Assertions.*;

import com.ontotext.javacourse.reflection.utilityclasses.ClassInfo;
import com.ontotext.javacourse.reflection.utilityclasses.Dog;
import org.junit.jupiter.api.Test;

class DisplayClassInfoTest {

  @Test
  void returnAndLogClassInfoWorksWithCorrectInput() {
    Dog dog = new Dog("Doge", 20, 200.4);
    ClassInfo classInfo = DisplayClassInfo.returnAndLogClassInfo(dog);
    assertEquals(classInfo.getClassName(), "com.ontotext.javacourse.reflection.utilityclasses.Dog");
    assertNull(classInfo.getParentClass());
    assertEquals(9, classInfo.getMethods().length);
    assertEquals(4, classInfo.getFields().length);
    assertNull(classInfo.getInterfaces());
    assertEquals(-1, classInfo.getPrivateFieldResult());
    assertEquals(-1, classInfo.getPrivateMethodResult());
  }
}