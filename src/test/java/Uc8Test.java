

import org.example.uc8.LengthUc8;
import org.example.uc8.LengthUnitUc8;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Uc8Test {

    private static final double EPSILON = 0.01;

    // -------------------------------
    // LengthUnit Enum Tests
    // -------------------------------

    @Test
    void testLengthUnitEnum_FeetConstant() {
        assertEquals(12.0, LengthUnitUc8.FEET.getFactor(), EPSILON);
    }

    @Test
    void testLengthUnitEnum_InchesConstant() {
        assertEquals(1.0, LengthUnitUc8.INCHES.getFactor(), EPSILON);
    }

    @Test
    void testLengthUnitEnum_YardsConstant() {
        assertEquals(36.0, LengthUnitUc8.YARDS.getFactor(), EPSILON);
    }

    @Test
    void testLengthUnitEnum_CentimetersConstant() {
        assertEquals(0.393701, LengthUnitUc8.CENTIMETERS.getFactor(), EPSILON);
    }

    // -------------------------------
    // Convert TO Base Unit (INCHES)
    // -------------------------------

    @Test
    void testConvertToBaseUnit_InchesToInches() {
        assertEquals(12.0,
                LengthUnitUc8.INCHES.convertToBaseUnit(12.0),
                EPSILON);
    }

    @Test
    void testConvertToBaseUnit_FeetToInches() {
        assertEquals(12.0,
                LengthUnitUc8.FEET.convertToBaseUnit(1.0),
                EPSILON);
    }

    @Test
    void testConvertToBaseUnit_YardsToInches() {
        assertEquals(36.0,
                LengthUnitUc8.YARDS.convertToBaseUnit(1.0),
                EPSILON);
    }

    @Test
    void testConvertToBaseUnit_CentimetersToInches() {
        assertEquals(12.0,
                LengthUnitUc8.CENTIMETERS.convertToBaseUnit(30.48),
                EPSILON);
    }

    // -------------------------------
    // Convert FROM Base Unit (INCHES)
    // -------------------------------

    @Test
    void testConvertFromBaseUnit_InchesToInches() {
        assertEquals(12.0,
                LengthUnitUc8.INCHES.convertFromBaseUnit(12.0),
                EPSILON);
    }

    @Test
    void testConvertFromBaseUnit_InchesToFeet() {
        assertEquals(1.0,
                LengthUnitUc8.FEET.convertFromBaseUnit(12.0),
                EPSILON);
    }

    @Test
    void testConvertFromBaseUnit_InchesToYards() {
        assertEquals(1.0,
                LengthUnitUc8.YARDS.convertFromBaseUnit(36.0),
                EPSILON);
    }

    @Test
    void testConvertFromBaseUnit_InchesToCentimeters() {
        assertEquals(30.48,
                LengthUnitUc8.CENTIMETERS.convertFromBaseUnit(12.0),
                EPSILON);
    }

    // -------------------------------
    // LengthUc8 Tests
    // -------------------------------

    @Test
    void testQuantityLengthRefactored_Equality() {
        LengthUc8 q1 = new LengthUc8(1.0, LengthUnitUc8.FEET);
        LengthUc8 q2 = new LengthUc8(12.0, LengthUnitUc8.INCHES);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testQuantityLengthRefactored_ConvertTo() {
        LengthUc8 q = new LengthUc8(1.0, LengthUnitUc8.FEET);

        LengthUc8 result = q.convertTo(LengthUnitUc8.INCHES);

        assertEquals(12.0, result.getLength(), EPSILON);
        assertEquals(LengthUnitUc8.INCHES, result.getUnit());
    }

    @Test
    void testQuantityLengthRefactored_Add() {
        LengthUc8 q1 = new LengthUc8(1.0, LengthUnitUc8.FEET);
        LengthUc8 q2 = new LengthUc8(12.0, LengthUnitUc8.INCHES);

        LengthUc8 result = q1.add(q2, LengthUnitUc8.FEET);

        assertEquals(2.0, result.getLength(), EPSILON);
    }

    @Test
    void testQuantityLengthRefactored_AddWithTargetUnit() {
        LengthUc8 q1 = new LengthUc8(1.0, LengthUnitUc8.FEET);
        LengthUc8 q2 = new LengthUc8(12.0, LengthUnitUc8.INCHES);

        LengthUc8 result = q1.add(q2, LengthUnitUc8.YARDS);

        assertEquals(0.67, result.getLength(), EPSILON);
    }

    // -------------------------------
    // Backward Compatibility
    // -------------------------------

    @Test
    void testBackwardCompatibility_UC1EqualityTests() {
        assertTrue(new LengthUc8(1, LengthUnitUc8.FEET)
                .equals(new LengthUc8(12, LengthUnitUc8.INCHES)));
    }

    @Test
    void testBackwardCompatibility_UC5ConversionTests() {
        LengthUc8 result = new LengthUc8(1, LengthUnitUc8.FEET)
                .convertTo(LengthUnitUc8.INCHES);

        assertEquals(12, result.getLength(), EPSILON);
    }



    @Test
    void testBackwardCompatibility_UC7AdditionWithTargetUnitTests() {
        LengthUc8 result = new LengthUc8(1, LengthUnitUc8.FEET)
                .add(new LengthUc8(12, LengthUnitUc8.INCHES), LengthUnitUc8.YARDS);

        assertEquals(0.67, result.getLength(), EPSILON);
    }

    // -------------------------------
    // Round Trip Conversion
    // -------------------------------

    @Test
    void testRoundTripConversion_RefactoredDesign() {
        LengthUc8 original = new LengthUc8(5.0, LengthUnitUc8.FEET);

        LengthUc8 result = original
                .convertTo(LengthUnitUc8.INCHES)
                .convertTo(LengthUnitUc8.FEET);

        assertEquals(original.getLength(), result.getLength(), EPSILON);
    }

    // -------------------------------
    // Immutability
    // -------------------------------

    @Test
    void testUnitImmutability() {
        LengthUnitUc8 unit = LengthUnitUc8.FEET;

        assertEquals("FEET", unit.name());
        assertThrows(IllegalArgumentException.class, () ->
                LengthUnitUc8.valueOf("INVALID"));
    }
}