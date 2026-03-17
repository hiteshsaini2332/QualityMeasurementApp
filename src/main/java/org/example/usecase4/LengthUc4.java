package org.example.usecase4;

public class LengthUc4 {
    private double value;
    private LengthUnitUc4 unit;
    public LengthUc4(double value, LengthUnitUc4 unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        this.value = value;
        this.unit = unit;
    }
    public double toFactor() {
        return unit.getFactor(value);
    }
    public boolean compare(LengthUc4 thatLength) {
        return Double.compare(
                this.toFactor(),
                thatLength.toFactor()
        ) == 0;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof LengthUc4)) return false;


        LengthUc4 other = (LengthUc4) obj;
        return Double.compare(this.toFactor(), other.toFactor()) == 0;
    }

}
