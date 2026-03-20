package org.example.uc11;

public enum LengthUnitUc11 implements IMeasurable{
    FEET(12.0),
    INCHES(1.0),
    YARDS(36.0),
    CENTIMETERS(0.393701);

    private double conversionFactor;
    LengthUnitUc11(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }
    public double getConversionFactor() {
        return conversionFactor;
    }
    public double convertToBaseUnit(double value) {
        return value*conversionFactor;
    }
    public double convertFromBaseUnit(double value) {
        return value/conversionFactor;
    }
    public String getUnitName() {
        return this.name();
    }
}
