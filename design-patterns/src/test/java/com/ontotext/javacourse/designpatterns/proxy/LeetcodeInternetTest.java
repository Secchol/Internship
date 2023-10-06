package com.ontotext.javacourse.designpatterns.proxy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LeetcodeInternetTest {

  private LeetcodeInternet leetcodeInternet;

  @BeforeEach
  void setUp() {
    leetcodeInternet = new LeetcodeInternet();
  }

  @Test
  void connectToReturnsTrueIfProblemIsSolved() {
    leetcodeInternet.solveProblem();
    assertTrue(leetcodeInternet.connectTo("https://wikipedia.com"));
  }

  @Test
  void connectToReturnsFalseIfProblemIsNotSolved() {
    assertFalse(leetcodeInternet.connectTo("https://wikipedia.com"));
  }
}
