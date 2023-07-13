package com.ontotext.javacourse.reflection.utilityclasses;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import lombok.*;

/**
 * The ClassInfo class holds information about a given class like its class name, fields,
 * methods,parent class,interfaces,private method result and private field result.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClassInfo {

  private String className;
  private Field[] fields;

  private Method[] methods;

  private Class<?> parentClass;

  private Class<?>[] interfaces;

  private Object privateMethodResult;

  private Object privateFieldResult;
}
