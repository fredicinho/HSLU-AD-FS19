/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW13;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author freda
 */
public class DemoQuickSearch {
    private static final Logger LOG = LogManager.getLogger(DemoQuickSearch.class);

    
    public static void main(String[] args){
        String search = "assnoghjblaöhblöbgggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg";
        String string1 = "Kuchen";
        LOG.info("Testfall Nr.1: String " + string1 + " wird gesucht!");
        long start = System.currentTimeMillis();
        int result = QuickSearch.quickSearch(string1, search);
        long ende = System.currentTimeMillis();
        
        long time = ende - start;
        
        LOG.info("Das Resultat lautet: " + result);
        LOG.info("Benötigte Zeit in MilliSekunden: " + time);
        
        
        
        
        
        
    }
    
}
