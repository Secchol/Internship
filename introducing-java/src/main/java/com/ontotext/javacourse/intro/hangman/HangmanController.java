package com.ontotext.javacourse.intro.hangman;

public class HangmanController {
    private HangmanModel model;
    private HangmanView view;

    public HangmanController(HangmanModel model, HangmanView view) {
        setModel(model);
        setView(view);
    }

    public HangmanModel getModel() {
        return this.model;
    }

    public void setModel(HangmanModel model) {
        this.model = model;
    }

    public HangmanView getView() {
        return this.view;
    }

    public void setView(HangmanView view) {
        this.view = view;
    }

    /**
     * Starts the hangman game and displays the end result
     */
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
