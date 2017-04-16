package com.github.shmvanhouten;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PrimeFactorsTest {

    @Test
    public void itShouldGiveOutput2ForInput2() throws Exception {
        List<Integer> resultList = new ArrayList<>();
        resultList.add(2);
        assertThat(PrimeFactors.getPrimeFactors(2), is(resultList));
    }

    @Test
    public void itShouldGiveOutPut3ForInput3() throws Exception {
        List<Integer> resultList = new ArrayList<>();
        resultList.add(3);
        assertThat(PrimeFactors.getPrimeFactors(3),is(resultList));
    }

    @Test
    public void itShouldGiveOutput2and2ForInput4() throws Exception {
        List<Integer> resultList = new ArrayList<>();
        resultList.add(2);
        resultList.add(2);
        assertThat(PrimeFactors.getPrimeFactors(4),is(resultList));
    }

    @Test
    public void itShouldGiveOutPut2and3ForInput6() throws Exception {
        List<Integer> resultList = new ArrayList<>();
        resultList.add(2);
        resultList.add(3);
        assertThat(PrimeFactors.getPrimeFactors(6), is(resultList));
    }

    @Test
    public void itShouldGiveCorrectOutputForLargeInput() throws Exception {
        List<Integer> resultList = new ArrayList<>();
        int[] addThis = {2, 2, 2, 2, 2, 5, 7, 7, 11};
        for (Integer prime : addThis) {
            resultList.add(prime);
        }
        assertThat(PrimeFactors.getPrimeFactors(86240),is(resultList));
    }

    @Test
    public void itShouldGive86243For86243() throws Exception {
        List<Integer> resultList = new ArrayList<>();
        resultList.add(86243);
        assertThat(PrimeFactors.getPrimeFactors(86243),is(resultList));
    }

    @Test
    public void itShouldReturnAStringWithTheAmountOfTimesEachPrimeIsUsedInTheProduct() throws Exception {
        assertThat(PrimeFactors.getPrimeFactorsString(86240),is("(2**5)(5)(7**2)(11)"));
    }

    @Test
    public void itShouldReturnAStringWithTheAmountOfTimesEachPrimeIsUsedInTheProduct2() throws Exception {
        assertThat(PrimeFactors.getPrimeFactorsString(7775460),is("(2**2)(3**3)(5)(7)(11**2)(17)"));
    }
}