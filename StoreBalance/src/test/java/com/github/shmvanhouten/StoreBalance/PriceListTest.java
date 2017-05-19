package com.github.shmvanhouten.StoreBalance;

import com.github.shmvanhouten.StoreBalance.Money;
import com.github.shmvanhouten.StoreBalance.PriceList;
import org.junit.Test;


import static com.github.shmvanhouten.StoreBalance.Currency.EUR;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PriceListTest {

    @Test
    public void itShouldAddThePriceOfTomatoSoup () throws Exception{
        PriceList priceList = new PriceList();
        Money tomatoSoupPrice = new Money("2.50", EUR);
        priceList.inputPrice("tomatoSoup", tomatoSoupPrice);
        assertThat(priceList.getPrice("tomatoSoup"), is(tomatoSoupPrice));
    }

    @Test
    public void itShouldAddADifferentPriceOfTomatoSoup () throws Exception{
        PriceList priceList = new PriceList();
        Money tomatoSoupPrice = new Money("2.30", EUR);
        priceList.inputPrice("tomatoSoup", tomatoSoupPrice);
        assertThat(priceList.getPrice("tomatoSoup"), is(tomatoSoupPrice));
    }

    @Test
    public void itShouldReturnTheSecondAddedPriceForTomatoSoup() throws Exception{
        PriceList priceList = new PriceList();
        Money tomatoSoupPrice = new Money("2.30", EUR);
        Money newTomatoSoupPrice = new Money("2.25", EUR);
        Money beansPrice = new Money("1.50", EUR);
        priceList.inputPrice("tomatoSoup", tomatoSoupPrice);
        priceList.inputPrice("tomatoSoup", newTomatoSoupPrice);
        priceList.inputPrice("beans", beansPrice);
        assertThat(priceList.getPrice("tomatoSoup"), is(newTomatoSoupPrice));
        assertThat(priceList.getPrice("beans"), is(beansPrice));
    }

}
