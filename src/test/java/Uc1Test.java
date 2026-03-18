import org.example.uc1.FeetUc1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class Uc1Test {
    @Test
    void testFeetEquality_SameValue(){
        FeetUc1 f1 = new FeetUc1(1.0);
        FeetUc1 f2 = new FeetUc1(1.0);
        assertTrue(f1.equals(f2));
    }
    @Test
    void testFeetEquality_DifferentValue(){
        FeetUc1 f1 = new FeetUc1(1.0);
        FeetUc1 f2 = new FeetUc1(2.0);
        assertFalse(f1.equals(f2));
    }
    @Test
    void testFeetEquality_NullValue(){
        FeetUc1 f1 = new FeetUc1(1.0);
        assertFalse(f1.equals(null));
    }

    @Test
    void testFeetEquality_DifferentClass(){
        FeetUc1 f1 = new FeetUc1(1.0);
        assertFalse(f1.equals("5"));
    }

    @Test
    void testFeetEquality_SameReference(){
        FeetUc1 f1 = new FeetUc1(1.0);
        assertTrue(f1.equals(f1));
    }
}