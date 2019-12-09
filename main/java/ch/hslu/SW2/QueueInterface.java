/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW2;

/**
 *
 * @author freda
 */
public interface QueueInterface {
    
    /**
     * Fügt ein Element am Ende der Liste ein
     * 
     */
    public void enqueue(char i);
    
    /**
     * Nimmt ein Element vom Anfang der Liste
     * 
     * @return char 
     */
    public char dequeue();
   
    /**
     * Gibt das Element als String zurück
     * @return String
     */
    @Override
    public String toString();
}
