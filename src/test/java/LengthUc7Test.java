//package org.example.usecase7.LengthUnitUc7;

import org.example.usecase7.LengthUc7;
import org.example.usecase7.LengthUnitUc7;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LengthUc7Test {

    private static final double EPS = 1e-6;


    @Test
    void testConstructor_NullUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new LengthUc7(10.0, null);
        });
    }


    @Test
    void testConvertToBaseUnit() {
        LengthUc7 length = new LengthUc7(1.0, LengthUnitUc7.FEET);
        assertEquals(12.0, length.convertToBaseUnit(), EPS);
    }

    @Test
    void testConvertTo_TargetUnit() {
        LengthUc7 length = new LengthUc7(12.0, LengthUnitUc7.INCHES);
        LengthUc7 converted = length.convertTo(LengthUnitUc7.FEET);

        assertEquals(1.0, converted.convertToBaseUnit() / 12.0, EPS);
        assertEquals(LengthUnitUc7.FEET, converted.getUnit());
    }


    @Test
    void testCompare_EqualDifferentUnits() {
        LengthUc7 a = new LengthUc7(1.0, LengthUnitUc7.FEET);
        LengthUc7 b = new LengthUc7(12.0, LengthUnitUc7.INCHES);

        assertTrue(a.compare(b));
    }

    @Test
    void testCompare_NotEqual() {
        LengthUc7 a = new LengthUc7(1.0, LengthUnitUc7.FEET);
        LengthUc7 b = new LengthUc7(10.0, LengthUnitUc7.INCHES);

        assertFalse(a.compare(b));
    }

    @Test
    void testCompare_Null() {
        LengthUc7 a = new LengthUc7(1.0, LengthUnitUc7.FEET);

        assertThrows(IllegalArgumentException.class, () -> {
            a.compare(null);
        });
    }

    @Test
    void testEquals_DifferentUnitsSameValue() {
        LengthUc7 a = new LengthUc7(1.0, LengthUnitUc7.FEET);
        LengthUc7 b = new LengthUc7(12.0, LengthUnitUc7.INCHES);

        assertEquals(a, b);
    }


    @Test
    void testAddition_ExplicitTargetUnit_Feet() {
        LengthUc7 result = new LengthUc7(1.0, LengthUnitUc7.FEET)
                .addAndConvert(
                        new LengthUc7(12.0, LengthUnitUc7.INCHES),
                        LengthUnitUc7.FEET
                );

        assertEquals(2.0, result.convertToBaseUnit() / 12.0, EPS);
    }

    @Test
    void testAddition_ExplicitTargetUnit_Inches() {
        LengthUc7 result = new LengthUc7(1.0, LengthUnitUc7.FEET)
                .addAndConvert(
                        new LengthUc7(12.0, LengthUnitUc7.INCHES),
                        LengthUnitUc7.INCHES
                );

        assertEquals(24.0, result.convertToBaseUnit(), EPS);
    }

    @Test
    void testAddition_ExplicitTargetUnit_Yards() {
        LengthUc7 result = new LengthUc7(1.0, LengthUnitUc7.FEET)
                .addAndConvert(
                        new LengthUc7(12.0, LengthUnitUc7.INCHES),
                        LengthUnitUc7.YARDS
                );

        assertEquals(0.6666667, result.convertToBaseUnit() / 36.0, EPS);
    }

    @Test
    void testAddition_Commutativity() {
        LengthUc7 a = new LengthUc7(1.0, LengthUnitUc7.FEET);
        LengthUc7 b = new LengthUc7(12.0, LengthUnitUc7.INCHES);

        LengthUc7 r1 = a.addAndConvert(b, LengthUnitUc7.FEET);
        LengthUc7 r2 = b.addAndConvert(a, LengthUnitUc7.FEET);

        assertEquals(r1.convertToBaseUnit(), r2.convertToBaseUnit(), EPS);
    }

    @Test
    void testAddition_WithZero() {
        LengthUc7 result = new LengthUc7(5.0, LengthUnitUc7.FEET)
                .addAndConvert(
                        new LengthUc7(0.0, LengthUnitUc7.INCHES),
                        LengthUnitUc7.FEET
                );

        assertEquals(5.0, result.convertToBaseUnit() / 12.0, EPS);
    }

    @Test
    void testAddition_NegativeValues() {
        LengthUc7 result = new LengthUc7(5.0, LengthUnitUc7.FEET)
                .addAndConvert(
                        new LengthUc7(-2.0, LengthUnitUc7.FEET),
                        LengthUnitUc7.INCHES
                );

        assertEquals(36.0, result.convertToBaseUnit(), EPS);
    }


    @Test
    void testAddition_NullOperand() {
        LengthUc7 a = new LengthUc7(1.0, LengthUnitUc7.FEET);

        assertThrows(IllegalArgumentException.class, () -> {
            a.addAndConvert(null, LengthUnitUc7.FEET);
        });
    }

    @Test
    void testAddition_NullTargetUnit() {
        LengthUc7 a = new LengthUc7(1.0, LengthUnitUc7.FEET);

        assertThrows(IllegalArgumentException.class, () -> {
            a.addAndConvert(
                    new LengthUc7(12.0, LengthUnitUc7.INCHES),
                    null
            );
        });
    }

    @Test
    void testAddition_LargeValues() {
        LengthUc7 result = new LengthUc7(1e6, LengthUnitUc7.FEET)
                .addAndConvert(
                        new LengthUc7(1e6, LengthUnitUc7.FEET),
                        LengthUnitUc7.FEET
                );

        assertEquals(2e6, result.convertToBaseUnit() / 12.0, EPS);
    }

    @Test
    void testAddition_SmallValues() {
        LengthUc7 result = new LengthUc7(0.001, LengthUnitUc7.FEET)
                .addAndConvert(
                        new LengthUc7(0.002, LengthUnitUc7.FEET),
                        LengthUnitUc7.FEET
                );

        assertEquals(0.003, result.convertToBaseUnit() / 12.0, EPS);
    }
}