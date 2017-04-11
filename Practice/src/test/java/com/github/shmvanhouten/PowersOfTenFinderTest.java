package com.github.shmvanhouten;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PowersOfTenFinderTest {
    @Test
    public void itShouldWriteOutEachPowerOfTenSeparately() throws Exception{
        PowersOfTenFinder finder = new PowersOfTenFinder();
        assertThat(finder.getStringOfWrittenOutPowersOfTen(12), is("10 + 2"));
        assertThat(finder.getStringOfWrittenOutPowersOfTen(132), is("100 + 30 + 2"));
    }
}