package bean;

import helper.Config;
import helper.Target;

import java.util.Random;

/**
 * @author  Qixiang Zhou
 * @project PictureGeneration
 */
public class Gene implements Cloneable{

    private final int rgb;
    private int x;
    private int y;
    private int radius;

    public Gene(int rgb, int x, int y, int radius) {
        this.rgb = rgb;
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getRgb() {
        return rgb;
    }

    public void mutate() {
        Random r = new Random();
        int x = r.nextInt(Target.getWidth());
        int y = r.nextInt(Target.getHeight());
        int radius = r.nextInt(Config.getInstance().getMaxRadius());
        // Redefine the feature of Gene
        this.setX(x); this.setY(y); this.setRadius(radius);
    }

//    private void circleSym4(int[][] data, int radius) {
//        int i, j, r2;
//        r2 = radius * radius;
//        drawPixel(data, x, y + radius);
//        drawPixel(data, x, y - radius);
//        for (i = 1; i <= radius; i++) {
//            j = (int) (Math.round(Math.sqrt(r2 - i*i)));
//            drawPixel(data, x + i, y + j);
//            drawPixel(data, x + i, y - j);
//            drawPixel(data, x - i, y + j);
//            drawPixel(data, x - i, y - j);
//        }
//    }

    private void drawCircle(int[][] data, int radius) {
        int d = (5 - radius * 4)/4;
        int i = 0;
        int r = radius;

        do {
            drawPixel(data, x + i, y + r);
            drawPixel(data, x + i, y - r);
            drawPixel(data, x - i, y + r);
            drawPixel(data, x - i, y - r);
            drawPixel(data, x + r, y + i);
            drawPixel(data, x + r, y - i);
            drawPixel(data, x - r, y + i);
            drawPixel(data, x - r, y - i);
            if (d < 0) {
                d += 2 * i + 1;
            } else {
                d += 2 * (i - r) + 1;
                r--;
            }
            i++;
        } while (i <= r);

    }

    private void drawPixel(int[][] data, int x, int y) {
        if (x >= 0 && x < data.length && y >= 0 && y < data[0].length) {
            data[x][y] = rgb;
        }
    }

    public void beActivated(int[][] data) {
        int width = data.length;
        int height = data[0].length;

        // Solve the corner case.
        if (x >= width || y >= width) {
            return;
        }

        for (int r = 0; r <= radius; r++) {
            drawCircle(data, r);
        }


        // Draw circle in the given matrix.
//        for (int i = 0; i < 360; i++) {
//            for (int r = 0; r <= radius; r++) {
//                double x1 = r * Math.cos(i * Math.PI / 180);
//                double y2 = r * Math.sin(i * Math.PI / 180);
//                int ELX = (int) Math.round(x + x1);
//                int ELY = (int) Math.round(y + y2);
//
//                // When the point is out of bound, then do nothing.
//                if (ELX >= 0 && ELX < width && ELY >= 0 && ELY < height) {
//                    data[ELX][ELY] = rgb;
//                }
//            }
//        }
//        return data;
    }

//    public int[][] toMatrix() {
//        int[][] data = drawCircle();
//        return data;
//    }

    @Override
    public boolean equals(Object obj) {
        Gene g = (Gene) obj;
        return this.x == g.x &&
                this.y == g.y &&
                this.radius == g.radius &&
                this.rgb == g.rgb;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
