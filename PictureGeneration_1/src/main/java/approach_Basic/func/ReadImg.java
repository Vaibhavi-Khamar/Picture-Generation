package approach_Basic.func;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author
 * @project GA
 */
public class ReadImg {
    public static int[][] getData(String path) {
        try {
            BufferedImage bimg = ImageIO.read(new File(path));
            int[][] data = new int[bimg.getHeight()][bimg.getWidth()];
            //鏂瑰紡涓�锛氶�氳繃getRGB()鏂瑰紡鑾峰緱鍍忕礌鐭╅樀
            //姝ゆ柟寮忎负娌縃eight鏂瑰悜鎵弿
           for (int i = 0; i < bimg.getHeight(); i++) {
                for (int j = 0; j < bimg.getWidth(); j++) {
                    int comp = bimg.getRGB(j, i);
                    if (comp == 0) {
                        data[i][j] = 0;
                        System.out.print(" ");
                    } else {
                        data[i][j] = 1;
                        System.out.print(1);
                    }
//                    System.out.print(data[i][j]);
                }
                System.out.println(" ");
            }


            return data;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeDate(int[][] data, String path) throws IOException {
        int cx = data.length;
        int cy = data[0].length;
        //濉厖鐭╁舰楂樺
        int cz = 1;
        //鐢熸垚鍥剧殑瀹藉害
        int width = cx * cz;
        //鐢熸垚鍥剧殑楂樺害
        int height = cy * cz;

        OutputStream output = new FileOutputStream(new File(path));
        BufferedImage bufImg = new BufferedImage(width, height,    BufferedImage.TYPE_INT_RGB);
        Graphics2D gs = bufImg.createGraphics();
        gs.setBackground(Color.WHITE);
        gs.clearRect(0, 0, width, height);
        gs.setColor(Color.BLACK);
        for (int i = 0; i < cx; i++) {
            for (int j = 0; j < cy; j++) {
                //1缁樺埗濉厖榛戠煩褰�
                if(data[j][i]==1){
                    gs.drawRect(i*cz, j*cz, cz, cz);
                    gs.fillRect(i*cz, j*cz, cz, cz);
                }
            }
        }
        gs.dispose();
        bufImg.flush();
        //杈撳嚭鏂囦欢
        ImageIO.write(bufImg, "jpeg", output);
    }

    public static void main(String[] args) {
        int[][] data = getData("./IMG.png");
        try {
            writeDate(data, "./approach_One.test.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
