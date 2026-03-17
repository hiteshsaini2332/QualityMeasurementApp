package org.example.usecase5;

public enum LengthUnitUc5 {
    FEET(12.0),
    INCHES(1.0),
    YARDS(36.0),
    CENTIMETERS(0.393701);

    private double value;

    LengthUnitUc5(double value) {
        this.value = value;
    }

    public double getFactor() {
        return value;
    }
}