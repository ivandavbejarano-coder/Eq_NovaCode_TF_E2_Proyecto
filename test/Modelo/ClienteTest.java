/*
 * Casos de prueba unitaria - Cliente
 * Equipo: Stackz
 */
package Modelo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas unitarias para la clase Cliente.
 * @author Equipo Stackz
 */
public class ClienteTest {

    private Cliente clientePersona;
    private Cliente clienteEmpresa;

    @BeforeAll
    public static void setUpClass() {
        System.out.println("=== Inicio de pruebas: ClienteTest ===");
    }

    @AfterAll
    public static void tearDownClass() {
        System.out.println("=== Fin de pruebas: ClienteTest ===");
    }

    @BeforeEach
    public void setUp() {
        clientePersona = new Cliente('C', "1234567890", false,
                "Juan Pérez", "juan@email.com", "3001234567",
                "María Pérez", 10.0);
        clienteEmpresa = new Cliente('N', "900123456", true,
                "Viajes SA", "info@viajessa.com", "6012345678",
                "Carlos Gómez", 15.0);
    }

    @AfterEach
    public void tearDown() {
        clientePersona = null;
        clienteEmpresa = null;
    }

    // CP-C01
    @Test
    public void testGetNombre_PersonaNatural() {
        assertEquals("Juan Pérez", clientePersona.getNombre(),
                "El nombre del cliente persona no coincide.");
    }

    // CP-C02
    @Test
    public void testGetNombre_Empresa() {
        assertEquals("Viajes SA", clienteEmpresa.getNombre(),
                "El nombre del cliente empresa no coincide.");
    }

    // CP-C03
    @Test
    public void testGetTipoIdentificacion_Cedula() {
        assertEquals('C', clientePersona.getTipoIdentificacion(),
                "El tipo de identificación debe ser 'C' (Cédula).");
    }

    // CP-C04
    @Test
    public void testGetTipoIdentificacion_NIT() {
        assertEquals('N', clienteEmpresa.getTipoIdentificacion(),
                "El tipo de identificación debe ser 'N' (NIT).");
    }

    // CP-C05
    @Test
    public void testGetNumeroIdentificacion() {
        assertEquals("1234567890", clientePersona.getNumeroIdentificacion(),
                "El número de identificación no coincide.");
    }

    // CP-C06
    @Test
    public void testIsEmpresa_PersonaNatural_DebeSerFalse() {
        assertFalse(clientePersona.isEmpresa(),
                "Una persona natural no debe marcarse como empresa.");
    }

    // CP-C07
    @Test
    public void testIsEmpresa_Empresa_DebeSerTrue() {
        assertTrue(clienteEmpresa.isEmpresa(),
                "Un cliente empresa debe marcarse como empresa.");
    }

    // CP-C08
    @Test
    public void testGetPorcentajeDescuento_Persona() {
        assertEquals(10.0, clientePersona.getPorcentajeDescuento(), 0.001,
                "El porcentaje de descuento del cliente persona no coincide.");
    }

    // CP-C09
    @Test
    public void testGetPorcentajeDescuento_Empresa() {
        assertEquals(15.0, clienteEmpresa.getPorcentajeDescuento(), 0.001,
                "El porcentaje de descuento del cliente empresa no coincide.");
    }

    // CP-C10
    @Test
    public void testSetNombre_ActualizaCorrectamente() {
        clientePersona.setNombre("Juan Carlos Pérez");
        assertEquals("Juan Carlos Pérez", clientePersona.getNombre(),
                "El nombre no fue actualizado correctamente.");
    }

    // CP-C11
    @Test
    public void testSetPorcentajeDescuento_ActualizaCorrectamente() {
        clientePersona.setPorcentajeDescuento(20.0);
        assertEquals(20.0, clientePersona.getPorcentajeDescuento(), 0.001,
                "El porcentaje de descuento no fue actualizado.");
    }

    // CP-C12
    @Test
    public void testGetEmail() {
        assertEquals("juan@email.com", clientePersona.getEmail(),
                "El email del cliente no coincide.");
    }

    // CP-C13
    @Test
    public void testGetTelefono() {
        assertEquals("3001234567", clientePersona.getTelefono(),
                "El teléfono del cliente no coincide.");
    }

    // CP-C14
    @Test
    public void testGetNombreContacto() {
        assertEquals("María Pérez", clientePersona.getNombreContacto(),
                "El nombre de contacto no coincide.");
    }

    // CP-C15
    @Test
    public void testDescuentoCero_ClienteSinDescuento() {
        Cliente sinDescuento = new Cliente('C', "9999999999", false,
                "Ana López", "ana@email.com", "3109999999", "Contacto", 0.0);
        assertEquals(0.0, sinDescuento.getPorcentajeDescuento(), 0.001,
                "Un cliente sin descuento debe tener 0%.");
    }
}
