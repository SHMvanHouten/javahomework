package com.github.shmvanhouten.practice;

import java.util.List;

import static java.lang.Math.*;

public class BinaryConverter {
    public int convert(List<Integer> binaryNumber) {
        int decimalNumber = 0;
        int powerRaiser = binaryNumber.size()-1;
        for (int bit : binaryNumber) {
            decimalNumber += bit * pow(2, powerRaiser);
            powerRaiser--;
        }
        return decimalNumber;
    }

//    public int convert(List<Integer> binaryNumber) {
//        return binaryNumber.stream().reduce((x,y)-> x*2 +y).get();
//    }
}
