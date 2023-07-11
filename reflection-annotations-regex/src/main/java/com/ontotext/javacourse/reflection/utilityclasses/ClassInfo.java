package com.ontotext.javacourse.reflection.utilityclasses;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClassInfo {

  private String className;
  private Field[] fields;

  private Method[] methods;

  private Class<?> parentClass;

  private Class<?>[] interfaces;

  private Object privateMethodResult;

  private Object privateFieldResult;
}
