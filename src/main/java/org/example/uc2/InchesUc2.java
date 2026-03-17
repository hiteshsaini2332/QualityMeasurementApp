package org.example.uc2;

public class Inches {
    private double value;
    public Inches(double value) {
        this.value = value;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inches feet = (Inches) o;
        return Double.compare(feet.value, value) == 0;
    }
}
