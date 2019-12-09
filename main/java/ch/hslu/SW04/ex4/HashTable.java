/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW04.ex4;

import ch.hslu.SW04.ex2.*;

/**
 *
 * @author freda
 */
public interface HashTable {
    
    public boolean search(Allocation a);
    
    public void insertElement(Allocation a);
    
    public boolean remove(Allocation a);
    
    
}
