package com.ontotext.javacourse.intro.sumnumbers;

import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SumNumbersTest {

    @Test
    void sumWorksWithEqualLengthNumbersInput() {
        assertEquals("1045", SumNumbers.sum("157", "888"));
    }

    @Test
    void sumWorksWithDifferentLengthNumbersInput() {
        assertEquals("15788311", SumNumbers.sum("15787423", "888"));
    }

    @Test
    void sumWorksWithLongNumbersInput() {
        assertEquals("281219555843646", SumNumbers.sum("157874231311123", "123345324532523"));
    }

    @Test
    void sumWorksWithEmptyZeroInput() {
        assertEquals("0", SumNumbers.sum("0", "0"));
    }

    @Test
    void sumWorksThrowsExceptionWithEmptyStringInput() {
        assertThrows(InvalidParameterException.class, () -> SumNumbers.sum("", "123"));
    }

    @Test
    void sumWorksWithTrailingZeroesNumberInput() {
        assertEquals("99999", SumNumbers.sum("99999", "000000000"));
        assertEquals("100000",SumNumbers.sum("99999","000000001"));
    }
}