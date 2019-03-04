package approach_Basic.func;

import approach_Basic.bean.Population;

/**
 * @author  Qixiang Zhou
 * @project GA
 */
public class GA {
    public static void main(String[] args) {
        Population p = new Population(100000, 10000);
        try {
            p.evolve(-1);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
