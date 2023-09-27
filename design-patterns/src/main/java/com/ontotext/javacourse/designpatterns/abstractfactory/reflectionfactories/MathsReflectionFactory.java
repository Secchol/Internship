package com.ontotext.javacourse.designpatterns.abstractfactory.reflectionfactories;

import com.ontotext.javacourse.designpatterns.abstractfactory.multiplechoicequestions.MathsMultipleChoiceQuestion;
import com.ontotext.javacourse.designpatterns.abstractfactory.multiplechoicequestions.MultipleChoiceQuestion;
import com.ontotext.javacourse.designpatterns.abstractfactory.openquestions.MathsOpenQuestion;
import com.ontotext.javacourse.designpatterns.abstractfactory.openquestions.OpenQuestion;
import java.lang.reflect.InvocationTargetException;

/**
 * The MathsReflectionFactory class contains method that create a multiple choice maths question and
 * an open answer maths question.
 */
public class MathsReflectionFactory implements QuestionReflectionFactory {
  @Override
  public MultipleChoiceQuestion createMultipleChoiceQuestionInstance(String className)
      throws ClassNotFoundException,
          InvocationTargetException,
          InstantiationException,
          IllegalAccessException,
          NoSuchMethodException {
    Object instance = ClassInstantiator.createInstance(className);
    if (!(instance instanceof MathsMultipleChoiceQuestion)) {
      throw new IllegalArgumentException("Class is not compatible with this factory");
    }
    return (MultipleChoiceQuestion) instance;
  }

  @Override
  public OpenQuestion createOpenQuestionInstance(String className)
      throws ClassNotFoundException,
          InvocationTargetException,
          InstantiationException,
          IllegalAccessException,
          NoSuchMethodException {
    Object instance = ClassInstantiator.createInstance(className);
    if (!(instance instanceof MathsOpenQuestion)) {
      throw new IllegalArgumentException("Class is not compatible with this factory");
    }
    return (OpenQuestion) instance;
  }
}
