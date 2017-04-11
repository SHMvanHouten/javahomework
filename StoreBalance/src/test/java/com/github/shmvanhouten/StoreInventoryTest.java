package com.github.shmvanhouten;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static java.time.LocalDate.of;
import static java.time.Month.*;
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
        Money tomatoSoupPrice = new Money("2.30", "eur");
        priceList.inputPrice("tomatoSoup", tomatoSoupPrice);
        Money expectedPrice = new Money("46.00", "eur");
        assertThat(inventory.getTotalValueOfProductsOfExpiryDate("tomatoSoup", of(2017,JUNE,30), priceList), is(expectedPrice));
    }

    @Test
    public void itShouldGiveTheTotalValueOfAllTheProductsOfThatType() throws Exception{
        StoreInventory inventory = new StoreInventory();
        inventory.addInventoryItem("tomatoSoup", of(2017,JUNE,30), 20);
        inventory.addInventoryItem("tomatoSoup", of(2017,JUNE,29), 15);
        PriceList priceList = new PriceList();
        priceList.inputPrice("tomatoSoup", new Money("2.30", "eur"));
        Money expectedPrice = new Money("80.50", "eur");
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
        priceList.inputPrice("tomatoSoup", new Money("2.30", "eur"));
        priceList.inputPrice("beans", new Money("1.50", "eur"));
        Money expectedPrice = new Money("71.50", "eur");
        assertThat(inventory.getTotalValueOfAllProductsOfExpiryDate(of(2017,JUNE,30),priceList, "eur"),is(expectedPrice));
    }

    @Test
    public void itShouldGiveTheTotalValueOfTheEntireStock() throws Exception{
        StoreInventory inventory = new StoreInventory();
        PriceList priceList = new PriceList();
        fillUpTheInventory(inventory);
        fillUpThePriceList(priceList);
        assertThat(inventory.getInventoryTotalValue(priceList, "eur"), is(new Money("236.72", "eur")));
    }

    @Test
    public void itShouldRemoveAnItemFromTheInventory() throws Exception{
        StoreInventory inventory = new StoreInventory();
        inventory.addInventoryItem("tomatoSoup", of(2017,APRIL,14), 20);
        inventory.addInventoryItem("sprite", of(2017,APRIL,14), 12);

        StoreInventory testInventory = new StoreInventory();
        testInventory.addInventoryItem("sprite", of(2017,APRIL,14), 12);

        inventory.removeEntry(new Product("tomatoSoup", of(2017,APRIL,14)));

        assertThat(inventory.getInventoryList().size(), is(testInventory.getInventoryList().size()));
        assertThat(inventory.getInventoryList().get(0).toString(), is(testInventory.getInventoryList().get(0).toString()));
    }

    @Test
    public void itShouldRemoveAllItemsFromAnExpiryDateFromTheInventoryAndPutItInAnExpiredProductList() throws Exception{
        StoreInventory inventory = new StoreInventory();
        PriceList priceList = new PriceList();
        fillUpTheInventory(inventory);
        fillUpThePriceList(priceList);
        inventory.addInventoryItem("tomatoSoup", of(2017,APRIL,14), 20);
        inventory.addInventoryItem("sprite", of(2017,APRIL,14), 12);
        inventory.addInventoryItem("cola", of(2017,APRIL,14), 23);
        inventory.addInventoryItem("bread", of(2017,APRIL,14), 9);
        List<InventoryItem> listOfExpiredProducts = inventory.removeAllEntriesOfExpiryDate(of(2017,APRIL,14));

        StoreInventory testInventory = new StoreInventory();
        fillUpTheInventory(testInventory);

        StoreInventory tempInventory = new StoreInventory();
        tempInventory.addInventoryItem("tomatoSoup", of(2017,APRIL,14), 20);
        tempInventory.addInventoryItem("sprite", of(2017,APRIL,14), 12);
        tempInventory.addInventoryItem("cola", of(2017,APRIL,14), 23);
        tempInventory.addInventoryItem("bread", of(2017,APRIL,14), 9);
        List<InventoryItem> testList = tempInventory.getInventoryList();

        assertThat(inventory.getInventoryList().size(), is(testInventory.getInventoryList().size()));
        assertThat(listOfExpiredProducts.size(), is(testList.size()));


        for (InventoryItem inventoryItem:testInventory.getInventoryList()) {
            assertThat(inventoryItem.getInventoryItemQuantity(), is(testInventory.getInventoryItem(inventoryItem.getProduct()).getInventoryItemQuantity()));
        }
    }



    private void fillUpThePriceList(PriceList priceList) {
        priceList.inputPrice("tomatoSoup", new Money("2.30", "eur"));
        priceList.inputPrice("beans", new Money("1.35", "eur"));
        priceList.inputPrice("cola", new Money("1.25", "eur"));
        priceList.inputPrice("sprite", new Money("1.25", "eur"));
        priceList.inputPrice("bread", new Money("1.59", "eur"));
    }


    private void fillUpTheInventory(StoreInventory inventory) {
        inventory.addInventoryItem("tomatoSoup", of(2017,JUNE,30), 20);
        inventory.addInventoryItem("tomatoSoup", of(2017,MAY,15), 15);
        inventory.addInventoryItem("beans", of(2017,AUGUST,10), 17);
        inventory.addInventoryItem("cola", of(2017,JUNE,30), 13);
        inventory.addInventoryItem("cola", of(2017,SEPTEMBER,30), 30);
        inventory.addInventoryItem("sprite", of(2017,DECEMBER,30), 28);
        inventory.addInventoryItem("bread", of(2017,APRIL,15), 28);
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
