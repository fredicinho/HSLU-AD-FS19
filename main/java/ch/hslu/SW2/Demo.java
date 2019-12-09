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
public class Demo {
    
        public static void main(String[] args){
        List l1 = new List();
        Allocation a = new Allocation(3, 4);
        Allocation b = new Allocation(3, 5);
        Allocation c = new Allocation(3, 6);
        Allocation d = new Allocation(3, 9);
       
        l1.addAllocation(a);
        l1.addAllocation(b);
        l1.addAllocation(c);
        l1.addAllocation(d);
        
        System.out.println(2463%15);
        
                }
}
