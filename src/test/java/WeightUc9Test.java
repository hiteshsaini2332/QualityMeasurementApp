package org.example.uc9;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WeightUc9Test {

    private static final double EPSILON = 0.01;


    @Test
    void testEquality_KilogramToKilogram_SameValue() {
        assertTrue(new WeightUc9(1, WeightUnitUc9.KILOGRAM)
                .equals(new WeightUc9(1, WeightUnitUc9.KILOGRAM)));
    }

    @Test
    void testEquality_KilogramToKilogram_DifferentValue() {
        assertFalse(new WeightUc9(1, WeightUnitUc9.KILOGRAM)
                .equals(new WeightUc9(2, WeightUnitUc9.KILOGRAM)));
    }

    @Test
    void testEquality_KilogramToGram() {
        assertTrue(new WeightUc9(1, WeightUnitUc9.KILOGRAM)
                .equals(new WeightUc9(1000, WeightUnitUc9.GRAM)));
    }

    @Test
    void testEquality_KilogramToPound() {
        assertTrue(new WeightUc9(1, WeightUnitUc9.KILOGRAM)
                .equals(new WeightUc9(2.20462, WeightUnitUc9.POUND)));
    }

    @Test
    void testEquality_NullComparison() {
        assertFalse(new WeightUc9(1, WeightUnitUc9.KILOGRAM).equals(null));
    }

    @Test
    void testEquality_SameReference() {
        WeightUc9 w = new WeightUc9(1, WeightUnitUc9.KILOGRAM);
        assertTrue(w.equals(w));
    }

    // -------------------------------
    // Conversion Tests
    // -------------------------------

    @Test
    void testConversion_KilogramToGram() {
        WeightUc9 result = new WeightUc9(1, WeightUnitUc9.KILOGRAM)
                .convertTo(WeightUnitUc9.GRAM);

        assertEquals(1000, result.getValue(), EPSILON);
    }

    @Test
    void testConversion_PoundToKilogram() {
        WeightUc9 result = new WeightUc9(2.20462, WeightUnitUc9.POUND)
                .convertTo(WeightUnitUc9.KILOGRAM);

        assertEquals(1.0, result.getValue(), EPSILON);
    }

    @Test
    void testConversion_ZeroValue() {
        WeightUc9 result = new WeightUc9(0, WeightUnitUc9.KILOGRAM)
                .convertTo(WeightUnitUc9.GRAM);

        assertEquals(0, result.getValue(), EPSILON);
    }

    @Test
    void testConversion_RoundTrip() {
        WeightUc9 original = new WeightUc9(1.5, WeightUnitUc9.KILOGRAM);

        WeightUc9 result = original
                .convertTo(WeightUnitUc9.GRAM)
                .convertTo(WeightUnitUc9.KILOGRAM);

        assertEquals(original.getValue(), result.getValue(), EPSILON);
    }

    // -------------------------------
    // Addition Tests
    // -------------------------------

    @Test
    void testAddition_SameUnit() {
        WeightUc9 result = new WeightUc9(1, WeightUnitUc9.KILOGRAM)
                .add(new WeightUc9(2, WeightUnitUc9.KILOGRAM));

        assertEquals(3, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_KgPlusGram() {
        WeightUc9 result = new WeightUc9(1, WeightUnitUc9.KILOGRAM)
                .add(new WeightUc9(1000, WeightUnitUc9.GRAM));

        assertEquals(2, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_PoundPlusKg() {
        WeightUc9 result = new WeightUc9(2.20462, WeightUnitUc9.POUND)
                .add(new WeightUc9(1, WeightUnitUc9.KILOGRAM),
                        WeightUnitUc9.POUND);

        assertEquals(4.41, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_ExplicitTargetUnit() {
        WeightUc9 result = new WeightUc9(1, WeightUnitUc9.KILOGRAM)
                .add(new WeightUc9(1000, WeightUnitUc9.GRAM),
                        WeightUnitUc9.GRAM);

        assertEquals(2000, result.getValue(), EPSILON);
    }

    @Test
    void testAddition_WithZero() {
        WeightUc9 result = new WeightUc9(5, WeightUnitUc9.KILOGRAM)
                .add(new WeightUc9(0, WeightUnitUc9.GRAM));

        assertEquals(5, result.getValue(), EPSILON);
    }

    // -------------------------------
    // Validation Tests
    // -------------------------------

    @Test
    void testNullUnit() {
        assertThrows(IllegalArgumentException.class, () ->
                new WeightUc9(1, null));
    }

    @Test
    void testInvalidValue() {
        assertThrows(IllegalArgumentException.class, () ->
                new WeightUc9(Double.NaN, WeightUnitUc9.KILOGRAM));
    }
}