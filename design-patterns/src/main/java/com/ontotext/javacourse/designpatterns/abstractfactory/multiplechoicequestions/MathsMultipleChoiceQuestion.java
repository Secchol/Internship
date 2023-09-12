package com.ontotext.javacourse.designpatterns.abstractfactory.multiplechoicequestions;

/** This class defines a multiple choice math question. */
public class MathsMultipleChoiceQuestion implements MultipleChoiceQuestion {

  @Override
  public void askQuestion() {
    System.out.println("What is the value of PI?");
  }

  @Override
  public boolean checkAnswer(String answer) {
    return answer.equalsIgnoreCase("3.14");
  }
}
