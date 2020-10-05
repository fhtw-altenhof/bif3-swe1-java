package bif3.swe1.oop.polymorphism.optimizedsolution;

public interface ShapeStackInterface {

    void push(ShapeCompositionInterface shareObj);

    ShapeCompositionInterface pop();

    boolean isEmpty();

    void describeStack();
}
