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
public class ListTest {
    
    public ListTest() {
    }

    @Test
    public void testKonstruktor() {
        List l1 = new List();
        assertEquals(0, l1.getAnzahlAllocation());
        assertEquals(null, l1.getHead());
        
    }
    
    @Test
    public void testAddAllocation(){
        List l1 = new List();
        Allocation a = new Allocation(3, 4);
        
        l1.addAllocation(a);
        assertEquals(1, l1.getAnzahlAllocation());
        assertEquals(a, l1.getHead());
        
    }
    
    @Test
    public void removeAllocation1(){
        List l1 = new List();
        Allocation a = new Allocation(3, 4);
        Allocation b = new Allocation(2, 6);
        Allocation c = new Allocation(3, 6);
        
        l1.addAllocation(a);
        l1.addAllocation(b);
        l1.addAllocation(c);
        l1.removeAllocation(c);
        assertEquals(b, l1.getHead());
        
    }
    
    @Test
    public void removeAllocation2(){
        List l1 = new List();
        Allocation a = new Allocation(3, 4);
        Allocation b = new Allocation(3, 5);
        Allocation c = new Allocation(3, 6);
        
        l1.addAllocation(a);
        l1.addAllocation(b);
        l1.addAllocation(c);
        l1.removeAllocation(b);
        assertEquals(a, c.getNext());
        
    }
    
    @Test
    public void removeALlocation3(){
        List l1 = new List();
        Allocation a = new Allocation(3, 4);
        Allocation b = new Allocation(3, 5);
        Allocation c = new Allocation(3, 6);
        
        l1.addAllocation(a);
        l1.addAllocation(b);
        l1.addAllocation(c);
        l1.removeAllocation(a);
        assertEquals(null, b.getNext());
    }
    
    @Test
    public void removeALlocation4(){
        List l1 = new List();
        Allocation a = new Allocation(3, 4);
        Allocation b = new Allocation(3, 5);
        Allocation c = new Allocation(3, 6);
        Allocation d = new Allocation(3, 9);
        
        l1.addAllocation(a);
        l1.addAllocation(b);
        l1.addAllocation(c);
        l1.removeAllocation(d);
        assertEquals(3, l1.getAnzahlAllocation());
    }
    
    @Test
    public void getAndRemoveFirstAllocation(){
        List l1 = new List();
        Allocation a = new Allocation(3, 4);
        Allocation b = new Allocation(3, 5);
        Allocation c = new Allocation(3, 6);
        Allocation d = new Allocation(3, 9);
        
        l1.addAllocation(a);
        l1.addAllocation(b);
        l1.addAllocation(c);
        assertEquals(c, l1.getAndRemoveFirstAllocation());
        assertEquals(2, l1.getAnzahlAllocation());
    }
    
    @Test
    public void testIterator(){
        List l1 = new List();
        Allocation a = new Allocation(3, 4);
        Allocation b = new Allocation(3, 5);
        Allocation c = new Allocation(3, 6);
        Allocation d = new Allocation(3, 9);
        
        l1.addAllocation(a);
        l1.addAllocation(b);
        l1.addAllocation(c);
        l1.addAllocation(d);
        
        
        
        assertTrue(l1.iterator().hasNext());
    }
    
}
