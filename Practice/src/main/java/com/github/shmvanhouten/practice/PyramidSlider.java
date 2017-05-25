package com.github.shmvanhouten.practice;

public class PyramidSlider {
    public int calculateBiggestPath(int[][] pyramid) {
        int sum = 0;
        for (int[] level : pyramid) {
            sum += level[0];
        }
        return sum;
    }
}
