package com.ontotext.javacourse.reflection.validateemail;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidateEmailTest {

  @Test
  void validateEmailReturnsTrueWithCorrectInput() {
    assertTrue(ValidateEmail.validateEmail("myemail@abv.bg"));
  }

  @Test
  void validateEmailReturnsTrueWithDashAndDotInput() {
    assertTrue(ValidateEmail.validateEmail("test.t-s@sir-ma.com"));
  }

  @Test
  void validateEmailReturnsFalseWithIncorrectEmailInput() {
    assertFalse(ValidateEmail.validateEmail("123sd@abv.bg"));
  }
}
