package bif3.swe1.tdd.weapon;

import bif3.swe1.oop.polymorphism.optimizedsolution.Circle;
import bif3.swe1.oop.polymorphism.optimizedsolution.CompoundShape;
import bif3.swe1.oop.polymorphism.optimizedsolution.Line;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ShapeLibraryIntegrationTests {
    private final int expectedZeroCount = 0;
    private final int expectedOneCount = 1;
    private final int expectedTwoCount = 2;
    private final int expectedThreeCount = 3;

    private CompoundShape _compoundShape;

    @BeforeAll
    public void Setup() {
        _compoundShape = new CompoundShape(7, 7);
    }

        [Test]
    public void TestCompoundShapeMath() {
        Line line = new Line(0, 1, 1, 1);
        Circle circle = new Circle(5, 5, 3);
        _compoundShape.add(line);
        _compoundShape.add(circle);
        _compoundShape.add(new Line(3, 4, 5, 6));

        // act
        double actualPerimeterSum = _compoundShape.getPerimeter();
        // manually calc sum of perimeters - line + circle + line
        double expectedPerimeterSum = 1 + 18.8495559215387594 + 2.828427124746190097;

        double actualAreaSum = _compoundShape.getArea();
        // manually calc sum of areas - line + circle + line
        double expectedAreaSum = 0 + 28.274333882308139146 + 0;

        // assert
        assertEquals(expectedPerimeterSum, actualPerimeterSum);
        assertEquals(expectedAreaSum, actualAreaSum);
    }

    public void TestCompoundShapeContent() {
        Line line = new Line(0, 1, 1, 1);
        Circle circle = new Circle(5, 5, 3);

        // act
        double actualZeroCount = _compoundShape.count;

        _compoundShape.add(line);
        int actualOneCount = _compoundShape.count;

        _compoundShape.add(circle);
        int actualTwoCount = _compoundShape.count;

        _compoundShape.add(new Line(3, 4, 5, 6));
        int actualThreeCount = _compoundShape.count;

        _compoundShape.clear();
        int actualClearCount = _compoundShape.count;

        // assert (not an optimal solution for testing, but shows a way to test with multiple asserts)
        assertEquals(expectedZeroCount, actualZeroCount);
        assertEquals(expectedOneCount, actualOneCount);
        assertEquals(expectedTwoCount, actualTwoCount);
        assertEquals(expectedThreeCount, actualThreeCount);
        assertEquals(expectedZeroCount, actualClearCount);
    }

    @AfterEach
    public void TearDown() {
        _compoundShape.clear();
    }
}