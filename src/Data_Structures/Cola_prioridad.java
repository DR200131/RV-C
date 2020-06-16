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
public class Cola_prioridad {
    private int[] Cola;
    private int C_datos; 
    private int tamaño; 

    private static final int frente = 1; 

    public Cola_prioridad(int tamaño) { 
        this.tamaño = tamaño; 
        this.C_datos = 0; 
        Cola = new int[this.tamaño + 1]; 
        Cola[0] = Integer.MIN_VALUE; 
    } 

    private int padre(int pos){ 
        return pos / 2; 
    } 

    private int hijo_I(int pos){ 
        return (2 * pos); 
    } 

    private int hijo_D(int pos){ 
        return (2 * pos) + 1; 
    } 

    private boolean es_hoja(int pos){ 
        if (pos >= (C_datos / 2) && pos <= C_datos) { 
            return true; 
        } 
        return false; 
    } 

    private void cambio(int fpos, int spos){ 
        int tmp; 
        tmp = Cola[fpos]; 
        Cola[fpos] = Cola[spos]; 
        Cola[spos] = tmp; 
    } 

    private void ubicar(int pos) { 
        if (!es_hoja(pos)) { 
            if (Cola[pos] > Cola[hijo_I(pos)] || Cola[pos] > Cola[hijo_D(pos)]){ 
                if(Cola[hijo_I(pos)] < Cola[hijo_D(pos)]) { 
                    cambio(pos, hijo_I(pos)); 
                    ubicar(hijo_I(pos)); 
                }  
                else{ 
                    cambio(pos, hijo_D(pos)); 
                    ubicar(hijo_D(pos)); 
                } 
            } 
        } 
    } 

    public void insertar(int dato) 
    { 
        if (C_datos >= tamaño) { 
            return; 
        } 
        Cola[++C_datos] = dato; 
        int actual = C_datos; 

        while (Cola[actual] < Cola[padre(actual)]) { 
            cambio(actual, padre(actual)); 
            actual = padre(actual); 
        } 
    } 

    public void print() { 
        for (int i = 1; i <= C_datos; i++) { 
            System.out.print(Cola[i]);
            System.out.println(); 
        } 
    } 

    public void minCola() { 
        for (int pos = (C_datos / 2); pos >= 1; pos--) { 
            ubicar(pos); 
        } 
    } 

    public void remove() { 
        Cola[frente] = Cola[C_datos--]; 
        ubicar(frente);  
    }
    
    public int peek() {  
        return Cola[frente];
    } 
}
