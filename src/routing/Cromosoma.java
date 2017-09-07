/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routing;

import java.util.ArrayList;

/**
 *
 * @author GUERRA
 */
public class Cromosoma {
    public ArrayList<Integer> genes ;
    public double fitness;
    
    public void print(){
        for(int i=0;i<genes.size();i++)
            System.out.print(genes.get(i)+"-");
        System.out.println();
    }
    Cromosoma(){
        this.genes= new ArrayList<>();
        this.fitness=0;
    }
    Cromosoma(Cromosoma copia){
        this.genes=new ArrayList<>(copia.genes);
        this.fitness=copia.fitness;
    }

}
