/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW09.ex4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.lang.ArrayUtils;

/**
 *
 * @author freda
 */
public class FixedSizeHeap implements IntegerHeap {

    private static final Logger LOG = LogManager.getLogger(FixedSizeHeap.class);

    int[] heapData;
    int maxSize;
    int counter;

    public FixedSizeHeap(int maxSize) {
        this.heapData = new int[maxSize];
        this.maxSize = maxSize;
        this.counter = 0;
    }

    public int[] getHeapData() {
        return this.heapData;
    }

    public int getMaxSize() {
        return this.maxSize;
    }

    public boolean isFull() {
        return this.counter == this.maxSize;
    }

    public boolean isEmpty() {
        return this.counter == 0;
    }

    public int getLast() {
        return this.heapData[counter - 1];
    }

    @Override
    public int getMax() {
        int maxValue = heapData[0];
        //Blatt unten rechts zur Wurzel machen
        this.heapData[0] = this.heapData[counter - 1];
        ArrayUtils.remove(heapData, counter - 1);
        counter--;
        reorganizeMax(0);
        return maxValue;
    }

    public boolean remove(int index) {
        if (index >= counter) {
            LOG.info("Es gibt kein Element mit diesem Index! Es kann nichts entfernt werden!");
            return false;
        } else {
            try {
                ArrayUtils.remove(this.heapData, index);
                reorganizeMax(index);
                counter--;
            } catch (Exception ex) {
                LOG.info("Beim entfernen des Objektes entstand ein Fehler!");
                return false;
            }
            return true;

        }
    }

    @Override
    public void insert(int value) {
        if (this.isFull()) {
            // Heap ist voll! 
            LOG.error("Heap ist voll! Element kann nicht eingefügt werden");
        }

        this.heapData[counter] = value;
        this.reorganize(counter);
        counter++;

    }

    public void reorganize(int index) {
        //Wenn counter < 1 ist, muss nicht reorganisiert werden
        if (counter < 1) {
            LOG.info("Es muss nichts reorganisiert werden!");
        } else {
            //Prüfen ob der Vater kleiner ist als der Sohn. Falls ja, tauschen!
            int parentIndex = (index - (int) 1) / (int) 2;
            if (this.heapData[index] > this.heapData[parentIndex]) {
                int tmpParent = this.heapData[parentIndex];
                this.heapData[parentIndex] = this.heapData[index];
                this.heapData[index] = tmpParent;
                reorganize(parentIndex);
            }

            LOG.info("Es wurde reorganisiert!");
        }
    }

    public void reorganizeMax(int index) {
        //Hilfsattribute
        boolean terminateLeft = false;
        boolean terminateRight = false;

        //Wenn index grösser als Counter, muss nichts getauscht werden
        if (index >= counter) {
            LOG.info("Es gibt nichts zu switchen da index > " + this.counter);

        } else {
            //Formel um den Vater zu finden
            int rightChildIndex = ((int) 2 * (index + (int) 1));

            if (rightChildIndex >= counter) {
                terminateRight = true;
            }

            int leftChildIndex = ((int) 2 * index) + (int) 1;

            if (leftChildIndex >= counter) {
                terminateLeft = true;
            }
            // Den rechten Ast durchgehen und dementsprechend austauschen
            if (this.heapData[index] <= this.heapData[rightChildIndex]) {
                if (terminateRight) {
                    //Falls TerminateFlag gesetzt wurde, abbrechen (kein Kind mehr vorhanden)
                    LOG.info("TerminateRightFlag wurde gesetzt. Abbruch");
                } else {
                    int tmpVater = heapData[index];
                    this.heapData[index] = this.heapData[rightChildIndex];
                    this.heapData[rightChildIndex] = tmpVater;
                    // Jetzt rekursiv nochmal reorganisieren
                    reorganizeMax(rightChildIndex);
                }

            }
            // Jetzt noch den linken Ast durchgehen
            if (this.heapData[index] <= this.heapData[leftChildIndex]) {
                if (terminateLeft) {
                    LOG.info("TerminateLeftFlax wurde gesetzt. Abbruch");
                } else {
                    int tmpVater = this.heapData[index];
                    this.heapData[index] = this.heapData[leftChildIndex];
                    this.heapData[leftChildIndex] = tmpVater;
                    // Jetzt rekursiv nochmal reorganisieren
                    reorganizeMax(leftChildIndex);

                }
            }

        }

    }

}
