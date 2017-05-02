package com.github.shmvanhouten.StoreBalance;

import com.github.shmvanhouten.StoreBalance.*;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static java.time.LocalDate.of;
import static java.time.Month.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StoreInventoryTest {

    public static final String PRODUCT_NAME = "tomatoSoup";

    @Test
    public void itShouldAddANewProductToTheStoreInventory() throws Exception{
        StoreInventory inventory = new StoreInventory();
        inventory.addInventoryItem(PRODUCT_NAME, of(2017,JUNE,29), 20);
        assertThat(inventory.getInventoryList().size(), is(1));
    }


    @Test(expected = IllegalArgumentException.class)
    public void itShouldRefuseAlreadyExpiredProducts() throws Exception {
        StoreInventory inventory = new StoreInventory();
        inventory.addInventoryItem(PRODUCT_NAME, of(2016, JUNE, 29), 20);

    }


    @Test
    public void itShouldHandleExpiredProducts() throws Exception {
        StoreInventory inventory = new StoreInventory();


        attemptToAddItemToInventory(inventory, PRODUCT_NAME, of(2016, JUNE, 29), 20);
        attemptToAddItemToInventory(inventory, PRODUCT_NAME, of(2017,JUNE,30), 20);
        attemptToAddItemToInventory(inventory, PRODUCT_NAME, of(2017,JUNE,29), 15);
        attemptToAddItemToInventory(inventory, "marsBars", of(2017, APRIL,20), 80);


        List<InventoryItem> inventoryList = inventory.getInventoryList();
        System.out.println("Continue with " + inventoryList.size() + " items");

        // resume normal program
    }

    private void attemptToAddItemToInventory(StoreInventory inventory, String product, LocalDate expiryDate, int quantity) {
        try {
            addItemToInventory(inventory, product, expiryDate, quantity);
        } catch (IllegalArgumentException e) {
            System.out.println("Expired Product found");
        }
    }

    private void addItemToInventory(StoreInventory inventory, String product, LocalDate expiryDate, int quantity) {
        inventory.addInventoryItem(product, expiryDate, quantity);
        System.out.println("Product added to inventory");
    }


    @Test
    public void itShouldChangeTheQuantityOfTheInventoryItemAndGetTheAmountOfThatProductOfThatExpirationDate(){
        StoreInventory inventory = new StoreInventory();
        inventory.addInventoryItem(PRODUCT_NAME, of(2017,JUNE,29), 20);
        inventory.addInventoryItem(PRODUCT_NAME, of(2017,JUNE,29), 15);
        assertThat(inventory.getProductOfExpiryDatesQuantity(PRODUCT_NAME, of(2017,JUNE,29)), is(35));
    }

    @Test
    public void itShouldGetTheTotalAmountOfATypeOfProduct(){
        StoreInventory inventory = new StoreInventory();
        inventory.addInventoryItem(PRODUCT_NAME, of(2017,JUNE,30), 20);
        inventory.addInventoryItem(PRODUCT_NAME, of(2017,JUNE,29), 15);
        assertThat(inventory.getProductTotalQuantity(PRODUCT_NAME), is(35));
    }

    @Test
    public void itShouldReturnAllProducts(){
        StoreInventory inventory = new StoreInventory();
        inventory.addInventoryItem(PRODUCT_NAME, of(2017,JUNE,30), 20);
        inventory.addInventoryItem(PRODUCT_NAME, of(2017,JUNE,29), 15);
        inventory.addInventoryItem("marsBars", of(2017,MAY,20), 80);

        List<InventoryItem> items = inventory.getInventoryList();

        assertThat(items.get(0).getInventoryItemQuantity(), is(80));
        assertThat(items.get(0).getProduct().getName(), is("marsBars"));
        assertThat(items.get(1).getProduct().getName(), is(PRODUCT_NAME));
    }

    @Test
    public void itShouldGiveTheTotalValueOfTheProductsWithThatExpirationDate() throws Exception{
        StoreInventory inventory = new StoreInventory();
        LocalDate juneThirty = of(2017, JUNE, 30);
        inventory.addInventoryItem(PRODUCT_NAME, juneThirty, 20);
        inventory.addInventoryItem(PRODUCT_NAME, of(2017,JUNE,29), 15);
        PriceList priceList = prepareDefaultPriceList("2.30", PRODUCT_NAME);

        Money totalValueOfSoup = inventory.getTotalValueOfProductsOfExpiryDate(PRODUCT_NAME, juneThirty, priceList);

        Money expectedPrice = new Money("46.00", "eur");
        assertThat(totalValueOfSoup, is(expectedPrice));

    }

    private PriceList prepareDefaultPriceList(String amount, String productName) {
        PriceList priceList = new PriceList();
        Money tomatoSoupPrice = new Money(amount, "eur");
        priceList.inputPrice(productName, tomatoSoupPrice);
        return priceList;
    }

    @Test
    public void itShouldGiveTheTotalValueOfAllTheProductsOfThatType() throws Exception{
        StoreInventory inventory = new StoreInventory();
        inventory.addInventoryItem(PRODUCT_NAME, of(2017,JUNE,30), 20);
        inventory.addInventoryItem(PRODUCT_NAME, of(2017,JUNE,29), 15);
        PriceList priceList = prepareDefaultPriceList("2.30", PRODUCT_NAME);


        Money expectedPrice = new Money("80.50", "eur");
        assertThat(inventory.getTotalValueOfProducts(PRODUCT_NAME, priceList), is(expectedPrice));
    }


    @Test
    public void itShouldGiveAListOfAllTheProductsOfAnExpiryDate() throws Exception{
        StoreInventory inventory = new StoreInventory();
        inventory.addInventoryItem(PRODUCT_NAME, of(2017,JUNE,30), 20);
        inventory.addInventoryItem(PRODUCT_NAME, of(2017,JUNE,29), 15);
        inventory.addInventoryItem("beans", of(2017,JUNE,30), 17);
        inventory.addInventoryItem("cola", of(2017,JUNE,30), 13);
        inventory.addInventoryItem("sprite", of(2017,JUNE,30), 28);
        List<Product> expiryDateList = inventory.getListOfAllProductsOfAnExpiryDate(of(2017,JUNE,30));
        Collections.sort(expiryDateList);
        assertThat(expiryDateList.get(0).getExpiryDate(), is(of(2017,JUNE,30)));
        assertThat(expiryDateList.get(0).getName(), is("beans"));
        assertThat(expiryDateList.get(1).getName(), is("cola"));
        assertThat(expiryDateList.get(3).getName(), is(PRODUCT_NAME));
    }

    @Test
    public void itShouldGiveTheTotalValueOfAllTheProductsOfAnExpiryDate() throws Exception{
        StoreInventory inventory = new StoreInventory();
        inventory.addInventoryItem(PRODUCT_NAME, of(2017,JUNE,30), 20);
        inventory.addInventoryItem(PRODUCT_NAME, of(2017,JUNE,29), 15);
        inventory.addInventoryItem("beans", of(2017,JUNE,30), 17);
        PriceList priceList = new PriceList();
        priceList.inputPrice(PRODUCT_NAME, new Money("2.30", "eur"));
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
    public void itShouldRemoveAnItemFromTheInventory() throws Exception {
        StoreInventory inventory = new StoreInventory();
        inventory.addInventoryItem(PRODUCT_NAME, of(2017,MAY,14), 20);
        inventory.addInventoryItem("sprite", of(2017,MAY,14), 12);

        StoreInventory testInventory = new StoreInventory();
        testInventory.addInventoryItem("sprite", of(2017,MAY,14), 12);

        inventory.removeEntry(new Product("tomatoSoup", of(2017,MAY,14)));

        assertThat(inventory.getInventoryList().size(), is(testInventory.getInventoryList().size()));
        assertThat(inventory.getInventoryList().get(0).toString(), is(testInventory.getInventoryList().get(0).toString()));
    }

    @Test
    public void itShouldRemoveAllItemsFromAnExpiryDateFromTheInventoryAndPutItInAnExpiredProductList() throws Exception{
        StoreInventory inventory = new StoreInventory();
        PriceList priceList = new PriceList();
        fillUpTheInventory(inventory);
        fillUpThePriceList(priceList);
        inventory.addInventoryItem(PRODUCT_NAME, of(2017,MAY,14), 20);
        inventory.addInventoryItem("sprite", of(2017,MAY,14), 12);
        inventory.addInventoryItem("cola", of(2017,MAY,14), 23);
        inventory.addInventoryItem("bread", of(2017,MAY,14), 9);
        List<InventoryItem> listOfExpiredProducts = inventory.removeAllEntriesOfExpiryDate(of(2017,MAY,14));

        StoreInventory testInventory = new StoreInventory();
        fillUpTheInventory(testInventory);

        StoreInventory tempInventory = new StoreInventory();
        tempInventory.addInventoryItem(PRODUCT_NAME, of(2017,MAY,14), 20);
        tempInventory.addInventoryItem("sprite", of(2017,MAY,14), 12);
        tempInventory.addInventoryItem("cola", of(2017,MAY,14), 23);
        tempInventory.addInventoryItem("bread", of(2017,MAY,14), 9);
        List<InventoryItem> testList = tempInventory.getInventoryList();

        assertThat(inventory.getInventoryList().size(), is(testInventory.getInventoryList().size()));
        assertThat(listOfExpiredProducts.size(), is(testList.size()));


        for (InventoryItem inventoryItem:testInventory.getInventoryList()) {
            Integer inventoryItemQuantity = inventoryItem.getInventoryItemQuantity();

            assertThat(inventoryItemQuantity, is(testInventory.getInventoryItem(inventoryItem.getProduct()).getInventoryItemQuantity()));
        }
    }

    @Test
    public void itShouldRemove10OfTheTomatoSoupCansFromTheEntry() throws Exception {
        StoreInventory inventory = new StoreInventory();
        inventory.addInventoryItem(PRODUCT_NAME, of(2017,MAY,25),30);
        inventory.removeQuantityOfInventoryItem(PRODUCT_NAME, of(2017,MAY,25), 10);
        assertThat(inventory.getProductOfExpiryDatesQuantity(PRODUCT_NAME, of(2017,MAY,25)), is(20));
        inventory.removeQuantityOfInventoryItem(PRODUCT_NAME, of(2017,MAY,25),20);
    }

    @Test (expected = UnknownProductException.class)
    public void itShouldThrowAnExceptionIfITryToFindAProductThatIsNotThere() throws Exception {
        StoreInventory inventory = new StoreInventory();
        inventory.addInventoryItem(PRODUCT_NAME, of(2017,MAY,25),30);
        InventoryItem rusk = inventory.getInventoryItem(new Product("rusk", of(2017,JANUARY,12)));
        System.out.println(rusk);
    }

    private void fillUpThePriceList(PriceList priceList) {
        priceList.inputPrice(PRODUCT_NAME, new Money("2.30", "eur"));
        priceList.inputPrice("beans", new Money("1.35", "eur"));
        priceList.inputPrice("cola", new Money("1.25", "eur"));
        priceList.inputPrice("sprite", new Money("1.25", "eur"));
        priceList.inputPrice("bread", new Money("1.59", "eur"));
    }


    private void fillUpTheInventory(StoreInventory inventory) {
        inventory.addInventoryItem(PRODUCT_NAME, of(2017,JUNE,30), 20);
        inventory.addInventoryItem(PRODUCT_NAME, of(2017,MAY,15), 15);
        inventory.addInventoryItem("beans", of(2017,AUGUST,10), 17);
        inventory.addInventoryItem("cola", of(2017,JUNE,30), 13);
        inventory.addInventoryItem("cola", of(2017,SEPTEMBER,30), 30);
        inventory.addInventoryItem("sprite", of(2017,DECEMBER,30), 28);
        inventory.addInventoryItem("bread", of(2017,MAY,15), 28);
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
