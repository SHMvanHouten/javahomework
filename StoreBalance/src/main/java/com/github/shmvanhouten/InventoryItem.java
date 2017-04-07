package com.github.shmvanhouten;

public class InventoryItem implements Comparable<InventoryItem> {
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

    @Override
    public int compareTo(InventoryItem other) {
        return this.getProduct().compareTo(other.getProduct());
    }
//    @Override
//    public String toString()
}

