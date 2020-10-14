package bif3.swe1.tdd;

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
    void setup() { }

    @Test
    void testLineLengthCalculation() {
        // arrange
        Line line = new Line(0, 1, 1, 1);
        double expectedLinePerimeter = 1;

        // act
        double actualLinePerimeter = line.getPerimeter();

        // assert
        assertEquals(expectedLinePerimeter, actualLinePerimeter);
    }

    @Test
    void testCircleAreaCalculation() {
        // arrange
        Circle circle = new Circle(5, 5, 3);
        double expectedCircleArea = 28.274333882308139146;

        // act
        double actualCircleArea = circle.getArea();

        // assert
        assertEquals(expectedCircleArea, actualCircleArea);
    }

    @Test
    void testCompoundShapeAdd() {
        // arrange
        CompoundShape compoundShape = new CompoundShape(7, 7);
        Line line = new Line(3, 4, 5, 6);

        // act
        compoundShape.add(line);

        // assert
        assertEquals(expectedOneCount, compoundShape.getCount());
    }

    @Test
    void testCompoundShapeClear() {
        // arrange
        CompoundShape compoundShape = new CompoundShape(7, 7);
        Line line = new Line(3, 4, 5, 6);

        // act
        compoundShape.add(line);
        compoundShape.clear();

        // assert
        assertEquals(expectedZeroCount, compoundShape.getCount());
    }

    @AfterAll
    void tearDown() { }
}