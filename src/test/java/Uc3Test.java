import org.example.uc3.Length;
import org.example.uc3.LengthUnit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Uc3Test {

    @Test
    public void testFeetEquality(){
        Length f1 = new Length(1.0, LengthUnit.FEET);
        Length f2 = new Length(1.0, LengthUnit.FEET);

        assertTrue(f1.equals(f2));
    }
    @Test
    public void testInchesEquality(){
        Length f1 = new Length(1.0, LengthUnit.INCHES);
        Length f2 = new Length(1.0, LengthUnit.INCHES);
    }

    @Test
    public  void testFeetInchesEquality(){
        Length f1 = new Length(1.0, LengthUnit.FEET);
        Length f2 = new Length(1.0, LengthUnit.INCHES);
        assertFalse(f1.equals(f2));
    }
    @Test
    public void testInchesFeetEquality(){
        Length f1 = new Length(1.0, LengthUnit.FEET);
        Length f2 = new Length(12.0, LengthUnit.INCHES);
        assertTrue(f1.equals(f2));
    }
    @Test
    public void testFeetInquality(){
        Length f1 = new Length(1.0, LengthUnit.FEET);
        Length f2 = new Length(2.0, LengthUnit.FEET);
        assertFalse(f1.equals(f2));
    }
    @Test
    public void testInchesInquality(){
        Length f1 = new Length(1.0, LengthUnit.INCHES);
        Length f2 = new Length(3.0, LengthUnit.INCHES);
        assertFalse(f1.equals(f2));
    }

    @Test
     public void testEqualitySameReference() {
        Length l1 = new Length(1.0, LengthUnit.FEET);

        assertTrue(l1.equals(l1));
    }

}
