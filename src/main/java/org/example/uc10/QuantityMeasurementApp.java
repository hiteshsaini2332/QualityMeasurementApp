package org.example.uc10;

public class QuantityMeasurementApp {

    // ✅ Equality (returns boolean)
    public static <U extends IMeasurable> boolean demonstrateEquality(
            Quantity<U> q1, Quantity<U> q2) {

        boolean result = q1.equals(q2);
        System.out.println(q1 + " == " + q2 + " → " + result);
        return result;
    }

    // ✅ Conversion (returns Quantity)
    public static <U extends IMeasurable> Quantity<U> demonstrateConversion(
            Quantity<U> q, U targetUnit) {

        Quantity<U> result = q.convertTo(targetUnit);
        System.out.println(q + " → " + result);
        return result;
    }

    // ✅ Addition (returns Quantity)
    public static <U extends IMeasurable> Quantity<U> demonstrateAddition(
            Quantity<U> q1, Quantity<U> q2) {

        Quantity<U> result = q1.add(q2);
        System.out.println(q1 + " + " + q2 + " → " + result);
        return result;
    }

    // ✅ Addition with target unit
    public static <U extends IMeasurable> Quantity<U> demonstrateAddition(
            Quantity<U> q1, Quantity<U> q2, U targetUnit) {

        Quantity<U> result = q1.add(q2, targetUnit);
        System.out.println(q1 + " + " + q2 + " → " + result);
        return result;
    }

    public static void main(String[] args) {

        // 🔹 Length
        Quantity<LengthUnitUc10> l1 = new Quantity<>(1, LengthUnitUc10.FEET);
        Quantity<LengthUnitUc10> l2 = new Quantity<>(12, LengthUnitUc10.INCHES);

        demonstrateEquality(l1, l2);
        demonstrateConversion(l1, LengthUnitUc10.INCHES);
        demonstrateAddition(l1, l2, LengthUnitUc10.FEET);

        System.out.println();

        // 🔹 Weight
        Quantity<WeightUnitUc10> w1 = new Quantity<>(1, WeightUnitUc10.KILOGRAM);
        Quantity<WeightUnitUc10> w2 = new Quantity<>(1000, WeightUnitUc10.GRAM);

        demonstrateEquality(w1, w2);
        demonstrateConversion(w1, WeightUnitUc10.GRAM);
        demonstrateAddition(w1, w2, WeightUnitUc10.KILOGRAM);
    }
}