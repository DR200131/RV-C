/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data_Structures;

/**
 *
 * @author Juan Pablo
 */
public class Pila {
    private ListaEnlazada pila;
    public Object peek(){
        return pila.obtener(0);
    }
    public Object pop(){
        Object tope = pila.obtener(0);
        pila.eliminar(0);
        return tope;
    }
    public void push(Object x){
        pila.agregarDelante(x);
    }
    public boolean isEmpty(){
        if(pila.tamaño() == 0){
            return true;
        }
        else{return false;}
    }
    public Pila(){
        pila = new ListaEnlazada();
    }
}
