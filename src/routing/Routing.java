/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routing;

import java.awt.BasicStroke;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
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
                //Informacion
 
                XYSeries carro = new XYSeries("Automovil");
                carro.add(1.0, 1.0);
                carro.add(2.0, 4.0);
                carro.add(3.0, 3.0);
 
                XYSeries bici = new XYSeries("Bicicleta");
                bici.add(1.0, 4.0);
                bici.add(2.0, 5.0);
                bici.add(3.0, 6.0);
 
                XYSeries moto = new XYSeries("Motocicleta");
                moto.add(3.0, 4.0);
                moto.add(4.0, 5.0);
                moto.add(5.0, 4.0);
 
                XYSeriesCollection dataset = new XYSeriesCollection();
                dataset.addSeries(carro);
                dataset.addSeries(bici);
                dataset.addSeries(moto);
 
                JFreeChart xylineChart = ChartFactory.createXYLineChart(
                                "Grafica XY",
                                "Transporte",
                                "Putuacion",
                                dataset,
                                PlotOrientation.VERTICAL, true, true, false);
 
               
                XYPlot plot = xylineChart.getXYPlot();
               
                XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
               
                renderer.setSeriesPaint(0, Color.RED);
                renderer.setSeriesPaint(1, Color.GREEN);
                renderer.setSeriesPaint(2, Color.YELLOW);
                renderer.setSeriesStroke(0, new BasicStroke(4.0f));
                renderer.setSeriesStroke(1, new BasicStroke(3.0f));
                renderer.setSeriesStroke(2, new BasicStroke(2.0f));
                plot.setRenderer(renderer);
               
                ChartPanel panel = new ChartPanel(xylineChart);
 
                // Creamos la ventana
                JFrame ventana = new JFrame("Grafica");
                ventana.setVisible(true);
                ventana.setSize(800, 600);
                ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
                ventana.add(panel);
         
        
    }

}
