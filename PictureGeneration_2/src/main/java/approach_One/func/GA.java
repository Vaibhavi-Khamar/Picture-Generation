package approach_One.func;

import approach_One.bean.Population;

/**
 * @author vaibhavi
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
