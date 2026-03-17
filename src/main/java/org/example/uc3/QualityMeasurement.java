package org.example.uc3;

public class QualityMeasurement {
    public static boolean demonstrateLengthEquality(Length length1, Length length2) {
        return length1.equals(length2);
    }
    public static void demonstrateFeetEquality() {
        Length l1=new Length(5,LengthUnit.FEET);
        Length l2=new Length(5,LengthUnit.FEET);
        System.out.println("Feet equality: "+l1.equals(l2));
    }
    public static void demonstrateInchesEquality() {
        Length l1=new Length(5,LengthUnit.INCHES);
        Length l2=new Length(5,LengthUnit.INCHES);
        System.out.println("Inches equality: "+l1.equals(l2));
    }
    public static void demonstrateFeetInchesComparison() {
        Length feet = new Length(1, LengthUnit.FEET);
        Length inches = new Length(12, LengthUnit.INCHES);

        System.out.println("Feet vs Inches equality: " + feet.equals(inches)); // true
    }

}
