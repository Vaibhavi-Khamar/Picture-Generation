package approach_Basic.bean;

import org.junit.Test;


import static org.junit.Assert.*;

/**
 * @author
 * @project GA
 */
public class IndividualTest {
    @Test
    public void test_tophenotype(){
    	int[][] data = new int[32][32];
    	for(int i=0;i<32;i++) {
    		for(int j=0;j<32;j++) {
    			data[i][j]=1;
    		}
    	}
    	data[1][0]=0;
    	data[2][31]=0;	
    	
    	Gene[] chromosome =new Gene[32];
    	int[] gene1=new int[32];
    	int[] gene2=new int[32];
    	int[] gene3=new int[32];
    	for(int i=0;i<32;i++) {
    		gene1[i]=1;
    		gene2[i]=1;
    		gene3[i]=1;
    	}
    	gene2[0]=0;
    	gene3[31]=0;
    	for(int i=0;i<32;i++) {
    		chromosome[i]=new Gene(gene1);
    	}
    	chromosome[1]=new Gene(gene2);
    	chromosome[2]=new Gene(gene3);
    	Individual individual= new Individual(chromosome);

    	assertArrayEquals(individual.getPhenotype(),data);

    }
    
    @Test
    public void tset_calFitness() {
    	Gene[] chromosome =new Gene[32];
    	int[][] target=Target.getTarget();
    	for(int i=0;i<32;i++) {
    		int[] gene = new int[32];
    		for(int j=0;j<32;j++){
    			gene[j]=target[i][j];
    		}
    		chromosome[i]=new Gene(gene);
    	}
    	
    	Individual individual= new Individual(chromosome);
    	
    	assertEquals(individual.getFitness(),32*32*10);
    	
    }
    
    @Test
    public void tset_calFitness2() {
    	Gene[] chromosome =new Gene[32];
    	int[][] target=Target.getTarget();
    	for(int i=0;i<32;i++) {
    		int[] gene = new int[32];
    		for(int j=0;j<32;j++){
    			if(target[i][j]==0)
    			gene[j]=1;
    			else gene[j]=0;
    		}
    		chromosome[i]=new Gene(gene);
    	}
    	
    	Individual individual= new Individual(chromosome);
    	
    	assertEquals(individual.getFitness(),32*32*(-5));
    	
    }
    
    
    

}