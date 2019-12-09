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
public interface StackInterface {
    
    /**
     * Legt ein Element auf den Stapel drauf.
     * 
     * @param string 
     */
    public void push(String string);
    
    /**
     * Nimmt das oberste Element vom Stapel.
     * 
     * @return String
     */
    public String pop();
    
    /**
     * Prüft ob der Stack leer ist.
     * 
     * @return boolean
     */
    public boolean empty();
 
    /**
     * Prüft ob der Stack voll ist.
     * @return  boolean
     */
    public boolean full();
    
    /**
     * Gibt die Anzahl Elemente im Stack zurück
     * 
     * @return int Anzahl Elemente
     */
    public int size();
    
    
}
