package com.ontotext.javacourse.intro.hangman;

import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Logger;

public class HangmanModel {

    private final String[] WORDS = new String[]{"elephant", "giraffe", "hangman", "mathematics", "lollipop"};
    private int guessesLeft;
    private ArrayList<Character> charsGuessed;
    private String word;

    /**
     * Sets the hidden word, initializes characters guessed arrayList and sets the attempts count to 5.
     */
    public HangmanModel() {
        Random random = new Random();
        setWord(WORDS[random.nextInt(WORDS.length)]);
        setGuessesLeft(5);
        charsGuessed = new ArrayList<>();
    }

    /**
     * @return the hidden word
     */
    public String getWord() {
        return word;
    }

    /**
     * @param word value to set the word attribute to
     */
    public void setWord(String word) {
        this.word = word;
    }

    /**
     * @return returns the user's left guesses
     */
    public int getGuessesLeft() {
        return guessesLeft;
    }

    /**
     * @param guessesLeft guesses left
     */
    public void setGuessesLeft(int guessesLeft) {
        this.guessesLeft = guessesLeft;
    }

    /**
     * Makes guess with a given character. If hidden word contains the character it is added to the guessed letters else
     * the user's guesses are lowered by one.
     * @param character the user's guess character
     * @return whether the user's guess was correct
     */
    public boolean makeGuess(char character) {
        if (word.indexOf(character) != -1) {
            charsGuessed.add(character);
        } else {
            guessesLeft--;
        }
        return word.indexOf(character) != -1;
    }

    /**
     * Returns the masked word. The masked word shows the users guessed letters and underscore for the letters that
     * have not been guessed yet.
     * @return the masked word
     */
    public String getMaskedWord() {
        StringBuilder maskedWord = new StringBuilder();
        char[] wordCharacters = this.word.toCharArray();
        for (int i = 0; i < wordCharacters.length; i++) {
            char currentChar = wordCharacters[i];
            if (charsGuessed.contains(currentChar)) {
                maskedWord.append(currentChar);
            } else {
                maskedWord.append("_");
            }
            maskedWord.append(" ");
        }
        return maskedWord.toString().trim();
    }

    /**
     * Checks whether the game is over. The game ends when the user has run out of guesses or has guessed all
     * the letters of the hidden word.
     * @return a boolean indicating whether the game is over
     */
    public boolean isGameOver() {
        StringBuilder currentWordState = new StringBuilder();
        String[] maskedWord = getMaskedWord().split(" ");
        for (String character : maskedWord) {
            currentWordState.append(character);
        }
        return getGuessesLeft() == 0 || getWord().equals(currentWordState.toString());
    }

}
