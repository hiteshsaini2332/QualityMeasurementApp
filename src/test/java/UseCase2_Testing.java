import org.example.uc2.FeetUc2;
import org.example.uc2.InchesUc2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UseCase2_Testing {
    @Test
    public void testFeetEquality_SameValue(){
        FeetUc2 f1=new FeetUc2(1.0);
        FeetUc2 f2=new FeetUc2(1.0);
        assertTrue(f1.equals(f2));
    }

    @Test
    public void testFeetEquality_DifferentValue(){
        FeetUc2 f1=new FeetUc2(1.0);
        FeetUc2 f2=new FeetUc2(2.0);
        assertFalse(f1.equals(f2));

    }
    @Test
    public void testFeetEquality_NullComparison(){
        FeetUc2 f1=new FeetUc2(1.0);
        assertFalse(f1.equals(null));
    }

    @Test
    public void testFeetEquality_DifferentClass(){
        FeetUc2 f1=new FeetUc2(1.0);
        assertFalse(f1.equals(new Object()));
    }

    @Test
    public void testFeetEquality_SameRefernce(){
        FeetUc2 f1=new FeetUc2(1.0);
        assertTrue(f1.equals(f1));
    }
    @Test
    public void testInchesEquality_SameValue(){
        InchesUc2 f1=new InchesUc2(1.0);
        InchesUc2 f2=new InchesUc2(1.0);
        assertTrue(f1.equals(f2));
    }

    @Test
    public void testInchesEquality_DifferentValue(){
        InchesUc2 f1=new InchesUc2(1.0);
        InchesUc2 f2=new InchesUc2(2.0);
        assertFalse(f1.equals(f2));

    }
    @Test
    public void testInchesEquality_NullComparison(){
        InchesUc2 f1=new InchesUc2(1.0);
        assertFalse(f1.equals(null));
    }

    @Test
    public void testInchesEquality_DifferentClass(){
        InchesUc2 f1=new InchesUc2(1.0);
        assertFalse(f1.equals(new Object()));
    }

    @Test
    public void testInchesEquality_SameRefernce(){
        InchesUc2 f1=new InchesUc2(1.0);
        assertTrue(f1.equals(f1));
    }

}
