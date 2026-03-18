package org.example.usecase6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Uc6Test {

    private static final double EPS = 1e-6;

    @Test
    void testConstructorNullUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new LengthUc6(10.0, null);
        });
    }

    @Test
    void testConvertToBaseUnitFeetToInches() {
        LengthUc6 length = new LengthUc6(1.0, LengthUnitUc6.FEET);
        assertEquals(12.0, length.convertToBaseUnit(), EPS);
    }

//    @Test
//    void testConvertToTargetUnit() {
//        LengthUc6 length = new LengthUc6(12.0, LengthUnitUc6.INCHES);
//        LengthUc6 converted = length.convertTo(LengthUnitUc6.FEET);
//
//        assertEquals(1.0, converted.convertToBaseUnit(), EPS);
//        assertEquals(LengthUnitUc6.FEET, converted.getUnit());
//    }

    @Test
    void testCompareEqualDifferentUnits() {
        LengthUc6 a = new LengthUc6(1.0, LengthUnitUc6.FEET);
        LengthUc6 b = new LengthUc6(12.0, LengthUnitUc6.INCHES);

        assertTrue(a.compare(b));
    }

    @Test
    void testEqualsEqualDifferentUnits() {
        LengthUc6 a = new LengthUc6(1.0, LengthUnitUc6.FEET);
        LengthUc6 b = new LengthUc6(12.0, LengthUnitUc6.INCHES);

        assertEquals(a, b);
    }

    @Test
    void testCompareNotEqual() {
        LengthUc6 a = new LengthUc6(1.0, LengthUnitUc6.FEET);
        LengthUc6 b = new LengthUc6(10.0, LengthUnitUc6.INCHES);

        assertFalse(a.compare(b));
    }

    @Test
    void testCompareNull() {
        LengthUc6 a = new LengthUc6(1.0, LengthUnitUc6.FEET);

        assertThrows(IllegalArgumentException.class, () -> {
            a.compare(null);
        });
    }

    @Test
    void testAdditionSameUnit() {
        LengthUc6 a = new LengthUc6(1.0, LengthUnitUc6.FEET);
        LengthUc6 b = new LengthUc6(2.0, LengthUnitUc6.FEET);

        LengthUc6 result = a.add(b);

        assertEquals(3.0, result.convertToBaseUnit() / 12.0, EPS);
    }

    @Test
    void testAdditionCrossUnitFeetPlusInches() {
        LengthUc6 a = new LengthUc6(1.0, LengthUnitUc6.FEET);
        LengthUc6 b = new LengthUc6(12.0, LengthUnitUc6.INCHES);

        LengthUc6 result = a.add(b);

        assertTrue(result.compare(new LengthUc6(2.0, LengthUnitUc6.FEET)));
    }

    @Test
    void testAdditionCrossUnitYardPlusFeet() {
        LengthUc6 a = new LengthUc6(1.0, LengthUnitUc6.YARDS);
        LengthUc6 b = new LengthUc6(3.0, LengthUnitUc6.FEET);

        LengthUc6 result = a.add(b);

        assertTrue(result.compare(new LengthUc6(2.0, LengthUnitUc6.YARDS)));
    }

    @Test
    void testAdditionWithZero() {
        LengthUc6 a = new LengthUc6(5.0, LengthUnitUc6.FEET);
        LengthUc6 zero = new LengthUc6(0.0, LengthUnitUc6.INCHES);

        LengthUc6 result = a.add(zero);

        assertTrue(result.compare(a));
    }

    @Test
    void testAdditionNegativeValues() {
        LengthUc6 a = new LengthUc6(5.0, LengthUnitUc6.FEET);
        LengthUc6 b = new LengthUc6(-2.0, LengthUnitUc6.FEET);

        LengthUc6 result = a.add(b);

        assertTrue(result.compare(new LengthUc6(3.0, LengthUnitUc6.FEET)));
    }

    @Test
    void testAdditionNullOperand() {
        LengthUc6 a = new LengthUc6(1.0, LengthUnitUc6.FEET);

        assertThrows(IllegalArgumentException.class, () -> {
            a.add(null);
        });
    }

    @Test
    void testAdditionLargeValues() {
        LengthUc6 a = new LengthUc6(1e6, LengthUnitUc6.FEET);
        LengthUc6 b = new LengthUc6(1e6, LengthUnitUc6.FEET);

        LengthUc6 result = a.add(b);

        assertTrue(result.compare(new LengthUc6(2e6, LengthUnitUc6.FEET)));
    }

    @Test
    void testAdditionSmallValues() {
        LengthUc6 a = new LengthUc6(0.001, LengthUnitUc6.FEET);
        LengthUc6 b = new LengthUc6(0.002, LengthUnitUc6.FEET);

        LengthUc6 result = a.add(b);

        assertTrue(result.compare(new LengthUc6(0.003, LengthUnitUc6.FEET)));
    }


    @Test
    void testConvertInvalidValue() {
        LengthUc6 length = new LengthUc6(10.0, LengthUnitUc6.FEET);

        assertThrows(IllegalArgumentException.class, () -> {
            length.convertFromBaseToTargetUnit(Double.NaN, LengthUnitUc6.FEET);
        });
    }

    @Test
    void testConvertNullTargetUnit() {
        LengthUc6 length = new LengthUc6(10.0, LengthUnitUc6.FEET);

        assertThrows(IllegalArgumentException.class, () -> {
            length.convertFromBaseToTargetUnit(10.0, null);
        });
    }
}