package org.example.uc14;
import org.example.*;
public class QuantityMeasurementApp {
    public static <U extends IMeasurable> boolean demonstrateEquality(Quantity<U> q1,Quantity<U> q2){
        return q1.equals(q2);
    }
    public static <U extends IMeasurable> Quantity<U> demonstrateConversion(Quantity<U> q,U targetUnit){
        return q.convertTo(targetUnit);
    }
    public static <U extends IMeasurable> Quantity<U> demonstrateAddition(Quantity<U> q1,Quantity<U> q2){
        return q1.add(q2);
    }
    public static <U extends IMeasurable> Quantity<U> demonstrateAddition(Quantity<U> q1,Quantity<U> q2,U targetUnit){
        return q1.add(q2,targetUnit);
    }
    public static <U extends IMeasurable> Quantity<U> demonstrateSubtraction(Quantity<U> q1,Quantity<U> q2){
        return q1.subtract(q2);
    }
    public static <U extends IMeasurable> Quantity<U> demonstrateSubtraction(Quantity<U> q1,Quantity<U> q2,U targetUnit){
        return q1.subtract(q2,targetUnit);
    }
    public static <U extends IMeasurable> double demonstrateDivision(Quantity<U> q1,Quantity<U> q2){
        return q1.divide(q2);
    }
    public static void main(String[] args) {
        System.out.println(demonstrateEquality(new Quantity<>(0.0,TemperatureUnitUc14.CELSIUS),new Quantity<>(32.0,TemperatureUnitUc14.FAHRENHEIT)));
        System.out.println(demonstrateEquality(new Quantity<>(273.15,TemperatureUnitUc14.KELVIN),new Quantity<>(0.0,TemperatureUnitUc14.CELSIUS)));
        System.out.println(demonstrateEquality(new Quantity<>(212.0,TemperatureUnitUc14.FAHRENHEIT),new Quantity<>(100.0,TemperatureUnitUc14.CELSIUS)));
        System.out.println(demonstrateEquality(new Quantity<>(100.0,TemperatureUnitUc14.CELSIUS),new Quantity<>(373.15,TemperatureUnitUc14.KELVIN)));
        System.out.println(demonstrateEquality(new Quantity<>(50.0,TemperatureUnitUc14.CELSIUS),new Quantity<>(122.0,TemperatureUnitUc14.FAHRENHEIT)));
        System.out.println(demonstrateConversion(new Quantity<>(100.0,TemperatureUnitUc14.CELSIUS),TemperatureUnitUc14.FAHRENHEIT));
        System.out.println(demonstrateConversion(new Quantity<>(32.0,TemperatureUnitUc14.FAHRENHEIT),TemperatureUnitUc14.CELSIUS));
        System.out.println(demonstrateConversion(new Quantity<>(273.15,TemperatureUnitUc14.KELVIN),TemperatureUnitUc14.CELSIUS));
        System.out.println(demonstrateConversion(new Quantity<>(0.0,TemperatureUnitUc14.CELSIUS),TemperatureUnitUc14.KELVIN));
        System.out.println(demonstrateConversion(new Quantity<>(-40.0,TemperatureUnitUc14.CELSIUS),TemperatureUnitUc14.FAHRENHEIT));
        try {
            System.out.println(demonstrateAddition(new Quantity<>(100.0,TemperatureUnitUc14.CELSIUS),new Quantity<>(50.0,TemperatureUnitUc14.CELSIUS)));
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        try{
            System.out.println(demonstrateSubtraction(new Quantity<>(100.0,TemperatureUnitUc14.CELSIUS),new Quantity<>(50.0,TemperatureUnitUc14.CELSIUS)));
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        try{
            System.out.println(demonstrateDivision(new Quantity<>(100.0, TemperatureUnitUc14.CELSIUS),new Quantity<>(50.0,TemperatureUnitUc14.CELSIUS)));
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        System.out.println(demonstrateEquality(new Quantity<>(100.0,TemperatureUnitUc14.CELSIUS),new Quantity<>(100.0,LengthUnitUc14.FEET)));
        System.out.println(demonstrateEquality(new Quantity<>(50.0,TemperatureUnitUc14.CELSIUS),new Quantity<>(50.0,WeightUnitUc14.KILOGRAM)));
    }
}
