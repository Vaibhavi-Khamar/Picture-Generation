package approach_One.bean;

import approach_One.func.IndividualFactory;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author vaibhavi
 * @project GA
 */

public class IndividualTest {

    @Test
    public void testClone() throws CloneNotSupportedException {
        IndividualFactory IF = new IndividualFactory();
        Individual i1 = IF.getIndividual();
        int[][] data = i1.getPhenotype().clone();
        Individual i2 = (Individual) i1.clone();
        i1.mutation();
        assertArrayEquals(i2.getPhenotype(), data);
    }
    
    @Test
    public void testcalFit() {
    	Gene[] chromosome=new Gene[32];
    	int[][]target=Target.getTarget();
    	for(int i=0;i<32;i++) {
    		int[] gene=new int[32];
    		for(int j=0;j<32;j++) {
    			if(target[i][j]==0)
    				gene[j]=1;
    			else gene[j]=0;
    		}
    	}
    }
    
    @Test
    public void testcalFit1() {
    	Gene[] chromosome=new Gene[32];
    	int[][]target=Target.getTarget();
    	for(int i=0;i<32;i++) {
    		int[] gene=new int[32];
    		for(int j=0;j<32;j++) {
    			gene[j]=target[i][j];
    		}
    		chromosome[i]=new Gene(5,4,4,2);
    	}
    	Individual ind=new Individual(chromosome);
    	assertEquals(ind.getFitness(),-23960);  	
    }
    
    @Test
    public void testCalFit2() {
        
        Gene g = new Gene(0, 1, 0, 1);
        int[][]target=Target.getTarget();
        Gene[]genes = new Gene[1];
        genes[0] = g;
        Individual i = new Individual(genes);       
        int fit = i.getFitness();
        assertEquals(new Integer(fit), new Integer(-23720));
    }
}
