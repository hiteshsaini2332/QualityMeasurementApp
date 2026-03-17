package org.example.uc3;

public class Length {
    private double value;
    private LengthUnit unit;
    public Length(double value, LengthUnit unit) {
        if (value < 0) {
            throw new IllegalArgumentException("Value cannot be negative");
        }
        this.value = value;
        this.unit=unit;
    }

    public boolean equals(Length length) {
        double base1=this.unit.toBaseUnit(this.value);
        double base2=length.unit.toBaseUnit(length.value);
        return Double.compare(base1, base2) == 0;
    }
}
