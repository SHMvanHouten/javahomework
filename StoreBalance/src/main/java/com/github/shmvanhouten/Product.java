package com.github.shmvanhouten;

import java.time.LocalDate;

public class Product implements Comparable<Product>{
    private final String name;
    private final LocalDate expiryDate;

    public Product(String name, LocalDate expiryDate) {
        this.name = name;
        this.expiryDate = expiryDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (!name.equals(product.name)) return false;
        return expiryDate.equals(product.expiryDate);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + expiryDate.hashCode();
        return result;
    }
    @Override
    public int compareTo(Product other) {

        int byProductName = this.getName().compareTo(other.getName());
        if(byProductName != 0){
            return byProductName;
        }
        return this.getExpiryDate().compareTo(other.getExpiryDate());
    }
}