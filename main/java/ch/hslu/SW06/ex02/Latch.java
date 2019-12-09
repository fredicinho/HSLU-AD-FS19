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
package ch.hslu.SW06.ex02;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Eine Synchronisationshilfe, die es ermöglicht, einen oder mehrere Threads warten zu lassen, bis
 * diese durch andere Threads aufgeweckt werden. Latches sperren so lange, bis sie einmal ausgelöst
 * werden. Danach sind sie frei passierbar.
 */
public class Latch implements Synch {
    private static final Logger LOG = LogManager.getLogger(Latch.class);
    
    private int timeout;
    private volatile boolean locked;
    
    public Latch(){
        this.locked = true;
        this.timeout = 0;
    }
    @Override
    public void acquire() throws InterruptedException {
        if (timeout > 0){
            try {
                LOG.info("Verzögerter Rennstart um :" + timeout/1000 + " Sekungen!");
                Thread.sleep(timeout);
            } catch (InterruptedException ex){
                LOG.info("Timeout wurde interrupted.");
            }
        }
        synchronized (this) {
            try {
            while(locked){
                LOG.debug("Start acquiring (wait)");
                this.wait();
                LOG.debug("Acquiring successfull (go)");
            }
            } catch (InterruptedException ex){
                LOG.error("Interrupt Latch: Start wurde abgebrochen");
                throw new InterruptedException();
            }
        }
    }

    @Override
    public void release() {
        locked = false;
        synchronized (this){
            this.notifyAll();
            LOG.debug("Released Horse");
        }

    }
}
