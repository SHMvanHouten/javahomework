package com.github.shmvanhouten.practice.areaCalculator;

class Circle implements Shape{
    private final double radius;
    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
}
