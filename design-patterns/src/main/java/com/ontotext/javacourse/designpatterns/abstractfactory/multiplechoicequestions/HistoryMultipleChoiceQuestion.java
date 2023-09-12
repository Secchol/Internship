package com.ontotext.javacourse.designpatterns.abstractfactory.multiplechoicequestions;

/**
 * This class defines a multiple choice history question.
 */
public class HistoryMultipleChoiceQuestion implements MultipleChoiceQuestion {

  @Override
  public void askQuestion() {
    System.out.println("What year did WW2 start?");
  }

  @Override
  public boolean checkAnswer(String answer) {
    return answer.equalsIgnoreCase("1939");
  }
}
