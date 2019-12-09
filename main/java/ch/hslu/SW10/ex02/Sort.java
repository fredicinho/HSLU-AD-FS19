/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW10.ex02;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.RecursiveAction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Offers some static methods for sorting Arrays.
 *
 * @author Dave
 */
public class Sort extends RecursiveAction {

    private static final Logger LOG = LogManager.getLogger(Sort.class);
    private char[] charArray;
    private final int min;
    private final int max;
    

    private static final int THRESHOLD = 1000000;

    public Sort(final char[] charArray, int min, int max) {
        this.charArray = charArray;
        this.min = min;
        this.max = max;
    }


    //Seq. Sort (Schwellwert unter Treshold
    private void sortSequentiell(final int min, final int max) {
        //LOG.debug("Seq Sort gestartet (r)");
        Arrays.sort(charArray, min, max);
    }

    //insertionSort2
    /**
     * Sortiert das int‐Array aufsteigend, erst ab Index a[1]. --> Neu so dass
     * ab Index 0 sortiert wird
     *
     * @param a Zu sortierendes Array.
     */
    public static void insertionSort2(final int[] array) {
        int elt;
        int j;
        for (int index = 1; index < (array.length); index++) {
            elt = array[index]; // next elt for insert
            j = index; // array[0]..array[j‐1] already sorted
            while (j > 0 && array[j - 1] > elt) {
                array[j] = array[j - 1]; // shift right
                j--; // go further left
            }
            array[j] = elt; // insert elt
        } // array[0]...array[j] sorted
    }

    //insertionSort2
    /**
     * Sortiert das int‐Array aufsteigend, erst ab Index a[1]. --> Neu so dass
     * ab Index 0 sortiert wird
     *
     * @param a Zu sortierendes Array.
     */
    public void insertionSort2(final char[] array, int left, int right) {
        char elt;
        int j;
        for (int index = left; index < right; index++) {
            elt = array[index]; // next elt for insert
            j = index; // array[0]..array[j‐1] already sorted
            while (j > 0 && array[j - 1] > elt) {
                array[j] = array[j - 1]; // shift right
                j--; // go further left
            }
            array[j] = elt; // insert elt
        } // array[0]...array[j] sorted
    }

    //Quicksort
    public final void quickSort1(final char[] a, final int left, final int right) {
        int up = left; // linke Grenze
        int down = right - 1; // rechte Grenze (ohne Trennelement)
        char t = a[right]; // rechtes Element als Trennelement
        boolean allChecked = false;
        do {
            while (a[up] < t) {
                up++; // suche grösseres (>=) Element von links an
            }
            while ((a[down] >= t) && (down > up)) {
                down--; // suche echt kleineres(<) Element von rechts an
            }
            if (down > up) { // solange keine Überschneidung
                exchange(a, up, down);
                up++;
                down--; // linke und rechte Grenze verschieben
            } else {
                allChecked = true; // Austauschen beendet
            }
        } while (!allChecked);
        exchange(a, up, right); // Trennelement an endgültige Position (a[up])
        if (left < (up - 1)) {
            quickSort1(a, left, (up - 1)); // linke Hälfte
        }
        if ((up + 1) < right) {
            quickSort1(a, (up + 1), right); // rechte Hälfte, ohne T’Elt.
        }
    }

    //Quicksort without left and right
    public final void quickSort2(final char[] a) { //1,5,100

        //Challenge: define left and right
        int up = 0; // linke Grenze
        int down = (a.length - 1); // rechte Grenze (ohne Trennelement)
        char t = a[down]; // rechtes Element als Trennelement
        boolean allChecked = false;
        do {
            while (a[up] < t) {
                up++; // suche grösseres (>=) Element von links an
            }
            while ((a[down] >= t) && (down > up)) {
                down--; // suche echt kleineres(<) Element von rechts an
            }
            if (down > up) { // solange keine Überschneidung
                exchange(a, up, down);
                up++;
                down--; // linke und rechte Grenze verschieben
            } else {
                allChecked = true; // Austauschen beendet
            }
        } while (!allChecked);
        exchange(a, up, (a.length - 1)); // Trennelement an endgültige Position (a[up])

        //jetzt: Statt links und rechts zu übergegebn, übergeben wir einfach ein linkes und ein rechtes array
        if (0 < (up - 1)) { //<- dieser vergleich ist nur da um zu schauen ob es mehr als 2 elemente übrig sind
            quickSort1(a, 0, (up - 1)); // linke Hälfte

        }
        if ((up + 1) < a.length - 1) {
            //Rechts: Start bei Trenn+1, Ende bei a.lenght
            quickSort1(a, (up + 1), (a.length - 1)); // rechte Hälfte, ohne T’Elt.
        }
    }

