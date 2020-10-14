package bif3.swe1.tdd;

import bif3.swe1.oop.polymorphism.optimizedsolution.Circle;
import bif3.swe1.oop.polymorphism.optimizedsolution.CompoundShape;
import bif3.swe1.oop.polymorphism.optimizedsolution.Line;
import bif3.swe1.oop.polymorphism.optimizedsolution.ShapeCompositionInterface;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ShapeLibraryIntegrationTests {
    private final int expectedZeroCount = 0;
    private final int expectedOneCount = 1;
    private final int expectedTwoCount = 2;
    private final int expectedThreeCount = 3;

    private CompoundShape _compoundShape;
    private Line _line;
    private Circle _circle;

    @BeforeAll
    void setup() {
        _compoundShape = new CompoundShape(7, 7);
        _line = new Line(0, 1, 1, 1);
        _circle = new Circle(5, 5, 3);
    }

    @Test
    void testCompoundShapeMath() {
        // arrange
        // manually calc sum of perimeters - line + circle + line
        double expectedPerimeterSum = 1 + 18.8495559215387594;
        // manually calc sum of areas - line + circle + line
        double expectedAreaSum = 0 + 28.274333882308139146;

        _compoundShape.add(_line);
        _compoundShape.add(_circle);

        // act
        double actualPerimeterSum = _compoundShape.getPerimeter();
        double actualAreaSum = _compoundShape.getArea();

        // assert
        assertEquals(expectedPerimeterSum, actualPerimeterSum);
        assertEquals(expectedAreaSum, actualAreaSum);
    }

    @Test
    void testCompoundShapeContent() {
        // arrange
        Line line = new Line(3, 4, 5, 6);

        // act
        int actualZeroCount = _compoundShape.getCount();
        int actualOneCount = AddToCompoundShapeAndGetCount(_line);
        int actualTwoCount = AddToCompoundShapeAndGetCount(_circle);
        int actualThreeCount = AddToCompoundShapeAndGetCount(line);

        _compoundShape.clear();
        int actualClearCount = _compoundShape.getCount();

        // assert (not an optimal solution for testing, but shows a way to test with multiple asserts)
        assertEquals(expectedZeroCount, actualZeroCount);
        assertEquals(expectedOneCount, actualOneCount);
        assertEquals(expectedTwoCount, actualTwoCount);
        assertEquals(expectedThreeCount, actualThreeCount);
        assertEquals(expectedZeroCount, actualClearCount);
    }

    private int AddToCompoundShapeAndGetCount(ShapeCompositionInterface shape) {
        _compoundShape.add(shape);
        return _compoundShape.getCount();
    }

    @AfterEach
    void afterEach() {
        _compoundShape.clear();
    }
}