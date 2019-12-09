/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */  
package ch.hslu.SW05.ex01;

import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author freda
 */
public class DemoBall {
    
    public static void main(String[] args){
        
        List<Integer> list = new ArrayList<>();
        List<Integer> listSync = Collections.synchronizedList(list);
        

        
        for (int i = 0; i < 10; i++) {
            
            Thread t = new Thread(() -> {
                     int balldiameter = ThreadLocalRandom.current().nextInt(40, 100);
                     int xPosition = ThreadLocalRandom.current().nextInt(0, 400);
                     String color = Circle.getColor(ThreadLocalRandom.current().nextInt(0, 5));
                     
                     Circle circle = new Circle(balldiameter, xPosition, 0, color);
                     circle.makeVisible();
                     
                     // canvas.draw(circle, color, new Ellipse2D.Double(xPosition, 0,
                       // balldiameter, balldiameter));
                     
                     for (int p = 0; p < 100; p++) {
                         while (circle.getY() < 400 - circle.getDiameter()){
                         circle.moveVertical(ThreadLocalRandom.current().nextInt(0, 30));
                         }
                         while (circle.getDiameter() != 0){
                             for (int u = circle.getDiameter(); u > 0; u--){
                                 circle.changeSize(u);
                                 circle.moveVertical(1);
                             }
                         }
                         circle.makeInvisible();
                     }
                 });
            t.start();


        }
        
        
        
        
        
        
    }
    
}
