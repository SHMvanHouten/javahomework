package com.github.shmvanhouten.practice.areaCalculator;

import java.math.BigDecimal;

import static java.lang.Math.*;

class AreaCalculator {
    double getTotalArea(Triangle triangle) {
        return triangle.getTriangleBase() * triangle.getTriangleHeight() / 2;
    }

    double getTotalArea(Square square) {
        double side = square.getSide();
        return side * side;
    }

    double getTotalArea(Rectangle rectangle) {
        return rectangle.getHeight() * rectangle.getWidth();
    }

    double getTotalArea(Circle circle) {
        double radius = circle.getRadius();
        BigDecimal area = new BigDecimal(pow(radius, 2) * PI);
        return area.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    double getTotalArea(Shape... a){
        double totalArea = 0;
        for(Shape shape: a){
            if(shape instanceof Triangle) {
                totalArea += getTotalArea((Triangle) shape);
            }else if(shape instanceof Square){
                totalArea += getTotalArea((Square) shape);
            }else if(shape instanceof Rectangle){
                totalArea += getTotalArea((Rectangle) shape);
            }else if(shape instanceof Circle){
                totalArea += getTotalArea((Circle) shape);
            }
        }
        return new BigDecimal(totalArea).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
