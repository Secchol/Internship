package com.ontotext.javacourse.reflection.replacestrings;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReplaceStringsTest {

  @Test
  void replaceStringsWorksWithCorrectInput() {
    String input = "<x>sdofkwoefkwefkew</x>";
    String expectedOutput = "<x/>";
    assertEquals(expectedOutput, ReplaceStrings.replaceStrings(input));
  }

  @Test
  void replaceStringsWorksWithLongerString() {
    String input =
        "<x><b></b><x>Hello world</x> <b>sdsdsd</b><x>Good morning</x><x>69</x><x>sdsdsdsd</x></x>";
    String expectedOutput = "<x><b></b><x/> <b>sdsdsd</b><x/><x/><x/></x>";
    assertEquals(expectedOutput, ReplaceStrings.replaceStrings(input));
  }
}
