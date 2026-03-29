package model;

import java.time.LocalDate;

public class Devolucion {
    private String codigoDevolucion;
    private String codigoProducto;
    private String nombreCliente;
    private String motivo;
    private LocalDate fechaCompra;
    private LocalDate fechaDevolucion;

    public Devolucion(String codigoDevolucion, String codigoProducto, String nombreCliente, String motivo, LocalDate fechaCompra, LocalDate fechaDevolucion) {
        this.codigoDevolucion = codigoDevolucion;
        this.codigoProducto = codigoProducto;
        this.nombreCliente = nombreCliente;
        this.motivo = motivo;
        this.fechaCompra = fechaCompra;
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getCodigoDevolucion() {
        return codigoDevolucion;
    }

    public void setCodigoDevolucion(String codigoDevolucion) {
        this.codigoDevolucion = codigoDevolucion;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
}
