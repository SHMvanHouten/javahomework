package com.github.shmvanhouten;


import java.math.BigDecimal;
import java.util.Map;

public class PotterKata {

    public int getTotalPrice(Map<Integer, Integer> amountOfEachBook) {
        BigDecimal totalValue = new BigDecimal(0);
        for (int bookNumber :
                amountOfEachBook.keySet()) {
            totalValue = totalValue.add(new BigDecimal(8.00).multiply(new BigDecimal(amountOfEachBook.get(bookNumber))));
        }
        return totalValue.intValue();
    }
}
