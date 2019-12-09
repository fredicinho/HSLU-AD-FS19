/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author freda
 */
public class DemoTask {
    private static final Logger LOG = LogManager.getLogger(DemoTask.class);
    private int task1, task2, task3 = 0;
    
    public DemoTask(){
        
    }
    
    public void task(final int n) throws InterruptedException { 
        task1(); task1(); task1(); task1();     // T ~ 4
        for (int i = 0; i < n; i++) {           // äussere Schleife: n-mal 
            task2(); task2(); task2();          // T ~ n · 3 
            for (int j = 0; j < n; j++) {       // innerer Schleife: n-mal 
                task3(); task3();               // T ~ n · n· 2 } } }
    
            }
        }
    }
    
    public void task1() throws InterruptedException{
        Thread.sleep(1);
        task1++;
        
    }
    
    public void task2() throws InterruptedException{
        Thread.sleep(1);
        task2++;
    }
    
    public void task3() throws InterruptedException{
        Thread.sleep(1);
        task3++;
    }
    
    
    public static void main(String[] args) throws InterruptedException{
        DemoTask demo = new DemoTask();
        
        System.out.println(System.currentTimeMillis());
        demo.task(100);
        System.out.println(System.currentTimeMillis());
        LOG.info("Task 1: " + demo.task1);
        LOG.info("Task 2: " + demo.task2);
        LOG.info("Task 3: " + demo.task3);
        
    }
}
