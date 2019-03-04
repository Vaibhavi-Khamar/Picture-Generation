package factory;

import bean.Gene;
import bean.Individual;

import java.util.ArrayList;
import java.util.List;

/**
 * @author  Qixiang Zhou
 * @project PictureGeneration
 */
public class IndividualFactory {
    public Individual getIndividual() {
        List<Gene> data = new ArrayList<>();
        data.add(new GeneFactory().createGene());
        return new Individual(data);
    }
}
