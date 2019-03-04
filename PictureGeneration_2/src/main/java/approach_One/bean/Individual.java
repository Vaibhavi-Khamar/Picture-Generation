package approach_One.bean;

import approach_One.func.GeneFactory;
import java.util.Random;

/**
 * @author vaibhavi
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

    private void toPhenotype() {
        int[][] data = new int[Target.getHeight()][Target.getWidth()];
        for (Gene g :
                chromosome) {
            for (int i = g.getY1(); i <= g.getY2(); i++) {
                for (int j = g.getX1(); j <= g.getX2(); j++) {
                    if (data[i][j] == 0) {
                        data[i][j] = 1;
                    }
                }
            }
        }
        this.phenotype = data;
    }

    private void calFitness() {
        int[][] data = Target.getTarget();
        int width = Target.getWidth();
        int height = Target.getHeight();
        int fitness = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (phenotype[i][j] == data[i][j]) {
                    fitness += 10;
                } else {
                    fitness -= 50;
                }
            }
        }
        this.fitness = fitness;
    }

    public void mutation() {
        Random r = new Random();
        int ratio = (int) ((Target.getWidth() * Target.getHeight()) * 0.001);
//        for (int k = 0; k < ratio; k++) {
//            int i = r.nextInt(Target.getHeight());
//            int j = r.nextInt(Target.getWidth());
//            if (phenotype[i][j] == 0) {
//                phenotype[i][j] = 1;
//            } else {
//                phenotype[i][j] = 0;
//            }
//        }
        for (int k = 0; k < ratio; k++) {
            this.chromosome[r.nextInt(chromosome.length)] = new GeneFactory().getGene();
        }
        this.toPhenotype();
        this.calFitness();
    }

    public void crossover(Individual o) {
        Random r = new Random();
//        int x_1 = r.nextInt(Target.getHeight());
//        int y_1 = r.nextInt(Target.getWidth());
//        int x_2 = r.nextInt(Target.getHeight());
//        int y_2 = r.nextInt(Target.getWidth());
//
//        for (int i = Math.min(x_1, x_2); i < Math.max(x_1, x_2); i++) {
//            for (int j = Math.min(y_1, y_2); j < Math.max(y_1, y_2); j++) {
//                int temp = this.phenotype[i][j];
//                this.phenotype[i][j] = o.phenotype[i][j];
//                o.phenotype[i][j] = temp;
//            }
//        }

//        int cutpoint = r.nextInt(Target.getWidth());
//        for (int i = 0; i < Target.getHeight(); i++) {
//            for (int j = 0; j < cutpoint; j++) {
//                int temp = this.phenotype[i][j];
//                this.phenotype[i][j] = o.phenotype[i][j];
//                o.phenotype[i][j] = temp;
//            }
//        }

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
