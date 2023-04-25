package com.ontotext.javacourse.intro.randomstrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class RandomPasswordTest {

    private static final String VALID_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwqyz0123456789";

    @Test
    void generateRandomPasswordHasCorrectLength() {
        assertEquals(20, RandomPassword.generateRandomPassword(20).length());
    }

    @Test
    void generateRandomPasswordContainsOnlyValidCharacters() {
        String generatedPassword = RandomPassword.generateRandomPassword(20);
        boolean containsInvalidCharacters = false;
        for (char character : generatedPassword.toCharArray()) {
            if (VALID_CHARACTERS.indexOf(character) == -1) {
                containsInvalidCharacters = true;
                break;
            }
        }
        assertFalse(containsInvalidCharacters);
    }

    @Test
    void generateRandomPasswordWorksWithZeroInput() {
        assertEquals("", RandomPassword.generateRandomPassword(0));
    }
}
