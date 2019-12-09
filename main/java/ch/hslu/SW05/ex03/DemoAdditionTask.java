/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW05.ex03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author freda
 */
public class DemoAdditionTask {
        private static final Logger LOG = LogManager.getLogger(DemoAdditionTask.class);

    public static void main(String[] args) {
        
        
        
        LOG.info("Start der Demo");
        AdditionTask a1 = new AdditionTask(1,10);
        AdditionTask a2 = new AdditionTask(10,20);
        AdditionTask a3 = new AdditionTask(10, 50);
        AdditionTask a4 = new AdditionTask(50, 100);
        
        Thread t1 = new Thread(a1, "Erster Thread");
        Thread t2 = new Thread(a2, "Zweiter Thread");
        Thread t3 = new Thread(a3, "Dritter Thread");
        Thread t4 = new Thread(a4, "Vierter Thread");
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        
        t1.stop();
        
        
        
        try {
        t2.join();
        t3.join();
        t4.join();
        } catch (InterruptedException ex) {
            LOG.info("Thread wurde unterbrochen: " + ex.getMessage());
        }
        
        LOG.info("Summe von a1: " + a1.getSum());
    }
    
}
