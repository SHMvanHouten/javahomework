package com.github.shmvanhouten.practice.binarycomparer;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

//Kata: create a method that tells how many bits need to be converted to get from one int to another.

public class BinaryComparerTest {

    @Test
    public void itShouldCompareTheIntegersBinaryValues() throws Exception {
        BinaryComparer comparer = new BinaryComparer(new IntToBinaryConverter());
        assertThat(comparer.getAmountOfBitsToConvert(1,2), is(2));
    }

    @Test
    public void itShouldSayTheAmountOfBitsThatNeedToBeChangedIs1() throws Exception {
        BinaryComparer comparer = new BinaryComparer(new IntToBinaryConverter());
        assertThat(comparer.getAmountOfBitsToConvert(1,3), is(1));
    }

    @Test
    public void itShouldSayTheAmountOfBitsThatNeedToBeChangedIs0() throws Exception {
        BinaryComparer comparer = new BinaryComparer(new IntToBinaryConverter());
        assertThat(comparer.getAmountOfBitsToConvert(1,1), is(0));
    }
}