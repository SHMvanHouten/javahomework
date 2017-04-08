package com.github.shmvanhouten;

        import java.math.BigDecimal;
        import java.time.Month;
        import java.util.*;


        import java.time.LocalDate;

public class StoreInventory {

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

        return new BigDecimal("32");
    }

    public List<Product> getListOfAllProductsOfAnExpiryDate(LocalDate expiryDate) {
        List<Product> listOfAllProductsOfExpiryDate = new ArrayList<>();
        for (Map.Entry<Product, InventoryItem> product: inventoryList.entrySet()) {
            Product tempProduct = product.getKey();
            if(tempProduct.getExpiryDate().equals(expiryDate)){
                listOfAllProductsOfExpiryDate.add(tempProduct);
            }
        }
        return listOfAllProductsOfExpiryDate;
    }
}
