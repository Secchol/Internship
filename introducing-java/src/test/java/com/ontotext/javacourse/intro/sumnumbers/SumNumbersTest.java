package com.ontotext.javacourse.intro.sumnumbers;

import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SumNumbersTest {

    @Test
    void sumWorksWithEqualLengthNumbersInput() {
        assertEquals(SumNumbers.sum("157", "888"), "1045");
    }

    @Test
    void sumWorksWithDifferentLengthNumbersInput() {
        assertEquals(SumNumbers.sum("15787423", "888"), "15788311");
    }

    @Test
    void sumWorksWithLongNumbersInput() {
        assertEquals(SumNumbers.sum("157874231311123", "123345324532523"), "281219555843646");
    }

    @Test
    void sumWorksWithEmptyZeroInput() {
        assertEquals(SumNumbers.sum("0", "0"), "0");
    }

    @Test
    void sumWorksThrowsExceptionWithEmptyStringInput() {
        assertThrows(InvalidParameterException.class, () -> SumNumbers.sum("", "123"));
    }
}