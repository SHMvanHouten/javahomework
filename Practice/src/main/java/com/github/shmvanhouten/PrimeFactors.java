package com.github.shmvanhouten;


import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.Map;

public class PrimeFactors {


    public static List<Integer> getPrimeFactors(int number) {
        int i = 2;
        List<Integer> outputList = new ArrayList<>();
        while(i<=number){
            if (number % i == 0){
                number /= i;
                outputList.add(i);
            }else{
                i++;
            }
        }
        return outputList;
    }

    public static Map<Integer, Integer> getPrimeFactorsMap(int number) {
        int i = 2;
        Map<Integer, Integer> outputMap = new TreeMap<>();
        while(i<=number){
            if (number % i == 0){
                number /= i;
                Integer primeEntry = outputMap.get(i);
                if(primeEntry != null) {
                    outputMap.put(i,primeEntry +1);
                }else{
                    outputMap.put(i, 1);
                }
            }else{
                i++;
            }
        }
        return outputMap;
    }

    public static String getPrimeFactorsString(int number) {
        Map<Integer, Integer> resultMap = getPrimeFactorsMap(number);
        StringBuilder outputString = new StringBuilder();
        for (Integer key: resultMap.keySet()) {
            outputString.append("(");
            Integer amount = resultMap.get(key);
            if(amount == 1){
                outputString.append(key);
            }else{
                outputString.append(key).append("**").append(amount);
            }
            outputString.append(")");
        }
        return outputString.toString();
    }
}
