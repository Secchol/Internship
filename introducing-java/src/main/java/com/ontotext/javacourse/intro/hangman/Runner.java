package com.ontotext.javacourse.intro.hangman;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args){

        HangmanModel model = new HangmanModel();
        HangmanView view = new HangmanView(model);
        HangmanController controller = new HangmanController(model, view);
        controller.startGame();
    }
}
