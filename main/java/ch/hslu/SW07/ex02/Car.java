/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW07.ex02;

import static java.lang.Thread.sleep;
import java.util.Random;

/**
 *
 * @author freda
 */
public class Car implements Runnable {
    
    private String name;
    private City city;
    private CarPark carParkedIn;
    private CarPark nextCarPark;
    private int driverType;
    private Integer[] driverTypeArray = {1, 2, 3, 4, 5};
    private boolean isParked = false;
    private int parkingDuration;
    Random random = new Random();
    
    
    
    public Car(String name, City city, int driverType, CarPark nextCarPark, int parkingDuration){
        this.name = name;
        this.city = city;
        this.driverType = driverType;
        this.nextCarPark = nextCarPark;
        this.parkingDuration = parkingDuration;
    }
    

    @Override
    public void run() {
        while(!CarParkDemo.isInterrupted()){
            park(nextCarPark);
        }
        Thread.currentThread().interrupt();
    }
    
    private void park(CarPark park){
        try {
            sleep(100);
        } catch (InterruptedException ex){
            ex.printStackTrace();
        }
        if (driverType == 1){
            while(park.getFreeSpace() == 0){
                try {
                    this.wait();
                } catch(InterruptedException ex){
                    ex.printStackTrace();
                }
            }
            this.isParked(park);
        }
    }
    
    private void isParked(CarPark park){
        this.carParkedIn = park;
        carParkedIn.setFreeSpace(carParkedIn.getFreeSpace() - 1);
        this.isParked = true;
        this.city.setParkingCounter(this.city.getParkingCounter() + 1);
        this.carParkedIn.setParkPerDay(carParkedIn.getParkPerDay() + 1);
        try{    
            this.wait(1);
        } catch (InterruptedException ex){
            ex.printStackTrace();
        }
        this.leave();
    }
    
    private void leave(){
        carParkedIn.setFreeSpace(carParkedIn.getFreeSpace() + 1);
        this.isParked = false;
    }
    
    public City getCity(){
        return this.city;
    }
    
    
    
}
