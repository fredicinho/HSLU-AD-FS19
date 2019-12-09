/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW13;

import org.junit.Test.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
/**
 *
 * @author freda
 */
public class QuickSearchTest {
    
    public QuickSearchTest() {
    }

    @Test
    public void testQuickSearch1() {
        String string1 = "HalloWelt";
        String test = "el";
        
        int result = QuickSearch.quickSearch(string1, test);
        assertEquals(6, result);
    }
    
        @Test
    public void testQuickSearch2() {
        String string1 = "";
        String test = "el";
        
        int result = QuickSearch.quickSearch(string1, test);
        assertEquals(-1, result);
    }
    
    @Test
    public void testQuickSearch() {
        String string1 = "slakghjbnalöfgrhbnasfklöjgbfsjklögbvnafjksgbnfskjalögbfhnkslajgb,fklsgbfskljgbf";
        String test = "Hallo";
        
        int result = QuickSearch.quickSearch(string1, test);
        assertEquals(-1, result);
    }
    
    
    
}
