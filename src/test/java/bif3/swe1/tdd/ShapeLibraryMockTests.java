package bif3.swe1.tdd;

import bif3.swe1.oop.polymorphism.optimizedsolution.CompoundShape;
import bif3.swe1.oop.polymorphism.optimizedsolution.ShapeCompositionInterface;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ShapeLibraryMockTests {

    private final double mockValue1 = 5.0;
    private final double mockValue2 = 3.0;

    @Mock
    ShapeCompositionInterface mockShape;

    private CompoundShape _compoundShape;

    @BeforeAll
    void setup() {
        _compoundShape = new CompoundShape(7, 7);
    }

    @Test
    void testCircleShapeMock() {
        // arrange
        mockShape = mock(ShapeCompositionInterface.class);

        when(mockShape.getArea()).thenReturn(mockValue1);
        when(mockShape.getPerimeter()).thenReturn(mockValue2);

        // act
        double tempArea = mockShape.getArea();
        double tempPerimeter = mockShape.getPerimeter();

        // assert
        verify(mockShape).getArea();
        verify(mockShape).getPerimeter();
    }

    @Test
    void testCompoundShapeMock() {
        // arrange
        double expectedAreaSum = mockValue1 + mockValue2;
        ShapeCompositionInterface mockShape1 = mock(ShapeCompositionInterface.class);
        ShapeCompositionInterface mockShape2 = mock(ShapeCompositionInterface.class);

        when(mockShape1.getArea()).thenReturn(mockValue1);
        when(mockShape2.getArea()).thenReturn(mockValue2);

        // act
        _compoundShape.add(mockShape1);
        _compoundShape.add(mockShape2);

        double actualAreaSum = _compoundShape.getArea();

        // assert
        assertEquals(expectedAreaSum, actualAreaSum);
    }

    @AfterEach
    void tearDown() {
        _compoundShape.clear();
    }
}