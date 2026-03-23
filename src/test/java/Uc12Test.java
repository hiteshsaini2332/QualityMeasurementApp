    import org.example.uc12.*;
    import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class Uc12Test {

   
        private static final double EPSILON=0.0001;
        @Test
        void testSubtraction_SameUnit_FeetMinusFeet(){
            Quantity<LengthUnitUc12> result=new Quantity<>(10.0,LengthUnitUc12.FEET).subtract(new Quantity<>(5.0,LengthUnitUc12.FEET));
            assertEquals(5.0,result.getValue(),EPSILON);
        }
        @Test
        void testSubtraction_SameUnit_LitreMinusLitre(){
            Quantity<VolumeUnitUc12> result=new Quantity<>(10.0,VolumeUnitUc12.LITRE).subtract(new Quantity<>(3.0,VolumeUnitUc12.LITRE));
            assertEquals(7.0,result.getValue(),EPSILON);
        }
        @Test
        void testSubtraction_CrossUnit_FeetMinusInches(){
            Quantity<LengthUnitUc12> result=new Quantity<>(10.0,LengthUnitUc12.FEET).subtract(new Quantity<>(6.0,LengthUnitUc12.INCHES));
            assertEquals(9.5,result.getValue(),EPSILON);
        }
        @Test
        void testSubtraction_ExplicitTargetUnit_Inches(){
            Quantity<LengthUnitUc12> result=new Quantity<>(10.0,LengthUnitUc12.FEET).subtract(new Quantity<>(6.0,LengthUnitUc12.INCHES),LengthUnitUc12.INCHES);
            assertEquals(114.0,result.getValue(),EPSILON);
        }
        @Test
        void testSubtraction_ResultingInNegative(){
            Quantity<LengthUnitUc12> result=new Quantity<>(5.0,LengthUnitUc12.FEET).subtract(new Quantity<>(10.0,LengthUnitUc12.FEET));
            assertEquals(-5.0,result.getValue(),EPSILON);
        }
        @Test
        void testSubtraction_ResultingInZero(){
            Quantity<LengthUnitUc12> result=new Quantity<>(10.0,LengthUnitUc12.FEET).subtract(new Quantity<>(120.0,LengthUnitUc12.INCHES));
            assertEquals(0.0,result.getValue(),EPSILON);
        }
        @Test
        void testSubtraction_WithZeroOperand(){
            Quantity<LengthUnitUc12> result=new Quantity<>(5.0,LengthUnitUc12.FEET).subtract(new Quantity<>(0.0,LengthUnitUc12.INCHES));
            assertEquals(5.0,result.getValue(),EPSILON);
        }
        @Test
        void testSubtraction_NonCommutative(){
            double a=new Quantity<>(10.0,LengthUnitUc12.FEET).subtract(new Quantity<>(5.0,LengthUnitUc12.FEET)).getValue();
            double b=new Quantity<>(5.0,LengthUnitUc12.FEET).subtract(new Quantity<>(10.0,LengthUnitUc12.FEET)).getValue();
            assertNotEquals(a,b);
        }
        @Test
        void testSubtraction_NullOperand(){
            assertThrows(IllegalArgumentException.class,()->new Quantity<>(10.0,LengthUnitUc12.FEET).subtract(null));
        }
        @Test
        void testSubtraction_CrossCategory(){
            Quantity<?> q1=new Quantity<>(10.0,LengthUnitUc12.FEET);
            Quantity<?> q2=new Quantity<>(5.0,WeightUnitUc12.KILOGRAM);
            assertThrows(IllegalArgumentException.class,()->{
                ((Quantity) q1).subtract((Quantity) q2);
            });
        }
        @Test
        void testDivision_SameUnit_FeetDividedByFeet(){
            double result=new Quantity<>(10.0,LengthUnitUc12.FEET).divide(new Quantity<>(2.0,LengthUnitUc12.FEET));
            assertEquals(5.0,result,EPSILON);
        }
        @Test
        void testDivision_SameUnit_LitreDividedByLitre(){
            double result=new Quantity<>(10.0,VolumeUnitUc12.LITRE).divide(new Quantity<>(5.0,VolumeUnitUc12.LITRE));
            assertEquals(2.0,result,EPSILON);
        }
        @Test
        void testDivision_CrossUnit_FeetDividedByInches(){
            double result=new Quantity<>(24.0,LengthUnitUc12.INCHES).divide(new Quantity<>(2.0,LengthUnitUc12.FEET));
            assertEquals(1.0,result,EPSILON);
        }
        @Test
        void testDivision_CrossUnit_KilogramDividedByGram(){
            double result=new Quantity<>(2.0,WeightUnitUc12.KILOGRAM).divide(new Quantity<>(2000.0,WeightUnitUc12.GRAM));
            assertEquals(1.0,result,EPSILON);
        }
        @Test
        void testDivision_RatioLessThanOne(){
            double result=new Quantity<>(5.0,LengthUnitUc12.FEET).divide(new Quantity<>(10.0,LengthUnitUc12.FEET));
            assertEquals(0.5,result,EPSILON);
        }
        @Test
        void testDivision_RatioEqualToOne(){
            double result=new Quantity<>(10.0,LengthUnitUc12.FEET).divide(new Quantity<>(10.0,LengthUnitUc12.FEET));
            assertEquals(1.0,result,EPSILON);
        }
        @Test
        void testDivision_NonCommutative(){
            double a=new Quantity<>(10.0,LengthUnitUc12.FEET).divide(new Quantity<>(5.0,LengthUnitUc12.FEET));
            double b=new Quantity<>(5.0,LengthUnitUc12.FEET).divide(new Quantity<>(10.0,LengthUnitUc12.FEET));
            assertNotEquals(a,b);
        }
        @Test
        void testDivision_ByZero(){
            assertThrows(ArithmeticException.class,()->new Quantity<>(10.0,LengthUnitUc12.FEET).divide(new Quantity<>(0.0,LengthUnitUc12.FEET)));
        }
        @Test
        void testDivision_NullOperand(){
            assertThrows(IllegalArgumentException.class,()->new Quantity<>(10.0,LengthUnitUc12.FEET).divide(null));
        }
        @Test
        void testDivision_CrossCategory(){
            Quantity<?> q1=new Quantity<>(10.0,LengthUnitUc12.FEET);
            Quantity<?> q2=new Quantity<>(5.0,WeightUnitUc12.KILOGRAM);
            assertThrows(IllegalArgumentException.class,()->{
                ((Quantity) q1).divide((Quantity)q2);
            });
        }
        @Test
        void testSubtractionAndDivision_Integration(){
            double result=new Quantity<>(10.0,LengthUnitUc12.FEET).subtract(new Quantity<>(2.0,LengthUnitUc12.FEET)).divide(new Quantity<>(2.0,LengthUnitUc12.FEET));
            assertEquals(4.0,result,EPSILON);
        }
        @Test
        void testSubtractionAddition_Inverse(){
            Quantity<LengthUnitUc12> a=new Quantity<>(10.0,LengthUnitUc12.FEET);
            Quantity<LengthUnitUc12> b=new Quantity<>(5.0,LengthUnitUc12.FEET);
            Quantity<LengthUnitUc12> result=a.add(b).subtract(b);
            assertTrue(a.equals(result));
        }
        @Test
        void testSubtraction_Immutability(){
            Quantity<LengthUnitUc12> a=new Quantity<>(10.0,LengthUnitUc12.FEET);
            Quantity<LengthUnitUc12> b=new Quantity<>(5.0,LengthUnitUc12.FEET);
            a.subtract(b);
            assertEquals(10.0,a.getValue(),EPSILON);
        }
        @Test
        void testDivision_Immutability(){
            Quantity<LengthUnitUc12> a=new Quantity<>(10.0,LengthUnitUc12.FEET);
            Quantity<LengthUnitUc12> b=new Quantity<>(2.0,LengthUnitUc12.FEET);
            a.divide(b);
            assertEquals(10.0, a.getValue(),EPSILON);
        }
}
