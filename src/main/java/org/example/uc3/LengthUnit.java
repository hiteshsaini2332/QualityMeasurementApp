package org.example.uc3;

public enum LengthUnit {
    FEET(1.0),
    INCHES(1.0/12.0);

    private final double conversionFactor;
    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }
    public double toBaseUnit(double length) {
        return length * conversionFactor;
    }
}
