package com.github.shmvanhouten;
import static com.google.common.base.Preconditions.checkArgument;


public class InventoryItem implements Comparable<InventoryItem> {
    private final Product product;
    private Integer quantity;

    public InventoryItem(Product product, Integer quantity) {
        checkArgument(quantity >=0);

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

    public void removeFromQuantity(int amount) {
        quantity -= amount;
    }

    @Override
    public int compareTo(InventoryItem other) {
        return this.getProduct().compareTo(other.getProduct());
    }

    @Override
    public String toString() {
        return "InventoryItem {" +
                "product name = '" + product.getName() + "\'" +
                ", expiryDate = " + product.getExpiryDate() +
                ", quantity = " + quantity +
                '}';
    }
}

