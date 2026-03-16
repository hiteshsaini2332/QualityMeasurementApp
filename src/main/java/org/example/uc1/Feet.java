package org.example.uc1;

public class Feet {
    private final double value;
    public Feet(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)return true;
        if(obj == null)return false;
        if(getClass() != obj.getClass())return false;

        return  Double.compare(this.value,((Feet) obj).value)==0;
    }

}
