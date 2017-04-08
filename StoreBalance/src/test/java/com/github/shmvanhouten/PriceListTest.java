package com.github.shmvanhouten;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PriceListTest {
    @Test
    public void itShouldAddThePriceOfTomatoSoup () throws Exception{
        PriceList priceList = new PriceList();
        BigDecimal tomatoSoupPrice = new BigDecimal("2.50");
        priceList.inputPrice("tomatoSoup", tomatoSoupPrice);
        assertThat(priceList.getPrice("tomatoSoup"), is(tomatoSoupPrice));
    }
    @Test
    public void itShouldAddADifferentPriceOfTomatoSoup () throws Exception{
        PriceList priceList = new PriceList();
        BigDecimal tomatoSoupPrice = new BigDecimal("2.30");
        priceList.inputPrice("tomatoSoup", tomatoSoupPrice);
        assertThat(priceList.getPrice("tomatoSoup"), is(tomatoSoupPrice));
    }
    @Test
    public void itShouldReturnTheSecondAddedPriceForTomatoSoup() throws Exception{
        PriceList priceList = new PriceList();
        BigDecimal tomatoSoupPrice = new BigDecimal("2.30");
        BigDecimal newTomatoSoupPrice = new BigDecimal("2.25");
        priceList.inputPrice("tomatoSoup", tomatoSoupPrice);
        priceList.inputPrice("tomatoSoup", newTomatoSoupPrice);
        assertThat(priceList.getPrice("tomatoSoup"), is(newTomatoSoupPrice));
    }
}
