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
public class Venta_Compra {
    private int Idcompra;
    private int Idventa;
    private String Proveedor;
    private String Cliente;
    private ListaEnlazada productos;
    private float Total;
    private String Fecha;
    private boolean Es_compra;
    
    public static int IdC = 1;
    public static int IdV = 1;

    public void Compra(String proveedor, float Total, String Fecha, ListaEnlazada productos) {
        this.Proveedor = proveedor;
        this.Total = Total;
        this.productos = productos;
        this.Fecha = Fecha;
        Idcompra = Venta_Compra.IdC++;
        Es_compra = true;
    }
    public void Venta(String Cliente, float Total, String Fecha, ListaEnlazada productos){
        this.Cliente = Cliente;
        this.Total = Total;
        this.productos = productos;
        this.Fecha = Fecha;
        Idventa = Venta_Compra.IdV++;
        Es_compra = false;
    }

    public int getIdcompra() {
        return Idcompra;
    }

    public int getIdventa() {
        return Idventa;
    }

    public String getProveedor() {
        return Proveedor;
    }

    public void setProveedor(String Proveedor) {
        this.Proveedor = Proveedor;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    public float getTotal() {
        return Total;
    }

    public String getFecha() {
        return Fecha;
    }
    
    public ListaEnlazada getProductos(){
        return productos;
    }
    
    public boolean getEsCompra(){
        return Es_compra;
    }
    
    public void setEsCompra(boolean es){
        this.Es_compra = es;
    }
    
    @Override
    public String toString() {
        if (Es_compra == true){
            return "Compra:" + '\n' + "Id Compra = " + Idcompra + '\n' +
                    "Proveedor = " + Proveedor + '\n' + "Total = " + Total + '\n'
                    + "Productos = " + '\n' + productos + "Fecha = " + Fecha + '\n';
        }
        else{
            return "Venta:" + '\n' + "Id Venta = " + Idventa + '\n' +
                    "Cliente = " + Cliente + '\n' + "Total = " + Total + '\n'
                    + "Productos = " + '\n' + productos + "Fecha = " + Fecha + '\n';
        }
    }
}