package com.github.shmvanhouten;

import org.junit.Ignore;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
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
        assertThat(inventory.getProductTotalQuantity("tomatoSoup"), is(35));
    }

    @Test
    public void itShouldReturnAllProducts(){
        StoreInventory inventory = new StoreInventory();
        inventory.addInventoryItem("tomatoSoup", of(2017,JUNE,30), 20);
        inventory.addInventoryItem("tomatoSoup", of(2017,JUNE,29), 15);
        inventory.addInventoryItem("marsBars", of(2017,APRIL,20), 80);

        List<InventoryItem> items = inventory.getInventoryList();

        assertThat(items.get(0).getInventoryItemQuantity(), is(80));
        assertThat(items.get(0).getProduct().getName(), is("marsBars"));
        assertThat(items.get(1).getProduct().getName(), is("tomatoSoup"));
        printInventoryItems(items);
        printProducts(items);
    }

    @Test
    public void itShouldGiveTheTotalValueOfTheProductsWithThatExpirationDate() throws Exception{
        StoreInventory inventory = new StoreInventory();
        inventory.addInventoryItem("tomatoSoup", of(2017,JUNE,30), 20);
        inventory.addInventoryItem("tomatoSoup", of(2017,JUNE,29), 15);
        PriceList priceList = new PriceList();
        BigDecimal tomatoSoupPrice = new BigDecimal("2.30");
        priceList.inputPrice("tomatoSoup", tomatoSoupPrice);
        BigDecimal expectedPrice = new BigDecimal("46.00");
        assertThat(inventory.getTotalValueOfProductsOfExpiryDate("tomatoSoup", of(2017,JUNE,30), priceList), is(expectedPrice));
    }

    @Test
    public void itShouldGiveTheTotalValueOfAllTheProductsOfThatType() throws Exception{
        StoreInventory inventory = new StoreInventory();
        inventory.addInventoryItem("tomatoSoup", of(2017,JUNE,30), 20);
        inventory.addInventoryItem("tomatoSoup", of(2017,JUNE,29), 15);
        PriceList priceList = new PriceList();
        priceList.inputPrice("tomatoSoup", new BigDecimal("2.30"));
        BigDecimal expectedPrice = new BigDecimal("80.50");
        assertThat(inventory.getTotalValueOfProducts("tomatoSoup", priceList), is(expectedPrice));
    }


    @Test
    public void itShouldGiveAListOfAllTheProductsOfAnExpiryDate() throws Exception{
        StoreInventory inventory = new StoreInventory();
        inventory.addInventoryItem("tomatoSoup", of(2017,JUNE,30), 20);
        inventory.addInventoryItem("tomatoSoup", of(2017,JUNE,29), 15);
        inventory.addInventoryItem("beans", of(2017,JUNE,30), 17);
        inventory.addInventoryItem("cola", of(2017,JUNE,30), 13);
        inventory.addInventoryItem("sprite", of(2017,JUNE,30), 28);
        List<Product> expiryDateList = inventory.getListOfAllProductsOfAnExpiryDate(of(2017,JUNE,30));
        Collections.sort(expiryDateList);
        assertThat(expiryDateList.get(0).getExpiryDate(), is(of(2017,JUNE,30)));
        assertThat(expiryDateList.get(0).getName(), is("beans"));
        assertThat(expiryDateList.get(1).getName(), is("cola"));
        assertThat(expiryDateList.get(3).getName(), is("tomatoSoup"));
    }

    @Test
    public void itShouldGiveTheTotalValueOfAllTheProductsOfAnExpiryDate() throws Exception{
        StoreInventory inventory = new StoreInventory();
        inventory.addInventoryItem("tomatoSoup", of(2017,JUNE,30), 20);
        inventory.addInventoryItem("tomatoSoup", of(2017,JUNE,29), 15);
        inventory.addInventoryItem("beans", of(2017,JUNE,30), 17);
        PriceList priceList = new PriceList();
        priceList.inputPrice("tomatoSoup", new BigDecimal("2.30"));
        priceList.inputPrice("beans", new BigDecimal("1.50"));
        BigDecimal expectedPrice = new BigDecimal("71.50");
        assertThat(inventory.getTotalValueOfAllProductsOfExpiryDate(of(2017,JUNE,30),priceList),is(expectedPrice));
    }







    private void printProducts(List<InventoryItem> items) {
        for(InventoryItem inventoryItem : items){
            System.out.println(inventoryItem.getProduct());
        }
    }

    private void printInventoryItems(Collection<InventoryItem> items) {
        for (InventoryItem inventoryItem : items) {
            System.out.println(inventoryItem);
        }
    }
}
