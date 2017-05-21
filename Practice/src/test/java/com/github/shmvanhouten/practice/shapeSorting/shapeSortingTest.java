package com.github.shmvanhouten.practice.shapeSorting;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class shapeSortingTest {

    @Test
    public void squareShouldHaveAnAreaOfItsSidesSquared() throws Exception {
        Shape square = new Square(2);
        assertThat(square.getArea(), is(4D));
        Map<String,String> dictionary = new HashMap<>();
    }

    @Test
    public void rectangleShouldHaveAnArea() throws Exception {
        Shape rectangle = new Rectangle(2,4);
        assertThat(rectangle.getArea(), is(8D));
    }

    @Test
    public void triangleShouldHaveAnArea() throws Exception {
        Shape triangle = new Triangle(4,3);
        assertThat(triangle.getArea(), is(6D));
    }

    @Test
    public void circleShouldHaveAnArea() throws Exception {
        Shape circle = new Circle(4);
        assertThat(circle.getArea(), is(16 * Math.PI));
    }

    @Test
    public void customShapeShouldHaveAnArea() throws Exception {
        Shape customShape = new CustomShape(4);
        assertThat(customShape.getArea(), is(4D));
    }

    @Test
    public void listOfShapesShouldGetSortedAccordingToArea() throws Exception {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(3));
        shapes.add(new Square(2));
        shapes.add(new Rectangle(5,2));
        shapes.add(new Triangle(1,3));
        shapes.add(new CustomShape(8));
        printShapeAreas(shapes);
        Collections.sort(shapes);
        System.out.println("sorted:");
        printShapeAreas(shapes);
        assertThat(isOrderedToAreaSize(shapes), is(true));
    }

    private void printShapeAreas(List<Shape> shapes) {
        for (Shape shape : shapes) {
            System.out.print(shape.getArea() + " + ");
            System.out.println(shape.getClass());
        }
    }

    private boolean isOrderedToAreaSize(List<Shape> shapes) {
        double area = -1;
        for (Shape shape : shapes) {
            if(shape.getArea()< area){
                return false;
            }
            area = shape.getArea();
        }
        return true;
    }
}