package com.github.shmvanhouten.practice.findTheLargestPossibleGap;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class LargestGapFinderTest {

    @Test
    public void itShouldIdentifyTheGapAsOne() throws Exception {
        LargestGapFinder finder = new LargestGapFinder();
        int[] array = {1,2};
        assertThat(finder.findLargestGap(array), is(1));
    }

    @Test
    public void itShouldIdentifyTheGapAsTwo() throws Exception {
        LargestGapFinder finder = new LargestGapFinder();
        int[] array = {1,2,3};
        assertThat(finder.findLargestGap(array), is(2));
    }

    @Test
    public void itShouldIdentifyTheGapAs3() throws Exception {
        LargestGapFinder finder = new LargestGapFinder();
        int[] array = {8,7,6,5,3,4,5};
        assertThat(finder.findLargestGap(array), is(3));
    }
}