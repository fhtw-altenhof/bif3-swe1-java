package bif3.swe1.oop.polymorphism.abstractbaseclass;

public abstract class AbstractShape {
    protected int x, y;

    public AbstractShape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    public abstract void printShapeType();

    public void showOrigin() {
        System.out.printf("Origin: %d, %d \n", this.x, this.y);
    }
}
