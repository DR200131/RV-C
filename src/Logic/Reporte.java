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
public class Reporte{
    private ListaEnlazada ListaVentas = new ListaEnlazada();
    private ListaEnlazada ListaCompras = new ListaEnlazada();
    private ArbolAVL ArbolVentas = new ArbolAVL();
    private ArbolAVL ArbolCompras = new ArbolAVL();
    private float ArbolGanancias = 0, ArbolGastos = 0;

    public ListaEnlazada getListaVentas(){
        return ListaVentas;
    }
    
    public ListaEnlazada getListaCompras(){
        return ListaCompras;
    }
    
    public ArbolAVL getArbolVentas(){
        return ArbolVentas;
    }
    
    public ArbolAVL getArbolCompras(){
        return ArbolCompras;
    }
    
    public ListaEnlazada añadirListaVenta(Venta_Compra venta){
        ListaVentas.agregarAtras(venta);
        return ListaVentas;
    }
    
    public ListaEnlazada añadirListaCompra(Venta_Compra compra){
        ListaCompras.agregarAtras(compra);
        return ListaCompras;
    }
    
    public ArbolAVL añadirArbolVenta(Venta_Compra venta){
        ArbolVentas.insertar(venta.getIdventa(), venta);
        return ArbolVentas;
    }
    
    public ArbolAVL añadirArbolCompra(Venta_Compra compra){
        ArbolCompras.insertar(compra.getIdcompra(), compra);
        return ArbolCompras;
    }
    
    public ListaEnlazada quitarListaVenta(Venta_Compra venta){
        int code = venta.getIdventa();
        for (int j=0; j<ListaVentas.tamaño(); j++){
            Venta_Compra compara = (Venta_Compra) ListaVentas.obtener(j);
            if (compara.getIdventa() == code){
                ListaVentas.eliminar(j);
                break;
            }
        }
        return ListaVentas;
    }
    
    public ListaEnlazada quitarListaCompra(Venta_Compra compra){
        int code = compra.getIdcompra();
        for (int j=0; j<ListaCompras.tamaño(); j++){
            Venta_Compra compara = (Venta_Compra) ListaCompras.obtener(j);
            if (compara.getIdcompra() == code){
                ListaCompras.eliminar(j);
                break;
            }
        }
        return ListaCompras;
    }
    
    public ArbolAVL quitarArbolVenta(Venta_Compra venta){
        ArbolVentas.eliminar(venta.getIdventa());
        return ArbolVentas;
    }
    
    public ArbolAVL quitarArbolCompra(Venta_Compra compra){
        ArbolCompras.eliminar(compra.getIdcompra());
        return ArbolCompras;
    }
    
    public void showListaVentas(){
        System.out.println(ListaVentas);
    }
    
    public void showListaCompras(){
        System.out.println(ListaCompras);
    }
    
    public void showArbolVentas(){
        ArbolVentas.inOrder(ArbolVentas.getRaiz());
    }
    
    public void showArbolCompras(){
        ArbolCompras.inOrder(ArbolCompras.getRaiz());
    } 
}
