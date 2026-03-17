package org.example.uc1;

public class FeetUc1 {


    private final double value;

    public FeetUc1(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        return Double.compare(this.value, ((FeetUc1) obj).value) == 0;
    }

    }
