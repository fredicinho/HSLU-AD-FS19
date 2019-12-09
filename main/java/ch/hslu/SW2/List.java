 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW2;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**
 *
 * @author freda
 */
public class List implements Iterable {
    
    private int anzahlAllocation;
    private Allocation head;
    
    /**
     * Konstruktor der Klasse Liste
     * Klassenvariable definieren: head = null und anzahl Allocation Objekte = 0
     * 
     */
    public List(){
        this.head = null;
        this.anzahlAllocation = 0;
    }
    
    /**
     * Ein Allocation Objekt in die Liste hinzufügen
     * 
     * @param a Allocation Objekt
     */
    public void addAllocation(Allocation a){
        if (this.anzahlAllocation == 0){
            this.head = a;
            this.anzahlAllocation++;
            a.setNext(null);
        } else {
            a.setNext(this.head);
            this.head = a;
            this.anzahlAllocation++;
        }
    }
    
    /**
     * Holt sich das erste Objekt in der Liste (den Header) und entfernt diesen aus der Liste
     * Der neue Header wird durch das darauffolgende Objekt gesetzt. 
     * 
     * @return first Allocation
     */
    public Allocation getAndRemoveFirstAllocation(){
        if (this.head != null){
        Allocation first = this.head;
        this.head = first.getNext();
        this.anzahlAllocation--;
        return first;

        } else {
            return null;
        }
        
    }
    
    /**
     * Überprüft ob ein bestimmtes Objekt in der Liste vorhanden ist
     * 
     * @param a Allocation
     * @return boolean
     */
    public boolean existAllocation(Allocation a){
        Allocation a1 = this.head;
        if (a1.equals(a)){
            return true;
        } 
        
        //Alle Elemente iterieren, solange Next!=null
        while (a1.getNext() != null) {
            if (a1.getNext().equals(a)) {
                return true;
            } else {
                //temp auf die nächste Node setzen
                a1 = a1.getNext();
            }
        }
        //fals nichts gefunden wurde return  == false
        return false;
    }
    
    /**
     * Entfernt ein bestimmtes Allocation Objekt aus der Liste
     * 
     * @param a Allocation
     * 
     */
    public void removeAllocation(Allocation a){
        Allocation a1 = this.head;
        if (a1.equals(a)){
            this.head = a1.getNext();
            this.anzahlAllocation--;
            
        } else {
        
        /**
         * Alle Elemente überprüfen solange != null
         * 1. Fall: Der Head ist das gesuchte Element
         * 2. Fall: Das gesuchte Element ist in der Liste mittendrin
         * 3. Fall: das gesuchte Element ist das letzte Element in der Liste
         * 4. Fall: Das gesuchte Element ist nicht in der Liste vorhanden.
         * Wichtig für UnitTest
         * 
         */
        while (a1.getNext() != null) {
            if (a1.getNext().equals(a)) {
                // Die Referenz des Elementes ändern (von Element 1 auf 3 und Element 2 somit entfernen
                Allocation a2 = a1.getNext();
                a1.setNext(a2.getNext());
                this.anzahlAllocation--;
            } else {
                //Allocation auf das nächste Element in der Liste setzen
                a1 = a1.getNext();
            }
        }
        }
        
        
    }
    /**
     * Gibt die Anzahl Elemente in der Liste zurück
     * 
     * @return int Anzahl Allocation Objekte in der Liste
     */
    public int getAnzahlAllocation(){
        return this.anzahlAllocation;
    }
    
    /**
     * Gib den Head der Liste zurück
     * 
     * @return Allocation Objekt
     */
    public Allocation getHead(){
        return this.head;
    }
    
    //Iterator Methode
    @Override
    public Iterator iterator() {
        return new ListIterator(this);
    }
    
    //private innere Klasse für Iterator
    private class ListIterator implements Iterator {

        private int pointer;
        private final int endpointer;
        private Allocation currentAllocation;
    
        public ListIterator(List list){
            currentAllocation = list.getHead();
            this.pointer = 0;
            this.endpointer = list.getAnzahlAllocation();
        }
        
        
    /**
     * Überprüft ob ein nächstes Objekt in der Liste vorhanden ist.
     * 
     * @return boolean
     */
    @Override
    public boolean hasNext() {
    return this.pointer < this.endpointer;
    }

    /**
     * Gibt das Objekt zurück, auf dem es gerade travesiert und setzt den Counter auf +1
     * @return Objekt auf dem es gerade traversiert
     */
    @Override
    public Allocation next() {
        if(this.hasNext()){
            pointer++;
            Allocation currentData = currentAllocation;
            currentAllocation = currentAllocation.getNext();
            return currentData;
        }
        else
        {
             throw new NoSuchElementException();
        }
    }

        @Override
     public void remove() {
          throw new UnsupportedOperationException();
    }
}
    
}
