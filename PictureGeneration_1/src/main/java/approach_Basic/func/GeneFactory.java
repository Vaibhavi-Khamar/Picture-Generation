package approach_Basic.func;

import approach_Basic.bean.Gene;
import approach_Basic.bean.Target;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author
 * @project GA
 */
public class GeneFactory {
    private static GeneFactory ourInstace = new GeneFactory();

    private GeneFactory() {
        Random r = new Random();
        for (int[] a:
                Target.getTarget()) {
            this.addgene(new Gene(a));
        }
    }

    public static GeneFactory getInstance() {
        return ourInstace;
    }

    private List<Gene> genepool = new ArrayList<>();

    private void addgene(Gene gene) {
        if (genepool.contains(gene)) {
            return;
        }
        genepool.add(gene);
    }

    public Gene getGene(int index) {
        return genepool.get(index);
    }

    public int size() {
        return genepool.size();
    }

    public Gene getGene() {
        Random r = new Random();
        return genepool.get(r.nextInt(this.size()));
    }
}
