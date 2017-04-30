package com.github.shmvanhouten.practice;

import java.util.Arrays;

public class EqualSidesOfAnArray {
    public int getIndexWhereBothSidesOfTheIndexAddUpToTheSameAmount(int[] inputArray) {
        int leftSide = inputArray[0];
        int rightSide = Arrays.stream(inputArray).sum() - leftSide;
        for(int i = 1; i<inputArray.length-1;i++){
            rightSide -= inputArray[i];
            if(leftSide == rightSide){
                return i;
            }
            leftSide += inputArray[i];
        }
        return -1;
    }
}
