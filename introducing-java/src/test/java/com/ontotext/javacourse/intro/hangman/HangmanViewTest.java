package com.ontotext.javacourse.intro.hangman;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class HangmanViewTest {

    private HangmanModel MODEL = new HangmanModel();
    private HangmanView VIEW = new HangmanView(MODEL);

    @Test
    void getModelReturnsModel() {
        assertEquals(VIEW.getModel(), MODEL);
    }

    @Test
    void setModelSetsViewModel() {
        VIEW.setModel(MODEL);
        assertEquals(VIEW.getModel(), MODEL);
    }

}