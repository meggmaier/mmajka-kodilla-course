package com.kodilla.testing.shapes.testingshapes;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class ShapeCollectorTestSuite {

    @Test
    public void testAddFigure(){
        //Given
        Square square = new Square(5);
        ShapeCollector shapeCollector = new ShapeCollector();

        //When
        shapeCollector.addFigure(square);

        //Then
        List<Shape> shapes = shapeCollector.showFigures();
        Assert.assertEquals(1, shapes.size());
    }
    @Test
    public void testRemoveFigure(){
        //Given
        Square square = new Square(5);
        ShapeCollector shapeCollector = new ShapeCollector();
        ArrayList<Shape> shapes = shapeCollector.showFigures();
        shapeCollector.addFigure(square);

        //When
        shapeCollector.removeFigure(square);

        //Then
        Assert.assertEquals(0, shapes.size());
    }
    @Test
    public void testGetFigure(){
        ///Given
        Square square = new Square(5);
        ShapeCollector shapeCollector = new ShapeCollector();
        shapeCollector.addFigure(square);


        //When
        Shape shape = shapeCollector.getFigure(0);

        //Then
        Assert.assertEquals(square, shape);
        }

    @Test
    public void testShowFigures(){
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        ArrayList<Shape> shapes = new ArrayList<>();

        //When
        ArrayList<Shape> shownFigures = shapeCollector.showFigures();

        //Then
        Assert.assertEquals(shapes,shownFigures);
    }
}
