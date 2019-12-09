/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW08.ex03;

import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author freda
 */
public class Sort {
    

        
         

    
    private int[] array;
    private int oberGrenze = 20;
    
    public Sort(int p){
        this.array = new int[p];
        for(int i = 0; i<array.length; i++) {
            array[i] = (int)(Math.random()*oberGrenze); //casten nicht vergessen!
        }
    }
    
    public int[] getArray(){
        return this.array;
    }
    
    public static void insertionSort3(final int[] a) {
        int temp; //temp variable als dummy objekt

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i; j < a.length; j++) {
                if (a[i] > a[j]) {
                    temp = a[i]; //aktuelles a[i] in temp var
                    a[i] = a[j]; //a[i] mit a[j] erstzen (a[j] ist ja kleiner
                    a[j] = temp; // a[j] das alte a[i] zuweisen (ist ja grösser)
                }
            }
        }

    }
    
    
    public static void insertionSort2(final int[] a){
        int elt; 
        int j; 
        for (int i = 1; i < a.length; i++) { 
            elt = a[i];                                   
            j = i;                                          
            while (0 < j && a[j - 1] > elt) { 
                a[j] = a[j - 1];                                  
                j--;                                           
            } 
            a[j] = elt; 
            
         }
    }
    
    public static void selectionSort(final int[] a){
        int n = a.length; 
  
        //jedes Element im Array passieren
        for (int i = 0; i < n-1; i++) 
        { 
            //das kleinste Element finden
            int min_idx = i; 
            for (int j = i+1; j < n; j++) 
                if (a[j] < a[min_idx]) 
                    min_idx = j; 
  
            // Das kleinste Element mit dem ersten Element austauschen! 
            int temp = a[min_idx]; 
            a[min_idx] = a[i]; 
            a[i] = temp; 
        } 
    }
    
    public static void bubbleSort(int[] a) 
    { 
        int n = a.length; 
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (a[j] > a[j+1]) 
                { 
                    // swap arr[j+1] and arr[i] 
                    int temp = a[j]; 
                    a[j] = a[j+1]; 
                    a[j+1] = temp; 
                } 
    } 
}
    
