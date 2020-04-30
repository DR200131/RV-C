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
public class ListaEnlazada {
    private Nodo cabeza;
    private int tamaño;
    
    public int tamaño(){
        return tamaño;
    }
    
    public int getindice(Object dato){
        Nodo temporal = cabeza;
        int indice = -1;
        for (int j=0; j<tamaño; j++){
            if (dato == temporal.ver_dato()){
                indice = j;
            }
            temporal = temporal.siguiente();
        }
        return indice;
    }
    
    public Object obtener(int indice){
        Nodo temporal = cabeza;
        for(int i = 0; i<indice;i++){
            temporal = temporal.siguiente();
        }
        return  temporal.ver_dato();
    }
    
    public void agregarDelante(Object dato){
        if(cabeza == null){
            cabeza = new Nodo(dato);
        }
        
        else{
            Nodo temporal = cabeza;
            Nodo nuevo = new Nodo(dato);
            nuevo.agregar(temporal);
            cabeza = nuevo;
        }
        tamaño++;
    }
    
    public void agregarAtras(Object dato){
        if(cabeza == null){
            cabeza = new Nodo(dato);
        }
        
        else{
            Nodo temporal = cabeza;
            Nodo nuevo = new Nodo(dato);
            while(temporal.siguiente() != null){
                temporal = temporal.siguiente();
            }
            temporal.agregar(nuevo);
        }
        tamaño++;
    }
    
    public void eliminar(int indice){
        if (indice<0) tamaño++;
        else if(indice == 0){
            cabeza = cabeza.siguiente();
        }
        else{
            Nodo temporal = cabeza;
            for(int i=0; i<indice-1; i++){
                temporal=temporal.siguiente();
            }
            temporal.agregar(temporal.siguiente().siguiente());
        }
        tamaño--;
    }
    
    public ListaEnlazada(){
        cabeza = null;
        tamaño = 0;
    }
    
    @Override
    public String toString() {
        Nodo temporal = cabeza;
        String cad = "";
        for (int j=0; j<tamaño; j++){
            cad += temporal;
            temporal = temporal.siguiente();
        }
        return cad;
    }
    
}