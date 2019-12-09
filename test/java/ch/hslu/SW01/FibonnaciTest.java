/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW01;

import org.junit.Test.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author freda
 */
public class FibonnaciTest {
    
    public FibonnaciTest() {
    }

    @Test
    public void testFiboRec10() {
        Fibonnaci f = new Fibonnaci();
        assertEquals(0, f.fiboRec1(0));
    }
    
    @Test
    public void testFiboRec11(){
        Fibonnaci f = new Fibonnaci();
        assertEquals(1, f.fiboRec1(1));
    }
    
    @Test
    public void testFiboRec12() {
        Fibonnaci f = new Fibonnaci();
        assertEquals(1, f.fiboRec1(2));
    }
    
    @Test
    public void testFiboRec1n(){
        Fibonnaci f = new Fibonnaci();
        assertEquals(55, f.fiboRec1(10));
    }
    
    @Test
    public void testFiboRec1x(){
        Fibonnaci f = new Fibonnaci();
        assertEquals(377, f.fiboRec1(14));
    }
    
    @Test
    public void testFiboRec2n(){
        Fibonnaci f = new Fibonnaci();
        assertEquals(55, f.fiboRec2(10));
    }
    
}
