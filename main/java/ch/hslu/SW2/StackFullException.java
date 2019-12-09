/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW2;

/**
 *
 * @author freda
 */
public class StackFullException extends Exception {

    public StackFullException() {
        System.out.println("Der Stack ist voll!");
    }
    
}
