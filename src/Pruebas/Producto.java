/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

/**
 *
 * @author Juan Pablo
 */
public class Producto {
    private String nombre;
    private String categoria;
    private float precio_compra;
    private float precio_venta;
    private int codigo_serial;
    private String proveedor;
    private String fecha_vencimiento;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(float precio_compra) {
        this.precio_compra = precio_compra;
    }

    public float getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(float precio_venta) {
        this.precio_venta = precio_venta;
    }

    public int getCodigo_serial() {
        return codigo_serial;
    }

    public void setCodigo_serial(int codigo_serial) {
        this.codigo_serial = codigo_serial;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(String fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public Producto(String nombre, String categoria, float precio_compra, 
            float precio_venta, int codigo_serial, String proveedor, String fecha_vencimiento) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
        this.codigo_serial = codigo_serial;
        this.proveedor = proveedor;
        this.fecha_vencimiento = fecha_vencimiento;
    }

    @Override
    public String toString() {
        return "Producto {" + "nombre = " + nombre + ", categoria = " + categoria + 
                ", precio_compra = " + precio_compra + ", precio_venta = " + precio_venta
                + ", codigo_serial = " + codigo_serial + ", proveedor = " + proveedor +
                ", fecha_vencimiento = " + fecha_vencimiento + '}';
    }
}