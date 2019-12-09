/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author freda
 */
public class Fibonnaci {
    private static final Logger LOG = LogManager.getLogger(Demo.class);
    
    private int[] fibArray;
    
    public int fiboRec1(final int x){
        if (x <= 0){                      // Rekursionsbasis
            return 0;
        } else if (x == 1) {              // Rekursionsbasis
            return 1;
        } else {
            return fiboRec1(x-1) + fiboRec1(x-2); //Rekursionsvorschrift
        }
    }
    
    public int fiboRec2(final int x){
        int[] fibArray = new int[x];
        fibArray[0] = 0;
        fibArray[1] = 1;
        if (x > 1){
            for(int i = 2; i < x; i++){
                fibArray[i] = fibArray[i-1] + fibArray[i-2];
            }
        }
        for (int z : fibArray){
            LOG.info(z);
        }
        
        return fibArray[x-1] + fibArray[x-2];
    }
    
}
