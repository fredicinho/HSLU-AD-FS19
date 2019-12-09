/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW06.ex04;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author freda
 */
public class BoundedBuffer<T> {
    
    private static final Logger LOG = LogManager.getLogger(BoundedBuffer.class);

    private final Object[] data;
    private int head, tail, count, maxSize;
    
    public BoundedBuffer(int maxSize){
        this.maxSize = maxSize;
        data = new Object[maxSize];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }
    

    public synchronized <T> void put(final T elem) throws InterruptedException {
        LOG.info("Element wird eingefügt");
        while (count == data.length){
            LOG.info("Buffer ist voll. Warte auf freien Platz.");
            this.wait();
        }
        LOG.info("Platz im Buffer ist jetzt frei");
        
        count++;
        data[tail] = elem;
        
        tail = (tail + 1) % data.length;
        
        if (count == 1){
            this.notifyAll(); // Wenn ein Element in den Buffer eingefügt wurde benachrichtigen, dass eines nun entnommen werden kann!
        }
    }
    
    public synchronized <T> boolean put(final T elem, int waitTime) throws InterruptedException {
        LOG.info("Element wird mit Wartezeit von " + waitTime + " in den Buffer eingefügt");
        while (count == data.length){
            this.wait(waitTime);
            if (count == data.length){
                return false;
            }
        }
        
        count++;
        data[tail] = elem;
        tail = (tail + 1) % data.length;
        if (count == 1){
            this.notifyAll(); // Wenn ein Element in den Buffer eingefügt wurde benachrichtigen, dass eines nun entnommen werden kann!
        }
        return true;
    }
    
    public synchronized <T> T get() throws InterruptedException {
        LOG.info("Es wird versucht ein Element zu entnehmen");
        while (count == 0){
            LOG.info("Buffer ist leer!");
            this.wait();
        }
        
        LOG.info("Es kann ein Element entnommen werden!");
        
        count--;
        T elem;
        elem = (T) data[head];
        data[head] = null;
        
        head = (head + 1) % data.length;
        
        if (count == data.length - 1){
            this.notifyAll(); // Wenn ein Element aus einem vollen Buffer entnommen wurde, Threads benachrichtigen dass ein Platz frei wurde!
        }
        
        return elem;
        
    }
    
    public synchronized <T> T get(int waitTime) throws InterruptedException {
        while (count == 0){
            this.wait(waitTime);
            if (count == 0){
                return null;
            }
        }
        
        count--;
        T obj = (T) data[head];
        data[head] = null;
        head = (head + 1) % data.length;
        
        if (count == data.length - 1){
            this.notifyAll();
        }
        
        return obj;
    }
    
    /**
     * Gibt das Erste Element (im Kopf) zurück. Es wird dabei aber NICHT vom Buffer gelöscht!
     * @param <T>
     * @return T First-Element
     * @throws InterruptedException 
     */
    public synchronized <T> T first() throws InterruptedException {
        while (count == 0) {
            this.wait();
        } 
            
        T obj = (T) data[head];
        return obj;
    }
    
    /**
     * Gibt das letzte Element (am Schwanz) zurück. Dabei wird das Element NICHT vom Buffer entfernt!
     * @param <T>
     * @return
     * @throws InterruptedException 
     */
    public synchronized <T> T last() throws InterruptedException {
        while (count == 0){
            this.wait();
        }
        
        if (tail == 0){
            T obj = (T) data[data.length - 1];
            return obj;
        } else {
            T obj = (T) data[tail - 1];
            return obj;
        }
    }
    
    
    public synchronized boolean empty(){
        return (count == 0);
    }
    
    public synchronized boolean full(){
        return (count == maxSize);
    }
    
    public synchronized int size(){
        return count;
    }
    
    
    
}
