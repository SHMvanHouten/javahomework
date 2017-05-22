package com.github.shmvanhouten.practice.shapeSorting;

class CustomShape extends Shape {
    CustomShape(double area) {
        super.area = area;
    }

    @Override
    public double calculateArea() {
        return 0;
    }
}
