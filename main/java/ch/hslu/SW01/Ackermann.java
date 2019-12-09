/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW01;

/**
 *
 * @author freda
 */
public class Ackermann {
    
    public static long ack1(final long x, final long y){
        if (x == 0){
            return y + 1;
        } else if (y == 0){
            return ack1(x-1, 1);
        } else
            return ack1(x-1, ack1(x, y-1));
        } 
    
    public static void main(String[] args){
        long x = 2;
        long y = 2;
        
         System.out.println( "ackermann(" + x + "," + y + ")=" + ack1(x,y) );
    }
}
