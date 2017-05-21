package com.github.shmvanhouten.practice.shapeSorting;

class Triangle implements Shape{
    private double base;
    private double height;
    private double area;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
        this.area = calculateArea();
    }

    @Override
    public double calculateArea() {
        return base * height / 2;
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
