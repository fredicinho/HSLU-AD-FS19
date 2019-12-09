/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW2;

import ch.hslu.SW2.Stack;

/**
 *
 * @author freda
 */
public class DemoStack {
    
    public static void main(String[] args){
        Stack s = new Stack(3);
        s.push("toll");
        s.push("sind");
        s.push("Datenstrukturen");
        
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
    
}
