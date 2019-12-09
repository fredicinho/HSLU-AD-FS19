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
public class StackTest {
    
    public StackTest() {
    }

    @Test
    public void testKonstruktorEmpty() {
        Stack s1 = new Stack(1);
        assertTrue(s1.empty());
    }
    
    @Test
    public void testPush(){
        Stack s1 = new Stack(1);
        s1.push(new String("last"));
        assertEquals("last", s1.getString(0));
    }
    
    @Test
    public void testFull(){
        Stack s1 = new Stack(2);
        s1.push(new String("blabla"));
        s1.push(new String("bla"));
        assertTrue(s1.full());
    }
    
    @Test
    public void testSize(){
        Stack s1 = new Stack(1);
        assertEquals(1, s1.size());
    }
    
    @Test
    public void testPop(){
        Stack s1 = new Stack(1);
        s1.push(new String("adsf"));
        String s = s1.pop();
        assertEquals("adsf", s);
    }
    
    @Test
    public void testPop1(){
        Stack s1 = new Stack(1);
        assertEquals(null, s1.pop());
        
    }
    
    /**@Test
    public void testPushFull(){
        assertThrows(StackFullException.class,
            ()->{
        Stack s1 = new Stack(1);
        s1.push(new String("bla"));
        s1.push(new String("asdf"));
            });
        
        
    }
    * */
    
}
