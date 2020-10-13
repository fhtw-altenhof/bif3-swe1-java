package bif3.swe1.tdd.weapon;

import bif3.swe1.oop.polymorphism.optimizedsolution.Circle;
import bif3.swe1.oop.polymorphism.optimizedsolution.CompoundShape;
import bif3.swe1.oop.polymorphism.optimizedsolution.Line;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ShapeLibraryUnitTests {

    private final int expectedZeroCount = 0;
    private final int expectedOneCount = 1;

    @BeforeAll
    void setup() {
    }

    @Test
    void testLineLengthCalculation() {
        // allocate
        Line line = new Line(0, 1, 1, 1);

        // act
        double actualLinePerimeter = line.getPerimeter();
        double expectedLinePerimeter = 1;

        // assert
        assertEquals(expectedLinePerimeter, actualLinePerimeter);
    }

    @Test
    void testCircleAreaCalculation() {
        // allocate
        Circle circle = new Circle(5, 5, 3);

        // act
        double actualCircleArea = circle.getArea();
        double expectedCircleArea = 28.274333882308139146;

        // assert
        assertEquals(expectedCircleArea, actualCircleArea);
    }

    @Test
    void testCompoundShapeAdd() {
        // allocate
        CompoundShape compoundShape = new CompoundShape(7, 7);

        // act
        compoundShape.add(new Line(3, 4, 5, 6));

        // assert
        assertEquals(expectedOneCount, compoundShape.getCount());
    }

    @Test
    void testCompoundShapeClear() {
        // allocate
        CompoundShape compoundShape = new CompoundShape(7, 7);

        // act
        compoundShape.add(new Line(3, 4, 5, 6));
        compoundShape.clear();

        // assert
        assertEquals(expectedZeroCount, compoundShape.getCount());
    }

    @AfterAll
    void tearDown() {
    }
}