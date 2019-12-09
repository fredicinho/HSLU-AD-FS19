/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW05.ex03;

import java.util.logging.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author freda
 */
public class AdditionTask implements Runnable {
    private volatile Thread runThread;
    private int rangeBegin, rangeEnd;
    private volatile boolean isStopped;
    private static final Logger LOG = LogManager.getLogger(AdditionTask.class);
    private int sum;

    
    public AdditionTask(int rangeBegin, int rangeEnd){
        this.rangeBegin = rangeBegin;
        this.rangeEnd = rangeEnd;
        this.isStopped = false;
    }
    
    public boolean isStopped(){
        return isStopped;
    }
    
    public void stopRequest(){
        this.isStopped = true;
        if (this.runThread != null){
            this.runThread.interrupt();
        }
    }
    
    public int getSum(){
        return this.sum;
    }

    @Override
    public void run() {
        this.runThread = Thread.currentThread();
        
        //Initialisierungsphase
        this.sum = 0;
        
        //Arbeitsphase
            for (int i = this.rangeBegin; i<=this.rangeEnd; i++){
                        sum += i;
                }
            
        //Aufräumphase
        if (isStopped() == false) {
            LOG.info(runThread.getName() + ": SUM of range " + this.rangeBegin + " and " + this.rangeEnd + " --> " + sum);
        } else {
            LOG.info(runThread.getName() + ": interrupted. Sum = " + sum);
        }
        
        }
        
    }
    

