package com.ontotext.javacourse.inputoutput.serialization;

import com.ontotext.javacourse.reflection.animals.Dog;
import java.io.Serial;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/** Defines a serializable object which contains some serializable data fields. */
@Getter
@Setter
@AllArgsConstructor
public class UserDefinedObject implements Serializable {
  @Serial private static final long serialVersionUID = 1L;
  private int intValue;
  private String stringValue;
  private Dog dog;

  @Override
  public boolean equals(Object o) {
    UserDefinedObject instance = (UserDefinedObject) o;
    return this.intValue == instance.intValue
        && this.stringValue.equals(instance.stringValue)
        && this.dog.getName().equals(instance.getDog().getName())
        && this.dog.getAge() == instance.getDog().getAge()
        && this.dog.getWeight() == instance.getDog().getWeight();
  }
}
