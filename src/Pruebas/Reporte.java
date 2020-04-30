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
public class Reporte{
    private ListaEnlazada ListaVentas = new ListaEnlazada();
    private ListaEnlazada ListaCompras = new ListaEnlazada();

    public ListaEnlazada getVentas(){
        return ListaVentas;
    }
    
    public ListaEnlazada getCompras(){
        return ListaCompras;
    }
    
    public ListaEnlazada añadirVenta(Venta_Compra venta){
        ListaVentas.agregarAtras(venta);
        return ListaVentas;
    }
    
    public ListaEnlazada añadirCompra(Venta_Compra compra){
        ListaCompras.agregarAtras(compra);
        return ListaCompras;
    }
    
    public ListaEnlazada quitarVenta(Venta_Compra venta){
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
    
    public ListaEnlazada quitarCompra(Venta_Compra compra){
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
    
    public void showVentas(){
        System.out.println(ListaVentas);
    }
    
    public void showCompras(){
        System.out.println(ListaCompras);
    }
}