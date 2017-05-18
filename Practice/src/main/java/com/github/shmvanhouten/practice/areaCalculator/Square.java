package com.github.shmvanhouten.practice.areaCalculator;

class Square extends Shape{
    private final double side;
    Square(double side) {
        this.side = side;
    }

    double getSide() {
        return side;
    }
}
