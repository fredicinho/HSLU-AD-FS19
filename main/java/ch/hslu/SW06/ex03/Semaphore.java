/*
 * Copyright 2019 Hochschule Luzern - Informatik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.hslu.SW06.ex03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Ein nach oben nicht begrenztes Semaphor, d.h. der Semaphorenzähler kann
 * unendlich wachsen.
 */
public final class Semaphore {
    private static final Logger LOG = LogManager.getLogger(Semaphore.class);

   
    private int limit;
    private int permits;
    private int count; // Anzahl der wartenden Threads.

    /**
     * Erzeugt ein Semaphore mit 0 Passiersignalen.
     */
    public Semaphore() {
        this(0);
    }

    /**
     * Erzeugt ein Semaphore mit einem Initalwert für den Semaphorenzähler.
     *
     * @param permits Anzahl Passiersignale zur Initialisierung.
     * @throws IllegalArgumentException wenn der Initalwert negativ ist.
     */
    public Semaphore(final int permits) throws IllegalArgumentException {
        if (permits < 0) {
            throw new IllegalArgumentException(permits + " < 0");
        }
        this.permits = permits;
        count = 0;
    }

    /**
     * Erzeugt ein nach oben begrenztes Semaphore.
     *
     * @param permits Anzahl Passiersignale zur Initialisierung.
     * @param limit maximale Anzahl der Passiersignale.
     * @throws IllegalArgumentException wenn Argumente ungültige Werte besitzen.
     */
    public Semaphore(final int permits, final int limit) throws IllegalArgumentException {
        if (limit > 0 && permits < limit){
            this.limit = limit;
            this.permits = permits;
            this.count = 0;
        } else {
            throw new IllegalArgumentException();
        }
        LOG.info("Semaphore erfolgreich initialisiert!");
    }

    /**
     * Entspricht dem P() Eintritt (Passieren) in einen synchronisierten
     * Bereich, wobei mitgezählt wird, der wievielte Eintritt es ist. Falls der
     * Zähler null ist wird der Aufrufer blockiert.
     *
     * @throws java.lang.InterruptedException falls das Warten unterbrochen
     * wird.
     */
    public synchronized void acquire() throws InterruptedException {
        while (permits == 0) {
            count++;
            LOG.info("permits: 0");
            this.wait();
            count--;
        }
        LOG.info("Permits--");
        permits--;
    }

    /**
     * Entspricht dem V() Verlassen (Freigeben) eines synchronisierten
     * Bereiches, wobei ebenfalls mitgezählt wird, wie oft der Bereich verlassen
     * wird.
     */
    public synchronized void release() throws IllegalArgumentException {
        if (permits == limit){
            LOG.info("Permits == Limits!");
            throw new IllegalArgumentException();
            
        } else {
        permits++;
        LOG.info("Permits++ and notifyAll()");
        this.notifyAll();
        }
    }

    /**
     * Lesen der Anzahl wartenden Threads.
     *
     * @return Anzahl wartende Threads.
     */
    public synchronized int pending() {
        return count;
    }
    
    /**
     * 
     * 
     * @param permits
     * @throws java.lang.InterruptedException
     */
    
    public synchronized void acquire(int permits) throws InterruptedException {
        LOG.info("Start acquire with multiple permits");
        
        for (int i = 0; i < permits; i++){
            acquire();
        }
        
    }
    
    public synchronized void release(int permits) throws InterruptedException {
        LOG.info("Start release with multiple permits");
        
        for (int i = 0; i < permits; i++){
            release();
        }
    }
}
