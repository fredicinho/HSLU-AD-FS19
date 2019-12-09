/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW11;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author freda
 */
public class DemoWordLanguage {
    
    private static String regex = "^(0)(1(11)*0)*$";
    private static Pattern pattern = Pattern.compile(regex);
    private static Matcher matcher;
    
    private static final Logger LOG = LogManager.getLogger(DemoWordLanguage.class);
    
    public static void main(String[] args){
        String string1 = "01110";
        LOG.info("Start des Regexes von folgender Zahl: " + string1);
        LOG.info("Der String erfüllt die Bedinung wie folgt: " + isWordLanguage(string1));
        
    }
    
    public static boolean isWordLanguage(final String string){
        matcher = pattern.matcher(string);
        boolean found = false;
        
        return matcher.matches();
    }
    
}
