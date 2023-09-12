package com.ontotext.javacourse.designpatterns.abstractfactory.factories;

import com.ontotext.javacourse.designpatterns.abstractfactory.multiplechoicequestions.MathsMultipleChoiceQuestion;
import com.ontotext.javacourse.designpatterns.abstractfactory.multiplechoicequestions.MultipleChoiceQuestion;
import com.ontotext.javacourse.designpatterns.abstractfactory.openquestions.MathsOpenQuestion;
import com.ontotext.javacourse.designpatterns.abstractfactory.openquestions.OpenQuestion;

/**
 * The MathsFactory class contains method that create a multiple choice maths question and an open
 * answer maths question.
 */
public class MathsFactory implements QuestionFactory {
  @Override
  public MultipleChoiceQuestion createMultipleChoiceQuestion() {
    return new MathsMultipleChoiceQuestion();
  }

  @Override
  public OpenQuestion createOpenQuestion() {
    return new MathsOpenQuestion();
  }
}
