package com.github.shmvanhouten;

public class InventoryItem {
    private final Product product;
    private Integer quantity;

    public InventoryItem(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    public void addToQuantity(Integer amount){
        quantity += amount;
    }

    public Integer getInventoryItemQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }
}
