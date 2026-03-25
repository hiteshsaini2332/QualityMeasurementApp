package org.example.uc14;

public enum LengthUnitUc14 implements IMeasurable {
    FEET(12.0),
    INCHES(1.0),
    YARDS(36.0),
    CENTIMETERS(0.393701);
    private final double conversionFactor;
    LengthUnitUc14(double conversionFactor){
        this.conversionFactor=conversionFactor;
    }
    @Override
    public double getConversionFactor(){
        return conversionFactor;
    }
    @Override
    public double convertToBaseUnit(double value){
        return value*getConversionFactor();
    }
    @Override
    public double convertFromBaseUnit(double baseValue){
        return baseValue/getConversionFactor();
    }
    @Override
    public String getUnitName(){
        return this.name();
    }
}
