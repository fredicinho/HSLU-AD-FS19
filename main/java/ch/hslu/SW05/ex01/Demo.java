package ch.hslu.SW05.ex01;

import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class Demo {

    public static void main(String[] args){

        List<Integer> asdf = new ArrayList<>();
        List<Integer> as = Collections.synchronizedList(asdf);

        Canvas c = Canvas.getCanvas();
        c.setVisible(true);

        for (int i = 0; i < 20; i++){

            Thread t = new Thread(() -> {
                int ballDiameter = ThreadLocalRandom.current().nextInt(20, 50 + 1);
                int ballSize = ThreadLocalRandom.current().nextInt(0, 400 + 1);
                String color = getColor(ThreadLocalRandom.current().nextInt(0, 5));

                Circle circle = new Circle(ballDiameter, ballSize, 0, color );
                c.draw(circle, color, new Ellipse2D.Double(ballSize, 0,
                        ballDiameter, ballDiameter));
                for (int j = 0; j < 10; j++) {
                    circle.moveVertical(j + ThreadLocalRandom.current().nextInt(0, 50 + 1));

                    c.wait(100);

                    c.draw(circle, color, new Ellipse2D.Double(circle.getX(), circle.getY(),
                            ballDiameter, ballDiameter));

                    System.out.println("Durchgang: + color:" + j + color);
                }
            });
            t.start();

        }

    }

    public static String getColor(int i){
        switch (i){
            case 0: return "blue";
            case 1: return "red";
            case 2: return "green";
            case 3: return "yellow";
            case 4: return "black";
            case 5: return "gray";
            default: return "yellow";
        }

    }
}
