package bif3.swe1.oop.polymorphism.interfacebasedshapes;

import lombok.Getter;

public class BetterCircle implements BetterShapeCompositionInterface {
    @Getter
    private int xOriginCoordinate;

    @Getter
    private int yOriginCoordinate;

    private int radius;

    public BetterCircle(int x, int y, int radius) {
        this.xOriginCoordinate = x;
        this.yOriginCoordinate = y;
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public double getPerimeter() {
        return 2.0 * radius * Math.PI;
    }

    @Override
    public void printShapeType() {
        System.out.println("I'm a Circle");
    }

    @Override
    public void showOrigin() {
        System.out.printf("Origin: %d, %d \n", this.xOriginCoordinate, this.yOriginCoordinate);
    }

}
