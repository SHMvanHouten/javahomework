package com.github.shmvanhouten;

import org.junit.Test;


import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PotterKataTest {

    @Test
    public void itShouldGiveThePrice() throws Exception {
        PotterKata calculator = new PotterKata();
        Map<Integer, Integer> input = new HashMap<>();
        input.put(1,1);
        assertThat(calculator.getTotalPrice(input), is(8));
    }
}