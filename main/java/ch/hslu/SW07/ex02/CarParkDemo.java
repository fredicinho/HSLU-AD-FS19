/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.SW07.ex02;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author freda
 */
public class CarParkDemo {

    private static final Logger LOG = LogManager.getLogger(CarParkDemo.class);
    private static boolean isInterrupted;

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Car> cars = new ArrayList();
        int anzahlCars = 2000;
        City city = new City("Paris");
        Random random = new Random();

        ExecutorService executor = Executors.newFixedThreadPool(8);

        for (int i = 0; i < anzahlCars; i++) {
            cars.add(i, new Car("Car driver " + (char) (i + 65), city, 1, city.list.get(random.nextInt(city.getList().size())), 5));
            executor.submit(cars.get(i));
        }

        try {
            sleep(10000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        try {
            sleep(8000);
        } catch (InterruptedException ex){
            ex.printStackTrace();
        }
        LOG.info("Parkhäuser werden geschlossen!");
        setInterrupted(true);
        executor.shutdown();
        
        LOG.info("Parkhaus 1: " + city.getList().get(0).getParkPerDay());
        LOG.info("Parkhaus 2: " + city.getList().get(1).getParkPerDay());
        LOG.info("Parkhaus 3: " + city.getList().get(2).getParkPerDay());
        LOG.info("Anzahl Autos die in der Stadt " + city.getName() + " parkiert haben: " + city.getParkingCounter());
        

    }

    public static boolean isInterrupted() {
        return isInterrupted;
    }

    public static void setInterrupted(boolean isInterrupted) {
        CarParkDemo.isInterrupted = isInterrupted;
    }

}
