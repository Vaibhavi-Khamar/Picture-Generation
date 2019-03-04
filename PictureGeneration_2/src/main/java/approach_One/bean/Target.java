package approach_One.bean;

import approach_One.func.ReadImg;

/**
 * @author vaibhavi
 * @project GA
 */

public class Target {

//    private static int[][] target() {
//        int[][] data = new int[4][4];
//        for (int i = 0; i < 2; i++) {
//            for (int j = 0; j < 4; j++) {
//                data[i][j] = 1;
//            }
//        }
//        return data;
//    }
//    private static final int[][] target = target();

    private static final int[][] target = ReadImg.getData("./img.png");
    private static final int height = target.length;
    private static final int width = target[0].length;

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
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(target[i][j]);
            }
            System.out.println(" ");
        }
    }
}
