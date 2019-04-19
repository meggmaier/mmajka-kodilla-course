package com.kodilla.testing.shapes.testingshapes;

public class Circle implements Shape {
    private String name = "circle";
    private double pi = Math.PI;
    private double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        return pi * r;
    }
}
