/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author CARLOS DURAN
 */
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Venta implements Serializable {
    private int    numero;
    private LocalDateTime fechaHoraGeneracion;
    private LocalDateTime fechaHoraActualizacion;
    private Cliente suCliente;
    private ArrayList<PaqueteTuristico> susPaquetesTuristicos;
    private char estado;  // 'A' activa | 'P' pagada | 'C' cancelada

    public Venta(int numero, LocalDateTime fechaHoraGeneracion, LocalDateTime fechaHoraActualizacion, Cliente suCliente, ArrayList<PaqueteTuristico> susPaquetesTuristicos, char estado) {
        this.numero = numero;
        this.fechaHoraGeneracion = fechaHoraGeneracion;
        this.fechaHoraActualizacion = fechaHoraActualizacion;
        this.suCliente = suCliente;
        this.susPaquetesTuristicos = susPaquetesTuristicos;
        this.estado = estado;
    }

    public int getNumero() {
        return numero;
    }

    public LocalDateTime getFechaHoraGeneracion() {
        return fechaHoraGeneracion;
    }

    public LocalDateTime getFechaHoraActualizacion() {
        return fechaHoraActualizacion;
    }

    public Cliente getSuCliente() {
        return suCliente;
    }

    public ArrayList<PaqueteTuristico> getSusPaquetesTuristicos() {
        return susPaquetesTuristicos;
    }

    public char getEstado() {
        return estado;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setFechaHoraGeneracion(LocalDateTime fechaHoraGeneracion) {
        this.fechaHoraGeneracion = fechaHoraGeneracion;
    }

    public void setFechaHoraActualizacion(LocalDateTime fechaHoraActualizacion) {
        this.fechaHoraActualizacion = fechaHoraActualizacion;
    }

    public void setSuCliente(Cliente suCliente) {
        this.suCliente = suCliente;
    }

    public void setSusPaquetesTuristicos(ArrayList<PaqueteTuristico> susPaquetesTuristicos) {
        this.susPaquetesTuristicos = susPaquetesTuristicos;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }   
    public int calcularCantidadTotalUnidadesPaquetes() {
        return susPaquetesTuristicos.stream()
               .mapToInt(PaqueteTuristico::getCantidadUnidades).sum();
    }
    public int calcularValorTotalPaquetes() {
        return susPaquetesTuristicos.stream()
               .mapToInt(PaqueteTuristico::calcularValorTotal).sum();
    }
    public int calcularValorDescuento() {
    return (int)(calcularValorTotalPaquetes() * getSuCliente().getPorcentajeDescuento() / 100);

    }
    public int calcularValorTotalPagar() {
        return calcularValorTotalPaquetes() - calcularValorDescuento();
    }

    @Override
    public String toString() {
        return "Venta{" + "numero=" + numero + ", fechaHoraGeneracion=" + fechaHoraGeneracion + ", fechaHoraActualizacion=" + fechaHoraActualizacion + ", suCliente=" + suCliente + ", susPaquetesTuristicos=" + susPaquetesTuristicos + ", estado=" + estado + '}';
    }
    
    
}