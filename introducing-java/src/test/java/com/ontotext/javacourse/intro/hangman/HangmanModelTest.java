package com.ontotext.javacourse.intro.hangman;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HangmanModelTest {

    private static HangmanModel MODEL = new HangmanModel();

    @AfterEach
    void tearDown() {
        MODEL = new HangmanModel();
    }

    @Test
    void makeGuessReturnsTrueIfGuessIsCorrect() {
        MODEL.setWord("chicken");
        assertTrue(MODEL.makeGuess('c'));
    }

    @Test
    void makeGuessReturnsFalseIfGuessIsIncorrect() {
        MODEL.setWord("chicken");
        assertFalse(MODEL.makeGuess('d'));
    }

    @Test
    void getMaskedWordReturnsCorrectStringWithGuessedLetters() {
        MODEL.setWord("chicken");
        MODEL.makeGuess('c');
        assertEquals("c _ _ c _ _ _", MODEL.getMaskedWord());
    }

    @Test
    void getMaskedWordReturnsCorrectStringWithNoGuessedLetters() {
        MODEL.setWord("chicken");
        assertEquals("_ _ _ _ _ _ _", MODEL.getMaskedWord());
    }

    @Test
    void isGameOverReturnsTrueIfGuessesAreZero() {
        MODEL.setGuessesLeft(0);
        assertTrue(MODEL.isGameOver());
    }

    @Test
    void isGameOverReturnsTrueIfWordIsGuessed() {
        MODEL.setWord("dog");
        MODEL.makeGuess('d');
        MODEL.makeGuess('o');
        MODEL.makeGuess('g');
        assertTrue(MODEL.isGameOver());
    }

    @Test
    void isGameOverReturnsFalseIfGameIsNotOver() {
        MODEL.setWord("banana");
        MODEL.setGuessesLeft(3);
        assertFalse(MODEL.isGameOver());
    }
}