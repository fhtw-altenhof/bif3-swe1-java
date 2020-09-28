package bif3.swe1.oop.polymorphism.optimizedsolution;

public class Circle extends Shape implements ShapeCompositionInterface {

    private int radius;

    public Circle(int x, int y, int radius) {
        super(x, y);
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
}
