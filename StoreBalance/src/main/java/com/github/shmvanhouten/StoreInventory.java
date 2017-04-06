package com.github.shmvanhouten;

        import java.util.*;


        import java.time.LocalDate;
        import static java.time.LocalDate.of;

public class StoreInventory {


    public Map<Product, InventoryItem> getInventoryList() {
        return inventoryList;
    }

    Map<Product, InventoryItem> inventoryList = new HashMap<>();
    public void addInventoryItem(String name, LocalDate expiryDate, Integer quantity){

        Product product = new Product(name, expiryDate);
        if(inventoryList.containsKey(product)) {
            inventoryList.get(product).addToQuantity(quantity);
        }
        else{
            InventoryItem inventoryItem = new InventoryItem(product, quantity);
            inventoryList.put(product, inventoryItem);
        }
    }


    public Integer getProductOfExpiryDatesQuantity(String name, LocalDate expiryDate) {
        Product tempProduct = new Product(name, expiryDate);
        return inventoryList.get(tempProduct).getInventoryItemQuantity();
    }

    public Integer getProductQuantity(String name) {
        Integer quantity = 0;
        for(Product product : inventoryList.keySet()){
            if(product.getName().equals(name)){
                quantity += inventoryList.get(product).getInventoryItemQuantity();
            }
        }
        return quantity;
    }
}
