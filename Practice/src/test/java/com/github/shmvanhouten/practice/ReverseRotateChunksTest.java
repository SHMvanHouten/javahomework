package com.github.shmvanhouten.practice;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ReverseRotateChunksTest {

    @Test
    public void itShouldRotateAChunk() throws Exception {
        ReverseRotateChunks scrambler = new ReverseRotateChunks();
        String expected = "2341";
        String actual = scrambler.rotateChunk("1234");
        assertThat(actual, is(expected));
    }

    @Test
    public void itShouldReverseAChunk() throws Exception {
        ReverseRotateChunks scrambler = new ReverseRotateChunks();
        String expected = "4321";
        String actual = scrambler.reverseChunk("1234");
        assertThat(actual, is(expected));
    }

    @Test
    public void itShouldDivideTheStringIntoChunks() throws Exception {
        ReverseRotateChunks scrambler = new ReverseRotateChunks();
        List<String> expected = Arrays.asList("123","456");
        List<String> actual = scrambler.divideStringIntoChunks("123456", 3);
        assertThat(actual, is(expected));
    }

    @Test
    public void itShouldScrambleChunksAccordingToTheirDivisibilityByTwo() throws Exception {
        ReverseRotateChunks scrambler = new ReverseRotateChunks();
        String expected = "351864";
        String actual = scrambler.scrambleString("135468", 3);
        assertThat(actual, is(expected));
    }
}