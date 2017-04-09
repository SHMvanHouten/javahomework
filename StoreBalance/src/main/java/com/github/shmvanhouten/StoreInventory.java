package com.github.shmvanhouten;

        import java.math.BigDecimal;
        import java.util.*;


        import java.time.LocalDate;

public class StoreInventory {

    private Map<Product, InventoryItem> inventoryList = new HashMap<>();



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

    public BigDecimal getTotalValueOfProductsOfExpiryDate(String productName, LocalDate expiryDate, PriceList priceList) {
        BigDecimal price = priceList.getPrice(productName);
        Integer quantity = getProductOfExpiryDatesQuantity(productName, expiryDate);
        return price.multiply(new BigDecimal(quantity));
    }

    public BigDecimal getTotalValueOfProducts(String productName, PriceList priceList) {
        BigDecimal price = priceList.getPrice(productName);
        Integer quantity = getProductTotalQuantity(productName);
        return price.multiply(new BigDecimal(quantity));
    }

    public BigDecimal getTotalValueOfAllProductsOfExpiryDate(LocalDate expiryDate, PriceList priceList) {
        BigDecimal totalValue = new BigDecimal("0");
        for (Product product: inventoryList.keySet()) {
            if(product.getExpiryDate().equals(expiryDate)){
                BigDecimal value = getTotalValueOfProductsOfExpiryDate(product.getName(), expiryDate, priceList);
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
}
