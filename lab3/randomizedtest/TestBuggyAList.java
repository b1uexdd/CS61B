package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import timingtest.AList;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove(){
        AListNoResizing<Integer> L = new AListNoResizing<Integer>();
        BuggyAList<Integer> LB = new BuggyAList<Integer>();
        L.addLast(4);
        L.addLast(5);
        L.addLast(6);

        LB.addLast(4);
        LB.addLast(5);
        LB.addLast(6);

        assertEquals(L.size(),  LB.size());
        assertEquals(L.removeLast(), LB.removeLast());
        assertEquals(L.removeLast(), LB.removeLast());
        assertEquals(L.removeLast(), LB.removeLast());
    }

    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> LB = new BuggyAList<Integer>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                LB.addLast(randVal);
                //System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int sizeB = LB.size();
                assertEquals(size, sizeB);
                //System.out.println("size: " + size);
            }else if (operationNumber == 2 && L.size() > 0) {
                int last = L.getLast();
                int lastB = LB.getLast();
                assertEquals(last, lastB);
                //System.out.println("last: " + last);
            }else if (operationNumber == 3 && L.size() > 0){
                int last = L.removeLast();
                int lastB = LB.removeLast();
                assertEquals(last, lastB);
                //System.out.println("lastRemove: " + last);
            }
        }
    }
}
