/*
 * Copyright 2019 Hochschule Luzern Informatik.
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
package ch.hslu.SW07.ex03;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Thread-sicherer Zähler mit AtomicInteger.
 */
public final class AtomicCounter implements Counter {

    private AtomicInteger counter;
    /**
     * Erzeugt einen Zähler mit Zählerstand 0.
     */
    public AtomicCounter() {
        this.counter = new AtomicInteger(0);
        
    }

    /**
     * see ch.hslu.ad.exercise.sw07.count.Counter#increment()
     */
    @Override
    public void increment() {
        this.counter.getAndIncrement();
    }

    /**
     * see ch.hslu.ad.exercise.sw07.count.Counter#decrement()
     */
    @Override
    public void decrement() {
        this.counter.getAndDecrement();
    }

    /**
     * see ch.hslu.ad.exercise.sw07.count.Counter#get()
     */
    @Override
    public int get() {
        return this.counter.get();
    }
}
