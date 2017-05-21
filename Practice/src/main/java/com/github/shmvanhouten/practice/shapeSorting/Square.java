package com.github.shmvanhouten.practice.shapeSorting;

class Square implements Shape{
    private double side;
    private double area;

    Square(double side){
        this.side = side;
        this.area = calculateArea();
    }

    @Override
    public double calculateArea() {
        return side * side;
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
