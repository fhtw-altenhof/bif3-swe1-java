package bif3.swe1.oop.polymorphism.abstractbaseclass;

public class DerivedLine extends AbstractShape {

    private int x2, y2;

    public DerivedLine(int x1, int y1, int x2, int y2) {
        super(x1, y1);
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public double getArea() {
        return 0;   // ???, a line does not have an area
    }

    @Override
    public double getPerimeter() {
        return Math.sqrt( (x2-x)*(x2-x) + (y2-y)*(y2-y) );
    }

    @Override
    public void printShapeType() {
        System.out.println("I'm a Line");
    }

    @Override
    public void showOrigin() {
        System.out.printf("Origin: %d, %d End: %d, %d \n", x, y, x2, y2);
    }
}
