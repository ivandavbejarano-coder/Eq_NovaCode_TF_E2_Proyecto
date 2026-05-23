/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author * @author Carlos Duran, Ivan David Bejarano Diaz, Zuri Saday Messu, Michael Steven Reyes
 */
public final class PaqueteTuristicoUnico extends PaqueteTuristico {
    private String nombreHotel;
    private String tipoDesayuno;  // opcional (null si alimentación no incluida)

    public PaqueteTuristicoUnico(String nombreHotel, String tipoDesayuno, String codigo, String nombre, String tipologiaTurismo, String descripcion, String origen, ArrayList<Destino> susDestinos, boolean alimentacionTodo, int tarifaDia, int cantidadUnidades) {
        super(codigo, nombre, tipologiaTurismo, descripcion, origen, susDestinos, alimentacionTodo, tarifaDia, cantidadUnidades);
        this.nombreHotel = nombreHotel;
        this.tipoDesayuno = tipoDesayuno;
    }

    public PaqueteTuristicoUnico(String nombreHotel, String codigo, String nombre, String tipologiaTurismo, String descripcion, String origen, ArrayList<Destino> susDestinos, boolean alimentacionTodo, int tarifaDia, int cantidadUnidades) {
        super(codigo, nombre, tipologiaTurismo, descripcion, origen, susDestinos, alimentacionTodo, tarifaDia, cantidadUnidades);
        this.nombreHotel = nombreHotel;
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    public String getTipoDesayuno() {
        return tipoDesayuno;
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

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public void setTipoDesayuno(String tipoDesayuno) {
        this.tipoDesayuno = tipoDesayuno;
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
        return "PaqueteTuristicoUnico{" 
                + "nombreHotel=" + nombreHotel 
                + ", tipoDesayuno=" + tipoDesayuno 
                + '}';
    }
    public int calcularValorUnidad() {
        return tarifaDia * calcularDuracionTotalDias();
            
    }
    }