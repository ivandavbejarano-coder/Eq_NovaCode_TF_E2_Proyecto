/*
 * Casos de prueba unitaria - Venta
 * Equipo: Stackz
 */
package Modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase Venta.
 * @author Equipo Stackz
 */
public class VentaTest {

    private Venta ventaActiva;
    private Venta ventaSinDescuento;
    private Cliente cliente10pct;
    private Cliente clienteSinDescuento;
    private PaqueteTuristicoUnico paquete;

    @BeforeAll
    public static void setUpClass() {
        System.out.println("=== Inicio de pruebas: VentaTest ===");
    }

    @AfterAll
    public static void tearDownClass() {
        System.out.println("=== Fin de pruebas: VentaTest ===");
    }

    @BeforeEach
    public void setUp() {
        // Cliente con 10% de descuento
        cliente10pct = new Cliente('C', "1234567890", false,
                "Juan Pérez", "juan@email.com", "3001234567", "Contacto", 10.0);

        // Cliente sin descuento
        clienteSinDescuento = new Cliente('C', "0987654321", false,
                "Laura Torres", "laura@email.com", "3119999999", "Contacto", 0.0);

        // Paquete: 5 días, $200.000/día, 2 unidades → valorTotal = 200000*5*2 = 2.000.000
        ArrayList<Destino> destinos = new ArrayList<>();
        destinos.add(new Destino("Cartagena", 5, new LinkedList<>(), false));
        paquete = new PaqueteTuristicoUnico(
                "Hotel Caribe", "PKG001", "Paquete Caribe",
                "Sol y Playa", "Desc", "Medellín", destinos, false, 200000, 2);

        ArrayList<PaqueteTuristico> listaPaquetes = new ArrayList<>();
        listaPaquetes.add(paquete);

        LocalDateTime ahora = LocalDateTime.now();

        ventaActiva = new Venta(1, ahora, ahora, cliente10pct, listaPaquetes, 'A');

        ArrayList<PaqueteTuristico> listaPaquetes2 = new ArrayList<>();
        listaPaquetes2.add(paquete);
        ventaSinDescuento = new Venta(2, ahora, ahora, clienteSinDescuento, listaPaquetes2, 'A');
    }

    @AfterEach
    public void tearDown() {
        ventaActiva      = null;
        ventaSinDescuento = null;
    }

    // CP-V01
    @Test
    public void testGetNumero() {
        assertEquals(1, ventaActiva.getNumero(),
                "El número de la venta debe ser 1.");
    }

    // CP-V02
    @Test
    public void testGetEstado_Activa() {
        assertEquals('A', ventaActiva.getEstado(),
                "El estado inicial de la venta debe ser 'A' (Activa).");
    }

    // CP-V03
    @Test
    public void testSetEstado_Pagada() {
        ventaActiva.setEstado('P');
        assertEquals('P', ventaActiva.getEstado(),
                "El estado debe cambiar a 'P' (Pagada).");
    }

    // CP-V04
    @Test
    public void testSetEstado_Cancelada() {
        ventaActiva.setEstado('C');
        assertEquals('C', ventaActiva.getEstado(),
                "El estado debe cambiar a 'C' (Cancelada).");
    }

    // CP-V05
    @Test
    public void testGetSuCliente_NombreCorrecto() {
        assertEquals("Juan Pérez", ventaActiva.getSuCliente().getNombre(),
                "El nombre del cliente de la venta no coincide.");
    }

    // CP-V06
    @Test
    public void testCalcularValorTotalPaquetes() {
        // 200000 * 5 días * 2 unidades = 2.000.000
        assertEquals(2000000, ventaActiva.calcularValorTotalPaquetes(),
                "El valor total de paquetes debe ser $2.000.000.");
    }

    // CP-V07
    @Test
    public void testCalcularValorDescuento_10pct() {
        // 10% de 2.000.000 = 200.000
        assertEquals(200000, ventaActiva.calcularValorDescuento(),
                "El descuento del 10% sobre $2.000.000 debe ser $200.000.");
    }

    // CP-V08
    @Test
    public void testCalcularValorTotalPagar_Con10pct() {
        // 2.000.000 - 200.000 = 1.800.000
        assertEquals(1800000, ventaActiva.calcularValorTotalPagar(),
                "El valor a pagar con 10% de descuento debe ser $1.800.000.");
    }

    // CP-V09
    @Test
    public void testCalcularValorDescuento_SinDescuento() {
        assertEquals(0, ventaSinDescuento.calcularValorDescuento(),
                "Con 0% de descuento, el valor de descuento debe ser $0.");
    }

    // CP-V10
    @Test
    public void testCalcularValorTotalPagar_SinDescuento() {
        assertEquals(2000000, ventaSinDescuento.calcularValorTotalPagar(),
                "Sin descuento, el valor a pagar debe ser igual al valor total: $2.000.000.");
    }

    // CP-V11
    @Test
    public void testCalcularCantidadTotalUnidades() {
        assertEquals(2, ventaActiva.calcularCantidadTotalUnidadesPaquetes(),
                "La cantidad total de unidades debe ser 2.");
    }

    // CP-V12
    @Test
    public void testGetSusPaquetesTuristicos_NoVacia() {
        assertFalse(ventaActiva.getSusPaquetesTuristicos().isEmpty(),
                "La lista de paquetes de la venta no debe estar vacía.");
    }

    // CP-V13
    @Test
    public void testGetSusPaquetesTuristicos_TamanoUno() {
        assertEquals(1, ventaActiva.getSusPaquetesTuristicos().size(),
                "La venta debe tener exactamente 1 paquete.");
    }

    // CP-V14
    @Test
    public void testFechaHoraGeneracion_NoNula() {
        assertNotNull(ventaActiva.getFechaHoraGeneracion(),
                "La fecha/hora de generación no debe ser nula.");
    }

    // CP-V15
    @Test
    public void testSetSuCliente_ActualizaCorrectamente() {
        ventaActiva.setSuCliente(clienteSinDescuento);
        assertEquals("Laura Torres", ventaActiva.getSuCliente().getNombre(),
                "El cliente de la venta no fue actualizado correctamente.");
    }
}
