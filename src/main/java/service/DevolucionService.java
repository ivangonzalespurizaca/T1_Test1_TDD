package service;

import model.Devolucion;

import java.util.ArrayList;
import java.util.List;

public class DevolucionService {

    // Nuestra "base de datos" en memoria
    private final List<Devolucion> listaDevoluciones = new ArrayList<>();

    public String registrarDevolucion(Devolucion dev) {
        // Validamos y obtenemos el posible mensaje de error
        String error = getValidationError(dev);

        // 2. Si hay error, lo retornamos inmediatamente
        if (error != null) {
            return error;
        }

        // 3. Si todo es correcto, registramos y retornamos éxito
        listaDevoluciones.add(dev);
        return "La devolución ha sido registrada correctamente";
    }

    private String getValidationError(Devolucion dev) {
        if (hasEmptyFields(dev))
            return "Debe ingresar todos los datos requeridos";

        if (!dev.getCodigoDevolucion().matches("^D\\d{4}$"))
            return "Ingrese un código de devolución válido";

        if (!dev.getCodigoProducto().matches("^[a-zA-Z0-9]{6}$"))
            return "Ingrese un código de producto válido";

        if (isClientNameInvalid(dev.getNombreCliente()))
            return "El nombre del cliente debe tener al menos cuatro caracteres alfabéticos";

        if (dev.getMotivo().length() < 10)
            return "El motivo de la devolución debe tener al menos diez caracteres";

        if (dev.getFechaDevolucion().isBefore(dev.getFechaCompra()))
            return "Ingrese una fecha de devolución válida";

        return null; // Todo OK
    }

    private boolean hasEmptyFields(Devolucion dev) {
        return dev.getCodigoDevolucion() == null || dev.getCodigoProducto() == null ||
                dev.getNombreCliente() == null || dev.getMotivo() == null ||
                dev.getFechaCompra() == null || dev.getFechaDevolucion() == null;
    }

    private boolean isClientNameInvalid(String name) {
        return name.length() < 4 || !name.matches("^[a-zA-Z\\s]+$");
    }
}
