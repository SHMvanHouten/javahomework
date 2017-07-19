package com.github.shmvanhouten.practice.PrimeFactorsFinder;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class PrimeFactorFinderTest {
    @Test
    public void itShouldFindThePrimeFactorsFor2() throws Exception {
        PrimeFactorFinder finder = new PrimeFactorFinder();
        assertThat(finder.getPrimeFactors(2), is(new int[]{2}));
    }
}