package helper;

import org.junit.Test;

/**
 * @author
 * @project PictureGeneration
 */
public class ImgProcessTest {
    @Test
    public void testRead() {
        ImgProcess ri = new ImgProcess();
        int[][] data = ri.readImg("./test.jpeg");
        for (int[] a : data) {
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i]);
            }
            System.out.println(" ");
        }
    }

    @Test
    public void testWrite() {
        ImgProcess ri = new ImgProcess();
        ri.writeImg(ri.readImg("./test.jpeg"), "./test.png");
    }
}