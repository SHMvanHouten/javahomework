package com.github.shmvanhouten;

import org.junit.Test;

import static java.time.LocalDate.of;
import static java.time.Month.APRIL;
import static java.time.Month.JUNE;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class InventoryItemTest {

    @Test
    public void itShouldGetTheAmountOfCansOfTomatoSoupOfACertainDate() throws Exception{
        Product product = new Product("tomatoSoup", of(2017, APRIL, 10));
        InventoryItem tomatoSoup = new InventoryItem(product, 15);
        assertThat(tomatoSoup.getInventoryItemQuantity(),is(15));
    }

    @Test
    public void itShouldAddAQuantityOfSixToTheInventoryItem() throws Exception{
        Product product = new Product("tomatoSoup", of(2017,APRIL,10));
        InventoryItem tomatoSoup = new InventoryItem(product, 15);
        tomatoSoup.addToQuantity(6);
        assertThat(tomatoSoup.getInventoryItemQuantity(), is(21));
    }
}
