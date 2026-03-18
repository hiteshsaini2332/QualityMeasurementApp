package org.example.usecase6;

public enum LengthUnitUc6 {
    FEET(12.0),
    INCHES(1.0),
    YARDS(36.0),
    CENTIMETERS(0.393701);
    private double value;
    private LengthUnitUc6(double value) {
        this.value = value;
    }
    public double getFactor(){
        return value;
    }
}
