package com.github.shmvanhouten.practice.areaCalculator;

class Triangle implements Shape{
    private final double triangleBase;
    private final double triangleHeight;
    Triangle(double triangleBase, double triangleHeight) {
        this.triangleBase = triangleBase;
        this.triangleHeight = triangleHeight;
    }

    double getTriangleBase() {
        return triangleBase;
    }

    double getTriangleHeight() {
        return triangleHeight;
    }
}
