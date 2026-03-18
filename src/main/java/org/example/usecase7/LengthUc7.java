package org.example.usecase7;

import org.example.usecase7.LengthUnitUc7;

public class LengthUc7 {
    private double length;
    private LengthUnitUc7 unit;
    private static final double EPS = 1e-6;

    public LengthUc7(double length, LengthUnitUc7 unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        this.length = length;
        this.unit = unit;
    }

    public double getLength() {
        return length;
    }

    public LengthUnitUc7 getUnit() {
        return unit;
    }

    public double convertToBaseUnit() {
        return length * unit.getFactor();
    }

    public boolean compare(LengthUc7 other) {
        if (other == null) {
            throw new IllegalArgumentException("Length cannot be null");
        }
        return Math.abs(this.convertToBaseUnit() - other.convertToBaseUnit()) < EPS;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof LengthUc7)) return false;

        LengthUc7 other = (LengthUc7) obj;

        return Math.abs(this.convertToBaseUnit() - other.convertToBaseUnit()) < EPS;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(Math.round(convertToBaseUnit() / EPS));
    }

    public double convertFromBaseToTargetUnit(double lengthInBase, LengthUnitUc7 targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        if (!Double.isFinite(lengthInBase)) {
            throw new IllegalArgumentException("Invalid numeric value");
        }

        return lengthInBase / targetUnit.getFactor();
    }

    public LengthUc7 convertTo(LengthUnitUc7 targetUnit) {
        double baseValue = this.convertToBaseUnit();
        double convertedValue = convertFromBaseToTargetUnit(baseValue, targetUnit);
        return new LengthUc7(convertedValue, targetUnit);
    }

    public LengthUc7 addAndConvert(LengthUc7 thatLength, LengthUnitUc7 targetUnit) {
        if (thatLength == null) {
            throw new IllegalArgumentException("Length cannot be null");
        }
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double sumInBase = this.convertToBaseUnit() + thatLength.convertToBaseUnit();
        double finalValue = convertFromBaseToTargetUnit(sumInBase, targetUnit);

        return new LengthUc7(finalValue, targetUnit);
    }
}