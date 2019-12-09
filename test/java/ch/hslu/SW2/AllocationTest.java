/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW2;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author freda
 */
public class AllocationTest {
    
    public AllocationTest() {
    }

    @Test
    public void testGetAddress() {
        Allocation a = new Allocation(2, 3);
        assertEquals(2, a.getAddress());
    }
    
    @Test
    public void testGetSize(){
        Allocation a = new Allocation(2, 3);
        assertEquals(3, a.getSize());
    }
    
    @Test
    public void testGetNext(){
        Allocation a = new Allocation(2, 3);
        assertEquals(null, a.getNext());
    }
    
    @Test
    public void testEquals(){
        Allocation a = new Allocation(3, 4);
        Allocation b = new Allocation(3, 4);
        assertTrue(a.equals(b));
    }
    
    @Test
    public void testEquals2(){
        Allocation a = new Allocation(3, 4);
        Allocation b = new Allocation(3, 5);
        assertFalse(a.equals(b));
    }
    
    @Test
    public void testEqualsContract() { 
        EqualsVerifier.forClass(Allocation.class);
    } 
    
    @Test
    public void testSetNext(){
        Allocation a = new Allocation(3, 4);
        Allocation b = new Allocation(4, 4);
        a.setNext(b);
        assertEquals(b, a.getNext());
    }
}
