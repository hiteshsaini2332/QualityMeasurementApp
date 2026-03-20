package org.example.uc10;

public enum WeightUnitUc10 implements IMeasurable{
    MILLIGRAM(0.000001),
    GRAM(0.001),
    KILOGRAM(1.0),
    POUND(0.453592),
    TONNE(1000.0);

    private final double conversionFactor;
    WeightUnitUc10(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }
    public double getConversionFactor() {
        return conversionFactor;
    }
    public  double convertFromBaseUnit(double value) {
        return value/conversionFactor;
    }
    public double convertToBaseUnit(double value) {
        return value*conversionFactor;
    }
    public String getUnitName() {
        return this.name();
    }

}
