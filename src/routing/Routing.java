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
        //clientes.get(0).print();
        Genetico genAlgoritmo= new Genetico();
        Memetico memAlgoritmo= new Memetico();
        genAlgoritmo.ejecutar(clientes);
        memAlgoritmo.ejecutar(clientes);
    }

}
