/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW2;

import org.junit.Test.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author freda
 */
public class QueueTest {
    
    public QueueTest() {
    }

    @Test
    public void testGetSize() {
        Queue q = new Queue(2);
        assertEquals(0, q.getSize());
    }
    
    @Test
    public void testEnqueue(){
        Queue q = new Queue(4);
        q.enqueue('A');
        q.enqueue('B');
        q.enqueue('C');
        q.enqueue('D');
        assertEquals(4, q.getSize());
    }
    
    @Test
    public void testEnqueue1(){
        Queue q = new Queue(4);
        q.enqueue('A');
        q.enqueue('B');
        q.enqueue('C');
        
        assertEquals(0, q.getFront());
        assertEquals(3, q.getRear());
    }
    
        @Test
    public void testEnqueu2(){
        Queue q = new Queue(4);
        q.enqueue('A');
        q.enqueue('B');
        q.enqueue('C');
        q.enqueue('D');
        
        assertEquals(0, q.getFront());
        assertEquals(0, q.getRear());
    }
    
    @Test
    public void testEnqueu3(){
        Queue q = new Queue(4);
        q.enqueue('A');
        q.enqueue('B');
        q.enqueue('C');
        q.enqueue('D');
        q.enqueue('K');
        
        assertEquals(0, q.getFront());
        assertEquals(0, q.getRear());
    }
    
    @Test
    public void testDequeue(){        
        Queue q = new Queue(4);
        q.enqueue('A');
        q.enqueue('B');
        q.enqueue('C');
        q.enqueue('D');
        
        char c = q.dequeue();
        assertEquals('A', c);
    
    }
    
    @Test
    public void testDequeue1(){
        Queue q = new Queue(4);
        q.enqueue('A');
        q.enqueue('B');
        q.enqueue('C');
        q.enqueue('D');
        
        char c = q.dequeue();
        assertEquals(1, q.getFront());
    }
    
    @Test
    public void testDequeue2(){
        Queue q = new Queue(4);
        q.enqueue('A');
        q.enqueue('B');
        q.enqueue('C');
        q.enqueue('D');
        
        char c = q.dequeue();
        char u = q.dequeue();
        char o = q.dequeue();
        
        assertEquals(3, q.getFront());
    }
    
    @Test
    public void testDeAndEnqueue(){
        Queue q = new Queue(4);
        q.enqueue('A');
        q.enqueue('B');
        q.enqueue('C');
        q.enqueue('D');
        
        char c = q.dequeue();
        char u = q.dequeue();
        char o = q.dequeue();
        char p = q.dequeue();
        
        assertEquals(0, q.getRear());
        assertEquals(0, q.getFront());
    }
    
    @Test
    public void testDequeue3(){
        Queue q = new Queue(4);
        q.enqueue('A');
        q.enqueue('B');
        q.enqueue('C');
        q.enqueue('D');
        
        char c = q.dequeue();
        char u = q.dequeue();
        char o = q.dequeue();
        char p = q.dequeue();
        char l = q.dequeue();
        
        assertEquals(0, q.getRear());
        assertEquals(0, q.getFront());
    }
    
    
}
