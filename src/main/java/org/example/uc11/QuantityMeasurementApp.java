package org.example.uc11;

public class QuantityMeasurementApp {
    public static <U extends IMeasurable> boolean demonstrateEquality(
            Quantity<U> q1, Quantity<U> q2) {

        boolean result = q1.equals(q2);
        System.out.println(q1 + " == " + q2 + " → " + result);
        return result;
    }

    public static <U extends IMeasurable> Quantity<U> demonstrateConversion(
            Quantity<U> q, U targetUnit) {

        Quantity<U> result = q.convertTo(targetUnit);
        System.out.println(q + " → " + result);
        return result;
    }

    public static <U extends IMeasurable> Quantity<U> demonstrateAddition(
            Quantity<U> q1, Quantity<U> q2) {

        Quantity<U> result = q1.add(q2);
        System.out.println(q1 + " + " + q2 + " → " + result);
        return result;
    }
    public static <U extends IMeasurable> Quantity<U> demonstrateAddition(
            Quantity<U> q1, Quantity<U> q2, U targetUnit) {

        Quantity<U> result = q1.add(q2, targetUnit);
        System.out.println(q1 + " + " + q2 + " → " + result);
        return result;
    }

    public static void main(String[] args) {

        Quantity<LengthUnitUc11> l1 = new Quantity<>(1, LengthUnitUc11.FEET);
        Quantity<LengthUnitUc11> l2 = new Quantity<>(12, LengthUnitUc11.INCHES);

        demonstrateEquality(l1, l2);
        demonstrateConversion(l1, LengthUnitUc11.INCHES);
        demonstrateAddition(l1, l2, LengthUnitUc11.FEET);

        System.out.println();

        Quantity<WeightUnitUc11> w1 = new Quantity<>(1, WeightUnitUc11.KILOGRAM);
        Quantity<WeightUnitUc11> w2 = new Quantity<>(1000, WeightUnitUc11.GRAM);
        Quantity<VolumeUnitUc11> v1 =
                new Quantity<>(1.0, VolumeUnitUc11.LITRE);

        Quantity<VolumeUnitUc11> v2 =
                new Quantity<>(1000.0, VolumeUnitUc11.MILLILITRE);

        Quantity<VolumeUnitUc11> v3 =
                new Quantity<>(1.0, VolumeUnitUc11.GALLON);
        demonstrateEquality(w1, w2);
        demonstrateConversion(w1, WeightUnitUc11.GRAM);
        demonstrateAddition(w1, w2, WeightUnitUc11.KILOGRAM);
        demonstrateEquality(v1, v2);

// Conversion
        demonstrateConversion(v1, VolumeUnitUc11.MILLILITRE);
        demonstrateConversion(v3, VolumeUnitUc11.LITRE);

// Addition
        demonstrateAddition(v1, v2, VolumeUnitUc11.LITRE);
        demonstrateAddition(v1, v3, VolumeUnitUc11.MILLILITRE);
    }
}
