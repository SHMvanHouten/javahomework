package com.github.shmvanhouten;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class PriceList {
    public Map<String, BigDecimal> priceList =  new HashMap<>();
    public void inputPrice(String productName, BigDecimal price) {
        priceList.put(productName, price);
    }

    public BigDecimal getPrice(String productName) {
        return priceList.get(productName);
    }
}
