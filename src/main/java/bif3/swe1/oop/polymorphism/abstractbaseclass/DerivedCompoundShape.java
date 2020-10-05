package bif3.swe1.oop.polymorphism.abstractbaseclass;

import java.util.ArrayList;
import java.util.List;

public class DerivedCompoundShape extends AbstractShape {

    private List<AbstractShape> shapeList = new ArrayList<>();

    public DerivedCompoundShape(int x, int y) {
        super(x, y);
    }

    public void add(AbstractShape shape) {
        shapeList.add(shape);
    }

    @Override
    public double getArea() {
        double tempArea = 0;
        for( AbstractShape shape : shapeList ) {
            tempArea += shape.getArea();
        }
        System.out.printf("Sum of all areas: %f \n", tempArea);
        return tempArea;
    }

    @Override
    public double getPerimeter() {
        double tempPerimeter = 0;
        for (AbstractShape shape : shapeList) {
            tempPerimeter += shape.getPerimeter();
        }
        System.out.printf("Sum of all perimeters: %f \n", tempPerimeter);
        return tempPerimeter;
    }

    @Override
    public void printShapeType() {
        System.out.println("I'm a CompoundShape");
        for(AbstractShape shape : shapeList) {
            shape.printShapeType();
        }
    }
}
