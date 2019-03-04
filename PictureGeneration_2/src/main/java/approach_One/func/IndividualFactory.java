package approach_One.func;

import approach_One.bean.Gene;
import approach_One.bean.Individual;
import approach_One.bean.Target;

/**
 * @author vaibhavi
 * @project GA
 */

public class IndividualFactory {
    public Individual getIndividual() {
//        Random r = new Random();
        return func_1();

    }

    private Individual func_1() {
        int len = (int) (Math.max(Target.getHeight(), Target.getWidth()) * 0.5);
        Gene[] data = new Gene[len];
        for (int i = 0; i < len; i++) {
            data[i] = new GeneFactory().getGene();
        }
        return new Individual(data);
    }
}
