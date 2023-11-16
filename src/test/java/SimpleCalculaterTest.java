import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import UnitTest.SimpleCalculator;

public class SimpleCalculaterTest {
    @Test
    @Before
    public void twoPlustwoShouldEqualFour(){
        SimpleCalculator calculator = new SimpleCalculator();
        assertEquals(4, calculator.add(2, 2));
        //assertThrows(IllegalArgumentException.class, ()-> 5,5 , "Fehler");
        assertSame(calculator.add(2, 4), calculator.add(2, 4));
    }
}
