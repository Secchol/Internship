package com.ontotext.javacourse.designpatterns.abstractfactory.factories;

import com.ontotext.javacourse.designpatterns.abstractfactory.multiplechoicequestions.MultipleChoiceQuestion;
import com.ontotext.javacourse.designpatterns.abstractfactory.openquestions.OpenQuestion;

/**
 * Defines a question factory that can create a multiple choice question and an open question
 * depending on the factory type.
 */
public interface QuestionFactory {
  MultipleChoiceQuestion createMultipleChoiceQuestion();

  OpenQuestion createOpenQuestion();
}
