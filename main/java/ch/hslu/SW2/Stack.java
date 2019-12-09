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
public class Stack implements StackInterface {
    private String[] myArray;
    private int currentIndex;
    private final int maxLength;
    
    public Stack(int i){
        this.myArray = new String[i];
        this.maxLength = i;
        this.currentIndex = 0;
    }
    
    /**
     * Gibt das ausgewählte Element im Stack als String zurück.
     * 
     * @param i Index
     * @return String des entsprechenden Objekts
     */
    public String getString(int i){
        return this.myArray[i];
    }
    
    /**
     * Fügt ein Element in den Stack ein.
     * @param string 
     */
    @Override
    public void push(String string) {
        try {
        if (this.full()){
            throw new StackFullException();
        } else {
        this.myArray[this.currentIndex] = string;
        this.currentIndex++;
        }
        } catch (StackFullException ex) {
            ex.getMessage();
        }
        
    }

    /**
     * Nimmt das oberste Element auf dem Stack heraus. 
     * @return String 
     */
    @Override
    public String pop() {
        if (this.currentIndex == 0){
            // Stack ist leer!
            return null;
        } else {
        String s = this.myArray[this.currentIndex - 1];
        this.currentIndex--;
        return s;
        }
    }

    @Override
    public boolean empty() {
        return this.currentIndex < 1;
    }

    @Override
    public boolean full() {
        return this.maxLength == this.size();
    }

    @Override
    public int size() {
        return this.currentIndex - 1;
    }
    
}
