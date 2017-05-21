package com.github.shmvanhouten.practice.shapeSorting;

import static java.lang.Math.PI;

class Circle implements Shape{
    private double radius;
    private double area;
    public Circle(double radius) {
        this.radius = radius;
        this.area = calculateArea();
    }

    @Override
    public double calculateArea() {
        return radius * radius * PI;
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public int compareTo(Shape shape) {
        if(this.area > shape.getArea()){
            return 1;
        }
        if(this.area < shape.getArea()){
            return -1;
        }
        return 0;
    }
}
