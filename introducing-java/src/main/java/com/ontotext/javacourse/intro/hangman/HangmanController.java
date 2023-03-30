package com.ontotext.javacourse.intro.hangman;

public class HangmanController {
    private HangmanModel model;
    private HangmanView view;

    /**
     * Sets the hangman model and hangman view to the given input
     * @param model hangman model
     * @param view hangman view
     */
    public HangmanController(HangmanModel model, HangmanView view) {
        setModel(model);
        setView(view);
    }

    /**
     * @return the hangman model
     */
    public HangmanModel getModel() {
        return this.model;
    }

    /**
     * @param model the hangman model
     */
    public void setModel(HangmanModel model) {
        this.model = model;
    }

    /**
     * @return the hangman view
     */
    public HangmanView getView() {
        return this.view;
    }

    /**
     * @param view the hangman view
     */
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
