/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW07.ex02;

/**
 *
 * @author freda
 */
public class CarPark {

    private String name;
    private int capacity;
    private int freeSpace;
    private int wait;
    private int minParkingTime;
    private int exit;
    private int parkPerDay;

    public CarPark(String name, int capacity, int minParkingTime) {
        this.name = name;
        this.capacity = capacity;
        this.minParkingTime = minParkingTime;
        this.freeSpace = capacity;
        this.parkPerDay = 0;
    }

    public synchronized int getFreeSpace() {
        return this.freeSpace;
    }

    public synchronized void setFreeSpace(int freeSpace) {
        if (this.getFreeSpace() != 0) {
            this.notifyAll();
        }
        
        this.freeSpace = freeSpace;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getWait() {
        return wait;
    }

    public void setWait(int wait) {
        this.wait = wait;
    }

    public int getMinParkingTime() {
        return minParkingTime;
    }

    public void setMinParkingTime(int minParkingTime) {
        this.minParkingTime = minParkingTime;
    }

    public int getExit() {
        return exit;
    }

    public void setExit(int exit) {
        this.exit = exit;
    }
    
    public int getParkPerDay(){
        return this.parkPerDay;
    }
    
    public void setParkPerDay(int parkPerDay){
        this.parkPerDay = parkPerDay;
    }

}
