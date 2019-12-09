/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW10.ex02;

import java.util.concurrent.RecursiveAction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author freda
 */
public class QuickSort extends RecursiveAction {

    private static final Logger LOG = LogManager.getLogger(Sort.class);
    private char[] charArray;
    private final int min;
    private final int max;

    private static final int THRESHOLD = 200000;

    public QuickSort(char[] charArray, int min, int max) {
        this.charArray = charArray;
        this.min = min;
        this.max = max;

    }

    /**
     * Vertauscht zwei bestimmte Zeichen im Array
     *
     * @param a Zeichen-Array
     * @param firstIndex Index des ersten Zeichens
     * @param secondIndex Index des zweiten Zeichens
     */
    private static final void exchange(final char[] a, final int firstIndex, final int secondIndex) {
        char tmp;

        tmp = a[firstIndex];
        a[firstIndex] = a[secondIndex];
        a[secondIndex] = tmp;

    }

    public static void arrayKoppieren(final char[] a, final char[] b) {

        System.arraycopy(a, 0, b, 0, a.length);
    }

    public static void insertionSort4(final char[] a, final int firstIndex, final int lastIndex) {
        char elt;
        int j;
        for (int i = firstIndex; i < lastIndex; i++) {
            elt = a[i];
            j = i;
            while (0 < j && a[j - 1] > elt) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = elt;

        }

    }
    
    public static int partition(char[] charArray, int left, int right){
        int up = left;              //linke Grenze
        int down = right - 1;       //rechte Grenze (ohne Trennelement
        char t = charArray[right];          //rechtes Element als Trennelement
        boolean allChecked = false;

        do {
            while (charArray[up] < t) {
                up++;               //Suche grösseres Element von t von links an
            }
            while (charArray[down] >= t && (down > up)) {
                down--;             // suche echt kleineres Element von t von recht an
            }

            if (down > up) {
                exchange(charArray, up, down);  //Elemente tauschen
                up++;                   //linke und rechte Seite verschieben
                down--;
            } else {
                allChecked = true;
            }

        } while (!allChecked);
        
        exchange(charArray, up, right);  
        return up;
        
    }

    @Override
    protected void compute() {
        //Wenn die Anzahl Elemente <= dem Threshold sind, wird mit InsertionSort sortiert
        if ((max - min) <= THRESHOLD) {
            insertionSort4(charArray, min, max);
        } else {
            // da Anzahl Elemente grösser dem Threshold sind, wird die Aufgabe gesplitet (mit quicksort)!
            int pivotIndex = partition(charArray, min, max);
            QuickSort s1 = new QuickSort(charArray, min, pivotIndex - 1);
            QuickSort s2 = new QuickSort(charArray, pivotIndex + 1, max);
            invokeAll(s1, s2);
        }
    }

}
