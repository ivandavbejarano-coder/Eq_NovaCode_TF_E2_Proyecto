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
import java.util.ArrayList;

public abstract class PaqueteTuristico implements Serializable {
    protected String  codigo;
    protected String  nombre;          // mínimo 10 chars
    protected String  tipologiaTurismo;
    protected String  descripcion;     // máximo 500 chars
    protected String  origen;
    protected ArrayList<Destino> susDestinos;
    protected boolean hotel        = true;
    protected boolean alimentacion = true;
    protected boolean alimentacionTodo;
    protected boolean vuelo        = true;
    protected boolean asistencia   = false;
    protected int     tarifaDia;      // > 0
    protected int     cantidadUnidades; // >= 1

    public PaqueteTuristico(String codigo, String nombre, String tipologiaTurismo, String descripcion, String origen, ArrayList<Destino> susDestinos, boolean alimentacionTodo, int tarifaDia, int cantidadUnidades) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipologiaTurismo = tipologiaTurismo;
        this.descripcion = descripcion;
        this.origen = origen;
        this.susDestinos = susDestinos;
        this.alimentacionTodo = alimentacionTodo;
        this.tarifaDia = tarifaDia;
        this.cantidadUnidades = cantidadUnidades;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipologiaTurismo() {
        return tipologiaTurismo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getOrigen() {
        return origen;
    }

    public ArrayList<Destino> getSusDestinos() {
        return susDestinos;
    }

    public boolean isHotel() {
        return hotel;
    }

    public boolean isAlimentacion() {
        return alimentacion;
    }

    public boolean isAlimentacionTodo() {
        return alimentacionTodo;
    }

    public boolean isVuelo() {
        return vuelo;
    }

    public boolean isAsistencia() {
        return asistencia;
    }

    public int getTarifaDia() {
        return tarifaDia;
    }

    public int getCantidadUnidades() {
        return cantidadUnidades;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipologiaTurismo(String tipologiaTurismo) {
        this.tipologiaTurismo = tipologiaTurismo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public void setSusDestinos(ArrayList<Destino> susDestinos) {
        this.susDestinos = susDestinos;
    }

    public void setHotel(boolean hotel) {
        this.hotel = hotel;
    }

    public void setAlimentacion(boolean alimentacion) {
        this.alimentacion = alimentacion;
    }

    public void setAlimentacionTodo(boolean alimentacionTodo) {
        this.alimentacionTodo = alimentacionTodo;
    }

    public void setVuelo(boolean vuelo) {
        this.vuelo = vuelo;
    }

    public void setAsistencia(boolean asistencia) {
        this.asistencia = asistencia;
    }

    public void setTarifaDia(int tarifaDia) {
        this.tarifaDia = tarifaDia;
    }

    public void setCantidadUnidades(int cantidadUnidades) {
        this.cantidadUnidades = cantidadUnidades;
    }

    
    @Override
    public String toString() {
        return "PaqueteTuristico{"
                + "codigo=" + codigo 
                + ", nombre=" + nombre 
                + ", tipologiaTurismo=" + tipologiaTurismo 
                + ", descripcion=" + descripcion 
                + ", origen=" + origen 
                + ", susDestinos=" + susDestinos 
                + ", hotel=" + hotel 
                + ", alimentacion=" + alimentacion 
                + ", alimentacionTodo=" + alimentacionTodo 
                + ", vuelo=" + vuelo 
                + ", asistencia=" + asistencia 
                + ", tarifaDia=" + tarifaDia 
                + ", cantidadUnidades=" + cantidadUnidades 
                + '}';
    }

    public int calcularDuracionTotalDias() {
        return susDestinos.stream()
               .mapToInt(Destino::getDiasPermanencia).sum();
    }
    public abstract int calcularValorUnidad();
    public int calcularValorTotal() {
        return calcularValorUnidad() * cantidadUnidades;
    }
}
    
