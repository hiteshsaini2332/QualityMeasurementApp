package org.example.uc14;

public enum VolumeUnitUc14 implements IMeasurable {
    LITRE(1.0),
    MILLILITRE(0.001),
    GALLON(3.78541);
    private final double conversionFactor;
    VolumeUnitUc14(double conversionFactor){
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
