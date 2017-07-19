package com.github.shmvanhouten.practice.PrimeFactorsFinder;

import java.util.HashMap;
import java.util.Map;

public class PrimeFactorFinder {
    public Map<Long, Integer> getPrimeFactors(long number) {
        Map<Long, Integer> factors = new HashMap<>();

        for (long i = 2; i <= number /2; i++) {
            while(number%i == 0){
                factors.merge(i,1, Integer::sum);
                number /= i;
            }
        }

        if(number > 1){
            factors.put(number, 1);
        }

        return factors;
    }
}
