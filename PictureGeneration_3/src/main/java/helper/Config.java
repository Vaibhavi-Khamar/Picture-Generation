package helper;

/**
 * @author  Qixiang Zhou
 * @project PictureGeneration
 */
public class Config {
    private static Config ourInstance = new Config();

    public static Config getInstance() {
        return ourInstance;
    }

    private Config() {
    }

    private int initSize;
    private int maxSize;
    private int offspringNum;
    private float mutationRate;
    private int generationNum;
    private int maxRadius;
    private int chromosomeSize;

    public void setConfig(int initSize, int maxSize, int offspringNum, float mutationRate, int generationNum, int maxRadius, int chromosomeSize) {
        this.initSize = initSize;
        this.maxSize = maxSize;
        this.offspringNum = offspringNum;
        this.mutationRate = mutationRate;
        this.generationNum = generationNum;
        this.maxRadius = maxRadius;
        this.chromosomeSize = chromosomeSize;
    }

    public int getInitSize() {
        return initSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int getOffspringNum() {
        return offspringNum;
    }

    public float getMutationRate() {
        return mutationRate;
    }

    public int getGenerationNum() {
        return generationNum;
    }

    public int getMaxRadius() {
        return maxRadius;
    }

    public int getChromosomeSize() {
        return chromosomeSize;
    }
}
