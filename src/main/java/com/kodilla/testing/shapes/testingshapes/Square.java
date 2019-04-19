package com.kodilla.testing.shapes.testingshapes;

public class Square implements Shape{
    private int sideLength;
    private String name = "square";

    public Square(int sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        return Math.pow(sideLength,2);
    }
}
