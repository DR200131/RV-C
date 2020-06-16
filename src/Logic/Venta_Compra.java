/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;
import Data_Structures.*;

/**
 *
 * @author Juan Pablo
 */
public class Venta_Compra {
    private int Idcompra;
    private int Idventa;
    private String Proveedor;
    private String Cliente;
    private ListaEnlazada productos_l;
    private ArbolAVL productos_a;
    private float Total;
    private String Fecha;
    private boolean Es_compra;
    
    public static int IdC = 1;
    public static int IdV = 1;

    public void ListaCompra(String proveedor, float Total, String Fecha, ListaEnlazada productos) {
        this.Proveedor = proveedor;
        this.Total = Total;
        this.productos_l = productos;
        this.Fecha = Fecha;
        Idcompra = Venta_Compra.IdC++;
        Es_compra = true;
    }
    public void ListaVenta(String Cliente, float Total, String Fecha, ListaEnlazada productos){
        this.Cliente = Cliente;
        this.Total = Total;
        this.productos_l = productos;
        this.Fecha = Fecha;
        Idventa = Venta_Compra.IdV++;
        Es_compra = false;
    }
    
    public void ArbolCompra(String proveedor, float Total, String Fecha, ArbolAVL productos) {
        this.Proveedor = proveedor;
        this.Total = Total;
        this.productos_a = productos;
        this.Fecha = Fecha;
        Idcompra = Venta_Compra.IdC++;
        Es_compra = true;
    }
    
    public void ArbolVenta(String Cliente, float Total, String Fecha, ArbolAVL productos){
        this.Cliente = Cliente;
        this.Total = Total;
        this.productos_a = productos;
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
    
    public ListaEnlazada getListaProductos(){
        return productos_l;
    }

    public void setListaProductos(ListaEnlazada productos_l) {
        this.productos_l = productos_l;
    }
    
    public ArbolAVL getArbolProductos(){
        return productos_a;
    }

    public void setArbolProductos(ArbolAVL productos_a) {
        this.productos_a = productos_a;
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
            return "Compra:" + '\n' + "Id Compra = " + '\n' +
                    "Proveedor = " + Proveedor + '\n' + "Total = " + Total + '\n'
                    + "Productos = " + '\n' + /*productos_l +*/ productos_a + '\n' + "Fecha = " + Fecha + '\n';
        }
        else{
            return "Venta:" + '\n' + "Id Venta = " + '\n' +
                    "Cliente = " + Cliente + '\n' + "Total = " + Total + '\n'
                    + "Productos = " + '\n' + /*productos_l +*/ productos_a + '\n' + "Fecha = " + Fecha + '\n';
        }
    }
}
