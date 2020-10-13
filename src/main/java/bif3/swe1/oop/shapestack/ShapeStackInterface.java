package bif3.swe1.oop.shapestack;

import bif3.swe1.oop.polymorphism.optimizedsolution.ShapeCompositionInterface;

public interface ShapeStackInterface {
    void push(ShapeCompositionInterface shapeObj);
    ShapeCompositionInterface pop();
    boolean isEmpty();
    void describeStack();
}
