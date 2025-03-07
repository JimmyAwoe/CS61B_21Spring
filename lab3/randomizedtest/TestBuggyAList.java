package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> alnr = new AListNoResizing<>();
        BuggyAList<Integer> bal = new BuggyAList<>();
        for (int i = 3; i < 6; i++) {
            alnr.addLast(i);
            bal.addLast(i);
        }
        for (int i =3; i < 6; i++) {
            alnr.removeLast();
            bal.removeLast();
            assertEquals(alnr.size(), bal.size());
            for (int j = 0; j < alnr.size(); j++){
                assertEquals(alnr.get(j), bal.get(j));
            }
        }
    }

    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> BL = new BuggyAList<>();
        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                BL.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int bsize = BL.size();
                assertEquals(size, bsize);
            } else if (operationNumber == 2) {
                if (L.size() == 0) {continue;}
                int last = L.getLast();
                int blast = BL.getLast();
                assertEquals(last, blast);
            } else if (operationNumber == 3) {
                if (L.size() == 0) {continue;}
                int last = L.removeLast();
                int blast = BL.removeLast();
                assertEquals(last, blast);
            }

        }
    }
}
