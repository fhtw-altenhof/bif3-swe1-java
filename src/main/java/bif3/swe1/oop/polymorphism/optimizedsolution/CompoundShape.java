package bif3.swe1.oop.polymorphism.optimizedsolution;

import bif3.swe1.oop.polymorphism.abstractbaseclass.AbstractShape;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class CompoundShape extends Shape implements ShapeCompositionInterface {
    private List<ShapeCompositionInterface> shapeList = new ArrayList<>();

    public CompoundShape(int x, int y) {
        super(x, y);
    }

    public void add(ShapeCompositionInterface shape) {
        shapeList.add(shape);
        System.out.println("No of elems: " + shapeList.size());
    }

    @Override
    public double getArea() {
        double tempArea = 0;
        for( ShapeCompositionInterface shape : shapeList ) {
            tempArea += shape.getArea();
        }
        System.out.printf("Sum of all areas: %f \n", tempArea);
        return tempArea;
    }

    @Override
    public double getPerimeter() {
        double tempPerimeter = 0;
        for (ShapeCompositionInterface shape : shapeList) {
            tempPerimeter += shape.getPerimeter();
        }
        System.out.printf("Sum of all perimeters: %f \n", tempPerimeter);
        return tempPerimeter;
    }

    @Override
    public void printShapeType() {
        System.out.println("I'm a CompoundShape");
        for(ShapeCompositionInterface shape : shapeList) {
            shape.printShapeType();
        }
    }

    public void clear() {
        shapeList.clear();
    }

    public int getCount() {
        return shapeList.size();
    }
}
