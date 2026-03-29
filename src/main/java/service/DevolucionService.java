package service;

import model.Devolucion;

import java.util.ArrayList;
import java.util.List;

public class DevolucionService {

    public String registrarDevolucion(Devolucion dev) {

        // Mínimo para pasar el test de campos nulos
        if (dev.getCodigoDevolucion() == null || dev.getCodigoProducto() == null ||
                dev.getNombreCliente() == null || dev.getMotivo() == null ||
                dev.getFechaCompra() == null || dev.getFechaDevolucion() == null) {
            return "Debe ingresar todos los datos requeridos";
        }

        // Mínimo para pasar el test de código de devolución (D + 4 números)
        if (!dev.getCodigoDevolucion().matches("^D\\d{4}$")) {
            return "Ingrese un código de devolución válido";
        }

        // Mínimo para pasar el test de código de producto (6 alfanuméricos)
        if (!dev.getCodigoProducto().matches("^[a-zA-Z0-9]{6}$")) {
            return "Ingrese un código de producto válido";
        }

        // Mínimo para pasar el test de nombre del cliente
        if (dev.getNombreCliente().length() < 4 || !dev.getNombreCliente().matches("^[a-zA-Z\\s]+$")) {
            return "El nombre del cliente debe tener al menos cuatro caracteres alfabéticos";
        }

        // Mínimo para pasar el test de fechas
        if (dev.getFechaDevolucion().isBefore(dev.getFechaCompra())) {
            return "Ingrese una fecha de devolución válida";
        }

        // Validación del motivo (Mínimo 10 caracteres)
        if (dev.getMotivo().length() < 10) {
            return "El motivo de la devolución debe tener al menos diez caracteres";
        }

        // Si nada de lo anterior falló, el test de éxito pasará con esto:
        return "La devolución ha sido registrada correctamente";
    }
}
