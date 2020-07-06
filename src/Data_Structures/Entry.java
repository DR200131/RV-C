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
import java.util.*;

public class Entry<K, V> {
    K key;
    V val;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getVal() {
        return val;
    }

    public void setVal(V val) {
        this.val = val;
    }

    @Override
    public int hashCode() {
        int prime = 13;
        int mul = 11;
        if (key != null) {
            int hashCode = prime * mul + key.hashCode();
            return hashCode;
        }
        return 0;
    }

}
