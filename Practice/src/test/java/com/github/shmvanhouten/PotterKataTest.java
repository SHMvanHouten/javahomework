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
        assertThat("one of book 1 == 8 eur",calculator.getTotalPrice(input), is("8.00 eur"));

        input.clear();
        input.put(2,2);
        assertThat("two of book 2 == 16 eur",calculator.getTotalPrice(input), is("16.00 eur"));

        input.clear();
        input.put(3,3);
        assertThat("three of book 3 == 24 eur",calculator.getTotalPrice(input), is("24.00 eur"));
    }

    @Test
    public void itShouldGiveThePriceWithAppropriateDiscount() throws Exception {
        PotterKata calculator = new PotterKata();
        Map<Integer, Integer> input = new HashMap<>();

        input.put(1,1);
        input.put(2,1);
        String reason = "one of book 1 and 1 of book 2 == 16 * 0.95";
        assertThat(reason, calculator.getTotalPrice(input), is("15.20 eur"));

    }

    @Test
    public void itShouldGive20PercentDiscountForFourBooks() throws Exception {
        PotterKata calculator = new PotterKata();
        Map<Integer, Integer> input = new HashMap<>();

        input.put(1,1);
        input.put(2,1);
        input.put(3,1);
        input.put(4,1);
        String reason2 = "one of book 1, 2, 3 and 4 == 32 * 0.80";
        assertThat(reason2, calculator.getTotalPrice(input), is("25.60 eur"));
    }
}