package approach_Basic.func;

import approach_Basic.bean.Gene;
import approach_Basic.bean.Individual;
import approach_Basic.bean.Target;

import java.util.Random;

/**
 * @author  Qixiang Zhou
 * @project GA
 */
public class IndividualFactory {
    public Individual getIndividual() {
//        Random r = new Random();
        return func_1();

    }


    private Individual func_1() {
        Random r = new Random();
        int len = Target.getHeight();
        Gene[] data = new Gene[len];
        for (int i = 0; i < len; i++) {
            Gene a =GeneFactory.getInstance().getGene();
            data[i] = a;
        }
        return new Individual(data);
    }
}
