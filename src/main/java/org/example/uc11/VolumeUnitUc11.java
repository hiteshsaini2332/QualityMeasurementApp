package org.example.uc11;

public enum VolumeUnitUc11 implements IMeasurable{
    LITRE(1.0),           // Base unit
    MILLILITRE(0.001),    // 1 mL = 0.001 L
    GALLON(3.78541);      // 1 gallon ≈ 3.78541 L

    private final double conversionFactor;

    VolumeUnitUc11(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }


    public double getConversionFactor() {
        return conversionFactor;
    }

    public double convertToBaseUnit(double value) {
        return value * conversionFactor;   // convert → litres
    }

    public double convertFromBaseUnit(double baseValue) {
        return baseValue / conversionFactor; // convert ← litres
    }

    public String getUnitName() {
        return this.name();
    }
}
