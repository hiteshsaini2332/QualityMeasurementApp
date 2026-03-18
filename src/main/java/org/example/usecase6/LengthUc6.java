package org.example.usecase6;

public class LengthUc6 {
    private double length;
    private LengthUnitUc6 unit;

    public LengthUc6(double length, LengthUnitUc6 unit) {
        if(unit==null){
            throw new IllegalArgumentException("Unit cannot be null");
        }
        this.length = length;
        this.unit = unit;
    }

    public double convertToBaseUnit(){
        return length*unit.getFactor();
    }
    public boolean compare(LengthUc6 other){
        if (other == null) {
            throw new IllegalArgumentException("Length cannot be null");
        }
        return Double.compare(this.convertToBaseUnit(), other.convertToBaseUnit())==0;
    }

    @Override
    public boolean equals(Object obj){
        if(this==obj){return true;}
        if(getClass() != obj.getClass()){return false;}
        LengthUc6 other = (LengthUc6)obj;
        return Double.compare(this.convertToBaseUnit(), other.convertToBaseUnit())==0;
    }
    @Override
    public int hashCode() {
        return Double.hashCode(convertToBaseUnit());
    }
    public double  convertFromBaseToTargetUnit(double lengthInInches,LengthUnitUc6 targetUnit){
        if ( targetUnit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        if (!Double.isFinite(lengthInInches)) {
            throw new IllegalArgumentException("Invalid numeric value");
        }

        return lengthInInches / targetUnit.getFactor();
    }
    public LengthUc6 convertTo(LengthUnitUc6 targetUnit){
        double baseValue = this.convertToBaseUnit();
        double convertedValue=convertFromBaseToTargetUnit(baseValue,targetUnit);
        return new LengthUc6(convertedValue,targetUnit);
    }
    public LengthUc6 add(LengthUc6 thatLength){
        if(thatLength==null){ throw new IllegalArgumentException("Length cannot be null");}
        double base=thatLength.convertToBaseUnit();
        double current=this.convertToBaseUnit();
        double convertedValue=current+base;
        double finalValue = convertFromBaseToTargetUnit(convertedValue, this.unit);
        return new LengthUc6(finalValue, this.unit);

    }

    public LengthUnitUc6 getUnit() {
        return unit;
    }
}
