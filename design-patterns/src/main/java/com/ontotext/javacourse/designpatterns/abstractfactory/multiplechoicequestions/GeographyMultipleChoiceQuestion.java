package com.ontotext.javacourse.designpatterns.abstractfactory.multiplechoicequestions;

/** This class defines a multiple choice geography question. */
public class GeographyMultipleChoiceQuestion implements MultipleChoiceQuestion {

  @Override
  public void askQuestion() {
    System.out.println("Which is the capital city of Germany?");
  }

  @Override
  public boolean checkAnswer(String answer) {
    return answer.equalsIgnoreCase("berlin");
  }
}
