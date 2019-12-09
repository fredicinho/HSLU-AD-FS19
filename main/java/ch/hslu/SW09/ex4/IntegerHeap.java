/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW09.ex4;

/**
 *
 * @author freda
 */
public interface IntegerHeap {
    
    /**
     * Gibt das grösste Element im Heap zurück
     * @return int Grösstes Element
     */
    public int getMax();
    
    /**
     * Fügt ein Element in den Heap hinein
     */
    public void insert(int value);
    
    
    
}
