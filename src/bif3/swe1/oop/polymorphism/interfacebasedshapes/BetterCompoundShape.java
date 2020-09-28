package bif3.swe1.oop.polymorphism.interfacebasedshapes;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class BetterCompoundShape implements BetterShapeCompositionInterface {
    @Getter
    private int xOriginCoordinate;

    @Getter
    private int yOriginCoordinate;

    private List<BetterShapeCompositionInterface> shapeList = new ArrayList<>();

    public BetterCompoundShape(int x, int y) {
        this.xOriginCoordinate = x;
        this.yOriginCoordinate = y;
    }

    public void add(BetterShapeCompositionInterface shape) {
        shapeList.add(shape);
    }

    @Override
    public double getArea() {
        double tempArea = 0;
        for( BetterShapeCompositionInterface shape : shapeList ) {
            tempArea += shape.getArea();
        }
        System.out.printf("Sum of all perimeters: %d \n", tempArea);
        return tempArea;
    }

    @Override
    public double getPerimeter() {
        double tempPerimeter = 0;
        for (BetterShapeCompositionInterface shape : shapeList) {
            tempPerimeter += shape.getPerimeter();
        }
        System.out.printf("Sum of all perimeters: %d \n", tempPerimeter);
        return tempPerimeter;
    }

    @Override
    public void printShapeType() {
        System.out.println("I'm a CompoundShape");
        for(BetterShapeCompositionInterface shape : shapeList) {
            shape.printShapeType();
        }
    }

    @Override
    public void showOrigin() {
        System.out.printf("Origin: %d, %d \n", this.xOriginCoordinate, this.yOriginCoordinate);
    }
}
