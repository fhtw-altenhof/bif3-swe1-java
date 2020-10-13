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

    @Mock
    ShapeCompositionInterface mockShape;

    private CompoundShape _compoundShape;

    @BeforeAll
    void setup() {
        _compoundShape = new CompoundShape(7, 7);
    }

    @Test
    void testCircleShapeMock() {
        // allocate
        mockShape = mock(ShapeCompositionInterface.class);

        when(mockShape.getArea()).thenReturn(5.0);
        when(mockShape.getPerimeter()).thenReturn(3.0);

        // act
        double tempArea = mockShape.getArea();
        double tempPerimeter = mockShape.getPerimeter();

        // assert
        verify(mockShape).getArea();
        verify(mockShape).getPerimeter();
    }

    @Test
    void testCompoundShapeMock() {
        // allocate
        var mockShape1 = mock(ShapeCompositionInterface.class);
        var mockShape2 = mock(ShapeCompositionInterface.class);

        when(mockShape1.getArea()).thenReturn(5.0);
        when(mockShape2.getArea()).thenReturn(7.0);

        // act
        _compoundShape.add(mockShape1);
        _compoundShape.add(mockShape2);

        double actualAreaSum = _compoundShape.getArea();
        double expectedAreaSum = 12;

        // assert
        assertEquals(expectedAreaSum, actualAreaSum);
    }

    @AfterEach
    void tearDown() {
        _compoundShape.clear();
    }
}