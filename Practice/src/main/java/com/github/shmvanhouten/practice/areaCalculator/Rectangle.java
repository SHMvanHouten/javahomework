package com.github.shmvanhouten.practice.areaCalculator;

class Rectangle implements Shape {
    private final double height;
    private final double width;
    Rectangle(double height, double width){
        this.height = height;
        this.width = width;
    }

    double getHeight() {
        return height;
    }

    double getWidth() {
        return width;
    }
}
