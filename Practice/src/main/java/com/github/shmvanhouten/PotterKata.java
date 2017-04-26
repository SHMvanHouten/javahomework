package com.github.shmvanhouten;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class PotterKata {

    public String getTotalPrice(Map<Integer, Integer> amountOfEachBook) {
        BigDecimal totalValue = new BigDecimal(0);
        int numberOfDifferentTypeBooks = 0;

        for (int bookNumber :
                amountOfEachBook.keySet()) {
            totalValue = totalValue.add(new BigDecimal(8.00).multiply(new BigDecimal(amountOfEachBook.get(bookNumber))));
            numberOfDifferentTypeBooks++;
        }

        BigDecimal discount = new BigDecimal(1);
        for(int i = 1; i<numberOfDifferentTypeBooks; i++){
            discount = discount.subtract(new BigDecimal(0.05));
        }

        return (totalValue.multiply(discount)).setScale(2, RoundingMode.CEILING).toString() + " eur";
    }
}
