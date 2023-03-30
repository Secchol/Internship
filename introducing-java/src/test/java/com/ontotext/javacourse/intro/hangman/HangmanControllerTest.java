package com.ontotext.javacourse.intro.hangman;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class HangmanControllerTest {

    private HangmanModel MODEL = new HangmanModel();
    private HangmanView VIEW = new HangmanView(MODEL);

    private HangmanController CONTROLLER = new HangmanController(MODEL, VIEW);

    @Test
    void getModelReturnsControllerModel() {
        assertEquals(CONTROLLER.getModel(), MODEL);
    }

    @Test
    void setModelSetsControllerModel() {
        CONTROLLER.setModel(MODEL);
        assertEquals(CONTROLLER.getModel(), MODEL);
    }

    @Test
    void getViewReturnsControllerView() {
        assertEquals(CONTROLLER.getView(), VIEW);
    }

    @Test
    void setViewSetsControllerView() {
        CONTROLLER.setView(VIEW);
        assertEquals(CONTROLLER.getView(), VIEW);
    }

}