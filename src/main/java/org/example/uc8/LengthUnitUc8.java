package org.example.uc8;

public enum LengthUnitUc8 {
    FEET(12.0),
    INCHES(1.0),
    YARDS(36.0),
    CENTIMETERS(0.393701);
    private double conversionFactor;
    private LengthUnitUc8(double conversionFactor) {
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
