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
class Nodo_arbol {
    Object dato;
    int llave, altura;
    Nodo_arbol hijo_izq, hijo_der; 

    public Nodo_arbol(int llave, Object dato) {
        this.llave = llave;
        this.dato = dato;
    } 
}

public class ArbolAVL {
    private Nodo_arbol raiz;
    private String datos = "";

    public Nodo_arbol getRaiz() {
            return raiz;
        }
    
    public Object getDatoRaiz(){
        return raiz.dato;
    }
    
    public int getLlaveRaiz(){
        return raiz.llave;
    }

    public void imprimir_Raiz() {
            System.out.println(raiz.dato);
        }

    public void actualizar_altura(Nodo_arbol nodo) {
            nodo.altura = 1 + Math.max(altura(nodo.hijo_izq), altura(nodo.hijo_der)); 
        }

    public int altura(Nodo_arbol nodo) {
        if(nodo== null){
            return -1;
        }
        else{return nodo.altura;}
    }

    public int balanceo(Nodo_arbol nodo) {
        if(nodo== null){
            return 0;
        }
        else{
            return altura(nodo.hijo_der) - altura(nodo.hijo_izq);
        }
    }

    public Nodo_arbol rotacion_derecha(Nodo_arbol nodo){
        Nodo_arbol temporal = nodo.hijo_izq;
        nodo.hijo_izq = temporal.hijo_der;
        temporal.hijo_der = nodo;
        actualizar_altura(nodo);
        actualizar_altura(temporal);
        return temporal;
    }

    public Nodo_arbol rotacion_izquierda(Nodo_arbol nodo){
        Nodo_arbol temporal = nodo.hijo_der;
        nodo.hijo_der = temporal.hijo_izq;
        temporal.hijo_izq = nodo;
        actualizar_altura(nodo);
        actualizar_altura(temporal);
        return temporal;
    }

    public Nodo_arbol rebalanceo(Nodo_arbol nodo){
        actualizar_altura(nodo);
        int balance = balanceo(nodo);
        if(balance > 1){
            if(altura(nodo.hijo_der.hijo_der) > altura(nodo.hijo_der.hijo_izq)){
                nodo = rotacion_izquierda(nodo);
            }
            else{
                nodo.hijo_der = rotacion_derecha(nodo.hijo_der);
                nodo = rotacion_izquierda(nodo);
            }
        }
        else if(balance < -1){
            if(altura(nodo.hijo_izq.hijo_izq) > altura(nodo.hijo_izq.hijo_der)){
                nodo = rotacion_derecha(nodo);
            }
            else{
                nodo.hijo_izq = rotacion_izquierda(nodo.hijo_izq);
                nodo = rotacion_derecha(nodo);
            }
        }
       raiz = nodo;
       return nodo; 
    }

    private Nodo_arbol insertar(Nodo_arbol nodo, int llave, Object dato) {
        if (nodo == null) {
            return new Nodo_arbol(llave, dato);
        } 
        else if (nodo.llave > llave) {
            nodo.hijo_izq = insertar(nodo.hijo_izq, llave, dato);
        } 
        else if (nodo.llave < llave) {
            nodo.hijo_der = insertar(nodo.hijo_der, llave, dato);
        } 
        /*else {
            throw new RuntimeException("Llave duplicada");
        }*/
        return rebalanceo(nodo);
    }

    public void insertar(int llave, Object dato){
        if(raiz == null){
            raiz = new Nodo_arbol(llave,dato);
        }
        else{
            insertar(raiz, llave, dato);
        }
    }

    public Object encontrar(int llave) {
        Nodo_arbol actual = raiz;
        while (actual != null) {
            if (actual.llave == llave) {
                break;
            }
            else if(actual.llave > llave){
                actual = actual.hijo_izq;
            }
            else if(actual.llave < llave){
                actual = actual.hijo_der;
            }
        }
        if(actual == null){
            Object n = -1;
            return n;
        }
        return actual.dato;
    }

    private Nodo_arbol Eliminar(Nodo_arbol nodo, int llave) {
        if (nodo == null) {
            return nodo;
        } else if (nodo.llave > llave) {
            nodo.hijo_izq = Eliminar(nodo.hijo_izq, llave);
        } else if (nodo.llave < llave) {
            nodo.hijo_der = Eliminar(nodo.hijo_der, llave);
        } else {
            if (nodo.hijo_izq == null || nodo.hijo_der == null) {
                nodo = (nodo.hijo_izq == null) ? nodo.hijo_der : nodo.hijo_izq;
            } else {
                Nodo_arbol mas_pequeño = minimo(nodo.hijo_der);
                nodo.llave = mas_pequeño.llave;
                nodo.dato = mas_pequeño.dato;
                nodo.hijo_der = Eliminar(nodo.hijo_der, nodo.llave);
            }
        }
        if (nodo != null) {
            nodo = rebalanceo(nodo);
        }
        return nodo;
    }

    public void eliminar(int llave){
        if(llave == raiz.llave && raiz.hijo_der == null && raiz.hijo_izq == null){
            raiz= null;
        }
        Eliminar(raiz, llave);
    }
    
    public Nodo_arbol minimo(Nodo_arbol nodo){
        if(nodo.hijo_izq == null){
            return nodo;
        }
        else{
            return minimo(nodo.hijo_izq);
        }
    }
    
    public Nodo_arbol maximo(Nodo_arbol nodo){
        if(nodo.hijo_der == null){
            return nodo;
        }
        else{
            return maximo(nodo.hijo_der);
        }
    }
    
    public int llaveMaximo(){
        return maximo(raiz).llave;
    }

    public boolean isEmpty(){
        return raiz == null;
    }

    public void inOrder(Nodo_arbol nodo){
        if(nodo != null){
            inOrder(nodo.hijo_izq);
            System.out.println(nodo.dato);
            inOrder(nodo.hijo_der);
        }
    }

    public void preOrder(Nodo_arbol nodo){
        if(nodo != null){
            System.out.println(nodo.dato);
            preOrder(nodo.hijo_izq);
            preOrder(nodo.hijo_der);
        }
    }

    public void posOrder(Nodo_arbol nodo){
        if(nodo != null){
            posOrder(nodo.hijo_izq);
            posOrder(nodo.hijo_der);
            System.out.println(nodo.dato);
        }
    }
    
    public String impresion(Nodo_arbol nodo){
        if(nodo != null){
            impresion(nodo.hijo_izq);
            datos+=nodo.dato.toString()+'\n';
            impresion(nodo.hijo_der);
        }
        return datos;
    }
    
    @Override
    public String toString() {
        return impresion(raiz);
    }
}