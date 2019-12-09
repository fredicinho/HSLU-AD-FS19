/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW09;

import java.util.Random;

/**
 *
 * @author freda
 */
public class Sort {

    private final char[] array;
    private final char[] arrayCopy;
    private final Random r = new Random();

    public Sort(int p) {
        this.array = new char[p];
        this.arrayCopy = new char[p];
        for (int i = 0; i < array.length; i++) {
            array[i] = (char) (r.nextInt(26) + 'a'); //Gibt zufàlligen Buchstaben von a - z aus
        }
        arrayKoppieren(array, arrayCopy);
    }

    public char[] randomChars(final int length) {
        char[] a = new char[length];
        for (int i = 0; i < a.length; i++) {
            a[i] = (char) (r.nextInt(26) + 'a'); //Gibt zufàlligen Buchstaben von a - z aus
        }

        return a;

    }

    public char[] getArray() {
        return this.array;
    }

    public char[] getArrayCopy() {
        return this.arrayCopy;
    }

    public static void insertionSort3(final int[] a) {
        int temp; //temp variable als dummy objekt

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i; j < a.length; j++) {
                if (a[i] > a[j]) {
                    temp = a[i]; //aktuelles a[i] in temp var
                    a[i] = a[j]; //a[i] mit a[j] erstzen (a[j] ist ja kleiner
                    a[j] = temp; // a[j] das alte a[i] zuweisen (ist ja grösser)
                }
            }
        }

    }

    public static void insertionSort2(final int[] a) {
        int elt;
        int j;
        for (int i = 1; i < a.length; i++) {
            elt = a[i];
            j = i;
            while (0 < j && a[j - 1] > elt) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = elt;

        }
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

    public static void selectionSort(final int[] a) {
        int n = a.length;

        //jedes Element im Array passieren
        for (int i = 0; i < n - 1; i++) {
            //das kleinste Element finden
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min_idx]) {
                    min_idx = j;
                }
            }

            // Das kleinste Element mit dem ersten Element austauschen! 
            int temp = a[min_idx];
            a[min_idx] = a[i];
            a[i] = temp;
        }
    }

    public static void bubbleSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    // swap arr[j+1] and arr[i] 
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    public static final void quickSort(final char[] a) {
        Sort.quickSort(a, 0, a.length - 1);
    }

    public static final void quickSort(final char[] a, final int left, final int right) {
        int up = left;              //linke Grenze
        int down = right - 1;       //rechte Grenze (ohne Trennelement
        char t = a[right];          //rechtes Element als Trennelement
        boolean allChecked = false;

        do {
            while (a[up] < t) {
                up++;               //Suche grösseres Element von t von links an
            }
            while (a[down] >= t && (down > up)) {
                down--;             // suche echt kleineres Element von t von recht an
            }

            if (down > up) {
                exchange(a, up, down);  //Elemente tauschen
                up++;                   //linke und rechte Seite verschieben
                down--;
            } else {
                allChecked = true;
            }

        } while (!allChecked);

        exchange(a, up, right);         //Trennelement an endgèltige Position
        if (left < (up - 1)) {
            quickSort(a, left, (up - 1));   // linke Hälfte
        }
        if ((up + 1) < right) {
            quickSort(a, (up + 1), right); // rechte Hälfte, ohne T’Elt
        }
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

    public static void quickInsertionSort(final char[] a, final int left, final int right) {
        int M = 25;
        int up = left;              //linke Grenze
        int down = right - 1;       //rechte Grenze (ohne Trennelement
        char t = a[right];          //rechtes Element als Trennelement
        boolean allChecked = false;

        do {
            while (a[up] < t) {
                up++;               //Suche grösseres Element von t von links an
            }
            while (a[down] >= t && (down > up)) {
                down--;             // suche echt kleineres Element von t von recht an
            }

            if (down > up) {
                exchange(a, up, down);  //Elemente tauschen
                up++;                   //linke und rechte Seite verschieben
                down--;
            } else {
                allChecked = true;
            }

        } while (!allChecked);

        exchange(a, up, right);         //Trennelement an endgèltige Position
        if (left < (up - 1) && (up - 1) - left < M) {  //Wenn zu sortierende Anzahl Elemente <=4, dann mit InsertionSort sortieren, ansonsten mit quickSort
            insertionSort4(a, left, (up - 1));
        } else if (left < (up - 1)) {
            quickSort(a, left, (up - 1));   // linke Hälfte
        }

        if ((up + 1) < right && right - (up + 1) < M) {     //Wenn zu sortierende Anzahl Elemente <= 4, dann mit InserionSort sortieren, ansonsten mit quickSort
            insertionSort4(a, (up + 1), right);
        } else if ((up + 1) < right) {
            quickSort(a, (up + 1), right); // rechte Hälfte, ohne T’Elt
        }
    }

    public static void quickInsertionSort(final char[] a) {
        quickInsertionSort(a, 0, a.length - 1);
    }

    public static void arrayKoppieren(final char[] a, final char[] b) {

        System.arraycopy(a, 0, b, 0, a.length);
    }
}
