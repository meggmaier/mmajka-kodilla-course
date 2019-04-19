package com.kodilla.testing.shapes.testingshapes;

public class Triangle implements Shape {
    private String name = "triangle";
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        return (base * height)/2;
    }
}
