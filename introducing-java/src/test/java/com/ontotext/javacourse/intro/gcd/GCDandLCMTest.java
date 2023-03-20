package com.ontotext.javacourse.intro.gcd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GCDandLCMTest {
    void findGCDMethodWorksWithCorrectInput() {
        assertEquals(GCDandLCM.findGCD(12,36),12);
    }
    @Test
    void findGCDMethodWorksWithZeroAsParam() {
        assertEquals(GCDandLCM.findGCD(10,0),10);
    }

    @Test
    void findGCDMethodWorksWithNegativeInput() {
        assertEquals(GCDandLCM.findGCD(-10,-20),-10);
    }

    @Test
    void findLCMMethodWorksWithCorrectInput() {
        assertEquals(GCDandLCM.findLCM(20,30),60);
    }

    @Test
    void findLCMMethodThrowsExceptionWithZeroAsInput() {
        assertThrows(IllegalArgumentException.class,()-> GCDandLCM.findLCM(0,30));
    }
    @Test
    void findLCMMethodWorksWithNegativeInput() {
        assertEquals(GCDandLCM.findLCM(-10,-20),-20);
    }
}