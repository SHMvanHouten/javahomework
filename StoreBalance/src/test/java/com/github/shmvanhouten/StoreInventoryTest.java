package com.github.shmvanhouten;

import org.junit.Test;

import java.util.List;

import static java.time.LocalDate.of;
import static java.time.Month.APRIL;
import static java.time.Month.JUNE;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StoreInventoryTest {

    @Test
    public void itShouldAddANewProductToTheStoreInventory() throws Exception{
        StoreInventory inventory = new StoreInventory();
        inventory.addInventoryItem("tomatoSoup", of(2017,JUNE,29), 20);
        assertThat(inventory.getInventoryList().size(), is(1));
    }

    @Test
    public void itShouldChangeTheQuantityOfTheInventoryItemAndGetTheAmountOfThatProductOfThatExpirationDate(){
        StoreInventory inventory = new StoreInventory();
        inventory.addInventoryItem("tomatoSoup", of(2017,JUNE,29), 20);
        inventory.addInventoryItem("tomatoSoup", of(2017,JUNE,29), 15);
        assertThat(inventory.getProductOfExpiryDatesQuantity("tomatoSoup", of(2017,JUNE,29)), is(35));
    }

    @Test
    public void itShouldGetTheTotalAmountOfATypeOfProduct(){
        StoreInventory inventory = new StoreInventory();
        inventory.addInventoryItem("tomatoSoup", of(2017,JUNE,30), 20);
        inventory.addInventoryItem("tomatoSoup", of(2017,JUNE,29), 15);
        assertThat(inventory.getProductQuantity("tomatoSoup"), is(35));
    }

    @Test
    public void itShouldReturnAllProducts(){
        StoreInventory inventory = new StoreInventory();
        inventory.addInventoryItem("tomatoSoup", of(2017,JUNE,30), 20);
        inventory.addInventoryItem("tomatoSoup", of(2017,JUNE,29), 15);
        inventory.addInventoryItem("marsBars", of(2017,APRIL,20), 80);

        List<InventoryItem> items = inventory.getInventoryList();

        assertThat(items.get(0).getInventoryItemQuantity(), is(80));
        assertThat(items.get(0).getInventoryItemQuantity(), is(80));
    }

}
