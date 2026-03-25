package org.example.usecase13;
import java.util.*;

public class QuantityMeasurementApp {
    public static <U extends IMeasurable> boolean demonstrateEquality(Quantity<U> quantity1,Quantity<U> quantity2){
        return quantity1.equals(quantity2);
    }
    public static <U extends IMeasurable> Quantity<U> demonstrateConversion(Quantity<U> quantity,U targetUnit){
        return quantity.convertTo(targetUnit);
    }
    public static <U extends IMeasurable> Quantity<U> demonstrateAddition(Quantity<U> quantity1,Quantity<U> quantity2){
        return quantity1.add(quantity2);
    }
    public static <U extends IMeasurable> Quantity<U> demonstrateAddition(Quantity<U> quantity1,Quantity<U> quantity2,U targetUnit){
        return quantity1.add(quantity2,targetUnit);
    }
    public static <U extends IMeasurable> Quantity<U> demonstrateSubtraction(Quantity<U> quantity1,Quantity<U> quantity2){
        return quantity1.subtract(quantity2);
    }
    public static <U extends IMeasurable> Quantity<U> demonstrateSubtraction(Quantity<U> quantity1,Quantity<U> quantity2,U targetUnit){
        return quantity1.subtract(quantity2,targetUnit);
    }
    public static <U extends IMeasurable> double demonstrateDivision(Quantity<U> quantity1,Quantity<U> quantity2){
        return quantity1.divide(quantity2);
    }
    public static void main(String[] args) {
        System.out.println(demonstrateAddition(new Quantity<>(1.0,LengthUnitUc13.FEET),new Quantity<>(12.0,LengthUnitUc13.INCHES)));
        System.out.println(demonstrateAddition(new Quantity<>(10.0,WeightUnitUc13.KILOGRAM),new Quantity<>(5000.0,WeightUnitUc13.GRAM),WeightUnitUc13.GRAM));
        System.out.println(demonstrateSubtraction(new Quantity<>(10.0,LengthUnitUc13.FEET),new Quantity<>(6.0,LengthUnitUc13.INCHES)));
        System.out.println(demonstrateSubtraction(new Quantity<>(5.0,VolumeUnitUc13.LITRE),new Quantity<>(2.0,VolumeUnitUc13.LITRE),VolumeUnitUc13.MILLILITRE));
        System.out.println(demonstrateDivision(new Quantity<>(10.0,LengthUnitUc13.FEET),new Quantity<>(2.0,LengthUnitUc13.FEET)));
        System.out.println(demonstrateDivision(new Quantity<>(24.0,LengthUnitUc13.INCHES),new Quantity<>(2.0,LengthUnitUc13.FEET)));
        try{
            System.out.println(demonstrateAddition(new Quantity<>(10.0,LengthUnitUc13.FEET),null));
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        try{
            System.out.println(demonstrateSubtraction(new Quantity<>(10.0,LengthUnitUc13.FEET),new Quantity<>(5.0,WeightUnitUc13.KILOGRAM)));
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        try{
            System.out.println(demonstrateDivision(new Quantity<>(10.0, LengthUnitUc13.FEET),new Quantity<>(0.0,LengthUnitUc13.FEET)));
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
