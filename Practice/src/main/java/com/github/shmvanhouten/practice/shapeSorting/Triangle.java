package com.github.shmvanhouten.practice.shapeSorting;

class Triangle extends Shape{
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
        super.area = calculateArea();
    }

    @Override
    public double calculateArea() {
        return base * height / 2;
    }
}
