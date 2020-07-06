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
public class Inventario {
    private ListaEnlazada productos_l = new ListaEnlazada();
    private ArbolAVL productos_a = new ArbolAVL();
    private HashTable<Integer, Producto> productos_t = new HashTable<Integer, Producto>();
    
    public ListaEnlazada getListaInventario(){
        return productos_l;
    }
    
    public void setListaInventario(ListaEnlazada inv){
        this.productos_l = inv;
    }
    
    public ListaEnlazada añadirLista(Producto prod){
        productos_l.agregarAtras(prod);
        return productos_l;
    }
    
    public ListaEnlazada quitarLista(Producto prod){
        int code = prod.getCodigo_serial();
        for (int j=0; j<productos_l.tamaño(); j++){
            Producto compara = (Producto) productos_l.obtener(j);
            if (compara.getCodigo_serial() == code){
                productos_l.eliminar(j);
                break;
            }
        }
        return productos_l;
    }
    
    public void imprimeListaInventario(){
        for(int i=0; i<productos_l.tamaño(); i++){
            System.out.println(productos_l.obtener(i));
        }
    }
    
    public Producto buscarListaSerial(int serial){
        for (int j=0; j<productos_l.tamaño(); j++){
            Producto compara = (Producto) productos_l.obtener(j);
            if (compara.getCodigo_serial() == serial){
                return compara;
            }
        }
        Producto compara = new Producto("", "", 0, 0, 0, "", "", 0);
        return compara;
    }
    
    public ArbolAVL getArbolInventario(){
        return productos_a;
    }
    
    public void setArbolInventario(ArbolAVL inv){
        this.productos_a = inv;
    }
    
    public ArbolAVL añadirArbol(Producto prod){
        productos_a.insertar(prod.getCodigo_serial(), prod);
        return productos_a;
    }
    
    public ArbolAVL quitarArbol(Producto prod){
        productos_a.eliminar(prod.getCodigo_serial());
        return productos_a;
    }
    
    public void imprimeArbolInventario(){
        productos_a.inOrder(productos_a.getRaiz());
    }
    
    public Producto buscarArbolSerial(int serial){
        Object n = productos_a.encontrar(serial);
        if (n.equals(-1)){
            Producto compara = new Producto("", "", 0, 0, 0, "", "", 0);
            return compara;
        }else{
            Producto prod = (Producto) productos_a.encontrar(serial);
            return prod; 
        }
    }

    public HashTable<Integer, Producto> getHashInventario() {
        return productos_t;
    }

    public void setHashInventario(HashTable<Integer, Producto> productos_t) {
        this.productos_t = productos_t;
    }
    
    public HashTable<Integer, Producto> añadirHash(Producto prod){
        productos_t.put(prod.getCodigo_serial()-10000000, prod);
        return productos_t;
    }
    
    public HashTable<Integer, Producto> quitarHash(Producto prod){
        productos_t.remove(prod.getCodigo_serial()-10000000);
        return productos_t;
    }
    
    public void imprimeHashInventario(){
        int tamaño = productos_t.size();
        int i = 0;
        while(tamaño>0){
            if (productos_t.getTable()[i] != null){
                System.out.println(productos_t.getTable()[i].getVal());
                tamaño--;
            }
            i++;
        }
    }
    
    public Producto buscarHashSerial(int serial){
        Producto n = productos_t.get(serial-10000000);
        if (n != null){
            return n;
        }else{
            return null;
        }
    }
    
}
