package com.github.shmvanhouten.practice.PrimeFactorsFinder;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class PrimeFactorFinderTest {
    @Test
    public void itShouldFindThePrimeFactorsFor2() throws Exception {
        PrimeFactorFinder finder = new PrimeFactorFinder();
        Map<Long, Integer> factorsExpected = new HashMap<>();
        factorsExpected.put(2L, 1);
        assertThat(finder.getPrimeFactors(2), is(factorsExpected));
    }

    @Test
    public void itShouldFindThePrimeFactorsFor3() throws Exception {
        PrimeFactorFinder finder = new PrimeFactorFinder();
        Map<Long, Integer> factorsExpected = new HashMap<>();
        factorsExpected.put(3L, 1);
        assertThat(finder.getPrimeFactors(3), is(factorsExpected));
    }

    @Test
    public void itShouldFindThePrimeFactorsFor4() throws Exception {
        PrimeFactorFinder finder = new PrimeFactorFinder();
        Map<Long, Integer> factorsExpected = new HashMap<>();
        factorsExpected.put(2L, 2);
        assertThat(finder.getPrimeFactors(4), is(factorsExpected));
    }

    @Test
    public void itShouldFindThePrimeFactorsFor255() throws Exception {
        PrimeFactorFinder finder = new PrimeFactorFinder();
        Map<Long, Integer> factorsExpected = new HashMap<>();
        factorsExpected.put(3L, 1);
        factorsExpected.put(5L, 1);
        factorsExpected.put(17L, 1);
        assertThat(finder.getPrimeFactors(255), is(factorsExpected));
    }
}