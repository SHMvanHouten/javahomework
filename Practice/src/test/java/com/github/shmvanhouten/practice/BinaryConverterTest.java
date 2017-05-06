package com.github.shmvanhouten.practice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BinaryConverterTest {

    @Test
    public void itShouldTranslateTheNumberFromBinaryToDecimal() throws Exception {
        BinaryConverter converter = new BinaryConverter();
        assertEquals(1, converter.convert(new ArrayList<>(Arrays.asList(0,0,0,1))));
        assertEquals(15, converter.convert(new ArrayList<>(Arrays.asList(1,1,1,1))));
        assertEquals(6, converter.convert(new ArrayList<>(Arrays.asList(0,1,1,0))));
        assertEquals(9, converter.convert(new ArrayList<>(Arrays.asList(1,0,0,1))));
    }
}