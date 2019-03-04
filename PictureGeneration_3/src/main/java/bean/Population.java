package bean;

import factory.IndividualFactory;
import helper.Config;
import helper.MaxPQ;

import java.util.List;
import java.util.Random;

/**
 * @author  Qixiang Zhou
 * @project PictureGeneration
 */
public class Population {
    private int maxPopulation;
    private int initPopulation;
    private MaxPQ<Individual> populations;
    private int gen = 0;


    public Population() {
        this.maxPopulation = Config.getInstance().getMaxSize();
        this.initPopulation = Config.getInstance().getInitSize();
        populations = new MaxPQ<>();
        initPopulation();
    }

    private void initPopulation() {
        if (initPopulation > maxPopulation) {
            return;
        }
        IndividualFactory IF = new IndividualFactory();
        for (int i = 0; i < initPopulation; i++) {
            populations.insert(IF.getIndividual());
        }
    }

    public Individual getBest() {
        return populations.max();
    }

    public void nextGeneration() {
        Random r = new Random();
        gen++;

        MaxPQ<Individual> newGeneration = new MaxPQ<>();

        // In the beginning, get all elements in PQ into List.
        // enlarge the chromosome size
        List<Individual> list = populations.asList();
        for (Individual individual : list) {
            individual.doubleChromosome();
        }

        // First select some to get mutation.
        for (int k = 0; k < populations.size(); k++) {
            Individual i = list.get(k);
            float v = r.nextFloat();
            if (v < Config.getInstance().getMutationRate()) {
                i.mutate();
            }
            newGeneration.insert(i);
        }

        // Second breed next generation, use crossover
        for (int k = 0; k < populations.size(); k++) {
            Individual mate1 = list.get(k);
            Individual mate2 = list.get(r.nextInt(populations.size()));
            for (int i = 0; i < Config.getInstance().getOffspringNum(); i++) {
                Individual newI = Individual.crossover(mate1, mate2);
                newGeneration.insert(newI);
            }
        }

        // Keep half of newgeneration. If new / 2 > maxPopulation, then keep maxPopulation.
        populations.clear();
        int size = newGeneration.size();
        if (size * 0.5 < maxPopulation) {
            for (int i = 0; i < size * 0.5; i++) {
                populations.insert(newGeneration.delMax());
            }
        } else {
            for (int i = 0; i < maxPopulation; i++) {
                populations.insert(newGeneration.delMax());
            }
        }
    }

}
