package org.example.uc8;

public class QualityUc8 {
    public static boolean demonstrateLengthEquality(LengthUc8 length1, LengthUc8 length2) {
        double base1 = length1.getUnit().convertToBaseUnit(length1.getLength());
        double base2 = length2.getUnit().convertToBaseUnit((length2.getLength()));
        return Double.compare(base1, base2) == 0;
    }
    public static boolean demonstrateLengthComparison(double value1, LengthUnitUc8 unit1,
                                                      double value2, LengthUnitUc8 unit2) {
        double base1 = unit1.convertToBaseUnit(value1);
        double base2 = unit2.convertToBaseUnit(value2);
        return base1 > base2;
    }
    public static LengthUc8 demonstrateLengthConversion(double value,
                                                     LengthUnitUc8 fromUnit,
                                                     LengthUnitUc8 toUnit) {
        double base = fromUnit.convertToBaseUnit(value);
        double converted = toUnit.convertFromBaseUnit(base);
        return new LengthUc8(converted, toUnit);
    }
    public static LengthUc8 demonstrateLengthConversion(LengthUc8 length,
                                                     LengthUnitUc8 toUnit) {
        double base = length.getUnit().convertToBaseUnit(length.getLength());
        double converted = toUnit.convertFromBaseUnit(base);
        return new LengthUc8(converted, toUnit);
    }
    public static LengthUc8 demonstrateLengthAddition(LengthUc8 length1, LengthUc8 length2) {
        double base1 = length1.getUnit().convertToBaseUnit(length1.getLength());
        double base2 = length2.getUnit().convertToBaseUnit(length2.getLength());
        double sumBase = base1 + base2;

        // return in first length's unit
        double result = length1.getUnit().convertFromBaseUnit(sumBase);
        return new LengthUc8(result, length1.getUnit());
    }
    public static LengthUc8 demonstrateLengthAddition(LengthUc8 length1,
                                                   LengthUc8 length2,
                                                   LengthUnitUc8 targetUnit) {
        double base1 = length1.getUnit().convertToBaseUnit(length1.getLength());
        double base2 = length2.getUnit().convertToBaseUnit(length2.getLength());
        double sumBase = base1 + base2;

        double result = targetUnit.convertFromBaseUnit(sumBase);
        return new LengthUc8(result, targetUnit);
    }

    public static void main(String[] args) {

        // Create Length objects (assuming Length class uses LengthUnitUc8)
        LengthUc8 length1 = new LengthUc8(3, LengthUnitUc8.FEET);        // 3 feet
        LengthUc8 length2 = new LengthUc8(36, LengthUnitUc8.INCHES);     // 36 inches
        LengthUc8 length3 = new LengthUc8(100, LengthUnitUc8.CENTIMETERS); // 100 cm

        // 1. Equality check
        boolean isEqual = demonstrateLengthEquality(length1, length2);
        System.out.println("3 feet == 36 inches? " + isEqual);

        // 2. Comparison
        boolean isGreater = demonstrateLengthComparison(2, LengthUnitUc8.YARDS,
                5, LengthUnitUc8.FEET);
        System.out.println("2 yards > 5 feet? " + isGreater);

        // 3. Conversion (value + units)
        LengthUc8 converted1 = demonstrateLengthConversion(1, LengthUnitUc8.YARDS,
                LengthUnitUc8.FEET);
        System.out.println("1 yard in feet: " +
                converted1.getLength() + " " + converted1.getUnit());

        // 4. Conversion (Length object)
        LengthUc8 converted2 = demonstrateLengthConversion(length3, LengthUnitUc8.INCHES);
        System.out.println("100 cm in inches: " +
                converted2.getLength() + " " + converted2.getUnit());

        // 5. Addition (default unit of first length)
        LengthUc8 sum1 = demonstrateLengthAddition(length1, length3);
        System.out.println("3 feet + 100 cm = " +
                sum1.getLength() + " " + sum1.getUnit());

        // 6. Addition (target unit)
        LengthUc8 sum2 = demonstrateLengthAddition(length1, length2, LengthUnitUc8.YARDS);
        System.out.println("3 feet + 36 inches in yards = " +
                sum2.getLength() + " " + sum2.getUnit());
    }

}
