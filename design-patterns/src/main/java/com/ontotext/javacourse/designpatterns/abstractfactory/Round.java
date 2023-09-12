package com.ontotext.javacourse.designpatterns.abstractfactory;

import com.ontotext.javacourse.designpatterns.abstractfactory.factories.QuestionFactory;
import com.ontotext.javacourse.designpatterns.abstractfactory.multiplechoicequestions.MultipleChoiceQuestion;
import com.ontotext.javacourse.designpatterns.abstractfactory.openquestions.OpenQuestion;
import lombok.AllArgsConstructor;

/**
 * The round class is a part of the game. Every round one multiple choice and one open answer
 * questions are asked.
 */
@AllArgsConstructor
public class Round {
  private QuestionFactory factory;

  /** Starts the round and asks two questions both on the same randomly chosen topic. */
  public void start() {
    MultipleChoiceQuestion multipleChoiceQuestion = factory.createMultipleChoiceQuestion();
    OpenQuestion openQuestion = factory.createOpenQuestion();
    multipleChoiceQuestion.askQuestion();
    openQuestion.writeAnswer("invalid answer");
  }
}
