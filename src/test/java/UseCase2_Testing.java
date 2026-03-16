import org.example.uc2.Feet;
import org.example.uc2.Inches;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UseCase2_Testing {
    @Test
    public void testFeetEquality_SameValue(){
        Feet f1=new Feet(1.0);
        Feet f2=new Feet(1.0);
        assertTrue(f1.equals(f2));
    }

    @Test
    public void testFeetEquality_DifferentValue(){
        Feet f1=new Feet(1.0);
        Feet f2=new Feet(2.0);
        assertFalse(f1.equals(f2));

    }
    @Test
    public void testFeetEquality_NullComparison(){
        Feet f1=new Feet(1.0);
        assertFalse(f1.equals(null));
    }

    @Test
    public void testFeetEquality_DifferentClass(){
        Feet f1=new Feet(1.0);
        assertFalse(f1.equals(new Object()));
    }

    @Test
    public void testFeetEquality_SameRefernce(){
        Feet f1=new Feet(1.0);
        assertTrue(f1.equals(f1));
    }
    @Test
    public void testInchesEquality_SameValue(){
        Feet f1=new Feet(1.0);
        Feet f2=new Feet(1.0);
        assertTrue(f1.equals(f2));
    }

    @Test
    public void testInchesEquality_DifferentValue(){
        Feet f1=new Feet(1.0);
        Feet f2=new Feet(2.0);
        assertFalse(f1.equals(f2));

    }
    @Test
    public void testInchesEquality_NullComparison(){
        Feet f1=new Feet(1.0);
        assertFalse(f1.equals(null));
    }

    @Test
    public void testInchesEquality_DifferentClass(){
        Feet f1=new Feet(1.0);
        assertFalse(f1.equals(new Object()));
    }

    @Test
    public void testInchesEquality_SameRefernce(){
        Feet f1=new Feet(1.0);
        assertTrue(f1.equals(f1));
    }

}
