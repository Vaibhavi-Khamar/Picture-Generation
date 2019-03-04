package bean;

import factory.GeneFactory;
import helper.Config;
import helper.ImgProcess;
import helper.Target;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author  Qixiang Zhou
 * @project PictureGeneration
 */
public class Individual implements Comparable<Individual>, Cloneable {

    private List<Gene> chromosome;
    private int[][] phenotype;
    private int fitness;
    private final int width = Target.getWidth();
    private final int height = Target.getHeight();

    public int getFitness() {
        return fitness;
    }

    public Individual(List<Gene> chromosome) {
        this.chromosome = chromosome;
        phenotypify();
        calFitness();
    }

    private void phenotypify() {

        int[][] data = new int[width][height];
        for (Gene g : chromosome) {
            g.beActivated(data);
        }
        this.phenotype = data;
    }

    private void calFitness() {
        int[][] data = Target.getTarget();
        int width = Target.getWidth();
        int height = Target.getHeight();
        int fitness = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int rgb = data[i][j];
                int rgb2 = phenotype[i][j];
                fitness += Math.abs((rgb & 0xFF) - (rgb2 & 0xFF));
                fitness += Math.abs(((rgb >> 8) & 0xFF) - ((rgb2 >> 8) & 0xFF));
                fitness += Math.abs(((rgb >> 16) & 0xFF) - ((rgb2 >> 16) & 0xFF));
            }
        }
        this.fitness = fitness;
    }

    public void mutate() {
        Random r = new Random();
        // Only 0.1% gene will be mutated, this is the fixed number, and it will not change.
        // And the minimum number of gene will be mutated is 1
        int index = r.nextInt(chromosome.size());
        for (int i = 0; i <= chromosome.size() * 0.001; i++) {
            Gene temp = chromosome.get(index);
            chromosome.remove(index);
            temp.mutate();
            chromosome.add(temp);
        }
        phenotypify();
        calFitness();
    }

    public static Individual crossover(Individual i1, Individual i2) {
        Random r = new Random();
        List<Gene> offspring = new ArrayList<>();
        if (r.nextBoolean()) {
            getOffspring(i1, offspring);
            getOffspring(i2, offspring);
        } else {
            getOffspring(i2, offspring);
            getOffspring(i1, offspring);
        }
        return new Individual(offspring);
    }

    private static void getOffspring(Individual individual, List<Gene> offspring) {
        for (int i = individual.chromosome.size() / 2; i < individual.chromosome.size(); i++) {
            try {
                offspring.add((Gene) individual.chromosome.get(i).clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                System.out.println("Clone gene fail!");
            }
        }
    }

    public void doubleChromosome() {
        if (chromosome.size() >= Config.getInstance().getChromosomeSize()) {
            return;
        }
        GeneFactory gf = new GeneFactory();
        // Chromosome size will increase each generation. The length will become 1.5 times before
        // The initial size is 1, and max size is defined in Config class.
        for (int i = 0; i <= chromosome.size() * 0.5; i++) {
            chromosome.add(gf.createGene());
        }
    }

    /**
    * Override compareTo in order to keep natural sequence in container.
    */
    @Override
    public int compareTo(Individual o) {
        Individual i = (Individual) o;
        return i.fitness - this.fitness;
    }

    /**
     * Override clone method, in order to copy the objects
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void print(int i) {
        new ImgProcess().writeImg(phenotype, "./Output/image"+i+".png");
    }
}
