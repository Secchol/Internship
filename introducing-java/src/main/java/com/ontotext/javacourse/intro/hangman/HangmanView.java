package com.ontotext.javacourse.intro.hangman;

import java.util.Scanner;
import java.util.logging.Logger;
import lombok.Getter;
import lombok.Setter;

/** Defines the view for Hangman game. Controls the display options. */
@Getter
@Setter
public class HangmanView {
  private static final Scanner SCANNER = new Scanner(System.in);
  private static final Logger LOGGER = Logger.getLogger(HangmanView.class.getName());
  private HangmanModel model;

  public HangmanView(HangmanModel model) {
    setModel(model);
  }

  public HangmanModel getModel() {
    return this.model;
  }

  public void setModel(HangmanModel model) {
    this.model = model;
  }

  /** Displays the user's left attempts and the masked word on the screen. */
  public void showGameStatus() {
    LOGGER.info("Attempts left: " + getModel().getGuessesLeft());
    LOGGER.info("Masked word: " + getModel().getMaskedWord());
  }

  /**
   * Gets the user's guess character
   *
   * @return the user's guess character
   */
  public Character promptGuess() {
    LOGGER.info("Guess a letter: ");
    String guess = SCANNER.nextLine();
    while (true) {
      if (guess.length() != 1) {
        LOGGER.info("Please enter a single letter!");
        guess = SCANNER.nextLine();
      } else {
        return guess.charAt(0);
      }
    }
  }

  /**
   * Displays message of the user has guessed the word or if he has run out of attempts.
   *
   * @param guessedWord whether the user has guessed the word before running out of attempts
   */
  public void endStatus(boolean guessedWord) {
    if (guessedWord) {
      LOGGER.info("Congratulations! You guessed the word!");
    } else {
      LOGGER.info("Game over! The word was: " + getModel().getWord());
    }
    SCANNER.close();
  }

  /** Displays message on screen if the user guesses a correct letter. */
  public void displayCorrectGuess() {
    LOGGER.info("Correct guess!");
  }

  /** Displays message on screen if the user guesses an incorrect letter. */
  public void displayIncorrectGuess() {
    LOGGER.info("Incorrect guess!");
  }
}
