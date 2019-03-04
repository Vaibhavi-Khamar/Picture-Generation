package approach_Basic.test;

import approach_Basic.func.ReadImg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author
 * @project GA
 */
class node {
    int i;

    public node(int i) {
        this.i = i;
    }
}

public class T {
    public static void main(String[] args) {

    }

    private static void test4() {
        int[][] data = ReadImg.getData("./img.png");
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                System.out.print(data[i][j]);
            }
            System.out.println(" ");
        }
    }

    private static void test3() {
        int[][] data = new int[4][4];
        for (int i = 0; i < data.length / 2; i++) {
            for (int j = 0; j < data[0].length; j++) {
                data[i][j] = 1;
            }
        }
        try {
            ReadImg.writeDate(data, "./img.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void test2() {
        node n1 = new node(3);
        node n2 = new node(2);
        node n3 = new node(3);

        List<node> list = new ArrayList<node>();
        list.add(n1);
        list.add(n2);
        list.add(n3);

        for (node n : list) {
            n.i = 1;
        }
        for (node n : list) {
            System.out.println(n.i);
        }
    }

    private static void test1() {
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(r.nextDouble());
        }
    }
}
