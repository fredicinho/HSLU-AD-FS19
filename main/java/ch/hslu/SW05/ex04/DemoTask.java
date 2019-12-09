/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW05.ex04;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.logging.log4j.LogManager;

/**
 *
 * @author freda
 */
public class DemoTask implements Runnable {

    private static final org.apache.logging.log4j.Logger LOG = LogManager.getLogger(DemoTask.class);

    private volatile Thread runThread;
    private long sleeptime;
    private Thread thread2join = null;
    private volatile boolean isStopped = false;

    public DemoTask(long sleeptime, Thread thread2join) {
        this.sleeptime = sleeptime;
        this.thread2join = thread2join;
    }
    
    public void stopRequest() {
        isStopped = true;
        if (runThread != null) {
            runThread.interrupt();
        }
    }
    
    public boolean isStopped() {
        return isStopped;
    }
    @Override
    public void run() {
                this.runThread = Thread.currentThread();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(DemoTask.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        LOG.debug("Thread gestartet");
        if (thread2join == null) {
            LOG.debug("[" + runThread.getName() + "]NextThread:(null)");

        } else {
            LOG.debug("[" + runThread.getName() + "]NextThread:(" + thread2join.getName() + ")");
        }

        //Intialisierungsphase
        this.runThread = Thread.currentThread();
        //join thread
        if (thread2join != null) {
            LOG.info("[" + runThread.getName() + "]Wait for Thread join(" + thread2join.getName() + ")");
            try {
                thread2join.join();
                LOG.info("[" + runThread.getName() + "]Thread hat (" + thread2join.getName() + ") gejoint");

            } catch (InterruptedException ex) {
                Logger.getLogger(DemoTask.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        //sleep
        if (sleeptime != 0) {
            LOG.info("[" + runThread.getName() + "]Sleep initialized(" + sleeptime + ")");

            try {
                Thread.sleep(sleeptime);
            } catch (InterruptedException ex) {
                LOG.info(("Fehler bei threadsleep"));
                Logger.getLogger(DemoTask.class.getName()).log(Level.SEVERE, null, ex);
            }
        } //Falls es keine sleeptime gibt -> immediate start (whatever)
        else {
            LOG.debug("[" + runThread.getName() + "]Nothing to wait/join");

            LOG.info("Immediate start");
        }
        LOG.warn("[" + runThread.getName() + "]Thread done.");

    }
}
