/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW12.ex02;

/**
 *
 * @author freda
 */
public class OptimierteSuche {
    
    public static int[] initNext(final String p) { final int m = p.length(); 
    final int[] next = new int[m];
    int i = 0; 
    int j = -1; 
    next[0] = -1; // special value! (-1 = no reference to a following state) 
    do { if ((j == -1) || (p.charAt(i) == p.charAt(j))) { //  (j == -1) must be first operand! 
        i++; 
        j++; 
        next[i] = j; 
    } else { 
        j = next[j]; 
      } 
    } while (i < (m - 1)); 
    
    return next; 
    }
    
    public static int stateSearch(final String a){
        int i = 0;
        String state = "";
        final int notFound = -1;
        do {
            switch (state){
                case "":                    // z0
                    if (a.charAt(i) == 'A'){
                        state = "A";
                    }
                    break;
                    
                case "A":                   //z1
                switch (a.charAt(i)) {
                    case 'N':
                        state = "AN";
                        break;
                    case 'A':
                        state = "A";
                        break;
                    default:
                        state = "";
                        break;
                }
                    break;

                    
                case "AN":                  //z2
                    if (a.charAt(i) == 'A'){
                        state = "ANA";
                    } else {
                        state = "";
                    }
                    break;
                    
                case "ANA":                 //z3
                    switch (a.charAt(i)){
                        case 'A':
                            state = "A";
                            break;
                        case 'N':
                            state = "ANAN";
                            break;
                        default:
                            state = "";
                            break;
                    }
                    break;
                    
                case "ANAN":                //z4
                    if (a.charAt(i) == 'A'){
                        state = "ANANA";
                    } else {
                        state = "";
                    }
                    break;
                    
                case "ANANA":
                    switch (a.charAt(i)){
                        case 'N':
                            state = "ANAN";
                            break;
                        case 'S':
                            state = "ANANAS";
                            break;
                        case 'A':
                            state = "A";
                            break;
                        default: 
                            state = "";
                            break;
                    }
                    break;                   
            }
            i++;
        } while ((state != "ANANAS") && (i < a.length()));
        if (state == "ANANAS"){
            return (i - state.length());
        }
        return notFound;
    }
    
}
