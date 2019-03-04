package bean;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Qixiang Zhou
 * @project PictureGeneration
 */
public class GeneTest {
    @Test
    public void test_drawCircle() {
        Gene g = new Gene(5, 4, 4, 2);
        int[][] data = new int[8][8];
        g.beActivated(data);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(data[i][j]);
            }
            System.out.println(" ");
        }
    }
}