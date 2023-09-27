package com.ontotext.javacourse.designpatterns.abstractfactory.reflectionfactories;

import com.ontotext.javacourse.designpatterns.abstractfactory.multiplechoicequestions.HistoryMultipleChoiceQuestion;
import com.ontotext.javacourse.designpatterns.abstractfactory.multiplechoicequestions.MultipleChoiceQuestion;
import com.ontotext.javacourse.designpatterns.abstractfactory.openquestions.HistoryOpenQuestion;
import com.ontotext.javacourse.designpatterns.abstractfactory.openquestions.OpenQuestion;
import java.lang.reflect.InvocationTargetException;

/**
 * The HistoryReflectionFactory class contains method that create a multiple choice history question
 * and an open answer history question.
 */
public class HistoryReflectionFactory implements QuestionReflectionFactory {
  @Override
  public MultipleChoiceQuestion createMultipleChoiceQuestionInstance(String className)
      throws ClassNotFoundException,
          InvocationTargetException,
          InstantiationException,
          IllegalAccessException,
          NoSuchMethodException {
    Object instance = ClassInstantiator.createInstance(className);
    if (!(instance instanceof HistoryMultipleChoiceQuestion)) {
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
    if (!(instance instanceof HistoryOpenQuestion)) {
      throw new IllegalArgumentException("Class is not compatible with this factory");
    }
    return (OpenQuestion) instance;
  }
}
