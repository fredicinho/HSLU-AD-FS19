/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW08.ex03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author freda
 */
public class DemoSort {
        private static final Logger LOG = LogManager.getLogger(DemoSort.class);
    
    
    public static void main(String[] args){
        Sort s1 = new Sort(10);
        
        for(int i = 0; i< s1.getArray().length; i++){
        LOG.info("Array [" + i + "] = " + s1.getArray()[i]);
        }
        
        Sort.selectionSort(s1.getArray());
        
        for(int i = 0; i< s1.getArray().length; i++){
        LOG.info("Array sortiert: [" + i + "] = " + s1.getArray()[i]);
        }
        
        
    }
    
}
