package com.github.shmvanhouten;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PriceListTest {
    @Test
    public void itShouldAddThePriceOfTomatoSoup () throws Exception{
        PriceList priceList = new PriceList();
        priceList.inputPrice("tomatoSoup", 2.50);
        assertThat(priceList.getPrice("tomatoSoup"), is(2.50));
    }
}
