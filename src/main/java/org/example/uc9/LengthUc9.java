package org.example.uc9;
import org.example.uc9.LengthUnitUc9;
public class LengthUc9 {

    private final double length;
    private final LengthUnitUc9 unit;
    private static final double EPSILON = 0.01;

    // ✅ Constructor with validation
    public LengthUc9(double length, LengthUnitUc9 unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        if (Double.isNaN(length) || !Double.isFinite(length)) {
            throw new IllegalArgumentException("Invalid length value");
        }

        this.length = length;
        this.unit = unit;
    }

    public double getLength() {
        return length;
    }

    public LengthUnitUc9 getUnit() {
        return unit;
    }

    public double toBaseUnit() {
        return unit.convertToBaseUnit(length);
    }

    // ✅ Rounding
    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }

    // ✅ Conversion
    public LengthUc9 convertTo(LengthUnitUc9 targetUnit) {
        double baseValue = toBaseUnit();
        double converted = targetUnit.convertFromBaseUnit(baseValue);
        return new LengthUc9(round(converted), targetUnit);
    }

    // ✅ Addition (default: result in this.unit)
    public LengthUc9 add(LengthUc9 other) {
        double sumBase = this.toBaseUnit() + other.toBaseUnit();
        double result = unit.convertFromBaseUnit(sumBase);
        return new LengthUc9(round(result), unit);
    }

    public LengthUc9 add(LengthUc9 other, LengthUnitUc9 targetUnit) {
        double sumBase = this.toBaseUnit() + other.toBaseUnit();
        double result = targetUnit.convertFromBaseUnit(sumBase);
        return new LengthUc9(round(result), targetUnit);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof LengthUc9 other)) return false;

        return Math.abs(this.toBaseUnit() - other.toBaseUnit()) < EPSILON;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(round(toBaseUnit()));
    }
}