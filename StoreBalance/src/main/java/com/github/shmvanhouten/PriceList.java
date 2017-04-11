package com.github.shmvanhouten;

import java.util.HashMap;
import java.util.Map;

public class PriceList {
    private Map<String, Money> priceList =  new HashMap<>();
    public void inputPrice(String productName, Money price) {
        priceList.put(productName, price);
    }

    public Money getPrice(String productName) {
        return priceList.get(productName);
    }
}
