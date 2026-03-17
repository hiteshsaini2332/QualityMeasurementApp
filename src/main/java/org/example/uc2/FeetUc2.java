package org.example.uc2;

public class FeetUc2 {
    private double value;
    public FeetUc2(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeetUc2 feet = (FeetUc2) o;
        return Double.compare(feet.value, value) == 0;
    }
}
