package com.github.shmvanhouten.practice.shapeSorting;

class Rectangle extends Shape {
    private double width;
    private double height;

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
        super.area = calculateArea();
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
}
