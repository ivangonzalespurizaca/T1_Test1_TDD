package service;

import model.Devolucion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DevolucionServiceTest {

    private final DevolucionService service = new DevolucionService();

    @Test
    @DisplayName("Should return error when return code format is invalid (Must be D + 4 digits)")
    void shouldReturnErrorWhenReturnCodeIsInvalid() {

        LocalDate fechaDeCompra = LocalDate.of(2026, 1, 3);

        Devolucion dev = new Devolucion(
                "A1234",// campo inválido
                "PROD12",
                "Juan",
                "El producto presenta fallas",
                fechaDeCompra,
                LocalDate.now());

        assertEquals("Ingrese un código de devolución válido", service.registrarDevolucion(dev));
    }

    @Test
    @DisplayName("Should return error when product code is not exactly 6 alphanumeric characters")
    void shouldReturnErrorWhenProductCodeIsInvalid() {

        LocalDate fechaDeCompra = LocalDate.of(2026, 1, 3);

        Devolucion dev = new Devolucion(
                "D1234",
                "12345", // campo inválido
                "Juan",
                "El producto presenta fallas",
                fechaDeCompra,
                LocalDate.now());

        assertEquals("Ingrese un código de producto válido", service.registrarDevolucion(dev));
    }

    @Test
    @DisplayName("Should return error when client name is shorter than 4 characters or not alphabetic")
    void shouldReturnErrorWhenClientNameIsInvalid() {

        LocalDate fechaDeCompra = LocalDate.of(2026, 1, 3);

        Devolucion dev = new Devolucion(
                "D1234",
                "PROD12",
                "An1", // campo inválido
                "El producto presenta fallas",
                fechaDeCompra,
                LocalDate.now());

        assertEquals("El nombre del cliente debe tener al menos cuatro caracteres alfabéticos", service.registrarDevolucion(dev));
    }

    @Test
    @DisplayName("Should return error when return date is before purchase date")
    void shouldReturnErrorWhenDateIsInvalid() {

        LocalDate fechaDeCompra = LocalDate.of(2026, 4, 12);

        Devolucion dev = new Devolucion(
                "D1234",
                "PROD12",
                "Juan",
                "El producto presenta fallas",
                fechaDeCompra, // campo inválido
                LocalDate.now());

        assertEquals("Ingrese una fecha de devolución válida", service.registrarDevolucion(dev));
    }

    @Test
    @DisplayName("Should return error when any required field is null or empty")
    void shouldReturnErrorWhenFieldsAreEmpty() {

        LocalDate fechaDeCompra = LocalDate.of(2026, 1, 3);

        Devolucion dev = new Devolucion(
                null, // campo inválido
                "PROD12",
                "Juan",
                "El producto presenta fallas",
                fechaDeCompra,
                LocalDate.now()
        );

        assertEquals("Debe ingresar todos los datos requeridos", service.registrarDevolucion(dev));
    }

    @Test
    @DisplayName("Should return success when all data is valid")
    void shouldReturnSuccessWhenAllDataIsValid() {

        LocalDate fechaDeCompra = LocalDate.of(2026, 1, 3);

        // Todos los campos son válidos
        Devolucion dev = new Devolucion(
                "D1234",
                "PROD12",
                "Carlos Perez",
                "El producto presenta fallas",
                fechaDeCompra,
                LocalDate.now()
        );

        assertEquals("La devolución ha sido registrada correctamente", service.registrarDevolucion(dev));
    }
}