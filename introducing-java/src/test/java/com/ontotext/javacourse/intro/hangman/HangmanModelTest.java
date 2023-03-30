package com.ontotext.javacourse.intro.hangman;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class HangmanModelTest {

    private HangmanModel MODEL = new HangmanModel();

    @AfterEach
    void tearDown() {
        MODEL = new HangmanModel();
    }

    @Test
    void getWordWorksWithCorrectInput() {
        MODEL.setWord("car");
        assertEquals(MODEL.getWord(), "car");
    }

    @Test
    void setWordWorksWithCorrectInput() {
        MODEL.setWord("dog");
        assertEquals(MODEL.getWord(), "dog");
    }

    @Test
    void setGuessesLeftWorksWithCorrectInput() {
        MODEL.setGuessesLeft(2);
        assertEquals(MODEL.getGuessesLeft(), 2);
    }

    @Test
    void getGuessesLeftHasCorrectInitialValue() {
        assertEquals(MODEL.getGuessesLeft(), 5);
    }

    @Test
    void makeGuessReturnsTrueIfGuessIsCorrect() {
        MODEL.setWord("chicken");
        assertEquals(MODEL.makeGuess('c'), true);
    }

    @Test
    void makeGuessReturnsFalseIfGuessIsIncorrect() {
        MODEL.setWord("chicken");
        assertEquals(MODEL.makeGuess('d'), false);
    }

    @Test
    void getMaskedWordReturnsCorrectStringWithGuessedLetters() {
        MODEL.setWord("chicken");
        MODEL.makeGuess('c');
        assertEquals(MODEL.getMaskedWord(), "c _ _ c _ _ _");
    }

    @Test
    void getMaskedWordReturnsCorrectStringWithNoGuessedLetters() {
        MODEL.setWord("chicken");
        assertEquals(MODEL.getMaskedWord(), "_ _ _ _ _ _ _");
    }

    @Test
    void isGameOverReturnsTrueIfGuessesAreZero() {
        MODEL.setGuessesLeft(0);
        assertEquals(MODEL.isGameOver(), true);
    }

    @Test
    void isGameOverReturnsTrueIfWordIsGuessed() {
        MODEL.setWord("dog");
        MODEL.makeGuess('d');
        MODEL.makeGuess('o');
        MODEL.makeGuess('g');
        assertEquals(MODEL.isGameOver(), true);
    }

    @Test
    void isGameOverReturnsFalseIfGameIsNotOver() {
        MODEL.setWord("banana");
        MODEL.setGuessesLeft(3);
        assertEquals(MODEL.isGameOver(), false);
    }
}