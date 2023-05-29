package com.ontotext.javacourse.intro.hangman;

import java.util.ArrayList;
import java.util.Random;

/**
 * Defines the model for Hangman game. Contains the business logic.
 */
public class HangmanModel {
  private final ArrayList<Character> charsGuessed;
  private int guessesLeft;
  private String word;

  /**
   * Sets the hidden word, initializes characters guessed arrayList and sets the attempts count to
   * 5.
   */
  public HangmanModel() {
    String[] words = new String[] {"elephant", "giraffe", "hangman", "mathematics", "lollipop"};
    Random random = new Random();
    setWord(words[random.nextInt(words.length)]);
    setGuessesLeft(5);
    charsGuessed = new ArrayList<>();
  }

  public String getWord() {
    return word;
  }

  public void setWord(String word) {
    this.word = word;
  }

  public int getGuessesLeft() {
    return guessesLeft;
  }

  public void setGuessesLeft(int guessesLeft) {
    this.guessesLeft = guessesLeft;
  }

  /**
   * Makes guess with a given character. If hidden word contains the character it is added to the
   * guessed letters else the user's guesses are lowered by one.
   *
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
   * Returns the masked word. The masked word shows the users guessed letters and underscore for the
   * letters that have not been guessed yet.
   *
   * @return the masked word
   */
  public String getMaskedWord() {
    StringBuilder maskedWord = new StringBuilder();
    char[] wordCharacters = this.word.toCharArray();
    for (char character : wordCharacters) {
      if (charsGuessed.contains(character)) {
        maskedWord.append(character);
      } else {
        maskedWord.append("_");
      }
      maskedWord.append(" ");
    }
    return maskedWord.toString().trim();
  }

  /**
   * Checks whether the game is over. The game ends when the user has run out of guesses or has
   * guessed all the letters of the hidden word.
   *
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
