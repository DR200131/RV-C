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

public class HashTable<K, V> {
    private float loadfactor = 0.75f;
    private int capacity = 10000000;
    private int size = 0;
    private Entry<K, V> table[] = new Entry[capacity];

    private int Hashing(int hashCode) {
        int location = hashCode % capacity;
        //System.out.println("Location:"+location);
        //System.out.println("hashCode:"+hashCode);
        return location;
    }

    public int size() {
        return this.size;
    }

    public Entry<K, V>[] getTable() {
        return table;
    }

    public boolean isEmpty() {
        if(this.size == 0) {
            return true;
        }
        return false;
    }

    public boolean containsKey(Object key) {
        if(key == null) {
            if(table[0].getKey() == null) {
                return true;
            }
        }
        int location = Hashing(key.hashCode());
        Entry e = null;
        try {
            e = table[location];
        }catch(NullPointerException ex) {

        }
        if(e!= null && e.getKey().equals(key)) {
            return true;
        }
        return false;
    }

    public boolean containsValue(Object value) {
        for(int i=0; i<table.length;i++) {
            if(table[i] != null && table[i].getVal().equals(value)) {
                return true;
            }
        }
        return false;
    }

    public V get(K key) {
        V ret = null;
        if(key == null) {
            Entry<K, V> e = null;
            try{
                e = table[0];
            }catch(NullPointerException ex) {

            }
            if(e != null) {
                return (V) e.getVal();
            }
        } else {
            int location = Hashing(key.hashCode());
            Entry<K, V> e = null;
            try{
            e = table[location];
            }catch(NullPointerException ex) {

            }
            if(e!= null && e.getKey().equals(key)) {
                return (V)e.getVal();
            }
        }
        return ret;
    }

    public V put(K key, V val) {
        V ret = null;
        if (key == null) {
            ret = putForNullKey(val);
            return ret;
        } else {
            int location = Hashing(key.hashCode());
            if(location >= capacity) {
                System.out.println("Rehashing required");
                return null;
            }
            Entry<K, V> e = null;
            try{
            e = table[location];
            }catch(NullPointerException ex) {

            }
            Entry<K, V> eNew = new Entry<K,V>();
            eNew.setKey(key);
            eNew.setVal(val);
            table[location] = eNew;
            if (!(e!= null && e.getKey().equals(key))) {
                size++;
            }
        }
        return ret;
    }

    private V putForNullKey(V val) {
        Entry<K, V> e = null;
        try {
            e = table[0];
        }catch(NullPointerException ex) {

        }
        V ret = null;
        if (e != null && e.getKey() == null) {
            ret = (V) e.getVal();
            e.setVal(val);
            return ret;
        } else {
            Entry<K, V> eNew = new Entry<K,V>();
            eNew.setKey(null);
            eNew.setVal(val);
            table[0] = eNew;
            size++;
        }
        return ret;
    }

    public V remove(K key) {
        int location = Hashing(key.hashCode());
        V ret = null;
        if(table[location].getKey().equals(key)) {
            table[location] = null;
            size--;
        }
        return ret;
    }
}
