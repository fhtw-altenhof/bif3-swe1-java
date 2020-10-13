package bif3.swe1.oop.shapestackgit;

import bif3.swe1.oop.polymorphism.optimizedsolution.ShapeCompositionInterface;

public interface ShapeStackInterface {
    void push(ShapeCompositionInterface shapeObj);
    ShapeCompositionInterface pop();
    boolean isEmpty();
    void describeStack();
}
