package approach_Basic.bean;

import java.util.Arrays;

/**
 * @author
 * @project GA
 */
public class Gene implements Cloneable {
    private int[] pixels;

    public Gene(int[] pixels) {
        this.pixels = pixels;
    }

    public int[] getPixels() {
        return pixels;
    }

    public void setPixels(int[] pixels) {
        this.pixels = pixels;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object obj) {
        Gene g = (Gene) obj;
        return Arrays.equals(this.pixels, g.pixels);
    }
}
