package org.example.uc11;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class uc11Test {

    // =========================
    // 🔹 LENGTH TESTS
    // =========================

    @Test
    void lengthFeetEqualsInches() {
        Quantity<LengthUnitUc11> q1 = new Quantity<>(1, LengthUnitUc11.FEET);
        Quantity<LengthUnitUc11> q2 = new Quantity<>(12, LengthUnitUc11.INCHES);

        assertTrue(q1.equals(q2));
    }

    @Test
    void lengthConversionFeetToInches() {
        Quantity<LengthUnitUc11> q = new Quantity<>(1, LengthUnitUc11.FEET);
        Quantity<LengthUnitUc11> result = q.convertTo(LengthUnitUc11.INCHES);

        assertEquals(12.0, result.getValue());
    }

    @Test
    void lengthAdditionFeetAndInches() {
        Quantity<LengthUnitUc11> q1 = new Quantity<>(1, LengthUnitUc11.FEET);
        Quantity<LengthUnitUc11> q2 = new Quantity<>(12, LengthUnitUc11.INCHES);

        Quantity<LengthUnitUc11> result = q1.add(q2);

        assertEquals(2.0, result.getValue());
    }

    // =========================
    // 🔹 WEIGHT TESTS
    // =========================

    @Test
    void weightKgEqualsGram() {
        Quantity<WeightUnitUc11> q1 = new Quantity<>(1, WeightUnitUc11.KILOGRAM);
        Quantity<WeightUnitUc11> q2 = new Quantity<>(1000, WeightUnitUc11.GRAM);

        assertTrue(q1.equals(q2));
    }

    @Test
    void weightConversionKgToGram() {
        Quantity<WeightUnitUc11> q = new Quantity<>(1, WeightUnitUc11.KILOGRAM);
        Quantity<WeightUnitUc11> result = q.convertTo(WeightUnitUc11.GRAM);

        assertEquals(1000.0, result.getValue());
    }

    @Test
    void weightAdditionKgAndGram() {
        Quantity<WeightUnitUc11> q1 = new Quantity<>(1, WeightUnitUc11.KILOGRAM);
        Quantity<WeightUnitUc11> q2 = new Quantity<>(1000, WeightUnitUc11.GRAM);

        Quantity<WeightUnitUc11> result = q1.add(q2);

        assertEquals(2.0, result.getValue());
    }

    // =========================
    // 🔹 VOLUME TESTS (UC11)
    // =========================

    @Test
    void volumeLitreEqualsMillilitre() {
        Quantity<VolumeUnitUc11> q1 = new Quantity<>(1, VolumeUnitUc11.LITRE);
        Quantity<VolumeUnitUc11> q2 = new Quantity<>(1000, VolumeUnitUc11.MILLILITRE);

        assertTrue(q1.equals(q2));
    }

    @Test
    void volumeGallonEqualsLitre() {
        Quantity<VolumeUnitUc11> q1 = new Quantity<>(1, VolumeUnitUc11.GALLON);
        Quantity<VolumeUnitUc11> q2 = new Quantity<>(3.78541, VolumeUnitUc11.LITRE);

        assertTrue(q1.equals(q2));
    }

    @Test
    void volumeConversionLitreToMillilitre() {
        Quantity<VolumeUnitUc11> q = new Quantity<>(1, VolumeUnitUc11.LITRE);
        Quantity<VolumeUnitUc11> result = q.convertTo(VolumeUnitUc11.MILLILITRE);

        assertEquals(1000.0, result.getValue());
    }

    @Test
    void volumeConversionGallonToLitre() {
        Quantity<VolumeUnitUc11> q = new Quantity<>(1, VolumeUnitUc11.GALLON);
        Quantity<VolumeUnitUc11> result = q.convertTo(VolumeUnitUc11.LITRE);

        assertEquals(3.79, result.getValue(), 0.0001);
    }

    @Test
    void volumeAdditionLitreAndMillilitre() {
        Quantity<VolumeUnitUc11> q1 = new Quantity<>(1, VolumeUnitUc11.LITRE);
        Quantity<VolumeUnitUc11> q2 = new Quantity<>(1000, VolumeUnitUc11.MILLILITRE);

        Quantity<VolumeUnitUc11> result = q1.add(q2);

        assertEquals(2.0, result.getValue());
    }

    @Test
    void volumeAdditionGallonAndLitre() {
        Quantity<VolumeUnitUc11> q1 = new Quantity<>(1, VolumeUnitUc11.GALLON);
        Quantity<VolumeUnitUc11> q2 = new Quantity<>(3.78541, VolumeUnitUc11.LITRE);

        Quantity<VolumeUnitUc11> result =
                q1.add(q2, VolumeUnitUc11.GALLON);

        assertEquals(2.0, result.getValue(), 0.01);
    }

    // =========================
    // 🔴 CROSS CATEGORY TESTS
    // =========================

    @Test
    void volumeVsLengthNotEqual() {
        Quantity<VolumeUnitUc11> v = new Quantity<>(1, VolumeUnitUc11.LITRE);
        Quantity<LengthUnitUc11> l = new Quantity<>(1, LengthUnitUc11.FEET);

        assertFalse(v.equals(l));
    }

    @Test
    void volumeVsWeightNotEqual() {
        Quantity<VolumeUnitUc11> v = new Quantity<>(1, VolumeUnitUc11.LITRE);
        Quantity<WeightUnitUc11> w = new Quantity<>(1, WeightUnitUc11.KILOGRAM);

        assertFalse(v.equals(w));
    }

    // =========================
    // 🔵 EDGE CASES
    // =========================

    @Test
    void zeroValuesEquality() {
        Quantity<VolumeUnitUc11> q1 = new Quantity<>(0, VolumeUnitUc11.LITRE);
        Quantity<VolumeUnitUc11> q2 = new Quantity<>(0, VolumeUnitUc11.MILLILITRE);

        assertTrue(q1.equals(q2));
    }

    @Test
    void negativeValues() {
        Quantity<VolumeUnitUc11> q1 = new Quantity<>(-1, VolumeUnitUc11.LITRE);
        Quantity<VolumeUnitUc11> q2 = new Quantity<>(-1000, VolumeUnitUc11.MILLILITRE);

        assertTrue(q1.equals(q2));
    }

    @Test
    void largeValues() {
        Quantity<VolumeUnitUc11> q1 = new Quantity<>(1_000_000, VolumeUnitUc11.MILLILITRE);
        Quantity<VolumeUnitUc11> q2 = new Quantity<>(1000, VolumeUnitUc11.LITRE);

        assertTrue(q1.equals(q2));
    }

    @Test
    void constructorNullUnit() {
        assertThrows(IllegalArgumentException.class,
                () -> new Quantity<>(1, null));
    }

    @Test
    void constructorInvalidValue() {
        assertThrows(IllegalArgumentException.class,
                () -> new Quantity<>(Double.NaN, VolumeUnitUc11.LITRE));
    }

    // =========================
    // 🔵 HASHCODE + EQUALS CONTRACT
    // =========================

    @Test
    void hashCodeConsistency() {
        Quantity<VolumeUnitUc11> q1 = new Quantity<>(1, VolumeUnitUc11.LITRE);
        Quantity<VolumeUnitUc11> q2 = new Quantity<>(1000, VolumeUnitUc11.MILLILITRE);

        assertEquals(q1.hashCode(), q2.hashCode());
    }

    @Test
    void equalsReflexive() {
        Quantity<VolumeUnitUc11> q = new Quantity<>(1, VolumeUnitUc11.LITRE);

        assertEquals(q, q);
    }

    @Test
    void equalsSymmetric() {
        Quantity<VolumeUnitUc11> q1 = new Quantity<>(1, VolumeUnitUc11.LITRE);
        Quantity<VolumeUnitUc11> q2 = new Quantity<>(1000, VolumeUnitUc11.MILLILITRE);

        assertEquals(q1, q2);
        assertEquals(q2, q1);
    }

    @Test
    void equalsTransitive() {
        Quantity<VolumeUnitUc11> q1 = new Quantity<>(1, VolumeUnitUc11.LITRE);
        Quantity<VolumeUnitUc11> q2 = new Quantity<>(1000, VolumeUnitUc11.MILLILITRE);
        Quantity<VolumeUnitUc11> q3 = new Quantity<>(1, VolumeUnitUc11.LITRE);

        assertEquals(q1, q2);
        assertEquals(q2, q3);
        assertEquals(q1, q3);
    }
}