/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * * @author Carlos Duran, Ivan David Bejarano Diaz, Zuri Saday Messu, Michael Steven Reyes
 */
import java.io.Serializable;
import java.util.LinkedList;

public class Destino implements Serializable {
    private String         nombreLugar;
    private int            diasPermanencia;   // mínimo 1
    private LinkedList<String> atractivos;
    private boolean        atractivosIncluidos;

    public Destino(String nombreLugar, int diasPermanencia, LinkedList<String> atractivos, boolean atractivosIncluidos) {
        this.nombreLugar = nombreLugar;
        this.diasPermanencia = diasPermanencia;
        this.atractivos = atractivos;
        this.atractivosIncluidos = atractivosIncluidos;
    }

    public String getNombreLugar() {
        return nombreLugar;
    }

    public int getDiasPermanencia() {
        return diasPermanencia;
    }

    public LinkedList<String> getAtractivos() {
        return atractivos;
    }

    public boolean isAtractivosIncluidos() {
        return atractivosIncluidos;
    }

    public void setNombreLugar(String nombreLugar) {
        this.nombreLugar = nombreLugar;
    }

    public void setDiasPermanencia(int diasPermanencia) {
        this.diasPermanencia = diasPermanencia;
    }

    public void setAtractivos(LinkedList<String> atractivos) {
        this.atractivos = atractivos;
    }

    public void setAtractivosIncluidos(boolean atractivosIncluidos) {
        this.atractivosIncluidos = atractivosIncluidos;
    }

    @Override
    public String toString() {
        return "Destino{" 
                + "nombreLugar=" + nombreLugar 
                + ", diasPermanencia=" + diasPermanencia 
                + ", atractivos=" + atractivos 
                + ", atractivosIncluidos=" + atractivosIncluidos 
                + '}';
    }

    
}
