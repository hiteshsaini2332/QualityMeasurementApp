package org.example.usecase4;

public enum LengthUnitUc4 {
    FEET(12.0),
    INCHES(1.0),
    YARDS(36.0),
    CENTIMETERS(0.393701);

    private double value;
    LengthUnitUc4(double value) {
        this.value = value;
    }
    public double getFactor(double v) {
        return this.value*v;
    }


}
