package com.ontotext.javacourse.intro.hangman;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/** Defines the controller for Hangman application. The controller starts the hangman game. */
@Getter
@Setter
@AllArgsConstructor
public class HangmanController {
  private HangmanModel model;
  private HangmanView view;

  /** Starts the hangman game and displays the end result. */
  public void startGame() {
    getView().showGameStatus();
    while (!model.isGameOver()) {
      char guess = getView().promptGuess();
      if (getModel().makeGuess(guess)) {
        getView().displayCorrectGuess();
        getView().showGameStatus();
      } else {
        getView().displayIncorrectGuess();
        getView().showGameStatus();
      }
    }

    getView().endStatus(model.getGuessesLeft() != 0);
  }
}
