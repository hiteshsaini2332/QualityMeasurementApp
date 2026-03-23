package org.example.uc12;

public enum LengthUnitUc12 implements IMeasurable {
    FEET(12.0),
    INCHES(1.0),
    YARDS(36.0),
    CENTIMETERS(0.393701);

    private double conversionFactor;
    LengthUnitUc12(double conversionFactor) {
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
