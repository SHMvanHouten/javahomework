package com.github.shmvanhouten.StoreBalance;

import com.github.shmvanhouten.StoreBalance.InventoryItem;
import com.github.shmvanhouten.StoreBalance.Product;
import org.junit.Test;

import static java.time.LocalDate.of;
import static java.time.Month.APRIL;
import static java.time.Month.MAY;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class InventoryItemTest {
    private final Product PRODUCT = new Product("tomatoSoup", of(2017, MAY, 10));

    @Test
    public void itShouldGetTheAmountOfCansOfTomatoSoupOfACertainDate() throws Exception{
        InventoryItem tomatoSoup = new InventoryItem(PRODUCT, 15);
        assertThat(tomatoSoup.getInventoryItemQuantity(),is(15));
    }

    @Test
    public void itShouldAddAQuantityOfSixToTheInventoryItem() throws Exception{
        InventoryItem tomatoSoup = new InventoryItem(PRODUCT, 15);
        tomatoSoup.addToQuantity(6);
        assertThat(tomatoSoup.getInventoryItemQuantity(), is(21));
    }
    @Test
    public void itShouldReturnAStringWithTheInvenoryItemIdentifiers() throws Exception{
        Product product = new Product("bananas", of(2017,APRIL,17));
        InventoryItem inventoryItem = new InventoryItem(product,20);
        assertThat(inventoryItem.toString(), is("InventoryItem {product name = 'bananas', expiryDate = 2017-04-17, quantity = 20}"));
    }

    @Test
    public void itShouldSubtractAQuantityOfTenFromTheInventoryItem() throws Exception {
        InventoryItem inventoryItem = new InventoryItem(PRODUCT, 30);
        inventoryItem.removeFromQuantity(10);
        assertThat(inventoryItem.getInventoryItemQuantity(),is(20));
    }

    @Test (expected = IllegalArgumentException.class)
    public void itShouldNotAllowANegativeQuantityToBeInputOnAnInventoryItem() throws Exception {
        InventoryItem negativeItem = new InventoryItem(PRODUCT, -23);
    }
}
