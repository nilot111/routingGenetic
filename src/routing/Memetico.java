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
public class Memetico {
    private int maxPoblacion = 200; // maximo numero de soluciones posibles
    private int maxGeneraciones=30; // maxiteraciones
    private double probMutacion=0.01;
    private int consumoBase=20;
    private int consumoLleno=35;
    private int capvehiculo=10;
    private int numVehiculos=3;
    private int maxUsosAlmacen=3;
    private int nclientes=0;
    private int MAXFIT=30000;
    private double porcConvergencia=0.98;
    private double porcPreservacion=0.6;
    private int maxIntentos=5;
    public ArrayList<Cromosoma> poblacion= new ArrayList<>();
    public ArrayList<Cliente> almacenes = new ArrayList<>();
    public ArrayList<Cliente> nodos; // aqui se incluyen tanto clientes como Almacenes
    public Cliente terminal= new Cliente(0,0,0); // terminal de buses donde todos parten y vuelven
    Memetico(){
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
    public Cromosoma ejecutar(ArrayList<Cliente> clientes){
        nclientes=clientes.size();
        inicializarNodos(clientes); // se juntan tanto clientes como depositos
        inicializarPoblacion();
        ArrayList<Cromosoma> poblacionNueva= new ArrayList<>(poblacion);
        double fitnessAnterior=0;
        double fitnessPromedio=0;
        for(int i=0;i<=maxGeneraciones;i++){
            fitnessPromedio=evaluar(poblacionNueva);
            if(i==maxGeneraciones) break;
            if(fitnessAnterior/fitnessPromedio>porcConvergencia){
                reiniciarPoblacion(poblacionNueva);
                fitnessPromedio=evaluar(poblacionNueva);
            }
            //System.out.println("fitness promedio generacion "+i+" : "+fitnessPromedio);
            reproduccion(poblacionNueva,fitnessPromedio);
            fitnessAnterior=fitnessPromedio;
        }
//        Cromosoma prueba=busquedaLocal(poblacion.get(0));
//        imprimeRecorrido(poblacion.get(0));
//        imprimeRecorrido(prueba);
//        System.out.println(poblacion.get(0).fitness);
//        System.out.println(prueba.fitness);
        
//        Cromosoma hijo= crossover(poblacionNueva.get(10),poblacionNueva.get(15));
        Cromosoma mejorSolucion=obtenerMejor(poblacionNueva);
//        mejorSolucion.print();
//        ArrayList<ArrayList<Integer>> arr= obtenerRutas(mejorSolucion);
//        for(int i=0;i<arr.size();i++){
//            for(int j=0;j<arr.get(i).size();j++){
//                System.out.print(arr.get(i).get(j)+"-");
//            }
//            System.out.println();
//        }
//        imprimeRecorrido(poblacionNueva.get(10));
//        imprimeRecorrido(poblacionNueva.get(15));

        imprimeRecorrido(mejorSolucion);
        System.out.println(mejorSolucion.fitness);
        return mejorSolucion;
    }
    
    public void reiniciarPoblacion(ArrayList<Cromosoma> poblacion){
        int nroPreservados=(int) (poblacion.size()*porcPreservacion);
        for(int i=nroPreservados;i<poblacion.size();i++){ // alteramos
            boolean abominacion=true;
            Cromosoma ind=poblacion.get(i);
            while(abominacion){
                Collections.shuffle(ind.genes);
                abominacion=!verificar(ind);
            }
            Cromosoma mejorado=busquedaLocal(ind);
            poblacion.set(i, mejorado);
        }
    }
    public Cromosoma  obtenerMejor(ArrayList<Cromosoma> poblacion){
        double fitMax=0;
        int imax=0;
        for(int i=0;i<poblacion.size();i++){
            if(poblacion.get(i).fitness>fitMax) {
                fitMax=poblacion.get(i).fitness;
                imax=i;
            }
        }
        return poblacion.get(imax);
    }
    public void reproduccion(ArrayList<Cromosoma> poblacion,double fitnessPromedio){
        int fitnessTotal=(int) Math.round(fitnessPromedio*poblacion.size());
        //System.out.println(fitnessTotal);
        ArrayList<Cromosoma> offspring= new ArrayList<>();
        for(Cromosoma solucion :poblacion){
            boolean abominacion=true;
            Cromosoma hijo=new Cromosoma();
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
                
                abominacion=!verificar(hijo);
//                if(!abominacion){ // comprobar que hijo es mejor que padres
//                    if(costoSolucion(hijo.genes)>costoSolucion(padre.genes) &&
//                            costoSolucion(hijo.genes)>costoSolucion(madre.genes))
//                        abominacion=true; // si es peor q padre y madre sigue siendo abominacion
//                }
                //imprimeRecorrido(hijo);
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
        int clien1 = clientRandom1.nextInt(hijo.genes.size());
        int clien2 = clientRandom2.nextInt(hijo.genes.size());
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
        Cromosoma hijo=new Cromosoma(); // inicializo con la madre
        ArrayList<ArrayList<Integer>> rutasPadre= obtenerRutas(padre);
        ArrayList<ArrayList<Integer>> rutasMadre= obtenerRutas(madre);
        Random ran=new Random();
        ArrayList<Integer> rutaRandom=rutasMadre.get(ran.nextInt(rutasMadre.size())); // obtengo ruta random de madre
        ArrayList<Integer> genes=(ArrayList<Integer>)padre.genes.clone();
        for(int i=1;i<rutaRandom.size();i++){ // elimino los clientes
            genes.remove(genes.indexOf(rutaRandom.get(i)));
        }     
        for(int j=1;j<rutaRandom.size();j++){ //inserto evluando costos desde 1 porq 0 es el almacen
            double costoMin=10000000;
            int indMin=0;
            for(int h=1;h<genes.size();h++){ // el primer gen no puede ser un cliente
                genes.add(h,rutaRandom.get(j));
                if(verificarGenes(genes)){ // si es factible
                    double costo=costoSolucion(genes);
                    if(costo<costoMin){
                        costoMin=costo;
                        indMin=h;
                    }
                    
                }
                genes.remove(h);
            }
            genes.add(indMin,rutaRandom.get(j));
        }          
        hijo.genes=(ArrayList<Integer>)genes.clone();
        hijo.genes=limpiarCromosoma(hijo);
        return hijo;
    }
    
    public ArrayList<ArrayList<Integer>> obtenerRutas(Cromosoma sol){
        ArrayList<Integer>solPura=limpiarCromosoma(sol);
        ArrayList<ArrayList<Integer>> rutas= new ArrayList<>();
        int i=1;
        ArrayList<Integer> ruta= new ArrayList<>();
        ruta.add(solPura.get(0));
        while(i<solPura.size()){
            if(solPura.get(i)>=nclientes ) {
                rutas.add(ruta);
                ruta= new ArrayList<>();  
                ruta.add(solPura.get(i));
            }
            else ruta.add(solPura.get(i));
            i++;
        }
        rutas.add(ruta);
        return rutas;
    }
    public double evaluar(ArrayList<Cromosoma> poblacion){
        int fitnessTotal=0;

        for(Cromosoma solucion : poblacion) {
            solucion.fitness=MAXFIT-costoSolucion(solucion.genes); // debido a que se escogera según su fitness , invertimos costo
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
            if(sol.genes.get(i-1)>=nclientes && sol.genes.get(i)>=nclientes) ; // no se consideraran almacenes contiguos, en caso de este solo se considerará el ultimo
            else limpio.add(sol.genes.get(i-1)); // solo se consideran clientes y almacenes anteriores a clientes
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
            ArrayList<Integer> genes= limpiarCromosoma(nuevaSolucion);
            nuevaSolucion.genes=(ArrayList<Integer>)genes.clone();
            Cromosoma optimizada= busquedaLocal(nuevaSolucion);
            poblacion.add(optimizada); // agregamos solución a la poblacion
//            ArrayList<Integer> limpio=limpiarCromosoma(origen);
//            origen.print();
//            for(int i=0;i<limpio.size();i++)
//                System.out.print(limpio.get(i)+"-");
//            System.out.println();
//            System.out.println(costoSolucion(limpio));
            //origen.print();
        }        
    }
    
    public Cromosoma busquedaLocal(Cromosoma individuo){
        Cromosoma mejorado= new Cromosoma(individuo);
        int intentosExt=0;
        double mejorFitness=MAXFIT-costoSolucion(individuo.genes);
        ArrayList<ArrayList<Integer>> rutas=obtenerRutas(individuo);
        ArrayList<Integer> randoms =new ArrayList<>();
        for(int i=0;i<rutas.size();i++) randoms.add(i);
        while(intentosExt<maxIntentos){
            Collections.shuffle(randoms);
            ArrayList<Integer> ruta1=rutas.get(randoms.get(0));
            ArrayList<Integer> ruta2=rutas.get(randoms.get(rutas.size()-1));
            boolean mejora=false;
            int minDemanda1=0,maxDemanda1=0,totalDemanda1=0,minDemanda2=0,maxDemanda2=0,totalDemanda2=0;
            totalDemanda1=demandaRuta(ruta1,minDemanda1,maxDemanda1);
            totalDemanda2=demandaRuta(ruta2,minDemanda2,maxDemanda2);           
            if(minDemanda1-maxDemanda2+totalDemanda2<=capvehiculo && 
                    minDemanda2-maxDemanda1+totalDemanda1<=capvehiculo){
                int intentosInt=0;
                while(intentosInt<maxIntentos){
                    Random rand= new Random();
                    Random rand2= new Random();
                    int indcliente1=individuo.genes.indexOf(ruta1.get(rand.nextInt(ruta1.size()-1)+1));// para que no coja el primero(alamcen)
                    int indcliente2=individuo.genes.indexOf(ruta2.get(rand2.nextInt(ruta2.size()-1)+1));// para que no coja el primero(alamcen)
                    Collections.swap(individuo.genes,indcliente1,indcliente2);// intercambiamos
                    double fitness=MAXFIT-costoSolucion(individuo.genes);
                    if(fitness>mejorFitness && verificar(individuo)){
                        mejorFitness=fitness;
                        mejorado.genes=(ArrayList<Integer>)individuo.genes.clone();
                        mejorado.fitness=mejorFitness;
                        intentosInt=0;
                        mejora=true;
                    }
                    else intentosInt++;
                }
            }
            if(mejora) intentosExt=0;
            else intentosExt++;
        }
        return mejorado;
    }
    
    
    public int demandaRuta(ArrayList<Integer> ruta,int minDemanda,int maxDemanda){
        int max=0;
        int min=10000;
        int total=0;
        int carga=0;
        for(int i=0;i<ruta.size();i++){
            if(ruta.get(i)>=nclientes || i==ruta.size()-1){ // si es centro o es el último
                if(carga>max) max=carga;
                if(carga<min) min=carga;
                total+=carga;
                carga=0;
            }
            else carga+=nodos.get(ruta.get(i)).getDemanda();
        }
        minDemanda=min;
        maxDemanda=max;
        return total;
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
    public boolean verificarGenes( ArrayList<Integer> genes){
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
    
    public void imprimeRecorrido(Cromosoma sol){

        for(int i=0;i<sol.genes.size();i++){
            if(sol.genes.get(i)>=nclientes){ // si es un almacen
                if(i>0) System.out.print("->T");// marcar fin de ruta
                int nAlmacen=(sol.genes.get(i)-nclientes)%maxUsosAlmacen; // determinamos el almacen
                System.out.print("//T->A"+nAlmacen);
            }
            else{ // si es cliente
                 System.out.print("->"+sol.genes.get(i));
            }
        }
        System.out.println("->T");
    }
}
