package bif3.swe1.oop.polymorphism.abstractbaseclass;

public class DerivedCircle extends AbstractShape {

    private int radius;

    public DerivedCircle(int x, int y, int radius) {
        super(x, y);
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
