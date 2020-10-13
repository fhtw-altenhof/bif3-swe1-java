package bif3.swe1.oop.shapestack;

import bif3.swe1.oop.polymorphism.optimizedsolution.ShapeCompositionInterface;

import java.util.ArrayList;
import java.util.List;

public class ShapeStack implements ShapeStackInterface {

    private List<ShapeCompositionInterface> shapeList = new ArrayList<>();
    private int top;
    private int maxSize = 0;

    public ShapeStack(int maxSize) {
        this.top = 0;
        this.maxSize = maxSize;
    }

    @Override
    public void push(ShapeCompositionInterface shapeObj) {
        if( top >= maxSize ) {
            System.out.println("STACK OVERFLOW!");
            return ;
        }
        top++;
        shapeList.add(shapeObj);
    }

    @Override
    public ShapeCompositionInterface pop() {
        if( isEmpty() ) {
            System.out.println("STACK UNDERFLOW!");
            return null;
        }
        top--;
        return shapeList.remove(top);
    }

    @Override
    public boolean isEmpty() {
        return top <= 0;
    }

    @Override
    public void describeStack() {
        for( ShapeCompositionInterface shape : shapeList ) {
            shape.printShapeType();
        }
    }
}
