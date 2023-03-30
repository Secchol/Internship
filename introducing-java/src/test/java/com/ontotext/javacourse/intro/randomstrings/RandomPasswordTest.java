package com.ontotext.javacourse.intro.randomstrings;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class RandomPasswordTest {

    private final String VALIDCHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwqyz0123456789";

    @Test
    void generateRandomPasswordHasCorrectLength() {
        assertEquals(RandomPassword.generateRandomPassword(20).length(), 20);
    }

    @Test
    void generateRandomPasswordContainsOnlyValidCharacters() {
        String generatedPassword = RandomPassword.generateRandomPassword(20);
        boolean containsInvalidCharacters = false;
        for (char character : generatedPassword.toCharArray()) {
            if (VALIDCHARACTERS.indexOf(character) == -1) {
                containsInvalidCharacters = true;
            }
        }
        assertEquals(containsInvalidCharacters, false);
    }

    @Test
    void generateRandomPasswordWorksWithZeroInput() {
        assertEquals(RandomPassword.generateRandomPassword(0), "");
    }
}
