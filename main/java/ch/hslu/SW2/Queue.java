                                                                                                                                                                                            /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW2;

import java.util.Arrays;

/**
 *
 * @author freda
 */
public class Queue implements QueueInterface {

    private char[] queue;
    private int front, rear, size, capacity;
    
    
    public Queue(int capacity){
        this.queue = new char[capacity];
        this.capacity = capacity;
        this.front = this.rear = this.size = 0;
        
    }
    
    /**
     * Fügt ein Element in die Queue ein, wobei diese am Anfang der Schlange hinzugefügt wird.
     * 
     * @param i Char
     */
    @Override
    public void enqueue(char i) {
        if (this.size == this.capacity) {
            //Queue ist voll!
        } else {
            this.queue[this.rear] = i;
            if (this.rear == this.capacity - 1){
                this.rear = 0;
            } else {
                this.rear++;
            }
            this.size++;
        }
        
    }

    /**
     * Nimt das letzte Element aus der Schlange heraus und gibt den Speicher wieder frei.
     * 
     * @return char 
     */
    @Override
    public char dequeue() {
        if (this.size == 0){
            //Queue ist leer
            return 'Z';
        } else {
            char x = this.queue[this.front];
            if (this.front == this.capacity - 1){
                this.front = 0;
            } else {
                this.front++;
            }
            
            this.size--;
            return x;
            
        }   
        
    }
    
    public boolean isFull(){
        return this.capacity == this.size;
    }
    
    public int getSize(){
        return this.size;
    }
    
    public int getCapacity(){
        return this.capacity;
    }
    
    @Override
    public String toString(){
        return Arrays.toString(this.queue);
    }
    
    public int getRear(){
        return this.rear;
    }
    
    public int getFront(){
        return this.front;
    }
    public char[] getQueue(){
        return this.queue;
    }


    
}
