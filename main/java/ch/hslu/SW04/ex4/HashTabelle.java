/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW04.ex4;


import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author freda
 */
public class HashTabelle implements HashTable {
    private static final Logger LOG = LogManager.getLogger(HashTabelle.class);
    private Node[] hashArray;
    private int size;
    
    public HashTabelle(int size){
        this.hashArray = new Node[size];
        this.size = 0;
    }

    @Override
    public boolean search(Allocation a) {
        if (this.size == 0){
            return false;
        } else {
            Node b = this.hashArray[getIndex(a)];
            while (!a.equals(b.getData())){
                if (b.getData() == null){
                    LOG.info("Element wurde nicht gefunden, obwohl der Index überprüft wurde");
                    return false;
                }
                b = b.getNext();
            }
           
            return true;
        }
    }

    @Override
    public void insertElement(Allocation a) {
        // Wenn kein Element im Index vorhanden ist, wird dieses eingefügt!
        if (this.hashArray[this.getIndex(a)] == null){
        this.hashArray[this.getIndex(a)] = new Node(a);
        LOG.info("Element wurde mit einem neuen Node hinzugefügt.");
        this.size++;
        
        // Für diesen Index ist bereits ein Element vorhanden. Es wird an das Ende der Liste eingefügt.
        } else {
            Node b = this.hashArray[this.getIndex(a)];
            while (b.getNext() != null){
                b = b.getNext();
            }
            b.setNext(new Node(a));
            LOG.info("Element wurde am Ende der Liste hinzugefügt.");
            this.size++;
        }
    }

    @Override
    public boolean remove(Allocation a) {
        //Approach1: nur 1 Element oder das erste = das gescuhte -> nullen
        if (a.equals(this.hashArray[getIndex(a)].getData())) {
            LOG.info("Element wurde entfernt. Es befand sich am Anfang der Liste");
            this.hashArray[getIndex(a)] = this.hashArray[getIndex(a)].getNext();
            this.size--;
            return true;
        }

        //Approach2: mehrere Elemente -> setNext auf übernächsten setzen
        if (this.hashArray[getIndex(a)].getNext() != null) {
            //iterieren
            int iterationcount = 1;
            Node nodeIterator = this.hashArray[getIndex(a)];
            while (nodeIterator.getNext() != null) {
                LOG.debug("[remove-Iterator] - has Next");
                if (nodeIterator.getNext().getData().equals(a)) {
                    LOG.warn("Element wurde gefunden und entfernt");
                    //do the magix
                    nodeIterator.setNext(nodeIterator.getNext().getNext());
                    this.size--;
                    return true;
                }
                nodeIterator = nodeIterator.getNext();
                iterationcount++;
            }
        }
        LOG.debug("[remove]Kein Fund - Nichts zu entfernen...");
        return false;
        
    }

    public Node[] getHashArray() {
        return this.hashArray;
    }

    public int getSize() {
        return this.size;
    }
    
    //Hilfsfunktion
    public int getIndex(Allocation a){
        return a.hashCode() % this.hashArray.length;
    }
    
    @Override
    public String toString(){
        for (Node a : this.hashArray) {
            if (a != null){
                Node b = a;
                LOG.info(b.getData().toString());
                while (b.getNext() != null){
            LOG.info(b.getData().toString());
            b = b.getNext();
                }
            } else {
                LOG.info("NULL");
            }
            
        }
        return "String Ende!";
    }
    
    
    
    
}
