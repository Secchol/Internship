package com.ontotext.javacourse.collections.hashdice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import lombok.AllArgsConstructor;

/** The DiceStatisticsBuilder class contains a method which builds statistics for given dice. */
@AllArgsConstructor
public class DiceStatisticsBuilder {
  private final Map<DiceRollCombination, Set<Integer>> statistics = new HashMap<>();
  private Die die;
  private int rolls;

  /**
   * Builds statistics based on the given dice.
   *
   * @return the map which contains information about the dice combinations and on which roll they
   *     fell
   */
  public Map<DiceRollCombination, Set<Integer>> buildStatistics() {
    for (int currentRoll = 1; currentRoll <= rolls; currentRoll++) {
      DiceRollCombination diceRollCombination = getDiceRollCombination();
      statistics.computeIfAbsent(diceRollCombination, k -> new HashSet<>());
      statistics.get(diceRollCombination).add(currentRoll);
    }
    return statistics;
  }

  private DiceRollCombination getDiceRollCombination() {
    return new DiceRollCombination(die.rollDie(), die.rollDie());
  }
}
