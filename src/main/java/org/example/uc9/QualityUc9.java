package org.example.uc9;

public class QualityUc9 {
    public static boolean demonstrateLengthEquality(LengthUc9 length1, LengthUc9 length2) {
        double base1 = length1.getUnit().convertToBaseUnit(length1.getLength());
        double base2 = length2.getUnit().convertToBaseUnit((length2.getLength()));
        return Double.compare(base1, base2) == 0;
    }
    public static boolean demonstrateLengthComparison(double value1, LengthUnitUc9 unit1,
                                                      double value2, LengthUnitUc9 unit2) {
        double base1 = unit1.convertToBaseUnit(value1);
        double base2 = unit2.convertToBaseUnit(value2);
        return base1 > base2;
    }
    public static LengthUc9 demonstrateLengthConversion(double value,
                                                        LengthUnitUc9 fromUnit,
                                                        LengthUnitUc9 toUnit) {
        double base = fromUnit.convertToBaseUnit(value);
        double converted = toUnit.convertFromBaseUnit(base);
        return new LengthUc9(converted, toUnit);
    }
    public static LengthUc9 demonstrateLengthConversion(LengthUc9 length,
                                                        LengthUnitUc9 toUnit) {
        double base = length.getUnit().convertToBaseUnit(length.getLength());
        double converted = toUnit.convertFromBaseUnit(base);
        return new LengthUc9(converted, toUnit);
    }
    public static LengthUc9 demonstrateLengthAddition(LengthUc9 length1, LengthUc9 length2) {
        double base1 = length1.getUnit().convertToBaseUnit(length1.getLength());
        double base2 = length2.getUnit().convertToBaseUnit(length2.getLength());
        double sumBase = base1 + base2;

        // return in first length's unit
        double result = length1.getUnit().convertFromBaseUnit(sumBase);
        return new LengthUc9(result, length1.getUnit());
    }
    public static LengthUc9 demonstrateLengthAddition(LengthUc9 length1,
                                                      LengthUc9 length2,
                                                      LengthUnitUc9 targetUnit) {
        double base1 = length1.getUnit().convertToBaseUnit(length1.getLength());
        double base2 = length2.getUnit().convertToBaseUnit(length2.getLength());
        double sumBase = base1 + base2;

        double result = targetUnit.convertFromBaseUnit(sumBase);
        return new LengthUc9(result, targetUnit);
    }

    public static void main(String[] args) {

        // Create Length objects (assuming Length class uses LengthUnitUc9)
        LengthUc9 length1 = new LengthUc9(3, LengthUnitUc9.FEET);        // 3 feet
        LengthUc9 length2 = new LengthUc9(36, LengthUnitUc9.INCHES);     // 36 inches
        LengthUc9 length3 = new LengthUc9(100, LengthUnitUc9.CENTIMETERS); // 100 cm

        // 1. Equality check
        boolean isEqual = demonstrateLengthEquality(length1, length2);
        System.out.println("3 feet == 36 inches? " + isEqual);

        // 2. Comparison
        boolean isGreater = demonstrateLengthComparison(2, LengthUnitUc9.YARDS,
                5, LengthUnitUc9.FEET);
        System.out.println("2 yards > 5 feet? " + isGreater);

        // 3. Conversion (value + units)
        LengthUc9 converted1 = demonstrateLengthConversion(1, LengthUnitUc9.YARDS,
                LengthUnitUc9.FEET);
        System.out.println("1 yard in feet: " +
                converted1.getLength() + " " + converted1.getUnit());

        // 4. Conversion (Length object)
        LengthUc9 converted2 = demonstrateLengthConversion(length3, LengthUnitUc9.INCHES);
        System.out.println("100 cm in inches: " +
                converted2.getLength() + " " + converted2.getUnit());

        // 5. Addition (default unit of first length)
        LengthUc9 sum1 = demonstrateLengthAddition(length1, length3);
        System.out.println("3 feet + 100 cm = " +
                sum1.getLength() + " " + sum1.getUnit());

        // 6. Addition (target unit)
        LengthUc9 sum2 = demonstrateLengthAddition(length1, length2, LengthUnitUc9.YARDS);
        System.out.println("3 feet + 36 inches in yards = " +
                sum2.getLength() + " " + sum2.getUnit());
    }
}
