package factory;

import bean.Gene;
import helper.Config;
import helper.Target;

import java.awt.*;
import java.util.Random;

/**
 * @author  Qixiang Zhou
 * @project PictureGeneration
 */
public class GeneFactory {
    public Gene createGene() {
        Random random = new Random();
        int x = random.nextInt(Target.getWidth());
        int y = random.nextInt(Target.getHeight());
        int radius = random.nextInt(Config.getInstance().getMaxRadius());
        int rgb = new Color(
                random.nextInt(256),
                random.nextInt(256),
                random.nextInt(256)
        ).getRGB();

        return new Gene(rgb, x, y, radius);
    }
}
