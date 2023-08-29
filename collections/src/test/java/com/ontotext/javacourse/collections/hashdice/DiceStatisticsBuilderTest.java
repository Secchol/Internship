package com.ontotext.javacourse.collections.hashdice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DiceStatisticsBuilderTest {
  @Test
  void buildStatisticsRollsDiceCorrectNumberOfTimes() {
    DiceStatisticsBuilder diceStatisticsBuilder = new DiceStatisticsBuilder(new Die(10), 20);
    assertEquals(
        20,
        diceStatisticsBuilder.buildStatistics().values().stream()
            .map(set -> set.stream().count())
            .reduce(0L, Long::sum));
  }

  @ParameterizedTest
  @ValueSource(ints = {0, -30})
  void buildStatisticsReturnsEmptyMapIfRollsAreLessThanOrEqualToZero(int rolls) {
    DiceStatisticsBuilder diceStatisticsBuilder = new DiceStatisticsBuilder(new Die(20), rolls);
    assertTrue(diceStatisticsBuilder.buildStatistics().isEmpty());
  }
}
