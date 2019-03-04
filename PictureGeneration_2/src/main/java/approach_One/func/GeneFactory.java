package approach_One.func;

import approach_One.bean.Gene;
import approach_One.bean.Target;
import java.util.Random;

/**
 * @author vaibhavi
 * @project GA
 */

public class GeneFactory {
    public Gene getGene() {
        Random r = new Random();

        int x1 = r.nextInt(Target.getWidth());
        int x2 = r.nextInt(Target.getWidth());
        int y1 = r.nextInt(Target.getHeight());
        int y2 = r.nextInt(Target.getHeight());

        if (r.nextBoolean()) {
            y1 = y2;
        } else {
            x1 = x2;
        }

        if (x1 > x2) {
            int temp = x1;
            x1 = x2;
            x2 = temp;
        }

        if (y1 > y2) {
            int temp = y1;
            y1 = y2;
            y2 = temp;
        }

        return new Gene(x1, x2, y1, y2);
    }
}
