/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW03;

/**
 *
 * @author freda
 */
public interface TreeInterface<E> {
    
    /**
     * Sucht im Baum nach einem Element und gibt ihn zurück.
     * @param data
     * @return Den Node mit dem enthaltenem Objekt
     */
    public Object search(E data);
    
    /**
     * Entfernt ein bestimmtes Element aus dem Baum
     * @param data 
     */
    public void remove(E data);
    
    /**
     * Fügt ein Element in den Baum hinein
     * @param data 
     */
    public void add(E data);
    
}
