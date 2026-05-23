/*
 * Casos de prueba unitaria - PaqueteTuristicoUnico
 * Equipo: Stackz
 */
package Modelo;

import java.util.ArrayList;
import java.util.LinkedList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase PaqueteTuristicoUnico.
 * @author Equipo Stackz
 */
public class PaqueteTuristicoUnicoTest {

    private PaqueteTuristicoUnico paquete1dest;
    private PaqueteTuristicoUnico paquete2dest;

    @BeforeAll
    public static void setUpClass() {
        System.out.println("=== Inicio de pruebas: PaqueteTuristicoUnicoTest ===");
    }

    @AfterAll
    public static void tearDownClass() {
        System.out.println("=== Fin de pruebas: PaqueteTuristicoUnicoTest ===");
    }

    @BeforeEach
    public void setUp() {
        // Paquete con 1 destino de 5 días, tarifa $200.000/día, 2 unidades
        ArrayList<Destino> destinos1 = new ArrayList<>();
        destinos1.add(new Destino("Cartagena", 5, new LinkedList<>(), false));

        paquete1dest = new PaqueteTuristicoUnico(
                "Hotel Caribe", "Continental",
                "PKG001", "Paquete Caribe", "Sol y Playa", "Paquete todo incluido",
                "Medellín", destinos1, true, 200000, 2);

        // Paquete con 2 destinos (3 + 4 días), tarifa $150.000/día, 1 unidad
        ArrayList<Destino> destinos2 = new ArrayList<>();
        destinos2.add(new Destino("Bogotá", 3, new LinkedList<>(), false));
        destinos2.add(new Destino("Cali", 4, new LinkedList<>(), false));

        paquete2dest = new PaqueteTuristicoUnico(
                "Hotel Bogotá Plaza",
                "PKG002", "Paquete Capital", "Cultural", "Recorrido ciudades",
                "Medellín", destinos2, false, 150000, 1);
    }

    @AfterEach
    public void tearDown() {
        paquete1dest = null;
        paquete2dest = null;
    }

    // CP-P01
    @Test
    public void testGetNombre() {
        assertEquals("Paquete Caribe", paquete1dest.getNombre(),
                "El nombre del paquete no coincide.");
    }

    // CP-P02
    @Test
    public void testGetOrigen() {
        assertEquals("Medellín", paquete1dest.getOrigen(),
                "El origen del paquete no coincide.");
    }

    // CP-P03
    @Test
    public void testGetNombreHotel() {
        assertEquals("Hotel Caribe", paquete1dest.getNombreHotel(),
                "El nombre del hotel no coincide.");
    }

    // CP-P04
    @Test
    public void testGetTipoDesayuno() {
        assertEquals("Continental", paquete1dest.getTipoDesayuno(),
                "El tipo de desayuno no coincide.");
    }

    // CP-P05
    @Test
    public void testGetTarifaDia() {
        assertEquals(200000, paquete1dest.getTarifaDia(),
                "La tarifa por día no coincide.");
    }

    // CP-P06
    @Test
    public void testGetCantidadUnidades() {
        assertEquals(2, paquete1dest.getCantidadUnidades(),
                "La cantidad de unidades no coincide.");
    }

    // CP-P07
    @Test
    public void testCalcularDuracionTotalDias_UnDestino() {
        assertEquals(5, paquete1dest.calcularDuracionTotalDias(),
                "La duración total con 1 destino de 5 días debe ser 5.");
    }

    // CP-P08
    @Test
    public void testCalcularDuracionTotalDias_DosDestinos() {
        assertEquals(7, paquete2dest.calcularDuracionTotalDias(),
                "La duración total con destinos de 3+4 días debe ser 7.");
    }

    // CP-P09
    @Test
    public void testCalcularValorUnidad_UnDestino() {
        // valorUnidad = tarifaDia * duracionTotalDias = 200000 * 5 = 1.000.000
        assertEquals(1000000, paquete1dest.calcularValorUnidad(),
                "El valor por unidad debe ser tarifa * días = 200000 * 5 = 1.000.000.");
    }

    // CP-P10
    @Test
    public void testCalcularValorUnidad_DosDestinos() {
        // valorUnidad = 150000 * 7 = 1.050.000
        assertEquals(1050000, paquete2dest.calcularValorUnidad(),
                "El valor por unidad debe ser 150000 * 7 = 1.050.000.");
    }

    // CP-P11
    @Test
    public void testCalcularValorTotal_DosUnidades() {
        // valorTotal = valorUnidad * cantidadUnidades = 1.000.000 * 2 = 2.000.000
        assertEquals(2000000, paquete1dest.calcularValorTotal(),
                "El valor total con 2 unidades debe ser 2.000.000.");
    }

    // CP-P12
    @Test
    public void testCalcularValorTotal_UnaUnidad() {
        // valorTotal = 1.050.000 * 1 = 1.050.000
        assertEquals(1050000, paquete2dest.calcularValorTotal(),
                "El valor total con 1 unidad debe ser 1.050.000.");
    }

    // CP-P13
    @Test
    public void testIsAlimentacionTodo_True() {
        assertTrue(paquete1dest.isAlimentacionTodo(),
                "El paquete 1 debe tener alimentación todo incluido.");
    }

    // CP-P14
    @Test
    public void testIsAlimentacionTodo_False() {
        assertFalse(paquete2dest.isAlimentacionTodo(),
                "El paquete 2 no debe tener alimentación todo incluido.");
    }

    // CP-P15
    @Test
    public void testSetNombreHotel_ActualizaCorrectamente() {
        paquete1dest.setNombreHotel("Hotel Nuevo");
        assertEquals("Hotel Nuevo", paquete1dest.getNombreHotel(),
                "El nombre del hotel no fue actualizado.");
    }
}
