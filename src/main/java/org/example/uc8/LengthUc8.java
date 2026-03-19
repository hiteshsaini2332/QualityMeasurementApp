package org.example.uc8;

public class LengthUc8 {
    private double length;
    private LengthUnitUc8 unit;
    public LengthUc8(double length, LengthUnitUc8 unit) {
        try{
            this.length = length;
            this.unit = unit;
            if(unit==null){
                throw new IllegalArgumentException();
            }
            if(Double.isNaN(length)||!(Double.isFinite(length))){
                throw new IllegalArgumentException();
            }

        }
        catch (IllegalArgumentException e){
            System.out.println("LENGTH or UNIT is Invalid!! ");
        }
    }
    public double getLength() {
        return length;
    }
    public LengthUnitUc8 getUnit() {
        return unit;
    }
    public double toBaseUnit(){
        return unit.convertToBaseUnit(length);
    }
    public double round(double value){
        return Math.round(value*100.0)/100.0;
    }
    public LengthUc8 convertTo(LengthUnitUc8 targetUnit){
        double baseValue = unit.convertToBaseUnit(length);
        double convertedValue = targetUnit.convertFromBaseUnit(baseValue);
        return new LengthUc8(round(convertedValue),targetUnit);
    }
    public LengthUc8 add(LengthUc8 other){
        double first=unit.convertToBaseUnit(length);
        double second=other.unit.convertToBaseUnit(other.length);
        double sum=first+second;
        return new LengthUc8(round(sum),unit);
    }
    public LengthUc8 add(LengthUc8 other, LengthUnitUc8 targetUnit){
        double first=unit.convertToBaseUnit(length);
        double second=other.unit.convertToBaseUnit(other.length);
        double sum=first+second;
        double result = targetUnit.convertFromBaseUnit(sum);
        return new LengthUc8(round(result),targetUnit);
    }
    public LengthUc8 add(LengthUc8 l1,LengthUc8 l2, LengthUnitUc8 targetUnit){
        double first=l1.unit.convertToBaseUnit(l1.length);
        double second=l2.unit.convertToBaseUnit(l2.length);
        double sum=first+second;
        double result = targetUnit.convertFromBaseUnit(sum);
        return new LengthUc8(round(result),targetUnit);
    }
    public double convertFromBaseUnitToTargetUnit(double base,LengthUnitUc8 targetUnit){
       return targetUnit.convertFromBaseUnit(base);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof LengthUc8 other)) return false;
        if(this==obj)return true;
        return Double.compare(this.toBaseUnit(), other.toBaseUnit()) == 0;
    }
    public boolean compare(LengthUc8 other)
    {
        return Double.compare(this.toBaseUnit(), other.toBaseUnit()) == 0;
    }
    @Override
    public int hashCode() {
        return Double.hashCode(toBaseUnit());
    }

}
