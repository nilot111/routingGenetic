/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package routing;

/**
 *
 * @author GUERRA
 */
public class Cliente {
    private int id;
    private int coordenadaX;
    private int coordenadaY;
    private int demanda;
    //private int tipoProducto;// 0 -> primer almacen, 1->segundo almacen , 2-> tercer almacen
    static int counter=-1;
    Cliente(int coordenadaX,int coordenadaY,int demanda){
        counter++;
        this.id=counter;
        this.coordenadaX=coordenadaX;
        this.coordenadaY=coordenadaY;
        this.demanda=demanda;
        //this.tipoProducto=tipo;
    }
    /**
     * @return the id
     */
    public void print(){
        System.out.println("Cliente "+id+": ("+coordenadaX+","+coordenadaY+") "
        +demanda);
    }
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the coordenadaX
     */
    public int getCoordenadaX() {
        return coordenadaX;
    }

    /**
     * @param coordenadaX the coordenadaX to set
     */
    public void setCoordenadaX(int coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    /**
     * @return the coordenadaY
     */
    public int getCoordenadaY() {
        return coordenadaY;
    }

    /**
     * @param coordenadaY the coordenadaY to set
     */
    public void setCoordenadaY(int coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    /**
     * @return the demanda
     */
    public int getDemanda() {
        return demanda;
    }

    /**
     * @param demanda the demanda to set
     */
    public void setDemanda(int demanda) {
        this.demanda = demanda;
    }
}
