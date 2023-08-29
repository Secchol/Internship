package com.ontotext.javacourse.designpatterns.singleton;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SingletonTest {

  @Test
  void getInstanceReturnsSingletonInstance() {
    assertNotNull(Singleton.getInstance());
  }

  @Test
  void getInstanceDoesNotCreateMoreThanOneInstance() {
    Singleton firstInvocation = Singleton.getInstance();
    Singleton secondInvocation = Singleton.getInstance();
    assertEquals(firstInvocation, secondInvocation);
  }
}
