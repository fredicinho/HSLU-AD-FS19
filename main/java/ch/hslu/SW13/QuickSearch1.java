/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW13;

/**
 *
 * @author freda
 */
public class QuickSearch1 {
    
    
    public static int quickSearchOptimized(final String a, final String p){
        final int n = a.length();
        final int m = p.length();
        final int range = 256;
        final int[] shift = new int[range];
        
        //Wenn der zu durchsuchende String leer ist, wird abgebrochen
        if (n == 0 || m == 0){
            return -1;
        }
        
        for (int i = 0; i < range; i++) {
            shift[i] = m + 1;
        } // overwrite fields according pattern 
        
        for (int i = 0; i < m; i++) {
            shift[p.charAt(i)] = m - i;
        }
        
        
        //search
        int i = 0; //index to string
        int j = 0; // index to pattern
        
        do {
            if (a.charAt(i + j) == p.charAt(j)){ //match
                j++;
            } else {        //mismatch
                if ((i + m) < n) {
                    i += shift[a.charAt(i+m)];
                    j = 0;
                } else {
                    break;      // mismatch && no shift is possible
                }
            }
            
        } while ((j<m) && ((i+m) <= n));
        // pattern p not found && end of a not reached
        if (j == m){
            return i; //pattern found
        } else {
            return -1;  //pattern not found
        }
    }
    
}
