/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW07.ex01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author freda
 */
public class DemoArrayBlockingQueue {
     private static final Logger LOG = LogManager.getLogger(DemoArrayBlockingQueue.class);
    
     
     public static void main(String[] args) throws InterruptedException{
         LOG.info("Initialisiere die ArrayBlockingQueue");
         ArrayBlockingQueue<Integer> myBuffer = new ArrayBlockingQueue<>(50);
         Thread thread = new Thread();
         
         Random random = new Random();
         final int mCons = 3;
         final int nProd = 3;
         final Producer[] producers = new Producer[nProd];
         final Consumer[] consumers = new Consumer[mCons];

         List<Future<Integer>> futures = new ArrayList<>();

        ExecutorService executor = Executors.newCachedThreadPool();
         

         
         double currentTime = System.currentTimeMillis();
         
         for (int i = 0; i < nProd; i++) {
            producers[i] = new Producer(myBuffer, 10000);
            futures.add(executor.submit(producers[i]));
            
             
         }
         
         
         for (int i = 0; i < mCons; i++){
             consumers[i] = new Consumer(myBuffer);
             futures.add(executor.submit(consumers[i]));
         }
         
         for (Future<Integer> f : futures){
             try {
             f.get();
             } catch(ExecutionException ex){
                 ex.printStackTrace();
             }
         }
         
         executor.shutdown();

        int sumPros = 0;
        for (int i = 0; i < nProd; i++) {
            sumPros += producers[i].getSum();
        }
        
        int sumCons = 0;
        for (int i = 0; i < mCons; i++) {
            sumCons += consumers[i].getSum();
        }
        double currentTime2 = System.currentTimeMillis();
        
        LOG.info(sumPros + " = " + sumCons);
        LOG.info("Zeitdauer: " + (currentTime2 - currentTime));
        
         
     }
}
