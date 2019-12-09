/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW12.ex02;

import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author freda
 */
public class DemoSuche {
        private static final Logger LOG = LogManager.getLogger(DemoSuche.class);
        
        public static void main(String[] args){
            String string = "HalloasdlkfjsakdfANANASasldfhasdgjkäf";
            LOG.info("Suche nach String ANANAS in folgendem String: " + string);
            int result = OptimierteSuche.stateSearch(string);
            LOG.info("Das Resultat lautet: " + result);
            String p = "ANANAS";
            LOG.info("Das Int-Array vom Pattern ANANAS lautet wie folgt: " + Arrays.toString(OptimierteSuche.initNext(p)));
        }

    
    
}
