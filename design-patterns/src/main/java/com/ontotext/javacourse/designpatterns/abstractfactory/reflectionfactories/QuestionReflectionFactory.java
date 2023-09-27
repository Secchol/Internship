package com.ontotext.javacourse.designpatterns.abstractfactory.reflectionfactories;

import com.ontotext.javacourse.designpatterns.abstractfactory.multiplechoicequestions.MultipleChoiceQuestion;
import com.ontotext.javacourse.designpatterns.abstractfactory.openquestions.OpenQuestion;
import java.lang.reflect.InvocationTargetException;

/**
 * Defines a factory that creates multiple choice question and open question instances using
 * reflection.
 */
public interface QuestionReflectionFactory {
  MultipleChoiceQuestion createMultipleChoiceQuestionInstance(String className)
      throws ClassNotFoundException,
          InvocationTargetException,
          InstantiationException,
          IllegalAccessException,
          NoSuchMethodException;

  OpenQuestion createOpenQuestionInstance(String className) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException;
}
