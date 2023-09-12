package com.ontotext.javacourse.designpatterns.abstractfactory.factories;

import com.ontotext.javacourse.designpatterns.abstractfactory.multiplechoicequestions.HistoryMultipleChoiceQuestion;
import com.ontotext.javacourse.designpatterns.abstractfactory.multiplechoicequestions.MultipleChoiceQuestion;
import com.ontotext.javacourse.designpatterns.abstractfactory.openquestions.HistoryOpenQuestion;
import com.ontotext.javacourse.designpatterns.abstractfactory.openquestions.OpenQuestion;

/**
 * The HistoryFactory class contains method that create a multiple choice history question and an
 * open answer history question.
 */
public class HistoryFactory implements QuestionFactory {
  @Override
  public MultipleChoiceQuestion createMultipleChoiceQuestion() {
    return new HistoryMultipleChoiceQuestion();
  }

  @Override
  public OpenQuestion createOpenQuestion() {
    return new HistoryOpenQuestion();
  }
}
