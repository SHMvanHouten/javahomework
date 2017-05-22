package com.github.shmvanhouten.practice.shapeSorting;

class Square extends Shape{
    private double side;

    Square(double side){
        this.side = side;
        super.area = calculateArea();
    }

    @Override
    public double calculateArea() {
        return side * side;
    }
}
