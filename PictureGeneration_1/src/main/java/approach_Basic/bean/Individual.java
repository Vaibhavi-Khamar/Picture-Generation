package approach_Basic.bean;

import approach_Basic.func.GeneFactory;

import java.util.Random;

/**
 * @author  Qixiang Zhou
 * @project GA
 */
public class Individual implements Comparable<Individual>, Cloneable {

    public int[][] getPhenotype() {
        return phenotype;
    }

    private int[][] phenotype;
    private Gene[] chromosome;

    public int getFitness() {
        return fitness;
    }

    private int fitness;

    public Individual(Gene[] chromosome) {
        this.chromosome = chromosome;
        this.toPhenotype();
        calFitness();
    }

    private void toPhenotype() {// TODO
        int[][] data = new int[Target.getHeight()][Target.getWidth()];
        int i = 0;
        for (Gene g :
                chromosome) {
            for (int j = 0; j < Target.getWidth(); j++) {
                data[i][j] = g.getPixels()[j];
            }
            i++;
        }
        this.phenotype = data;
    }

    private void calFitness() { //TODO
        int[][] data = Target.getTarget();
        int width = Target.getWidth();
        int height = Target.getHeight();
        int fitness = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (phenotype[i][j] == data[i][j]) {
                    fitness += 10;
                } else {
                    fitness -= 5;
                }
            }
        }
        this.fitness = fitness;
    }

    public void mutation() {
        Random r = new Random();

        for (int i = 0; i < chromosome.length * 0.1; i++) {
            int p1 = r.nextInt(chromosome.length);
            int p2 = r.nextInt(chromosome.length);
            Gene temp = chromosome[p1];
            chromosome[p1] = chromosome[p2];
            chromosome[p2] = temp;
        }
        this.toPhenotype();
        this.calFitness();
    }

    public void crossover(Individual o) {
        Random r = new Random();

        for (int i = 0; i < chromosome.length * 0.4; i++) {
            int cutpoint = r.nextInt(chromosome.length);
            Gene temp = this.chromosome[cutpoint];
            this.chromosome[cutpoint] = o.chromosome[cutpoint];
            o.chromosome[cutpoint] = temp;
        }

        this.toPhenotype();
        o.toPhenotype();
        calFitness();
        o.calFitness();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public int compareTo(Individual o) {
        return this.fitness - o.fitness;
    }

    public void show() {
        for (int i = 0; i < Target.getHeight(); i++) {
            for (int j = 0; j < Target.getWidth(); j++) {
                if (phenotype[i][j] == 0) {
                    System.out.print(" ");
                } else {
                    System.out.print(phenotype[i][j]);
                }

            }
            System.out.println(" ");
        }
    }
}
