package com.ontotext.javacourse.collections.hashdice;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class HashDiceTest {

  @Test
  void buildStatisticsWorksWithCorrectInput() {
    HashDice hashDice = createHashDice("6\n", "10\n");
    Map<String, HashSet<Integer>> result = hashDice.buildStatistics();
    assertEquals(
        10, result.values().stream().map(set -> set.stream().count()).reduce(0L, Long::sum));
  }

  @ParameterizedTest
  @ValueSource(strings = {"0\n", "-2\n"})
  void buildStatisticsThrowsExceptionIfDiceSidesLowerOrEqualToZero(String sides) {
    HashDice hashDice = createHashDice(sides, "20\n");
    assertThrows(IllegalArgumentException.class, hashDice::buildStatistics);
  }

  @Test
  void buildStatisticsThrowsExceptionIfInputIsNonNumeric() {
    HashDice hashDice = createHashDice("a\n", "$\n");
    assertThrows(InputMismatchException.class, hashDice::buildStatistics);
  }

  @ParameterizedTest
  @ValueSource(strings = {"0\n", "-20\n"})
  void buildStatisticsReturnsEmptyMapIfRollsAreLowerOrEqualToZero(String rolls) {
    HashDice hashDice = createHashDice("10\n", rolls);
    assertTrue(hashDice.buildStatistics().isEmpty());
  }

  private HashDice createHashDice(String sides, String rolls) {
    InputStream inputStream =
        new BufferedInputStream(new ByteArrayInputStream((sides + rolls).getBytes()));
    return new HashDice(inputStream);
  }
}
