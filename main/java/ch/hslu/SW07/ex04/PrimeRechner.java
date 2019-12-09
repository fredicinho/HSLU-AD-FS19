/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW07.ex04;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author freda
 */
public class PrimeRechner implements Callable<BigInteger> {

    private static final Logger LOG = LogManager.getLogger(PrimeRechner.class);

    @Override
    public BigInteger call() throws ExecutionException {
        BigInteger bi = new BigInteger(1024, new Random());
        if (bi.isProbablePrime(Integer.MAX_VALUE)) {
            LOG.info("Primmzahl gefunden");
            return bi;
        } else {
            return BigInteger.valueOf(0);
        }
    }
}

