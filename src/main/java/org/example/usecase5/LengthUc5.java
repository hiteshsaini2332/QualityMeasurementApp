package org.example.usecase5;

public class LengthUc5 {
    private double value;
    private LengthUnitUc5 unit;
    public LengthUc5(double value, LengthUnitUc5 unit) {
        this.value = value;
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        this.unit = unit;
    }
    public double toFactor() {
        return value*unit.getFactor();
    }
    public boolean compare(LengthUc5 thatLength) {
        return Double.compare(
                this.toFactor(),
                thatLength.toFactor()
        ) == 0;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof LengthUnitUc5)) return false;


        LengthUc5 other = (LengthUc5) obj;
        return Double.compare(this.toFactor(), other.toFactor()) == 0;
    }
    public static double convert(double value,
                                 LengthUnitUc5 source,
                                 LengthUnitUc5 target) {

        if (source == null || target == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid numeric value");
        }

        // convert to base (inches)
        double baseValue = value * source.getFactor();

        // convert to target
        return baseValue / target.getFactor();
    }
    public LengthUc5 convertTo(LengthUnitUc5 targetUnit) {
        double convertedValue = convert(this.value, this.unit, targetUnit);
        return new LengthUc5(convertedValue, targetUnit);
    }


}
