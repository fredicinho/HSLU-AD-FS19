/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW09;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author freda
 */
public class DemoSort {

    private static final Logger LOG = LogManager.getLogger(DemoSort.class);

    public static void main(String[] args) {
        
        Sort s1 = new Sort(200_000);
        
        
        
        
        //for(int i = 0; i< s1.getArray().length; i++){
        //LOG.info("Array [" + i + "] = " + s1.getArray()[i] + " und ArrayCopy: " + "[" + i + "] = " + s1.getArrayCopy()[i]);
        //}
        
        long start1 = System.currentTimeMillis();
        Sort.quickInsertionSort(s1.getArray());
        long ende1 = System.currentTimeMillis();
        long time1 = ende1 - start1;
        
        long start2 = System.currentTimeMillis();
        Sort.quickSort(s1.getArrayCopy());
        long ende2 = System.currentTimeMillis();
        long time2 = ende2 - start2;
        
        
        //for(int i = 0; i< s1.getArray().length; i++){
        //LOG.info("Array [" + i + "] = " + s1.getArray()[i] + " und ArrayCopy: " + "[" + i + "] = " + s1.getArrayCopy()[i]);
        //                                                                                   }
        
        LOG.info("Array mit quickInsertionSort (in MiliSekunden): " + time1);
        LOG.info("Array mit quickSort (in MiliSekunden): " + time2);
        
        
    }

}
