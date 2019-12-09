/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW05.ex04;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author freda
 */
public class JoinandSleep {
    
    
    private static final Logger LOG = LogManager.getLogger(JoinandSleep.class); 

    public static void main(String[] args){
        LOG.info("Thread 3 initialisiert - wait[4000],thread2join[null]");
        DemoTask demoT3 = new DemoTask(4000, null);
        Thread threadT3 = new Thread(demoT3,"ThreadT3");

        LOG.info("Thread 2 initialisiert - wait[3000],thread2join[threadT3]");
        DemoTask demoT2 = new DemoTask(3000, threadT3);
        Thread threadT2 = new Thread(demoT2,"ThreadT2");

        LOG.info("Thread 1 initialisiert - wait[4000],thread2join[threadT2]");
        DemoTask demoT1 = new DemoTask(2000, threadT2);
        Thread threadT1 = new Thread(demoT1,"ThreadT1");

        LOG.info("Thread1 start");
        threadT1.start();
        LOG.info("Thread2 start");
        threadT2.start();
        LOG.info("Thread3 start");
        threadT3.start();
    }
}
