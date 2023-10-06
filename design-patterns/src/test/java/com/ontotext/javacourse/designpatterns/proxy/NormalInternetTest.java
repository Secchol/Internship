package com.ontotext.javacourse.designpatterns.proxy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NormalInternetTest {
  private final Internet normalInternet = new NormalInternet();

  @Test
  void connectToReturnsTrueIfUrlIsValid() {
    assertTrue(normalInternet.connectTo("https://mysite.com"));
  }

  @Test
  void connectToThrowsExceptionIfUrlIsInvalid() {
    assertThrows(IllegalArgumentException.class, () -> normalInternet.connectTo("invalid site"));
  }
}
