package com.ontotext.javacourse.designpatterns.abstractfactory.factories;

import com.ontotext.javacourse.designpatterns.abstractfactory.multiplechoicequestions.GeographyMultipleChoiceQuestion;
import com.ontotext.javacourse.designpatterns.abstractfactory.multiplechoicequestions.MultipleChoiceQuestion;
import com.ontotext.javacourse.designpatterns.abstractfactory.openquestions.GeographyOpenQuestion;
import com.ontotext.javacourse.designpatterns.abstractfactory.openquestions.OpenQuestion;

/**
 * The GeographyFactory class contains method that create a multiple choice geography question and
 * an open answer geography question.
 */
public class GeographyFactory implements QuestionFactory {
  @Override
  public MultipleChoiceQuestion createMultipleChoiceQuestion() {
    return new GeographyMultipleChoiceQuestion();
  }

  @Override
  public OpenQuestion createOpenQuestion() {
    return new GeographyOpenQuestion();
  }
}
