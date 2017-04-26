package com.github.shmvanhouten;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

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
        Map<String, Integer> uniqueCounts = new TreeMap<>();
        BigDecimal totalValue = new BigDecimal(0);

        for (int bookEpisode : amountOfEachBook.keySet()) {
            for (int i = 0; i<amountOfEachBook.get(bookEpisode); i++){
                uniqueCounts.merge("entry" + i, 1,Integer::sum);
            }
        }

        for (String numberOfUniqueBooks : uniqueCounts.keySet()) {
            BigDecimal discountPrice = discountsMap.get(uniqueCounts.get(numberOfUniqueBooks)).multiply(new BigDecimal(8.00));
            BigDecimal amountOfBooks = new BigDecimal(uniqueCounts.get(numberOfUniqueBooks));
            totalValue = totalValue.add(amountOfBooks.multiply(discountPrice));
        }

        return (totalValue).setScale(2, RoundingMode.HALF_UP).toString() + " eur";
    }
}
