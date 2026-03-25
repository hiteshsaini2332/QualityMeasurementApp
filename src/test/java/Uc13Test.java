import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.example.usecase13.*;
public class Uc13Test {
    @Test
    void testValidation_NullOperand_ConsistentAcrossOperations(){
        Quantity<LengthUnitUc13> q=new Quantity<>(10.0,LengthUnitUc13.FEET);
        assertThrows(IllegalArgumentException.class,()->q.add(null));
        assertThrows(IllegalArgumentException.class,()->q.subtract(null));
        assertThrows(IllegalArgumentException.class,()->q.divide(null));
    }
    @Test
    void testValidation_CrossCategory_ConsistentAcrossOperations(){
        Quantity<LengthUnitUc13> length=new Quantity<>(10.0,LengthUnitUc13.FEET);
        Quantity<WeightUnitUc13> weight=new Quantity<>(5.0,WeightUnitUc13.KILOGRAM);
        assertThrows(IllegalArgumentException.class,()->length.add((Quantity) weight));
        assertThrows(IllegalArgumentException.class,()->length.subtract((Quantity) weight));
        assertThrows(IllegalArgumentException.class,()->length.divide((Quantity) weight));
    }
    @Test
    void testValidation_FiniteValue_ConsistentAcrossOperations(){
        assertThrows(IllegalArgumentException.class,()->new Quantity<>(Double.NaN,LengthUnitUc13.FEET));
        assertThrows(IllegalArgumentException.class,()->new Quantity<>(Double.POSITIVE_INFINITY,LengthUnitUc13.FEET));
    }
    @Test
    void testValidation_NullTargetUnit_AddSubtractReject(){
        Quantity<LengthUnitUc13> q1=new Quantity<>(10.0,LengthUnitUc13.FEET);
        Quantity<LengthUnitUc13> q2=new Quantity<>(5.0,LengthUnitUc13.FEET);
        assertThrows(IllegalArgumentException.class,()->q1.add(q2,null));
        assertThrows(IllegalArgumentException.class,()->q1.subtract(q2,null));
    }
    @Test
    void testAdd_UC12_BehaviorPreserved(){
        Quantity<LengthUnitUc13> result=new Quantity<>(1.0,LengthUnitUc13.FEET).add(new Quantity<>(12.0,LengthUnitUc13.INCHES));
        assertEquals(2.0,result.getValue(),0.001);
        assertEquals(LengthUnitUc13.FEET,result.getUnit());
    }
    @Test
    void testSubtract_UC12_BehaviorPreserved(){
        Quantity<LengthUnitUc13> result=new Quantity<>(10.0,LengthUnitUc13.FEET).subtract(new Quantity<>(6.0,LengthUnitUc13.INCHES));
        assertEquals(9.5,result.getValue(),0.001);
    }
    @Test
    void testDivide_UC12_BehaviorPreserved(){
        double result=new Quantity<>(24.0,LengthUnitUc13.INCHES).divide(new Quantity<>(2.0,LengthUnitUc13.FEET));
        assertEquals(1.0,result,0.001);
    }
    @Test
    void testArithmeticOperation_Add_EnumComputation(){
        double result=invokeEnum("ADD",10,5);
        assertEquals(15.0,result);
    }
    @Test
    void testArithmeticOperation_Subtract_EnumComputation(){
        double result = invokeEnum("SUBTRACT",10,5);
        assertEquals(5.0,result);
    }
    @Test
    void testArithmeticOperation_Divide_EnumComputation(){
        double result=invokeEnum("DIVIDE",10,5);
        assertEquals(2.0,result);
    }
    @Test
    void testArithmeticOperation_DivideByZero_EnumThrows(){
        assertThrows(ArithmeticException.class,()->invokeEnum("DIVIDE",10,0));
    }
    @Test
    void testImplicitTargetUnit_AddSubtract(){
        Quantity<LengthUnitUc13> result=new Quantity<>(1.0,LengthUnitUc13.FEET).add(new Quantity<>(12.0,LengthUnitUc13.INCHES));
        assertEquals(LengthUnitUc13.FEET,result.getUnit());
    }
    @Test
    void testExplicitTargetUnit_AddSubtract_Overrides(){
        Quantity<LengthUnitUc13> result=new Quantity<>(1.0,LengthUnitUc13.FEET).add(new Quantity<>(12.0,LengthUnitUc13.INCHES),LengthUnitUc13.INCHES);
        assertEquals(24.0,result.getValue(),0.001);
        assertEquals(LengthUnitUc13.INCHES,result.getUnit());
    }
    @Test
    void testImmutability_AfterAdd_ViaCentralizedHelper(){
        Quantity<LengthUnitUc13> q1=new Quantity<>(1.0,LengthUnitUc13.FEET);
        Quantity<LengthUnitUc13> q2=new Quantity<>(12.0,LengthUnitUc13.INCHES);
        q1.add(q2);
        assertEquals(1.0,q1.getValue());
        assertEquals(12.0,q2.getValue());
    }
    @Test
    void testAllOperations_AcrossAllCategories(){
        assertNotNull(new Quantity<>(1.0,LengthUnitUc13.FEET).add(new Quantity<>(12.0,LengthUnitUc13.INCHES)));
        assertNotNull(new Quantity<>(10.0,WeightUnitUc13.KILOGRAM).add(new Quantity<>(5000.0, WeightUnitUc13.GRAM)));
        assertNotNull(new Quantity<>(5.0,VolumeUnitUc13.LITRE).subtract(new Quantity<>(2.0,VolumeUnitUc13.LITRE)));
    }
    @Test
    void testArithmetic_Chain_Operations(){
        double result = new Quantity<>(10.0,LengthUnitUc13.FEET).add(new Quantity<>(12.0,LengthUnitUc13.INCHES)).subtract(new Quantity<>(6.0,LengthUnitUc13.INCHES)).divide(new Quantity<>(2.0,LengthUnitUc13.FEET));
        assertEquals(5.25,result,0.001);
    }
    double invokeEnum(String operationName, double a, double b) {
        try {
            Class<?> clazz = Class.forName("org.example.usecase13.Quantity$ArithmeticOperation");

            Object enumValue = Enum.valueOf((Class<Enum>) clazz, operationName);

            java.lang.reflect.Method method = clazz.getDeclaredMethod("compute", double.class, double.class);
            method.setAccessible(true);

            return (double) method.invoke(enumValue, a, b);

        } catch (java.lang.reflect.InvocationTargetException e) {
            // 🔥 THIS IS THE FIX
            Throwable cause = e.getCause();

            if (cause instanceof RuntimeException) {
                throw (RuntimeException) cause; // rethrow original exception
            } else if (cause instanceof Error) {
                throw (Error) cause;
            } else {
                throw new RuntimeException(cause);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
