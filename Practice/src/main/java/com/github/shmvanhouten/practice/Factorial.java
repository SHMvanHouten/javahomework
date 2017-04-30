package com.github.shmvanhouten.practice;

import java.math.BigInteger;

public class Factorial {

    public static BigInteger getFactorial(int n) {
        if(n == 1){
            return BigInteger.valueOf(1);
        }else{
            return BigInteger.valueOf(n).multiply(getFactorial(n-1));
        }
    }

    public static String getFactorialString(int n) {
        return getFactorial(n).toString();
    }

    public static String Factorial(int n) {
        if (n == 0 || n == 1) {
            return "1";
        }
        if (n < 0){
            return null;
        }
        BigInteger result = new BigInteger("2");
        for(int i = 3; i<= n; i++){
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result.toString();
    }
}
