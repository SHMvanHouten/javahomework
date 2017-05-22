package com.github.shmvanhouten.practice.shapeSorting;

import static java.lang.Math.PI;

class Circle extends Shape{
    private double radius;
    public Circle(double radius) {
        this.radius = radius;
        super.area = calculateArea();
    }

    @Override
    public double calculateArea() {
        return radius * radius * PI;
    }
}
