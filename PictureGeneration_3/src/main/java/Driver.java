import bean.Individual;
import bean.Population;
import helper.Config;

/**
 * @author  Qixiang Zhou
 * @project PictureGeneration
 */
public class Driver {
    public static void main(String[] args) throws CloneNotSupportedException {
        Config.getInstance().setConfig(200, 200, 2, 0.4f, 100000, 20, 1000);
        Population p = new Population();
        Individual bestIndividual = (Individual) p.getBest().clone();
        System.out.println("Begin  " + bestIndividual.getFitness());
        bestIndividual.print(0);
        for (int i = 1; i <= Config.getInstance().getGenerationNum(); i++) {
            p.nextGeneration();
            if (p.getBest().compareTo(bestIndividual) > 0) {
                bestIndividual = (Individual) p.getBest().clone();
                System.out.println("generation "+i +" "+ bestIndividual.getFitness());
                bestIndividual.print(i);
            }
        }
    }
//    public void evolve(int num_generation) throws CloneNotSupportedException {
//        if (num_generation == 0) return;
//        if (num_generation < 0) num_generation = Integer.MAX_VALUE;
//        Individual o = (Individual) populations.max().clone();
//        System.out.print("0" + "    ");
//        System.out.print(populations.size() + "    ");
//        System.out.println(o.getFitness());
//        o.show();
//        for (int i = 0; i < num_generation; i++) {
//            nextGeneration();
//            if (populations.max().getFitness() > o.getFitness()) {
//                o = (Individual) populations.max().clone();
//                System.out.print(i + "    ");
//                System.out.print(populations.size() + "    ");
//                System.out.println(o.getFitness());
//                o.show();
//            }
//        }
//    }
}
