import org.example.uc14.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class Uc14Test {
    private static final double EPSILON=0.01;
    @Test
    void testTemperatureEquality_CelsiusToCelsius_SameValue(){
        assertTrue(new Quantity<>(0.0,TemperatureUnitUc14.CELSIUS).equals(new Quantity<>(0.0,TemperatureUnitUc14.CELSIUS)));
    }
    @Test
    void testTemperatureEquality_CelsiusToFahrenheit_0Celsius32Fahrenheit(){
        assertTrue(new Quantity<>(0.0,TemperatureUnitUc14.CELSIUS).equals(new Quantity<>(32.0,TemperatureUnitUc14.FAHRENHEIT)));
    }
    @Test
    void testTemperatureEquality_CelsiusToKelvin(){
        assertTrue(new Quantity<>(0.0,TemperatureUnitUc14.CELSIUS).equals(new Quantity<>(273.15,TemperatureUnitUc14.KELVIN)));
    }
    @Test
    void testTemperatureEquality_Negative40Equal(){
        assertTrue(new Quantity<>(-40.0,TemperatureUnitUc14.CELSIUS).equals(new Quantity<>(-40.0,TemperatureUnitUc14.FAHRENHEIT)));
    }
    @Test
    void testTemperatureEquality_SymmetricProperty(){
        Quantity<TemperatureUnitUc14> a=new Quantity<>(0.0,TemperatureUnitUc14.CELSIUS);
        Quantity<TemperatureUnitUc14> b=new Quantity<>(32.0,TemperatureUnitUc14.FAHRENHEIT);
        assertTrue(a.equals(b));
        assertTrue(b.equals(a));
    }
    @Test
    void testTemperatureConversion_CelsiusToFahrenheit(){
        Quantity<TemperatureUnitUc14> result=new Quantity<>(100.0,TemperatureUnitUc14.CELSIUS).convertTo(TemperatureUnitUc14.FAHRENHEIT);
        assertEquals(212.0,result.getValue(),EPSILON);
    }
    @Test
    void testTemperatureConversion_FahrenheitToCelsius(){
        Quantity<TemperatureUnitUc14> result=new Quantity<>(32.0,TemperatureUnitUc14.FAHRENHEIT).convertTo(TemperatureUnitUc14.CELSIUS);
        assertEquals(0.0,result.getValue(),EPSILON);
    }

    @Test
    void testTemperatureConversion_CelsiusToKelvin(){
        Quantity<TemperatureUnitUc14> result=new Quantity<>(0.0,TemperatureUnitUc14.CELSIUS).convertTo(TemperatureUnitUc14.KELVIN);
        assertEquals(273.15,result.getValue(),EPSILON);
    }
    @Test
    void testTemperatureConversion_RoundTrip(){
        Quantity<TemperatureUnitUc14> original=new Quantity<>(50.0,TemperatureUnitUc14.CELSIUS);
        Quantity<TemperatureUnitUc14> converted=original.convertTo(TemperatureUnitUc14.FAHRENHEIT).convertTo(TemperatureUnitUc14.CELSIUS);
        assertEquals(original.getValue(),converted.getValue(),EPSILON);
    }
    @Test
    void testTemperatureUnsupportedOperation_Add(){
        Quantity<TemperatureUnitUc14> t1=new Quantity<>(100.0,TemperatureUnitUc14.CELSIUS);
        Quantity<TemperatureUnitUc14> t2=new Quantity<>(50.0,TemperatureUnitUc14.CELSIUS);
        assertThrows(UnsupportedOperationException.class,()->t1.add(t2));
    }
    @Test
    void testTemperatureUnsupportedOperation_Subtract(){
        Quantity<TemperatureUnitUc14> t1=new Quantity<>(100.0,TemperatureUnitUc14.CELSIUS);
        Quantity<TemperatureUnitUc14> t2=new Quantity<>(50.0,TemperatureUnitUc14.CELSIUS);
        assertThrows(UnsupportedOperationException.class,()->t1.subtract(t2));
    }
    @Test
    void testTemperatureUnsupportedOperation_Divide(){
        Quantity<TemperatureUnitUc14> t1=new Quantity<>(100.0,TemperatureUnitUc14.CELSIUS);
        Quantity<TemperatureUnitUc14> t2=new Quantity<>(50.0,TemperatureUnitUc14.CELSIUS);
        assertThrows(UnsupportedOperationException.class,()->t1.divide(t2));
    }
    @Test
    void testTemperatureVsLengthIncompatibility(){
        assertFalse(new Quantity<>(100.0,TemperatureUnitUc14.CELSIUS).equals(new Quantity<>(100.0,LengthUnitUc14.FEET)));
    }
    @Test
    void testTemperatureVsWeightIncompatibility(){
        assertFalse(new Quantity<>(50.0,TemperatureUnitUc14.CELSIUS).equals(new Quantity<>(50.0,WeightUnitUc14.KILOGRAM)));
    }
    @Test
    void testTemperatureVsVolumeIncompatibility(){
        assertFalse(new Quantity<>(25.0,TemperatureUnitUc14.CELSIUS).equals(new Quantity<>(25.0,VolumeUnitUc14.LITRE)));
    }
    @Test
    void testTemperatureAbsoluteZero(){
        Quantity<TemperatureUnitUc14> result=new Quantity<>(-273.15,TemperatureUnitUc14.CELSIUS).convertTo(TemperatureUnitUc14.KELVIN);
        assertEquals(0.0,result.getValue(),EPSILON);
    }
    @Test
    void testTemperatureEqualPointMinus40(){
        Quantity<TemperatureUnitUc14> result=new Quantity<>(-40.0,TemperatureUnitUc14.CELSIUS).convertTo(TemperatureUnitUc14.FAHRENHEIT);
        assertEquals(-40.0,result.getValue(),EPSILON);
    }
    @Test
    void testTemperatureNullUnitValidation(){
        assertThrows(IllegalArgumentException.class,()->new Quantity<>(100.0,null));
    }
    @Test
    void testTemperatureNullOperandValidation(){
        Quantity<TemperatureUnitUc14> t=new Quantity<>(100.0,TemperatureUnitUc14.CELSIUS);
        assertFalse(t.equals(null));
    }
}
