package IntList;

import static org.junit.Assert.*;
import org.junit.Test;

public class prime_test {
    @Test
    public void testprime(){
        IntList lst = IntList.of(14, 18, 20, 39);
        boolean change = IntListExercises.squarePrimes(lst);
        assertFalse(change);
        assertEquals("14 -> 18 -> 20 -> 39", lst.toString());
    }

    @Test
    public void testprimetrue(){
        IntList lst = IntList.of(14, 17, 2, 5);
        boolean change = IntListExercises.squarePrimes(lst);
        assertTrue(change);
        assertEquals("14 -> 289 -> 4 -> 25", lst.toString());
    }
}

