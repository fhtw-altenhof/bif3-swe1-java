package bif3.swe1.oop.polymorphism.optimizedsolution;

public abstract class Shape {
    protected int x, y;

    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void showOrigin() {
        System.out.printf("Origin: %d, %d\n", x, y);
    }
}
