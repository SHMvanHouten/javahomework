package com.github.shmvanhouten;

import java.time.LocalDate;

public class Product {
    public String getName() {
        return name;
    }

    private final String name;
    private final LocalDate expiryDate;
    public Product(String name, LocalDate expiryDate) {
        this.name = name;
        this.expiryDate = expiryDate;
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
}
