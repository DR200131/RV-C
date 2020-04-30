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
public class Inventario {
    private ListaEnlazada productos = new ListaEnlazada();
    
    public ListaEnlazada getInventario(){
        return productos;
    }
    
    public void setInventario(ListaEnlazada inv){
        this.productos = inv;
    }
    
    public ListaEnlazada añadir(Producto prod){
        productos.agregarAtras(prod);
        return productos;
    }
    
    public ListaEnlazada quitar(Producto prod){
        int code = prod.getCodigo_serial();
        for (int j=0; j<productos.tamaño(); j++){
            Producto compara = (Producto) productos.obtener(j);
            if (compara.getCodigo_serial() == code){
                productos.eliminar(j);
                break;
            }
        }
        return productos;
    }
    
    public void imprimeInventario(){
        for(int i=0; i<productos.tamaño(); i++){
            System.out.println(productos.obtener(i));
        }
    }
    
    public Producto buscarSerial(int serial){
        Producto compara = new Producto("", "", 0, 0, 0, "", "");
        for (int j=0; j<productos.tamaño(); j++){
            compara = (Producto) productos.obtener(j);
            if (compara.getCodigo_serial() == serial){
                break;
            }
        }
        return compara;
    }
    
    public int contarProductos(int serial){
        int counter = 0;
        for (int j=0; j<productos.tamaño(); j++){
            Producto comparador = (Producto) productos.obtener(j);
            if (comparador.getCodigo_serial() == serial){
                counter++;
            }
        }
        return counter;
    }
}