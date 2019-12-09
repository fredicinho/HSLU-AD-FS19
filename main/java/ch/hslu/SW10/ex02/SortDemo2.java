/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW10.ex02;

import java.util.concurrent.ForkJoinPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author freda
 */
public class SortDemo2 {
    private static final Logger LOG = LogManager.getLogger(SortDemo2.class);

    public static void main(final String args[]) throws InterruptedException {

        LOG.info("initialize array");

        char myCharArray[] = mergeSort.randomChars(200000);

        LOG.info("Initialisiere Forkjoin pool");
        final ForkJoinPool forkPool = new ForkJoinPool();
        final QuickSort SortTask = new QuickSort(myCharArray,0,myCharArray.length - 1); //<-- Konstruktor Array mitgeben

        // Zeitmessung
        long start;
        long end;
        // char myCharArray2[] = myCharArray.clone();
        LOG.info("Start Processing");
        LOG.info("Teste MergeSort paralellisiert");
        // Startzeit
        start = System.nanoTime();

        forkPool.invoke(SortTask); //<-- Der Pool führt die Compute Methode aus, und diese führt den QUickInsertion Sort aus
        // Invoke ist blockierend!
        // Sort.quickInsertionSort(myCharArray, 0, myCharArray.length - 1);
        end = System.nanoTime();
        LOG.info("MergeSort parallel  Took: " + ((end - start) / 1000000) + "ms to sort a random Array.");

        LOG.info("Done.");
        
        SortDemo.printArray(myCharArray);
        

    }

    public static void printArray(char[] cArray) {

        for (int i = 0; i < cArray.length; i++) {
            LOG.info(cArray[i]);
        }
    }
    
}
