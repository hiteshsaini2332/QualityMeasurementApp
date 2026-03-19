package org.example.uc9;

public enum LengthUnitUc9 {
    FEET(12.0),
    INCHES(1.0),
    YARDS(36.0),
    CENTIMETERS(0.393701);
    private double conversionFactor;
    private LengthUnitUc9(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }
    public double getFactor(){
        return conversionFactor;
    }
    public double convertToBaseUnit(double baseValue){
        return baseValue * conversionFactor;
    }
    public double convertFromBaseUnit(double baseValue){
        return  baseValue / conversionFactor;
    }
}