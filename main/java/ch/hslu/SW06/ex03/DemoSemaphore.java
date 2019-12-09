/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW06.ex03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author freda
 */
public class DemoSemaphore {
        private static final Logger LOG = LogManager.getLogger(DemoSemaphore.class);
    static final Semaphore sema = new Semaphore(0, 70);
    static long sum = 0;

    public static void main(final String args[]) throws InterruptedException {

        LOG.info("***start***");

        LOG.info("initialisiere Semaphor (permits: 0 | limit 1");
        //Example Thread
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 10000; i++) {
                sum += i;
            }
            LOG.info("calc finished, notifing...");
            sema.release();
        });

        //Example thread
        Thread t2 = new Thread(() -> {
            LOG.info("wait for result...");
            try {
                sema.acquire();
            } catch (InterruptedException e) {
                return;
            }
            LOG.info("sum = " + sum);
        });

       LOG.info("Starte Thread 1");
        t1.start();

        LOG.info("Starte Thread 2");
        t2.start();
        
       
        //Ein paar Threads mehr starten
        Thread[] multithread1 = new Thread[30];
        Thread[] multithread2 = new Thread[30];

        for (int i = 0; i < 30; i++) {
            multithread1[i] = t1;
            multithread2[i] = t2;
        }
        
        for(Thread thr1 : multithread1){
            thr1.start();
            for(Thread thr2 : multithread2){
                thr2.start();
            }
        }
    }
}
