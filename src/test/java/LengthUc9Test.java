
import org.example.uc9.LengthUnitUc9;
import org.example.uc9.LengthUc9;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class LengthUc9Test {
    private static final double EPSILON = 0.01;
    @Test
    void testLengthUnitEnum_FeetConstant() {
        assertEquals(12.0, LengthUnitUc9.FEET.getFactor(), EPSILON);
    }

    @Test
    void testLengthUnitEnum_InchesConstant() {
        assertEquals(1.0, LengthUnitUc9.INCHES.getFactor(), EPSILON);
    }

    @Test
    void testLengthUnitEnum_YardsConstant() {
        assertEquals(36.0, LengthUnitUc9.YARDS.getFactor(), EPSILON);
    }

    @Test
    void testLengthUnitEnum_CentimetersConstant() {
        assertEquals(0.393701, LengthUnitUc9.CENTIMETERS.getFactor(), EPSILON);
    }


    @Test
    void testConvertToBaseUnit_InchesToInches() {
        assertEquals(12.0,
                LengthUnitUc9.INCHES.convertToBaseUnit(12.0),
                EPSILON);
    }

    @Test
    void testConvertToBaseUnit_FeetToInches() {
        assertEquals(12.0,
                LengthUnitUc9.FEET.convertToBaseUnit(1.0),
                EPSILON);
    }

    @Test
    void testConvertToBaseUnit_YardsToInches() {
        assertEquals(36.0,
                LengthUnitUc9.YARDS.convertToBaseUnit(1.0),
                EPSILON);
    }

    @Test
    void testConvertToBaseUnit_CentimetersToInches() {
        assertEquals(12.0,
                LengthUnitUc9.CENTIMETERS.convertToBaseUnit(30.48),
                EPSILON);
    }

    // -------------------------------
    // Convert FROM Base Unit (INCHES)
    // -------------------------------

    @Test
    void testConvertFromBaseUnit_InchesToInches() {
        assertEquals(12.0,
                LengthUnitUc9.INCHES.convertFromBaseUnit(12.0),
                EPSILON);
    }

    @Test
    void testConvertFromBaseUnit_InchesToFeet() {
        assertEquals(1.0,
                LengthUnitUc9.FEET.convertFromBaseUnit(12.0),
                EPSILON);
    }

    @Test
    void testConvertFromBaseUnit_InchesToYards() {
        assertEquals(1.0,
                LengthUnitUc9.YARDS.convertFromBaseUnit(36.0),
                EPSILON);
    }

    @Test
    void testConvertFromBaseUnit_InchesToCentimeters() {
        assertEquals(30.48,
                LengthUnitUc9.CENTIMETERS.convertFromBaseUnit(12.0),
                EPSILON);
    }


    @Test
    void testQuantityLengthRefactored_Equality() {
        LengthUc9 q1 = new LengthUc9(1.0, LengthUnitUc9.FEET);
        LengthUc9 q2 = new LengthUc9(12.0, LengthUnitUc9.INCHES);

        assertTrue(q1.equals(q2));
    }

    @Test
    void testQuantityLengthRefactored_ConvertTo() {
        LengthUc9 q = new LengthUc9(1.0, LengthUnitUc9.FEET);

        LengthUc9 result = q.convertTo(LengthUnitUc9.INCHES);

        assertEquals(12.0, result.getLength(), EPSILON);
        assertEquals(LengthUnitUc9.INCHES, result.getUnit());
    }

    @Test
    void testQuantityLengthRefactored_Add() {
        LengthUc9 q1 = new LengthUc9(1.0, LengthUnitUc9.FEET);
        LengthUc9 q2 = new LengthUc9(12.0, LengthUnitUc9.INCHES);

        LengthUc9 result = q1.add(q2, LengthUnitUc9.FEET);

        assertEquals(2.0, result.getLength(), EPSILON);
    }

    @Test
    void testQuantityLengthRefactored_AddWithTargetUnit() {
        LengthUc9 q1 = new LengthUc9(1.0, LengthUnitUc9.FEET);
        LengthUc9 q2 = new LengthUc9(12.0, LengthUnitUc9.INCHES);

        LengthUc9 result = q1.add(q2, LengthUnitUc9.YARDS);

        assertEquals(0.67, result.getLength(), EPSILON);
    }


    @Test
    void testBackwardCompatibility_UC1EqualityTests() {
        assertTrue(new LengthUc9(1, LengthUnitUc9.FEET)
                .equals(new LengthUc9(12, LengthUnitUc9.INCHES)));
    }

    @Test
    void testBackwardCompatibility_UC5ConversionTests() {
        LengthUc9 result = new LengthUc9(1, LengthUnitUc9.FEET)
                .convertTo(LengthUnitUc9.INCHES);

        assertEquals(12, result.getLength(), EPSILON);
    }



    @Test
    void testBackwardCompatibility_UC7AdditionWithTargetUnitTests() {
        LengthUc9 result = new LengthUc9(1, LengthUnitUc9.FEET)
                .add(new LengthUc9(12, LengthUnitUc9.INCHES), LengthUnitUc9.YARDS);

        assertEquals(0.67, result.getLength(), EPSILON);
    }

    // -------------------------------
    // Round Trip Conversion
    // -------------------------------

    @Test
    void testRoundTripConversion_RefactoredDesign() {
        LengthUc9 original = new LengthUc9(5.0, LengthUnitUc9.FEET);

        LengthUc9 result = original
                .convertTo(LengthUnitUc9.INCHES)
                .convertTo(LengthUnitUc9.FEET);

        assertEquals(original.getLength(), result.getLength(), EPSILON);
    }


    @Test
    void testUnitImmutability() {
        LengthUnitUc9 unit = LengthUnitUc9.FEET;

        assertEquals("FEET", unit.name());
        assertThrows(IllegalArgumentException.class, () ->
                LengthUnitUc9.valueOf("INVALID"));
    }
}