    //Create Random Size Char Array
    public static char[] randomChars(final int length) {

        char myCharArray[] = new char[length];
        Random r = new Random();

        // Array befüllen
        for (int i = 0; i < length; i++) {
            myCharArray[i] = (char) (r.nextInt(26) + 97);
            //System.out.print(myCharArray[i]);
        }
        return myCharArray;

    }

    /**
     * Sortiert Teilfolgen n M mit Insertion Sort zu Ende. @param a Array @
     *
     * @param a Array
     * @param left Linke Grenze
     * @param right Rechte Grenze
     */
    public void quickInsertionSort(final char[] a, int left, int right) {
        int M = 25;
        int up = left; // linke Grenze
        int down = right - 1; // rechte Grenze (ohne Trennelement)
        char t = a[right]; // rechtes Element als Trennelement
        boolean allChecked = false;
        do {
            while (a[up] < t) {
                up++; // suche grösseres (>=) Element von links an
            }
            while ((a[down] >= t) && (down > up)) {
                down--; // suche echt kleineres(<) Element von rechts an
            }
            if (down > up) { // solange keine Überschneidung
                exchange(a, up, down);
                up++;
                down--; // linke und rechte Grenze verschieben
            } else {
                allChecked = true; // Austauschen beendet
            }
        } while (!allChecked);
        exchange(a, up, right); // Trennelement an endgültige Position (a[up])
        if (left < (up - 1)) {
            //n<M prüfen
            if (((up - 1) - left) < M) {
                // LOG.debug("Choose InsertionSort (n = " + ((up - 1) - left) + ")");
                insertionSort2(a, left, (up - 1));
            } else {
                //LOG.debug("Choose Quicksort (n = " + ((up - 1) - left) + ")");
                quickInsertionSort(a, left, (up - 1));
                //quickSort1(a, left, (up - 1)); // linke Hälfte
            }
        }
        if ((up + 1) < right) {
            if ((right - (up + 1)) < M) {
                // LOG.debug("Choose InsertionSort (n = " + (right - (up + 1)) + ")");

                insertionSort2(a, (up + 1), right);
            } else {
                //LOG.debug("Choose Quicksort (n = " + (right - (up + 1)) + ")");
                quickInsertionSort(a, (up + 1), right);
                //quickSort1(a, (up + 1), right); // rechte Hälfte, ohne T’Elt.
            }
        }
    }

    //Hilfsmethode Exchange
    /**
     * Vertauscht zwei bestimmte Zeichen im Array.
     *
     * @param a Zeichen-Array
     * @param firstIndex Index des ersten Zeichens
     * @param secondIndex Index des zweiten Zeichens
     */
    private void exchange(final char[] a,
            final int firstIndex,
            final int secondIndex) {
        char tmp;
        tmp = a[firstIndex];
        a[firstIndex] = a[secondIndex];
        a[secondIndex] = tmp;
    }

    @Override
    protected void compute() {
        //Definition des RecursiveAction Tasks für QuickinsertionTask
        if ((max - min) <= THRESHOLD) {
            sortSequentiell(min, max);
           // LOG.debug("Seq Sort gestartet");
        } else {
           // LOG.debug("Fork Split");

            final int mid = min + (max - min) / 2;
            invokeAll(
                    new Sort(charArray, min, mid),
                    new Sort(charArray, mid, max)
            );
            merge(min, mid, max);
        }
    }

    private void merge(final int min, final int mid, final int max) {
       // LOG.debug("Merge started");
        char[] buf = Arrays.copyOfRange(charArray, min, mid);
        int i = 0;
        int j = min;
        int k = mid;
        while (i < buf.length) {
            if (k == max || buf[i] < charArray[k]) {
                charArray[j] = buf[i];
                i++;
            } else {
                charArray[j] = charArray[k];
                k++;
            }
            j++;
        }
    }
}
