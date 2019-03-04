package helper;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author  Qixiang Zhou
 * @project PictureGeneration
 */
public class ImgProcess {

    public int[][] readImg(String path) {
        BufferedImage img = null;
        File f = null;

        try {
            f = new File(path);
            img = ImageIO.read(f);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int width = img.getWidth();
        int height = img.getHeight();
        int[][] data = new int[width][height];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                data[x][y] = img.getRGB(x,y);
            }
        }
        return data;
    }


    public void writeImg(int[][] data, String path) {
        int width = data.length;
        int height = data[0].length;
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        File f = null;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                img.setRGB(x, y, data[x][y]);
            }
        }

        try {
            f = new File(path);
            ImageIO.write(img, "png", f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
