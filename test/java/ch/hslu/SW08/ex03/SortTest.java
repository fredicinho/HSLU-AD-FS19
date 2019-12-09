/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW08.ex03;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author freda
 */
public class SortTest {
    
    public SortTest() {
    }

    @Test
    public void testInsertionSort2() {
        int[] array = {1,5,7,10,4,2};
        Sort.insertionSort2(array);
        
        assertEquals(10 , array[5]);
    }
    
}
