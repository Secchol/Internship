package com.ontotext.javacourse.intro.randomstrings;

/**
 * The RandomPassword class contains a method which generates a random password with given length
 */
public final class RandomPassword {

    private RandomPassword() throws IllegalAccessException {
        throw new IllegalAccessException("RandomPassword class is not meant to be instantiated");
    }

    /**
     * Generates a random password with a given length that contains only digits, lowercase and uppercase letters
     * @param passwordLength the length of the password to generated
     * @return the generated password
     */
    public static String generateRandomPassword(int passwordLength) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwqyz0123456789";
        StringBuilder randomPassword = new StringBuilder(passwordLength);
        for (int i = 1; i <= passwordLength; i++) {
            int randomIndex = Math.abs(characters.length() - 1 - Integer.parseInt(String.valueOf(Math.random()).substring(2, 4)));
            Character randomChar = characters.charAt(randomIndex);
            randomPassword.append(randomChar);
        }
        return randomPassword.toString();
    }
}
