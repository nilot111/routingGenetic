/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author GUERRA
 */
public class Genetico {
    private int maxPoblacion = 200; // maximo numero de soluciones posibles
    private int maxGeneraciones=4; // maxiteraciones
    private double probMutacion=0.01;
    private int consumoBase=20;
    private int consumoLleno=25;
    private int capvehiculo=10;
    private int numVehiculos=3;
    private int maxUsosAlmacen=3;
    private int nclientes=0;
    public ArrayList<Cromosoma> poblacion= new ArrayList<>();
    public ArrayList<Cliente> almacenes = new ArrayList<>();
    public ArrayList<Cliente> nodos; // aqui se incluyen tanto clientes como Almacenes
    public Cliente terminal= new Cliente(0,0,0); // terminal de buses donde todos parten y vuelven
    Genetico(){
        almacenes.add(new Cliente(10,10,0));
        almacenes.add(new Cliente(25,10,0));
        almacenes.add(new Cliente(50,10,0));
        
        
    }
    public void inicializarNodos(ArrayList<Cliente> clientes){
        nodos=new ArrayList<>(clientes);
        int nroAlmacen=0;
        for(int i=1;i<=almacenes.size()*maxUsosAlmacen;i++){ //inicializamos nodos con clientes y almacenes
            nodos.add(almacenes.get(nroAlmacen));
            if(i%maxUsosAlmacen==0) nroAlmacen++;
        }        
    }
    public void ejecutar(ArrayList<Cliente> clientes){
        nclientes=clientes.size();
        inicializarNodos(clientes); // se juntan tanto clientes como depositos
        inicializarPoblacion();
        ArrayList<Cromosoma> poblacionNueva= new ArrayList<>(poblacion);
      
        for(int i=0;i<maxGeneraciones;i++){
            double fitnessPromedio=evaluar(poblacionNueva);
            System.out.println("fitness promedio generacion "+i+" : "+fitnessPromedio);
            reproduccion(poblacionNueva,fitnessPromedio);
        }
    }
    
    public void reproduccion(ArrayList<Cromosoma> poblacion,double fitnessPromedio){
        int fitnessTotal=(int) Math.round(fitnessPromedio*poblacion.size());
        //System.out.println(fitnessTotal);
        ArrayList<Cromosoma> offspring= new ArrayList<>();
        for(Cromosoma solucion :poblacion){
            boolean abominacion=true;
            Cromosoma hijo=null;
            int n=0;
            while(abominacion) { // seguir haciendo crossover hasta obtener una solución factible
                Random semilla = new Random(); // seleccionar padre
                Random semilla2 = new Random();// seleccionar madre
                int pospadre=semilla.nextInt(fitnessTotal);
                int posmadre=semilla2.nextInt(fitnessTotal);
                //System.out.println(pospadre);
                int encPadre=0,encMadre=0,sumafit=0; // simulamos ruleta de selecciones de padres
                while(sumafit<=pospadre){
                    sumafit+=poblacion.get(encPadre++).fitness;
                }
                sumafit=0;
                while(sumafit<=posmadre){
                    sumafit+=poblacion.get(encMadre++).fitness;
                }         
                encPadre--;
                encMadre--;
                Cromosoma padre=poblacion.get(encPadre);
                Cromosoma madre=poblacion.get(encMadre);                
                hijo= crossover(padre,madre);
                //hijo.print();
                abominacion=verificar(hijo);
                //System.out.println("intento "+n);
                n++;
            }
            if(Math.random()<=probMutacion) mutacion(hijo); // solo si da dentro de la probabilidad de mutar, muta
            offspring.add(hijo);
        }
        //copiar nueva  generacion a poblacion
        for(int i=0;i<offspring.size();i++){
            poblacion.set(i, offspring.get(i));
        }
    }
    
    public void mutacion(Cromosoma hijo){
        Random clientRandom1 = new Random();
        Random clientRandom2 = new Random();
        int clien1 = clientRandom1.nextInt(nodos.size());
        int clien2 = clientRandom2.nextInt(nodos.size());
        if(hijo.genes.get(clien1)<nclientes && hijo.genes.get(clien2)<nclientes){
            int auxclien1=hijo.genes.get(clien1);
            int auxclien2=hijo.genes.get(clien2);
            hijo.genes.set(clien1,auxclien2 ); // hacemos intercambio
            hijo.genes.set(clien2, auxclien1);
            if(!verificar(hijo)){ // si es abominacion se revierte la mutacion
                hijo.genes.set(clien1, auxclien1); // hacemos intercambio
                hijo.genes.set(clien2, auxclien2);                
            }
        }
    }
    public Cromosoma crossover(Cromosoma padre, Cromosoma madre){
        Cromosoma hijo=new Cromosoma(madre); // inicializo con la madre
        int numNodos=nodos.size();
        int posIni = (int) (Math.random() * numNodos);
        int aux=posIni;
        int posFin = (int) (Math.random() * numNodos);
        if(posIni>posFin){
            posIni=posFin;
            posFin=aux;
        }
        
        for(int i=0;i<numNodos;i++){
            if(i<posIni || i>posFin) {
                hijo.genes.set(i,padre.genes.get(i));
            } //hereda del padre
        }

        return hijo;
    }
    
