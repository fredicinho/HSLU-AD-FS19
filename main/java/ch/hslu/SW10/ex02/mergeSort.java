/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW10.ex02;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.RecursiveAction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author freda
 */
public class mergeSort extends RecursiveAction{
    
    private static final Logger LOG = LogManager.getLogger(mergeSort.class);
    private char[] charArray;
    private final int min;
    private final int max;
    private Random random;
    

    private static final int THRESHOLD = 1000000;

    //Hier handelt es sich um einen Mergesort der parallelisiert ausgeführt wird!
    
    public mergeSort(final char[] charArray, int min, int max) {
        this.charArray = charArray;
        this.min = min;
        this.max = max;
    }
    
    //Seq. Sort (Schwellwert unter Treshold
    private void sortSequentiell(final int min, final int max) {
        //LOG.debug("Seq Sort gestartet (r)");
        Arrays.sort(charArray, min, max);
    }
    
    
    private void merge(int min, int mid, int max){
        char[] buf = Arrays.copyOfRange(charArray, min, mid);
        int i = 0;
        int j = min;
        int k = mid;
        
        while (i < buf.length){
            if (k == max || buf[i] < charArray[k]){
                charArray[j] = buf[i];
                i++;
            } else {
                charArray[j] = charArray[k];
                k++;
            }
            j++;
        }
    }

    @Override
    protected void compute() {
        //Wenn die Anzahl Elemente <= dem Threshold sind, wird sequentiell sortiert (bzw. mit Array.sort!
        if ((max-min) <= THRESHOLD){
            sortSequentiell(min, max);
        } else {
            // da Anzahl Elemente grösser dem Threshold sind, wird die Aufgabe gesplitet!
            final int mid = min + (max-min)/2;
            mergeSort sort1 = new mergeSort(charArray, mid, max);
            mergeSort sort2 = new mergeSort(charArray, min, mid);
            invokeAll(sort1, sort2);
            merge(min, mid, max);
        }
    }
    
    //Create Random Size Char Array
    public static char[] randomChars(final int length) {

        char myCharArray[] = new char[length];
        Random r = new Random();

        // Array befüllen
        for (int i = 0; i < length; i++) {
            myCharArray[i] = (char) (r.nextInt(26) + 97);
        }
        return myCharArray;

    }
    
    
    
}
