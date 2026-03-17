import org.example.usecase4.LengthUc4;
import org.example.usecase4.LengthUnitUc4;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Uc4Test {

    @Test
    void testEquality_YardToYard_SameValue() {
        assertEquals(new LengthUc4(1.0, LengthUnitUc4.YARDS),
                new LengthUc4(1.0, LengthUnitUc4.YARDS));
    }

    @Test
    void testEquality_YardToYard_DifferentValue() {
        assertNotEquals(new LengthUc4(1.0, LengthUnitUc4.YARDS),
                new LengthUc4(2.0, LengthUnitUc4.YARDS));
    }

    @Test
    void testEquality_YardToFeet_EquivalentValue() {
        assertEquals(new LengthUc4(1.0, LengthUnitUc4.YARDS),
                new LengthUc4(3.0, LengthUnitUc4.FEET));
    }

    @Test
    void testEquality_FeetToYard_EquivalentValue() {
        assertEquals(new LengthUc4(3.0, LengthUnitUc4.FEET),
                new LengthUc4(1.0, LengthUnitUc4.YARDS));
    }

    @Test
    void testEquality_YardToInches_EquivalentValue() {
        assertEquals(new LengthUc4(1.0, LengthUnitUc4.YARDS),
                new LengthUc4(36.0, LengthUnitUc4.INCHES));
    }

    @Test
    void testEquality_InchesToYard_EquivalentValue() {
        assertEquals(new LengthUc4(36.0, LengthUnitUc4.INCHES),
                new LengthUc4(1.0, LengthUnitUc4.YARDS));
    }

    @Test
    void testEquality_YardToFeet_NonEquivalentValue() {
        assertNotEquals(new LengthUc4(1.0, LengthUnitUc4.YARDS),
                new LengthUc4(2.0, LengthUnitUc4.FEET));
    }

    @Test
    void testEquality_CentimetersToInches_EquivalentValue() {
        assertEquals(new LengthUc4(1.0, LengthUnitUc4.CENTIMETERS),
                new LengthUc4(0.393701, LengthUnitUc4.INCHES));
    }

    @Test
    void testEquality_CentimetersToFeet_NonEquivalentValue() {
        assertNotEquals(new LengthUc4(1.0, LengthUnitUc4.CENTIMETERS),
                new LengthUc4(1.0, LengthUnitUc4.FEET));
    }

    @Test
    void testEquality_MultiUnit_TransitiveProperty() {
        LengthUc4 yard = new LengthUc4(1.0, LengthUnitUc4.YARDS);
        LengthUc4 feet = new LengthUc4(3.0, LengthUnitUc4.FEET);
        LengthUc4 inches = new LengthUc4(36.0, LengthUnitUc4.INCHES);

        assertEquals(yard, feet);
        assertEquals(feet, inches);
        assertEquals(yard, inches);
    }

    @Test
    void testEquality_YardWithNullUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new LengthUc4(1.0, null);
        });
    }

    @Test
    void testEquality_YardSameReference() {
        LengthUc4 l = new LengthUc4(2.0, LengthUnitUc4.YARDS);
        assertEquals(l, l);
    }

    @Test
    void testEquality_YardNullComparison() {
        LengthUc4 l = new LengthUc4(2.0, LengthUnitUc4.YARDS);
        assertNotEquals(l, null);
    }

    @Test
    void testEquality_CentimetersWithNullUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new LengthUc4(5.0, null);
        });
    }

    @Test
    void testEquality_CentimetersSameReference() {
        LengthUc4 l = new LengthUc4(5.0, LengthUnitUc4.CENTIMETERS);
        assertEquals(l, l);
    }

    @Test
    void testEquality_CentimetersNullComparison() {
        LengthUc4 l = new LengthUc4(5.0, LengthUnitUc4.CENTIMETERS);
        assertNotEquals(l, null);
    }

    @Test
    void testEquality_AllUnits_ComplexScenario() {
        LengthUc4 yard = new LengthUc4(2.0, LengthUnitUc4.YARDS);
        LengthUc4 feet = new LengthUc4(6.0, LengthUnitUc4.FEET);
        LengthUc4 inches = new LengthUc4(72.0, LengthUnitUc4.INCHES);

        assertEquals(yard, feet);
        assertEquals(feet, inches);
        assertEquals(yard, inches);
    }
}