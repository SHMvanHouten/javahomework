package com.github.shmvanhouten.practice.binarycomparer;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class IntToBinaryConverterTest {

    @Test
    public void itShouldConvertTheIntToBinaries() throws Exception {
        IntToBinaryConverter converter = new IntToBinaryConverter();
        List<Integer> expectedBinary = Arrays.asList(0,0,0,0,0,0,0,1);
        assertThat(converter.convertIntegerToBinary(1), is(expectedBinary));
    }

    @Test
    public void itShouldAlsoConvertTheIntToBinaries() throws Exception {
        IntToBinaryConverter converter = new IntToBinaryConverter();
        List<Integer> expectedBinary = Arrays.asList(1,0,0,0,0,0,0,1);
        assertThat(converter.convertIntegerToBinary(129), is(expectedBinary));
    }

    @Test
    public void itShouldAlsoConvertThisIntToBinaries() throws Exception {
        IntToBinaryConverter converter = new IntToBinaryConverter();
        List<Integer> expectedBinary = Arrays.asList(0,0,0,0,1,0,0,1);
        assertThat(converter.convertIntegerToBinary(9), is(expectedBinary));
    }

}