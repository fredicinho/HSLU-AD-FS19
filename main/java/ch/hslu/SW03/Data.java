/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW03;

import java.util.Objects;

/**
 *
 * @author freda
 */
//Randnotiz <E extends Comprable<E>> heisst, dass sicher gegangen wird, dass der genericshe Type Comparable implementiert hat, sonst kein initialisieren möglich
public class Data<E extends Comparable<E>> implements Comparable<E> {
        
    //private int DataID;
    private E data;
    
    public Data(E data){
        this.data=data;
    }
    
    public void setData(E data){
        this.data=data;
    }
    
    public E getData(){
        return this.data;
    }
    
    
    //overrides

    @Override
    public int hashCode() {
        return Objects.hashCode(this.data);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Data<E> other = (Data<E>) obj;
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(E other) {
        return (data).compareTo(other);
    }

    @Override
    public String toString() {
        return "Data{" + data + '}';
    }
    
}
