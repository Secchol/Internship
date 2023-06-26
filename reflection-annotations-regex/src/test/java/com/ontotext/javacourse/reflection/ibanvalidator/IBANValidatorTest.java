package com.ontotext.javacourse.reflection.ibanvalidator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IBANValidatorTest {

  @Test
  void validateIBANWorksWithFormattedInput() {
    String input = "<iban>BG80 BNBG 9661 1020 3456 78<iban>";
    String expectedOutput = "<iban>****<iban>";
    assertEquals(expectedOutput, IBANValidator.validateIBAN(input));
  }

  @Test
  void validateIBANWorksWithNonFormattedInput() {
    String input = "<iban>BG80BNBG96611020345678<iban>";
    String expectedOutput = "<iban>****<iban>";
    assertEquals(expectedOutput, IBANValidator.validateIBAN(input));
  }

  @Test
  void validateIBANReplacesOnlyValidIBAN() {
    String input =
        "<iban>BG80TPYF9661112334567812<iban><iban>NL45RABO4880983179<iban><iban>IS436626447472266645126642<iban>";
    String expectedOutput =
        "<iban>****12<iban><iban>NL45RABO4880983179<iban><iban>IS436626447472266645126642<iban>";
    assertEquals(expectedOutput, IBANValidator.validateIBAN(input));
  }
}
