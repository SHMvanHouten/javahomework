package com.github.shmvanhouten.StoreBalance;

import java.time.LocalDate;
import java.util.*;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static java.time.LocalDate.now;

public class StoreInventory {

    private Map<Product, InventoryItem> inventoryList = new HashMap<>();



    public void addInventoryItem(String name, LocalDate expiryDate, Integer quantity) throws IllegalArgumentException {

        checkArgument(expiryDate.isAfter(now()), "Expiration date has passed");
        checkNotNull(name);


        Product product = new Product(name, expiryDate);
        if(inventoryList.containsKey(product)) {
            inventoryList.get(product).addToQuantity(quantity);
        } else{
            InventoryItem inventoryItem = new InventoryItem(product, quantity);
            inventoryList.put(product, inventoryItem);
        }
    }


    public Integer getProductOfExpiryDatesQuantity(String name, LocalDate expiryDate) {
        Product tempProduct = new Product(name, expiryDate);
        return inventoryList.get(tempProduct).getInventoryItemQuantity();
    }

    public Integer getProductTotalQuantity(String name) {
        Integer quantity = 0;
        for(Product product : inventoryList.keySet()){
            if(product.getName().equals(name)){
                quantity += inventoryList.get(product).getInventoryItemQuantity();
            }
        }
        return quantity;
    }
    public List<InventoryItem> getInventoryList() {
        List<InventoryItem> returnList = new ArrayList<>();

        returnList.addAll(inventoryList.values());
        Collections.sort(returnList);
        return returnList;
    }

    public Money getTotalValueOfProductsOfExpiryDate(String productName, LocalDate expiryDate, PriceList priceList) {
        Money price = priceList.getPrice(productName);
        Integer quantity = getProductOfExpiryDatesQuantity(productName, expiryDate);
        return price.multiply(quantity);
    }

    public Money getTotalValueOfProducts(String productName, PriceList priceList) {
        Money price = priceList.getPrice(productName);
        Integer quantity = getProductTotalQuantity(productName);
        return price.multiply(quantity);
    }

    public Money getTotalValueOfAllProductsOfExpiryDate(LocalDate expiryDate, PriceList priceList, String currency) {
        Money totalValue = new Money("0", currency);
        for (Product product: inventoryList.keySet()) {
            if(product.getExpiryDate().equals(expiryDate)){
                Money value = getTotalValueOfProductsOfExpiryDate(product.getName(), expiryDate, priceList);
                totalValue = totalValue.add(value);
            }
        }
        return totalValue;
    }

    public List<Product> getListOfAllProductsOfAnExpiryDate(LocalDate expiryDate) {
        List<Product> listOfAllProductsOfExpiryDate = new ArrayList<>();
        for (Product product: inventoryList.keySet()) {
            if(product.getExpiryDate().equals(expiryDate)){
                listOfAllProductsOfExpiryDate.add(product);
            }
        }
        return listOfAllProductsOfExpiryDate;
    }

    public Money getInventoryTotalValue(PriceList priceList, String currency) {
        Money totalValue = new Money("0", currency);
        for(Product product: inventoryList.keySet()){
            totalValue = totalValue.add(this.getTotalValueOfProductsOfExpiryDate(product.getName(), product.getExpiryDate(), priceList));
        }
        return totalValue;
    }

    public List<InventoryItem> removeAllEntriesOfExpiryDate(LocalDate expiryDate) {
        List<InventoryItem> listOfAllInventoryItemsOfExpiryDate = new ArrayList<>();
        List<Product> listOfAllProductItemsOfExpiryDate = getListOfAllProductsOfAnExpiryDate(expiryDate);
        for (Product product: listOfAllProductItemsOfExpiryDate) {
            try {
                listOfAllInventoryItemsOfExpiryDate.add(inventoryList.get(product));
                removeEntry(product);
            } catch (UnknownProductException e) {
                // Ignore this, because the unknown product should be removed anyway.
                System.err.println("Attempt to remove unknown product: " + product.getName());
            }
        }
        return listOfAllInventoryItemsOfExpiryDate;
    }

    public void removeEntry(Product product) throws UnknownProductException {
        checkForProduct(product);

        inventoryList.remove(product);
    }

    public InventoryItem getInventoryItem(Product product) throws UnknownProductException {
        checkForProduct(product);

        return inventoryList.get(product);
    }

    private void checkForProduct(Product product) throws UnknownProductException {
        if (!inventoryList.containsKey(product)) {
            throw new UnknownProductException();
        }
    }

    public void removeQuantityOfInventoryItem(String productName, LocalDate expiryDate, int amount) {
        Product tempProduct = new Product(productName,expiryDate);
        InventoryItem inventoryItem = inventoryList.get(tempProduct);
        if(inventoryItem.getInventoryItemQuantity() - amount<= 0){
            try {
                removeEntry(tempProduct);
                System.out.println("Product removed.");
            } catch (UnknownProductException e) {

            }
        }else{
            inventoryItem.removeFromQuantity(amount);
        }
    }
}
