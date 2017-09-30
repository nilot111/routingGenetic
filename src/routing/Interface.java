/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routing;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.paint.Color;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.ChartMouseListener;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYPointerAnnotation;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.LegendItemEntity;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author GUERRA
 */
public class Interface extends javax.swing.JFrame {

    /**
     * Creates new form Interface
     */
    public ArrayList<Cliente> clientes= new ArrayList<>();  
    public ArrayList<Cliente> centros = new ArrayList<>();
    public File archClientes= null;
    public File archCentros=null;
    public int nclientes=0;
    public int nCentros=0;
    public int maxusos=10;
    
    public Interface() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        panel_configuración = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        text_clientes = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        consumoBase = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        consumoMax = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        capVehicular = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        porcConvergencia = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        porcPreservacion = new javax.swing.JSpinner();
        jButton3 = new javax.swing.JButton();
        maxPoblacion = new javax.swing.JSpinner();
        porcMutacion = new javax.swing.JSpinner();
        maxGeneraciones = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rutas_gen = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        gen_costo = new javax.swing.JTextField();
        gen_fit = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        rutas_mem = new javax.swing.JTextArea();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        mem_costo = new javax.swing.JTextField();
        mem_fit = new javax.swing.JTextField();
        panel_genetico = new javax.swing.JPanel();
        panel_memetico = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1200, 1200));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_configuración.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Ruta de archivo:");
        panel_configuración.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 29, -1, -1));

        jButton1.setText("Explorar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panel_configuración.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(547, 25, -1, -1));

        text_clientes.setText("C:\\Users\\GUERRA\\Desktop\\Tesis 2\\Data\\test.txt");
        text_clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_clientesActionPerformed(evt);
            }
        });
        panel_configuración.add(text_clientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 26, 437, -1));

        jLabel6.setText("Consumo de combustible base:");
        panel_configuración.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 102, -1, -1));

        consumoBase.setValue(20);
        panel_configuración.add(consumoBase, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 99, 60, -1));

        jLabel7.setText("Consumo de combustible máximo:");
        panel_configuración.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 128, -1, -1));

        consumoMax.setValue(35);
        panel_configuración.add(consumoMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 125, 60, -1));

        jLabel8.setText("Capacidad vehícular:");
        panel_configuración.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 154, -1, -1));

        capVehicular.setValue(80);
        panel_configuración.add(capVehicular, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 151, 60, -1));

        jLabel9.setText("Máxima población:");
        panel_configuración.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 102, -1, -1));

        jLabel10.setText("Máximas generaciones:");
        panel_configuración.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(396, 128, -1, -1));

        jLabel11.setText("Porcentaje de mutación:");
        panel_configuración.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(391, 154, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Configuración del algoritmo memético:");
        panel_configuración.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 177, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Configuración general de los algoritmos:");
        panel_configuración.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 74, -1, -1));

        jLabel3.setText("Porcentaje de convergencia:");
        panel_configuración.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 215, -1, -1));

        porcConvergencia.setValue(100);
        panel_configuración.add(porcConvergencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 212, 63, -1));

        jLabel12.setText("Porcentaje de preservación:");
        panel_configuración.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(372, 215, -1, -1));

        porcPreservacion.setValue(99);
        panel_configuración.add(porcPreservacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(542, 212, 63, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setText("Ejecutar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        panel_configuración.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, 131, 33));

        maxPoblacion.setValue(300);
        panel_configuración.add(maxPoblacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(542, 99, 63, -1));

        porcMutacion.setValue(1);
        panel_configuración.add(porcMutacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(542, 151, 63, -1));

        maxGeneraciones.setValue(30);
        panel_configuración.add(maxGeneraciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(542, 125, 63, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Resultados obtenidos:");
        panel_configuración.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, -1));

        jLabel13.setText("Algoritmo Genético");
        panel_configuración.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, 20));

        jLabel14.setText("Algoritmo Memético");
        panel_configuración.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, -1, 20));

        jLabel15.setText("Rutas:");
        panel_configuración.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, 20));

        rutas_gen.setColumns(20);
        rutas_gen.setRows(5);
        jScrollPane1.setViewportView(rutas_gen);

        panel_configuración.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 270, 90));

        jLabel16.setText("Costo:");
        panel_configuración.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, -1, -1));

        jLabel17.setText("Fitness:");
        panel_configuración.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 490, -1, -1));
        panel_configuración.add(gen_costo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 460, 113, -1));
        panel_configuración.add(gen_fit, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 490, 113, -1));

        jLabel18.setText("Rutas:");
        panel_configuración.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 340, -1, 20));

        rutas_mem.setColumns(20);
        rutas_mem.setRows(5);
        jScrollPane2.setViewportView(rutas_mem);

        panel_configuración.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 360, 250, 90));

        jLabel19.setText("Costo:");
        panel_configuración.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 460, -1, -1));

        jLabel20.setText("Fitness:");
        panel_configuración.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 490, -1, -1));
        panel_configuración.add(mem_costo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 460, 113, -1));
        panel_configuración.add(mem_fit, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 490, 113, -1));

        jTabbedPane1.addTab("Configuración y resultados", panel_configuración);

        javax.swing.GroupLayout panel_geneticoLayout = new javax.swing.GroupLayout(panel_genetico);
        panel_genetico.setLayout(panel_geneticoLayout);
        panel_geneticoLayout.setHorizontalGroup(
            panel_geneticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );
        panel_geneticoLayout.setVerticalGroup(
            panel_geneticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 532, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Algoritmo Genético", panel_genetico);

        javax.swing.GroupLayout panel_memeticoLayout = new javax.swing.GroupLayout(panel_memetico);
        panel_memetico.setLayout(panel_memeticoLayout);
        panel_memeticoLayout.setHorizontalGroup(
            panel_memeticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );
        panel_memeticoLayout.setVerticalGroup(
            panel_memeticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 532, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Algoritmo Memético", panel_memetico);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        leerArchivo();
        int maxp=(int)maxPoblacion.getValue();
        int maxg=(int)maxGeneraciones.getValue();
        int capV=(int)capVehicular.getValue();
        int consumoB=(int)consumoBase.getValue();
        int consumoM=(int)consumoMax.getValue();
        int probMut=(int)porcMutacion.getValue();

        Genetico genAlgoritmo= new Genetico(clientes,centros,maxp,maxg,probMut
                ,consumoB,consumoM,capV);        
        Cromosoma mejor1=genAlgoritmo.ejecutarMulti();
        
//        int porcCon=(int)porcConvergencia.getValue();
//        int porcPre=(int)porcPreservacion.getValue();
//        Memetico memAlgoritmo= new Memetico(clientes,centros,maxp,maxg,probMut
//                ,consumoB,consumoM,capV,porcCon,porcPre);
//        Cromosoma mejor2=memAlgoritmo.ejecutar();
        graficarSolucionesMulti(mejor1,0);
//        graficarSoluciones(mejor2,1);
        mostrarResultadosMulti(mejor1,0);
//        mostrarResultados(mejor2,1);
    }//GEN-LAST:event_jButton3ActionPerformed
    
    public void mostrarResultados(Cromosoma sol,int numAlgoritmo){
        int indRuta=1;
        JTextArea textArea=rutas_gen;
        JTextField textCost=gen_costo;
        JTextField textFit=gen_fit;
        if(numAlgoritmo==1)  {
            textArea=rutas_mem;
            textCost=mem_costo;
            textFit=mem_fit;
        }
        for(int i=0;i<sol.genes.size();i++){
            if(sol.genes.get(i)>=nclientes){ // si es un almacen
                if(i>0) {
                    textArea.append("->T\n");
                    indRuta++;
                }// marcar fin de ruta
                
                int nAlmacen=(sol.genes.get(i)-nclientes-1)/maxusos; // determinamos el almacen
                
                textArea.append("Ruta "+indRuta+":T->A"+nAlmacen);
            }
            else{ // si es cliente
                 textArea.append("->"+sol.genes.get(i));
            }
        }
        textArea.append("->T");
        int costoT=(int)sol.costo;
        int fitT=(int)sol.fitness;
        textCost.setText(""+costoT);
        textFit.setText(""+fitT);
        
    }
    
    public void mostrarResultadosMulti(Cromosoma sol,int numAlgoritmo){
        int indRuta=1;
        JTextArea textArea=rutas_gen;
        JTextField textCost=gen_costo;
        JTextField textFit=gen_fit;
        if(numAlgoritmo==1)  {
            textArea=rutas_mem;
            textCost=mem_costo;
            textFit=mem_fit;
        }
        int h=0;
        while(h<sol.genes.size()){
            textArea.append("Ruta "+indRuta+":T->");
            while(h<sol.genes.size() && sol.genes.get(h)>=nclientes){ // mientras sea un centro
                int ncentro=sol.genes.get(h)-nclientes;
                textArea.append("C"+ncentro+"->");
                h++;
            }
            while(h<sol.genes.size()&& sol.genes.get(h)<nclientes){// mientras sea un cliente
                textArea.append(sol.genes.get(h)+"->");
                h++;
            }
            textArea.append("T\n");
            indRuta++;            
        }
        int costoT=(int)sol.costo;
        int fitT=(int)sol.fitness;
        textCost.setText(""+costoT);
        textFit.setText(""+fitT);
        
    }
    public void graficarSolucionesMulti(Cromosoma gen, int algoritmo){
        XYSeriesCollection solGenSeries = new XYSeriesCollection();
        int indRuta=1;
        XYSeries ruta=null;
        int h=0;
        while(h<gen.genes.size()){
            ruta = new XYSeries("ruta "+indRuta,false);
            while(h<gen.genes.size() && gen.genes.get(h)>=nclientes){ // mientras sea un centro
                int ncentro=gen.genes.get(h)-nclientes;
                ruta.add(centros.get(ncentro).getCoordenadaX()
                         , centros.get(ncentro).getCoordenadaY());                
                h++;
            }
            while(h<gen.genes.size()&& gen.genes.get(h)<nclientes){// mientras sea un cliente
                ruta.add(clientes.get(gen.genes.get(h)).getCoordenadaX()
                         ,clientes.get(gen.genes.get(h)).getCoordenadaY());                
                h++;
            }
            solGenSeries.addSeries(ruta);
            indRuta++;            
        }
        
        String nombre="Grafica del Genético";
        if(algoritmo==1) nombre="Grafica del Memético";
        JFreeChart xylineChartGen = ChartFactory.createXYLineChart(
                        nombre,
                        "Eje x",
                        "Eje y",
                        solGenSeries,
                        PlotOrientation.VERTICAL, true, true, false);
        XYPlot plotGen = xylineChartGen.getXYPlot();
        for(int i=0;i<centros.size();i++){
                XYPointerAnnotation pointer = new XYPointerAnnotation("Centro "+i,
                        centros.get(i).getCoordenadaX(), centros.get(i).getCoordenadaY(),
                                                              6.0 * Math.PI / 4.0);
                plotGen.addAnnotation(pointer);            
        }
        for(int i=0;i<clientes.size();i++){
            XYTextAnnotation texCliente = new XYTextAnnotation(""+i,
                    clientes.get(i).getCoordenadaX(), clientes.get(i).getCoordenadaY());
            plotGen.addAnnotation(texCliente);
        }
        XYLineAndShapeRenderer rendererGen = new XYLineAndShapeRenderer();
        for(int i=0;i<solGenSeries.getSeries().size();i++){ // pintamos
            rendererGen.setSeriesPaint(i, new java.awt.Color((float)Math.random() //color aleatorio
                    , (float)Math.random(), (float)Math.random()));
//            rendererGen.setSeriesPaint(i,java.awt.Color.RED);
            rendererGen.setSeriesStroke(i, new BasicStroke(1.0f));
        }
        
        plotGen.setRenderer(rendererGen);
        plotGen.getRenderer().setSeriesVisible(0,false);
        ChartPanel panelGen = new ChartPanel(xylineChartGen);
        panelGen.setPreferredSize(new Dimension(630, 520)); // ajusto tamaño
        panelGen.setMouseWheelEnabled(true);
        if(algoritmo==0){
            panel_genetico.setLayout(new BorderLayout());
            panel_genetico.add(panelGen, BorderLayout.NORTH);         
        }
        else{
            panel_memetico.setLayout(new BorderLayout());
            panel_memetico.add(panelGen, BorderLayout.NORTH);             
        }
        pack();
        
    }
    
    public void graficarSoluciones(Cromosoma gen, int algoritmo){
        XYSeriesCollection solGenSeries = new XYSeriesCollection();
        int numRuta=1;
        XYSeries ruta=null;
        for(int i=0;i<gen.genes.size();i++){
            if(gen.genes.get(i)>=nclientes){ // si es un almacen
                //if(i>0) System.out.print("->T");// marcar fin de ruta
                int nAlmacen=(gen.genes.get(i)-nclientes-1)/maxusos; // determinamos el almacen
                if(ruta!=null) solGenSeries.addSeries(ruta);
                 ruta = new XYSeries("ruta "+numRuta,false);
                 
                 ruta.add(centros.get(nAlmacen).getCoordenadaX()
                         , centros.get(nAlmacen).getCoordenadaY());
                 numRuta++;
            }
            else{ // si es cliente
                 ruta.add(clientes.get(gen.genes.get(i)).getCoordenadaX()
                         ,clientes.get(gen.genes.get(i)).getCoordenadaY());
            }
            if(i==(gen.genes.size()-1)) solGenSeries.addSeries(ruta);
        }
        String nombre="Grafica del Genético";
        if(algoritmo==1) nombre="Grafica del Memético";
        JFreeChart xylineChartGen = ChartFactory.createXYLineChart(
                        nombre,
                        "Eje x",
                        "Eje y",
                        solGenSeries,
                        PlotOrientation.VERTICAL, true, true, false);
        XYPlot plotGen = xylineChartGen.getXYPlot();
        for(int i=0;i<centros.size();i++){
                XYPointerAnnotation pointer = new XYPointerAnnotation("Centro "+i,
                        centros.get(i).getCoordenadaX(), centros.get(i).getCoordenadaY(),
                                                              6.0 * Math.PI / 4.0);
                plotGen.addAnnotation(pointer);            
        }
        System.out.println(clientes.size());
        for(int i=0;i<clientes.size();i++){
            XYTextAnnotation texCliente = new XYTextAnnotation(""+i,
                    clientes.get(i).getCoordenadaX(), clientes.get(i).getCoordenadaY());
            plotGen.addAnnotation(texCliente);
        }
        XYLineAndShapeRenderer rendererGen = new XYLineAndShapeRenderer();
        for(int i=0;i<solGenSeries.getSeries().size();i++){ // pintamos
            rendererGen.setSeriesPaint(i, new java.awt.Color((float)Math.random() //color aleatorio
                    , (float)Math.random(), (float)Math.random()));
//            rendererGen.setSeriesPaint(i,java.awt.Color.RED);
            rendererGen.setSeriesStroke(i, new BasicStroke(1.0f));
        }
        
        plotGen.setRenderer(rendererGen);
        ChartPanel panelGen = new ChartPanel(xylineChartGen);
        
        panelGen.setPreferredSize(new Dimension(630, 520)); // ajusto tamaño
        panelGen.setMouseWheelEnabled(true);
        if(algoritmo==0){
            panel_genetico.setLayout(new BorderLayout());
            panel_genetico.add(panelGen, BorderLayout.NORTH);         
        }
        else{
            panel_memetico.setLayout(new BorderLayout());
            panel_memetico.add(panelGen, BorderLayout.NORTH);             
        }
        pack();
    }
    public void leerArchivo(){
        int n=0;
        try (Scanner scanner = new Scanner(new FileReader(text_clientes.getText()))) {
            while (scanner.hasNext()&& n<=(3+2*nCentros)) {
                if (scanner.hasNextInt() ) {
                    if(n==2) nclientes=scanner.nextInt();
                    else if(n==3) nCentros=scanner.nextInt();
                    else scanner.nextInt();
                } else {                   
                    scanner.next();
                }
                n++;
            }
            n=0;
            int coordX=0,coordY=0,demanda=0,codExt=0,tipoCentro=0;
            while(scanner.hasNext()){
                if (scanner.hasNextInt()){
                    if(n==0) codExt=scanner.nextInt();
                    else if(n==1) coordX=scanner.nextInt();
                    else if(n==2) coordY=scanner.nextInt();
                    else if(n==4) {
                        demanda=scanner.nextInt();
                        if(clientes.size()<nclientes){
                            Random rand = new Random();
                            int tipo=rand.nextInt(nCentros); // asignamos aleatoriamente el tipo
                            clientes.add(new Cliente(codExt,coordX,coordY,demanda,tipo));
                        }                           
                        else {
                            centros.add(new Cliente(codExt,coordX,coordY,demanda,tipoCentro));
                            tipoCentro++;
                        }
                    }
                    else scanner.nextInt();
                }
                else scanner.next();
                n++;
                if(n==5){
                    n=0;
                    scanner.nextLine();
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser= new JFileChooser();
        chooser.showOpenDialog(null);
        archClientes= chooser.getSelectedFile();
        String fileName=archClientes.getAbsolutePath();
        text_clientes.setText(fileName);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void text_clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_clientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_clientesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner capVehicular;
    private javax.swing.JSpinner consumoBase;
    private javax.swing.JSpinner consumoMax;
    private javax.swing.JTextField gen_costo;
    private javax.swing.JTextField gen_fit;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JSpinner maxGeneraciones;
    private javax.swing.JSpinner maxPoblacion;
    private javax.swing.JTextField mem_costo;
    private javax.swing.JTextField mem_fit;
    private javax.swing.JPanel panel_configuración;
    private javax.swing.JPanel panel_genetico;
    private javax.swing.JPanel panel_memetico;
    private javax.swing.JSpinner porcConvergencia;
    private javax.swing.JSpinner porcMutacion;
    private javax.swing.JSpinner porcPreservacion;
    private javax.swing.JTextArea rutas_gen;
    private javax.swing.JTextArea rutas_mem;
    private javax.swing.JTextField text_clientes;
    // End of variables declaration//GEN-END:variables
}
