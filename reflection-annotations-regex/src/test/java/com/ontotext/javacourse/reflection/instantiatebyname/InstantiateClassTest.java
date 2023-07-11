package com.ontotext.javacourse.reflection.instantiatebyname;

import static org.junit.jupiter.api.Assertions.*;

import com.ontotext.javacourse.reflection.utilityclasses.ClassInfo;
import com.ontotext.javacourse.reflection.utilityclasses.Dog;
import org.junit.jupiter.api.Test;

class InstantiateClassTest {

  @Test
  void returnAndLogClassInfoReturnsCorrectOutput() {
    Dog dog = new Dog("Doge", 20, 200.4);
    ClassInfo classInfo = InstantiateClass.instantiateClassByName();
    assertEquals("com.ontotext.javacourse.reflection.utilityclasses.Dog", classInfo.getClassName());
    assertEquals(
        "com.ontotext.javacourse.reflection.utilityclasses.Animal",
        classInfo.getParentClass().getName());
    assertEquals(9, classInfo.getMethods().length);
    assertEquals(4, classInfo.getFields().length);
    assertEquals(2, classInfo.getInterfaces().length);
    assertEquals(-1, classInfo.getPrivateFieldResult());
    assertEquals(-1, classInfo.getPrivateMethodResult());
  }
}
