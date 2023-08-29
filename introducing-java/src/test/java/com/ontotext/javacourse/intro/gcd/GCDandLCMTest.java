package com.ontotext.javacourse.intro.gcd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class GCDandLCMTest {
  @Test
  void findGCDMethodWorksWithCorrectInput() {
    assertEquals(12, GCDandLCM.findGCD(12, 36));
  }

  @Test
  void findGCDMethodWorksWithZeroAsParam() {
    assertEquals(10, GCDandLCM.findGCD(10, 0));
  }

  @Test
  void findGCDMethodWorksWithBothParametersAsZero() {
    assertEquals(0, GCDandLCM.findGCD(0, 0));
  }

  @Test
  void findGCDMethodWorksWithNegativeInput() {
    assertEquals(-10, GCDandLCM.findGCD(-10, -20));
  }

  @Test
  void findLCMMethodWorksWithCorrectInput() {
    assertEquals(60, GCDandLCM.findLCM(20, 30));
  }

  @Test
  void findLCMMethodThrowsExceptionWithZeroAsInput() {
    assertThrows(IllegalArgumentException.class, () -> GCDandLCM.findLCM(0, 30));
  }

  @Test
  void findLCMMethodWorksWithNegativeInput() {
    assertEquals(GCDandLCM.findLCM(-10, -20), -20);
  }
}
