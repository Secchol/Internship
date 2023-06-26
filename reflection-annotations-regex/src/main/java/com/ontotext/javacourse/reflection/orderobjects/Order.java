package com.ontotext.javacourse.reflection.orderobjects;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** Defines an annotation which holds information about class sorting position. */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Order {
  /**
   * The class order value.
   *
   * @return the class order value.
   */
  int value() default 0;
}
