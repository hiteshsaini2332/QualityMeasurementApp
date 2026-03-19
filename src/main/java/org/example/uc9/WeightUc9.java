package org.example.uc9;

import java.util.Objects;
import org.example.uc9.WeightUnitUc9;
public class WeightUc9 {

    private final double value;
    private final WeightUnitUc9 unit;

    public WeightUc9(double value, WeightUnitUc9 unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        if (Double.isNaN(value) || !Double.isFinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public WeightUnitUc9 getUnit() {
        return unit;
    }

    private double toBase() {
        return unit.convertToBaseUnit(value);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof WeightUc9 other)) return false;

        double diff = Math.abs(this.toBase() - other.toBase());

        return diff < 0.01; // tolerance
    }

    @Override
    public int hashCode() {
        return Objects.hash(toBase());
    }


    public WeightUc9 convertTo(WeightUnitUc9 targetUnit) {
        double base = toBase();
        double result = targetUnit.convertFromBaseUnit(base);
        return new WeightUc9(round(result), targetUnit);
    }


    public WeightUc9 add(WeightUc9 other) {
        return add(other, this.unit);
    }

    public WeightUc9 add(WeightUc9 other, WeightUnitUc9 targetUnit) {
        double sumBase = this.toBase() + other.toBase();
        double result = targetUnit.convertFromBaseUnit(sumBase);
        return new WeightUc9(round(result), targetUnit);
    }

    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}