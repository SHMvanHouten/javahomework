package com.github.shmvanhouten;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class PotterKata {
    Map<Integer, BigDecimal> discountsMap = new HashMap<>();
    public PotterKata(){
        discountsMap.put(1, new BigDecimal(1.00));
        discountsMap.put(2, new BigDecimal(0.95));
        discountsMap.put(3, new BigDecimal(0.90));
        discountsMap.put(4, new BigDecimal(0.80));
        discountsMap.put(5, new BigDecimal(0.75));
    }

    public String getTotalPrice(Map<Integer, Integer> amountOfEachBook) {
        BigDecimal totalValue = new BigDecimal(0);
        int numberOfDifferentTypeBooks = 0;

        for (int bookNumber :
                amountOfEachBook.keySet()) {
            totalValue = totalValue.add(new BigDecimal(8.00).multiply(new BigDecimal(amountOfEachBook.get(bookNumber))));
            numberOfDifferentTypeBooks++;
        }

        BigDecimal discount = discountsMap.get(numberOfDifferentTypeBooks);

        return (totalValue.multiply(discount)).setScale(2, RoundingMode.HALF_UP).toString() + " eur";
    }
}
