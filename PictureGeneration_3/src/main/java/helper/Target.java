package helper;

/**
 * @author  Qixiang Zhou
 * @project PictureGeneration
 */
public class Target {
    private static final int[][] target = new ImgProcess().readImg("./test.jpeg");
    private static final int width= target.length;
    private static final int height = target[0].length;

    public static int[][] getTarget() {
        return target;
    }

    public static int getHeight() {
        return height;
    }

    public static int getWidth() {
        return width;
    }

    public static void show() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                System.out.print(target[i][j]);
            }
            System.out.println(" ");
        }
    }
}
