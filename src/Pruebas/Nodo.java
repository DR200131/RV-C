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
public class Nodo {
    private Nodo siguiente;
    private Object dato;
    
    Nodo siguiente(){
        return this.siguiente;
    }
    
    void agregar(Nodo n){
        this.siguiente = n;
    }
    
    Object ver_dato(){
        return this.dato;
    } 
    
    Nodo(Object dato){
        this.dato = dato;
        this.siguiente = null;
    }
    
    @Override
    public String toString() {
        return "" + dato + '\n';
    }
}