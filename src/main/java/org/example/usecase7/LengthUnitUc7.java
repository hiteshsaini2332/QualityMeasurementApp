package org.example.usecase7;

public enum LengthUnitUc7 {
    FEET(12.0),
    INCHES(1.0),
    YARDS(36.0),
    CENTIMETERS(0.393701);
    private double value;
    private LengthUnitUc7(double value) {
        this.value = value;
    }
    public double getFactor(){
        return value;
    }
}