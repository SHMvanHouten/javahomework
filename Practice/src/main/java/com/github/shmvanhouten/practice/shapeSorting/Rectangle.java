package com.github.shmvanhouten.practice.shapeSorting;

class Rectangle implements Shape{
    private double width;
    private double height;
    private double area;

    Rectangle(double width, double height) {
        this.width = width;
        this.height =height;
        this.area = calculateArea();
    }

    @Override
    public double calculateArea() {
        return width * height;
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
