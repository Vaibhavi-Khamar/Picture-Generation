package approach_Basic.bean;

import approach_Basic.func.IndividualFactory;
import approach_Basic.func.MaxPQ;

import java.util.List;
import java.util.Random;

/**
 * @author  Qixiang Zhou
 * @project GA
 */
public class Population {
    private int maxPopulation;
    private int initPopulation;
    private MaxPQ<Individual> populations;


    public Population(int maxPopulation, int initPopulation) {
        this.maxPopulation = maxPopulation;
        this.initPopulation = initPopulation;
        populations = new MaxPQ<>();
        initPopulation();
    }

    public Population() {
        this(10000, 1000);
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

    private void nextGeneration() throws CloneNotSupportedException {
        Random r = new Random();

        MaxPQ<Individual> newGeneration = new MaxPQ<>();
        // In the beginning, get all elements in PQ into List.
        List<Individual> list = populations.asList();

        // First select some to get mutation.

        for (int k = 0; k < populations.size(); k++) {
            Individual i = list.get(k);
            float v = r.nextFloat();
            if (v < 0.5) {
                i.mutation();
            }
            newGeneration.insert(i);
        }
        // Second breed next generation, use crossover
        for (int k = 0; k < populations.size(); k++) {
            Individual i = list.get(k);
            Individual mate1 = (Individual) i.clone();
            Individual mate2 = list.get(r.nextInt(populations.size()));
//            Individual mate2 = list[r.nextInt(populations.size())];
            mate1.crossover(mate2);
            newGeneration.insert(mate1);
            newGeneration.insert(mate2);
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

    public void evolve(int num_generation) throws CloneNotSupportedException {
        if (num_generation == 0) return;
        if (num_generation < 0) num_generation = Integer.MAX_VALUE;
        Individual o = (Individual) populations.max().clone();
        System.out.print("0" + "    ");
        System.out.print(populations.size() + "    ");
        System.out.println(o.getFitness());
        o.show();
        for (int i = 0; i < num_generation; i++) {
            nextGeneration();
            if (populations.max().getFitness() > o.getFitness()) {
                o = (Individual) populations.max().clone();
                System.out.print(i + "    ");
                System.out.print(populations.size() + "    ");
                System.out.println(o.getFitness());
                o.show();
            }
        }
    }

}