    public double evaluar(ArrayList<Cromosoma> poblacion){
        int fitnessTotal=0;
        double costoMax=0;
        for (Cromosoma solucion : poblacion) { // considerando solo un tipo de producto
            ArrayList<Integer> solucionPura=limpiarCromosoma(solucion); // quitar almacenes no usados de la solucion
            double costo=costoSolucion(solucionPura);
            if(costo>costoMax) costoMax=costo;
            solucion.fitness=costo;
        }
        for(Cromosoma solucion : poblacion) {
            solucion.fitness=costoMax-solucion.fitness; // debido a que se escogera según su fitness , invertimos costo
            fitnessTotal+=solucion.fitness;
        }
        //System.out.println(fitnessTotal);
        return fitnessTotal/poblacion.size();
    }
    public double costoSolucion(ArrayList<Integer> solucionPura){
        double costo=0;
        int carga=0;
        boolean sigAlmacen=true; // si en caso el siguiente nodo es un almacen inicializar viajes
        for(int i=solucionPura.size()-1;i>=0;i--){ // leo al reves porque es más facil calcular la carga asi
            int idcliente=solucionPura.get(i);
            if(sigAlmacen){ //  si es el ultimo o el siguiente nodo es un almacen agregar costo 
                costo+=dist(nodos.get(idcliente),terminal)*consumoBase; // desde terminal
                carga=0;
                sigAlmacen=false;
            }
            else { // caso Cliente o almacen
                int idClientePosterior=solucionPura.get(i+1);
                carga+=nodos.get(idClientePosterior).getDemanda(); // voy acumulando las cargas
                costo+=dist(nodos.get(idcliente),nodos.get(idClientePosterior))*
                        (consumoBase+(consumoLleno-consumoBase)*carga/capvehiculo);
                if(idcliente>=nclientes) { // si estoy en un almacen , considerar viaje a terminal
                    costo+=dist(nodos.get(idcliente),terminal)*consumoBase;
                    sigAlmacen=true; 
                }
            }
        }
        return costo;
    }
    public double dist(Cliente nodo1, Cliente nodo2){
        return Math.sqrt(Math.pow((nodo1.getCoordenadaX()-nodo2.getCoordenadaX()), 2)
                + Math.pow((nodo1.getCoordenadaY()-nodo2.getCoordenadaY()), 2));
    }
    public ArrayList<Integer> limpiarCromosoma(Cromosoma sol){
        ArrayList<Integer> limpio= new ArrayList<>();
        int tamArreglo=sol.genes.size();
        for(int i=1;i<tamArreglo;i++){
            if(sol.genes.get(i-1)>=nclientes && sol.genes.get(i)>=nclientes) continue; // no se consideraran almacenes contiguos, en caso de este solo se considerará el ultimo
            limpio.add(sol.genes.get(i-1)); // solo se consideran clientes y almacenes anteriores a clientes
        }
        if(sol.genes.get(tamArreglo-1)<nclientes) limpio.add(sol.genes.get(tamArreglo-1)); // si el ultimo es cliente se agrega
        return limpio;
    }
    public void inicializarPoblacion (){
        Cromosoma origen= new Cromosoma();
        int tamCrom=nodos.size();
        for(int j=0;j<tamCrom;j++) origen.genes.add(j);
        for(int j=0;j<maxPoblacion;j++){// generar maxpoblacion soluciones
            boolean factible=false;
            while(!factible){ 
                Collections.shuffle(origen.genes); // generar solución aleatoria
                factible=verificar(origen); //verificar si es factible
            }
            Cromosoma nuevaSolucion=new Cromosoma(origen);
            poblacion.add(nuevaSolucion); // agregamos solución a la poblacion
//            ArrayList<Integer> limpio=limpiarCromosoma(origen);
//            origen.print();
//            for(int i=0;i<limpio.size();i++)
//                System.out.print(limpio.get(i)+"-");
//            System.out.println();
//            System.out.println(costoSolucion(limpio));
            //origen.print();
        }        
    }
    public boolean verificar(Cromosoma solucion){
        ArrayList<Integer> genes=solucion.genes;
        if(genes.get(0)<nclientes) return false; // si comienza por cliente no va
        else{
            int i=1;
            while(i<genes.size()){ // mientras recorra todo el arreglo
                while(i<genes.size() && genes.get(i)>=nclientes ) i++; // Avanzar hasta encontrar un cliente o terminar arreglo
                int carga=0; // Inicializar carga cuando haya un almacen
                if(i>=genes.size()) continue;
                while(i<genes.size() && genes.get(i)<nclientes ){ // mientras sean clientes aumentar carga
                    carga+=nodos.get(genes.get(i)).getDemanda();
                    i++;
                    if(carga>capvehiculo) return false;
                }
            }
        }
        return true;
    }
}
