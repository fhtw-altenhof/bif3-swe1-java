package bif3.swe1.oop.polymorphism.interfacebasedshapes;

import lombok.Getter;

public class BetterLine implements BetterShapeCompositionInterface {
    @Getter
    private int xOriginCoordinate;

    @Getter
    private int yOriginCoordinate;

    private int xEndCoordinate, yEndCoordinate;

    public BetterLine(int x1, int y1, int x2, int y2) {
        this.xOriginCoordinate = x1;
        this.yOriginCoordinate = y1;
        this.xEndCoordinate = x2;
        this.yEndCoordinate = y2;
    }

    @Override
    public double getArea() {
        return 0;   // ???, a line does not have an area
    }

    @Override
    public double getPerimeter() {
        return Math.sqrt( (xEndCoordinate-xOriginCoordinate)*(xEndCoordinate-xOriginCoordinate) + (yEndCoordinate-yOriginCoordinate)*(yEndCoordinate-yOriginCoordinate) );
    }

    @Override
    public void printShapeType() {
        System.out.println("I'm a Line");
    }

    @Override
    public void showOrigin() {
        System.out.printf("Origin: %d, %d End: %d, %d \n", xOriginCoordinate, yOriginCoordinate, xEndCoordinate, yEndCoordinate);
    }

}
