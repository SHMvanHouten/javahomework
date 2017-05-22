package com.github.shmvanhouten.practice.shapeSorting;

abstract class Shape implements Comparable<Shape>{
    double area;

    abstract double calculateArea();

    public double getArea(){
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
