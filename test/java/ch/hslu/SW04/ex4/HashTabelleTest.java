/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW04.ex4;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


/**
 *
 * @author freda
 */
public class HashTabelleTest {
    
    public HashTabelleTest() {
    }

    @Test
    public void testKonstruktorundSize() {
        HashTabelle h1 = new HashTabelle(10);
        assertEquals(0, h1.getSize());
    }
    
    @Test
    public void testInsertElement(){
        HashTabelle h1 = new HashTabelle(10);
        Allocation a1 = new Allocation(1,2);
        Allocation a2 = new Allocation(2,3);
        
        h1.insertElement(a1);        
        h1.insertElement(a2);
        assertEquals(2, h1.getSize());

        
    }
    
    @Test
    public void testRemove(){
        HashTabelle h1 = new HashTabelle(10);
        Allocation a1 = new Allocation(1,2);
        Allocation a2 = new Allocation(2,3);
        
        h1.insertElement(a1);        
        h1.insertElement(a2);
        
        assertTrue(h1.remove(a2));
        
    }
    
    @Test
    public void testRemove1(){
        HashTabelle h1 = new HashTabelle(2);
        Allocation a1 = new Allocation(1,2);
        Allocation a2 = new Allocation(2,3);
        
        h1.insertElement(a1);        
        h1.insertElement(a2);
        
        assertTrue(h1.remove(a1));
        
    }
    
    @Test
    public void testRemove2(){
        HashTabelle h1 = new HashTabelle(2);
        Allocation a1 = new Allocation(1,2);
        Allocation a2 = new Allocation(2,3);
        Allocation a3 = new Allocation(2, 4);
        Allocation a4 = new Allocation(3, 4);
        
        h1.insertElement(a1);        
        h1.insertElement(a2);
        h1.insertElement(a3);
        h1.insertElement(a4);
        
        assertTrue(h1.remove(a1));
        assertTrue(h1.remove(a2));
        assertEquals(2, h1.getSize());
        
    }
    
    @Test
    public void testSearch(){
        HashTabelle h1 = new HashTabelle(2);
        Allocation a1 = new Allocation(1,2);
        Allocation a2 = new Allocation(2,3);
        Allocation a3 = new Allocation(2, 4);
        Allocation a4 = new Allocation(3, 4);
        
        h1.insertElement(a1);        
        h1.insertElement(a2);
        h1.insertElement(a3);
        h1.insertElement(a4);
        
        assertTrue(h1.search(a4));
        
    }
    
}
