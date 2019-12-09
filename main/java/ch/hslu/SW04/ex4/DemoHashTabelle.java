/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW04.ex4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author freda
 */
public class DemoHashTabelle {
    private static final Logger LOG = LogManager.getLogger(HashTabelle.class);
    
    public static void main(String[] args){
        HashTabelle h1 = new HashTabelle(10);
        Allocation a1 = new Allocation(1, 2);
        Allocation a2 = new Allocation(2, 2);
        Allocation a3 = new Allocation(3, 4);
        Allocation a4 = new Allocation(4, 5);
        Allocation a5 = new Allocation(5, 6);
        Allocation a6 = new Allocation(6, 7);
        Allocation a7 = new Allocation(7, 8);
        
        h1.insertElement(a1);
        h1.insertElement(a2);
        h1.insertElement(a3);
        h1.insertElement(a4);
        h1.insertElement(a5);
        h1.insertElement(a6);
        h1.insertElement(a7);
        
        h1.remove(a7);
        h1.remove(a1);
        
        LOG.info(h1.toString());
        
        
    }
    
}
