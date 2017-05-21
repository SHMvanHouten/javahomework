package com.github.shmvanhouten.practice.shapeSorting;

class CustomShape implements Shape {
    private double area;
    CustomShape(double area) {
        this.area = area;
    }

    @Override
    public double calculateArea() {
        return 0;
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
