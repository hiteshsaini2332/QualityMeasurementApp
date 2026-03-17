import org.example.usecase5.LengthUc5;
import org.example.usecase5.LengthUnitUc5;
import org.junit.jupiter.api.Test;

import static org.example.usecase5.LengthUc5.convert;
import static org.junit.jupiter.api.Assertions.*;

public class Uc5Test {

    private static final double EPS = 1e-6;

    @Test
    void testConversion_FeetToInches() {
        assertEquals(12.0,
                convert(1.0,
                        LengthUnitUc5.FEET,
                        LengthUnitUc5.INCHES), EPS);
    }

    @Test
    void testConversion_InchesToFeet() {
        assertEquals(2.0,
                convert(24.0,
                        LengthUnitUc5.INCHES,
                        LengthUnitUc5.FEET), EPS);
    }

    @Test
    void testConversion_YardsToInches() {
        assertEquals(36.0,
                convert(1.0,
                        LengthUnitUc5.YARDS,
                        LengthUnitUc5.INCHES), EPS);
    }

    @Test
    void testConversion_CentimetersToInches() {
        assertEquals(1.0,
                convert(2.54,
                        LengthUnitUc5.CENTIMETERS,
                        LengthUnitUc5.INCHES), EPS);
    }

    @Test
    void testConversion_RoundTrip() {
        double value = 5.0;

        double converted = convert(value,
                LengthUnitUc5.FEET,
                LengthUnitUc5.INCHES);

        double back = convert(converted,
                LengthUnitUc5.INCHES,
                LengthUnitUc5.FEET);

        assertEquals(value, back, EPS);
    }

    @Test
    void testConversion_ZeroValue() {
        assertEquals(0.0,
                convert(0.0,
                        LengthUnitUc5.FEET,
                        LengthUnitUc5.INCHES), EPS);
    }

    @Test
    void testConversion_NegativeValue() {
        assertEquals(-12.0,
                convert(-1.0,
                        LengthUnitUc5.FEET,
                        LengthUnitUc5.INCHES), EPS);
    }

    @Test
    void testConversion_InvalidUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
          convert(1.0, null,
                    LengthUnitUc5.FEET);
        });
    }

    @Test
    void testConversion_NaN() {
        assertThrows(IllegalArgumentException.class, () -> {
            convert(Double.NaN,
                    LengthUnitUc5.FEET,
                    LengthUnitUc5.INCHES);
        });
    }
}