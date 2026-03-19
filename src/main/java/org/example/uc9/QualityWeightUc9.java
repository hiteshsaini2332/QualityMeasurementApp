package org.example.uc9;

public class QualityWeightUc9 {
    public static boolean demonstrateWeightEquality(WeightUc9 weight1, WeightUc9 weight2) {
        return weight1.equals(weight2);
    }
    public static boolean demonstrateWeightComparison(double value1, WeightUnitUc9 unit1,
                                                      double value2, WeightUnitUc9 unit2) {

        double base1 = unit1.convertToBaseUnit(value1);
        double base2 = unit2.convertToBaseUnit(value2);

        return Math.abs(base1 - base2) < 0.01;
    }
    public static WeightUc9 demonstrateWeightConversion(double value,
                                                        WeightUnitUc9 fromUnit,
                                                        WeightUnitUc9 toUnit) {

        double base = fromUnit.convertToBaseUnit(value);
        double converted = toUnit.convertFromBaseUnit(base);

        return new WeightUc9(Math.round(converted * 100.0) / 100.0, toUnit);
    }
    public static WeightUc9 demonstrateWeightConversion(WeightUc9 weight,
                                                        WeightUnitUc9 toUnit) {

        return weight.convertTo(toUnit);
    }
    public static WeightUc9 demonstrateWeightAddition(WeightUc9 weight1,
                                                      WeightUc9 weight2) {

        return weight1.add(weight2);
    }
    public static WeightUc9 demonstrateWeightAddition(WeightUc9 weight1,
                                                      WeightUc9 weight2,
                                                      WeightUnitUc9 targetUnit) {

        return weight1.add(weight2, targetUnit);
    }
    public static void main(String[] args) {

        WeightUc9 w1 = new WeightUc9(1.0, WeightUnitUc9.KILOGRAM);
        WeightUc9 w2 = new WeightUc9(1000.0, WeightUnitUc9.GRAM);

        System.out.println("Equality: " +
                demonstrateWeightEquality(w1, w2));

        System.out.println("Comparison: " +
                demonstrateWeightComparison(1, WeightUnitUc9.KILOGRAM,
                        1000, WeightUnitUc9.GRAM));

        WeightUc9 converted = demonstrateWeightConversion(2.20462,
                WeightUnitUc9.POUND, WeightUnitUc9.KILOGRAM);

        System.out.println("Converted: " +
                converted.getValue() + " " + converted.getUnit());

        WeightUc9 sum = demonstrateWeightAddition(w1, w2);
        System.out.println("Sum: " +
                sum.getValue() + " " + sum.getUnit());
    }
}
