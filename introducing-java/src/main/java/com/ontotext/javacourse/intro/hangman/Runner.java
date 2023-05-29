package com.ontotext.javacourse.intro.hangman;

/**
 * Sets up model, view and controller and triggers the start of the Hangman game.
 */
public class Runner {
  public static void main(String[] args) {
    HangmanModel model = new HangmanModel();
    HangmanView view = new HangmanView(model);
    HangmanController controller = new HangmanController(model, view);
    controller.startGame();
  }
}
