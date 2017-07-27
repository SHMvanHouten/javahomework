//    Write a function which takes an array data of numbers and returns the largest difference in indexes j - i such that data[i] <= data[j]
package com.github.shmvanhouten.practice.findTheLargestPossibleGap;

public class LargestGapFinder {
    public int findLargestGap(int[] array) {
        int largestGap = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i ; j--) {
                int indexGap = j - i;
                if(array[j] >= array[i] && indexGap > largestGap){
                    largestGap = indexGap;
                }
            }
        }
        return largestGap;
    }
}

