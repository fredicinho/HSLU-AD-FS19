/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW07.ex02;

import java.util.ArrayList;

/**
 *
 * @author freda
 */
public class City {
    private final String name;
    public ArrayList<CarPark> list;
    private int parkingCounter;
    
    public City(String name){
        this.name = name;
        this.list = new ArrayList<>();
        this.list.add(new CarPark("Parkhaus 1", 500, 10));
        this.list.add(new CarPark("Parkhaus 2", 300, 200));
        this.list.add(new CarPark("Parkhaus 3", 200, 60));
        this.parkingCounter = 0;
    }
    
    public synchronized int getParkingCounter(){
        return this.parkingCounter;
    }
    
    public synchronized void setParkingCounter(int parkingCounter){
        this.parkingCounter = parkingCounter;
    }
    
    public ArrayList<CarPark> getList(){
        return this.list;
    }
    
    public String getName(){
        return this.name;
    }
    
}
