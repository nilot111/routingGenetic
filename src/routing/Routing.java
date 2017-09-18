/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routing;

import java.util.ArrayList;
import javax.swing.JFrame;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author GUERRA
 */
public class Routing {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Cliente> clientes= new ArrayList<>();   
        clientes.add(new Cliente(63,53,1)); // cliente 0
        clientes.add(new Cliente(32,2,3)); // cliente 1
        clientes.add(new Cliente(38,99,4)); // cliente 2
        clientes.add(new Cliente(1,26,4)); // cliente 3
        clientes.add(new Cliente(66,63,4)); // cliente 4
        clientes.add(new Cliente(6,12,2)); // cliente 5
        clientes.add(new Cliente(40,48,2)); // cliente 6
        clientes.add(new Cliente(15,2,5)); // cliente 7
        clientes.add(new Cliente(88,91,1)); // cliente 8
        clientes.add(new Cliente(86,31,1)); // cliente 9
        ArrayList<Cliente> almacenes = new ArrayList<>();
        almacenes.add(new Cliente(0,0,0));  // el primer almacen será la terminal
        almacenes.add(new Cliente(10,10,0));
        almacenes.add(new Cliente(25,10,0));
        almacenes.add(new Cliente(50,10,0));
        //clientes.get(0).print();
//        Genetico genAlgoritmo= new Genetico();
//        Memetico memAlgoritmo= new Memetico();
//        Cromosoma mejor1=genAlgoritmo.ejecutar(clientes);
//        Cromosoma mejor2=memAlgoritmo.ejecutar(clientes);
//        JFrame ventana=new JFrame("Rutas de pedidos");
//        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        RoutingInterface panel = new RoutingInterface();
//        ventana.add(panel);
//        ventana.setSize(1300,700);
//        ventana.setVisible(true);
//        int nclientes=genAlgoritmo.nclientes;
//        ArrayList<Cliente> nodos= genAlgoritmo.nodos;
//        XYSeriesCollection dataset = new XYSeriesCollection();
        
        
    }

}
