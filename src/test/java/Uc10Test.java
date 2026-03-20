import org.example.uc10.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Uc10Test {
    @Test
    public void lengthFeetEqualsInches() {
        Quantity<LengthUnitUc10> q1 = new Quantity<>(1, LengthUnitUc10.FEET);
        Quantity<LengthUnitUc10> q2 = new Quantity<>(12, LengthUnitUc10.INCHES);

        assertTrue(q1.equals(q2));
    }

    @Test
    public void lengthYardsEqualsFeet() {
        Quantity<LengthUnitUc10> q1 = new Quantity<>(1, LengthUnitUc10.YARDS);
        Quantity<LengthUnitUc10> q2 = new Quantity<>(3, LengthUnitUc10.FEET);

        assertTrue(q1.equals(q2));
    }

    @Test
    public void weightKilogramEqualsGrams() {
        Quantity<WeightUnitUc10> q1 = new Quantity<>(1, WeightUnitUc10.KILOGRAM);
        Quantity<WeightUnitUc10> q2 = new Quantity<>(1000, WeightUnitUc10.GRAM);

        assertTrue(q1.equals(q2));
    }

    @Test
    public void weightPoundEqualsGrams() {
        Quantity<WeightUnitUc10> q1 = new Quantity<>(1, WeightUnitUc10.POUND);
        Quantity<WeightUnitUc10> q2 = new Quantity<>(453.592, WeightUnitUc10.GRAM);

        assertTrue(q1.equals(q2));
    }
    @Test
    public void convertLengthFeetToInches() {
        Quantity<LengthUnitUc10> q = new Quantity<>(1, LengthUnitUc10.FEET);

        Quantity<LengthUnitUc10> result =
                QuantityMeasurementApp.demonstrateConversion(q, LengthUnitUc10.INCHES);

        assertEquals(12.0, result.getValue());
    }

    @Test
    public void convertWeightKilogramsToGrams() {
        Quantity<WeightUnitUc10> q = new Quantity<>(1, WeightUnitUc10.KILOGRAM);

        Quantity<WeightUnitUc10> result =
                QuantityMeasurementApp.demonstrateConversion(q, WeightUnitUc10.GRAM);

        assertEquals(1000.0, result.getValue());
    }

    @Test
    public void convertLengthYardsToInches() {
        Quantity<LengthUnitUc10> q = new Quantity<>(1, LengthUnitUc10.YARDS);

        Quantity<LengthUnitUc10> result =
                QuantityMeasurementApp.demonstrateConversion(q, LengthUnitUc10.INCHES);

        assertEquals(36.0, result.getValue());
    }
    @Test
    public void addLengthFeetAndInches() {
        Quantity<LengthUnitUc10> q1 = new Quantity<>(1, LengthUnitUc10.FEET);
        Quantity<LengthUnitUc10> q2 = new Quantity<>(12, LengthUnitUc10.INCHES);

        Quantity<LengthUnitUc10> result =
                QuantityMeasurementApp.demonstrateAddition(q1, q2);

        assertEquals(2.0, result.getValue());
    }

    @Test
    public void addWeightKilogramsAndGrams() {
        Quantity<WeightUnitUc10> q1 = new Quantity<>(1, WeightUnitUc10.KILOGRAM);
        Quantity<WeightUnitUc10> q2 = new Quantity<>(1000, WeightUnitUc10.GRAM);

        Quantity<WeightUnitUc10> result =
                QuantityMeasurementApp.demonstrateAddition(q1, q2);

        assertEquals(2.0, result.getValue());
    }

    @Test
    public void addWeightKilogramsAndPounds() {
        Quantity<WeightUnitUc10> q1 = new Quantity<>(1, WeightUnitUc10.KILOGRAM);
        Quantity<WeightUnitUc10> q2 = new Quantity<>(1, WeightUnitUc10.POUND);

        Quantity<WeightUnitUc10> result =
                QuantityMeasurementApp.demonstrateAddition(q1, q2, WeightUnitUc10.KILOGRAM);

        assertEquals(1.45, result.getValue(), 0.01);
    }

    @Test
    public void addLengthYardsAndFeet() {
        Quantity<LengthUnitUc10> q1 = new Quantity<>(1, LengthUnitUc10.YARDS);
        Quantity<LengthUnitUc10> q2 = new Quantity<>(3, LengthUnitUc10.FEET);

        Quantity<LengthUnitUc10> result =
                QuantityMeasurementApp.demonstrateAddition(q1, q2, LengthUnitUc10.YARDS);

        assertEquals(2.0, result.getValue());
    }

    @Test
    public void addWeightTonnesAndKilograms() {
        Quantity<WeightUnitUc10> q1 = new Quantity<>(1, WeightUnitUc10.TONNE);
        Quantity<WeightUnitUc10> q2 = new Quantity<>(1000, WeightUnitUc10.KILOGRAM);

        Quantity<WeightUnitUc10> result =
                QuantityMeasurementApp.demonstrateAddition(q1, q2, WeightUnitUc10.TONNE);

        assertEquals(2.0, result.getValue());
    }
    @Test
    public void preventCrossTypeComparisonLengthVsWeight() {
        Quantity<LengthUnitUc10> length = new Quantity<>(1, LengthUnitUc10.FEET);
        Quantity<WeightUnitUc10> weight = new Quantity<>(1, WeightUnitUc10.KILOGRAM);

        assertFalse(length.equals(weight));
    }

    @Test
    public void preventCrossTypeAdditionLengthVsWeight() {
        Quantity<LengthUnitUc10> length = new Quantity<>(1, LengthUnitUc10.FEET);
        Quantity<WeightUnitUc10> weight = new Quantity<>(1, WeightUnitUc10.KILOGRAM);

        assertThrows(IllegalArgumentException.class, () -> {
            length.add((Quantity) weight);
        });
    }
    @Test
    void testIMeasurableInterface_LengthUnitImplementation() {
        LengthUnitUc10 unit = LengthUnitUc10.FEET;

        assertNotNull(unit.getConversionFactor());
        assertEquals(12.0, unit.getConversionFactor());
        assertEquals(12.0, unit.convertToBaseUnit(1));
        assertEquals(1.0, unit.convertFromBaseUnit(12));
        assertEquals("FEET", unit.getUnitName());
    }

    @Test
    void testIMeasurableInterface_WeightUnitImplementation() {
        WeightUnitUc10 unit = WeightUnitUc10.KILOGRAM;

        assertNotNull(unit.getConversionFactor());
        assertEquals(1.0, unit.getConversionFactor());
        assertEquals(1.0, unit.convertToBaseUnit(1));
        assertEquals(1.0, unit.convertFromBaseUnit(1));
        assertEquals("KILOGRAM", unit.getUnitName());
    }

    @Test
    void testIMeasurableInterface_ConsistentBehavior() {
        assertTrue(LengthUnitUc10.FEET instanceof IMeasurable);
        assertTrue(WeightUnitUc10.KILOGRAM instanceof IMeasurable);
    }

    // ✅ Equality Tests

    @Test
    void testGenericQuantity_LengthOperations_Equality() {
        Quantity<LengthUnitUc10> q1 = new Quantity<>(1.0, LengthUnitUc10.FEET);
        Quantity<LengthUnitUc10> q2 = new Quantity<>(12.0, LengthUnitUc10.INCHES);

        assertEquals(q1, q2);
    }

    @Test
    void testGenericQuantity_WeightOperations_Equality() {
        Quantity<WeightUnitUc10> q1 = new Quantity<>(1.0, WeightUnitUc10.KILOGRAM);
        Quantity<WeightUnitUc10> q2 = new Quantity<>(1000.0, WeightUnitUc10.GRAM);

        assertEquals(q1, q2);
    }

    // ✅ Conversion Tests

    @Test
    void testGenericQuantity_LengthOperations_Conversion() {
        Quantity<LengthUnitUc10> q = new Quantity<>(1.0, LengthUnitUc10.FEET);
        Quantity<LengthUnitUc10> result = q.convertTo(LengthUnitUc10.INCHES);

        assertEquals(12.0, result.getValue());
        assertEquals(LengthUnitUc10.INCHES, result.getUnit());
    }

    @Test
    void testGenericQuantity_WeightOperations_Conversion() {
        Quantity<WeightUnitUc10> q = new Quantity<>(1.0, WeightUnitUc10.KILOGRAM);
        Quantity<WeightUnitUc10> result = q.convertTo(WeightUnitUc10.GRAM);

        assertEquals(1000.0, result.getValue());
        assertEquals(WeightUnitUc10.GRAM, result.getUnit());
    }

    // ✅ Addition Tests

    @Test
    void testGenericQuantity_LengthOperations_Addition() {
        Quantity<LengthUnitUc10> q1 = new Quantity<>(1.0, LengthUnitUc10.FEET);
        Quantity<LengthUnitUc10> q2 = new Quantity<>(12.0, LengthUnitUc10.INCHES);

        Quantity<LengthUnitUc10> result = q1.add(q2, LengthUnitUc10.FEET);

        assertEquals(2.0, result.getValue());
    }

    @Test
    void testGenericQuantity_WeightOperations_Addition() {
        Quantity<WeightUnitUc10> q1 = new Quantity<>(1.0, WeightUnitUc10.KILOGRAM);
        Quantity<WeightUnitUc10> q2 = new Quantity<>(1000.0, WeightUnitUc10.GRAM);

        Quantity<WeightUnitUc10> result = q1.add(q2, WeightUnitUc10.KILOGRAM);

        assertEquals(2.0, result.getValue());
    }

    // ✅ Cross Category Tests

    @Test
    void testCrossCategoryPrevention_LengthVsWeight() {
        Quantity<LengthUnitUc10> length = new Quantity<>(1.0, LengthUnitUc10.FEET);
        Quantity<WeightUnitUc10> weight = new Quantity<>(1.0, WeightUnitUc10.KILOGRAM);

        assertNotEquals(length, weight);
    }

    // (Compile-time safety cannot be tested directly in JUnit)

    // ✅ Constructor Validation

    @Test
    void testGenericQuantity_ConstructorValidation_NullUnit() {
        assertThrows(IllegalArgumentException.class,
                () -> new Quantity<>(1.0, null));
    }

    @Test
    void testGenericQuantity_ConstructorValidation_InvalidValue() {
        assertThrows(IllegalArgumentException.class,
                () -> new Quantity<>(Double.NaN, LengthUnitUc10.FEET));
    }

    // ✅ All Unit Conversion Combinations

    @Test
    void testGenericQuantity_Conversion_AllUnitCombinations() {
        Quantity<LengthUnitUc10> q = new Quantity<>(1.0, LengthUnitUc10.FEET);

        for (LengthUnitUc10 unit : LengthUnitUc10.values()) {
            Quantity<LengthUnitUc10> converted = q.convertTo(unit);
            assertNotNull(converted);
        }
    }

    // ✅ Addition All Combinations

    @Test
    void testGenericQuantity_Addition_AllUnitCombinations() {
        Quantity<LengthUnitUc10> q1 = new Quantity<>(1.0, LengthUnitUc10.FEET);

        for (LengthUnitUc10 unit : LengthUnitUc10.values()) {
            Quantity<LengthUnitUc10> q2 = new Quantity<>(1.0, unit);
            Quantity<LengthUnitUc10> result = q1.add(q2, LengthUnitUc10.FEET);

            assertNotNull(result);
        }
    }

    // ✅ HashCode Consistency

    @Test
    void testHashCode_GenericQuantity_Consistency() {
        Quantity<LengthUnitUc10> q1 = new Quantity<>(1.0, LengthUnitUc10.FEET);
        Quantity<LengthUnitUc10> q2 = new Quantity<>(12.0, LengthUnitUc10.INCHES);

        assertEquals(q1.hashCode(), q2.hashCode());
    }

    // ✅ Equals Contract

    @Test
    void testEquals_GenericQuantity_ContractPreservation() {
        Quantity<LengthUnitUc10> q1 = new Quantity<>(1.0, LengthUnitUc10.FEET);
        Quantity<LengthUnitUc10> q2 = new Quantity<>(12.0, LengthUnitUc10.INCHES);
        Quantity<LengthUnitUc10> q3 = new Quantity<>(1.0, LengthUnitUc10.FEET);

        // Reflexive
        assertEquals(q1, q1);

        // Symmetric
        assertEquals(q1, q2);
        assertEquals(q2, q1);

        // Transitive
        assertEquals(q1, q2);
        assertEquals(q2, q3);
        assertEquals(q1, q3);
    }

    // ✅ Immutability

    @Test
    void testImmutability_GenericQuantity() {
        Quantity<LengthUnitUc10> q1 = new Quantity<>(1.0, LengthUnitUc10.FEET);
        Quantity<LengthUnitUc10> q2 = q1.convertTo(LengthUnitUc10.INCHES);

        assertNotSame(q1, q2);
    }
}
