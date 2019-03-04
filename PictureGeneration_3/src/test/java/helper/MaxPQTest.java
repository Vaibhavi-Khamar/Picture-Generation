package helper;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author
 * @project PictureGeneration
 */
public class MaxPQTest {
    @Test
    public void ismaxHeap() {
        MaxPQ<Integer> mp = new MaxPQ<>();
        mp.insert(100);
        mp.insert(1);
        mp.insert(1);
        assertEquals(new Integer(100), mp.max());
    }

    @Test
    public void testDel() {
        MaxPQ<Integer> mp = new MaxPQ<>();
        mp.insert(100);
        mp.insert(50);
        mp.insert(30);
        mp.delMax();
        assertEquals(new Integer(50), mp.max());
    }
}