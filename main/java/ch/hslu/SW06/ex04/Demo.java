/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW06.ex04;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author freda
 */
public class Demo {
        private static final Logger LOG = LogManager.getLogger(Demo.class);

    
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        final int nPros = 3;
        final Producer[] producers = new Producer[nPros];
        final ThreadGroup prosGroup = new ThreadGroup("Producer-Threads");
        final int mCons = 2;
        final Consumer[] consumers = new Consumer[mCons];
        final ThreadGroup consGroup = new ThreadGroup("Consumer-Threads");
        final BoundedBuffer<Integer> queue = new BoundedBuffer<>(50);
        for (int i = 0; i < nPros; i++) {
            producers[i] = new Producer(queue, random.nextInt(10000));
            new Thread(prosGroup, producers[i], "Prod  " + (char) (i + 65)).start();
        }
        for (int i = 0; i < mCons; i++) {
            consumers[i] = new Consumer(queue);
            new Thread(consGroup, consumers[i], "Cons " + (char) (i + 65)).start();
        }
        
                while (prosGroup.activeCount() > 0) {
            Thread.yield();
        }
        TimeUnit.MILLISECONDS.sleep(100);
        consGroup.interrupt();
        int sumPros = 0;
        for (int i = 0; i < nPros; i++) {
            LOG.info("Prod " + (char) (i + 65) + " = " + producers[i].getSum());
            sumPros += producers[i].getSum();
        }
        int sumCons = 0;
        for (int i = 0; i < mCons; i++) {
            LOG.info("Cons " + (char) (i + 65) + " = " + consumers[i].getSum());
            sumCons += consumers[i].getSum();
        }
        LOG.info(sumPros + " = " + sumCons);
        
    }
    
}
