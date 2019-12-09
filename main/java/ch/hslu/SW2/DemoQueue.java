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
public class DemoQueue {
    
    public static void main(String[] args){
        Queue q = new Queue(4);
        q.enqueue('A');
        q.enqueue('B');
        q.enqueue('C');
        q.enqueue('D');
        char c = q.dequeue();
        q.enqueue('U');
        
        System.out.println(q.toString());
        System.out.println(c);
    }
    
}
