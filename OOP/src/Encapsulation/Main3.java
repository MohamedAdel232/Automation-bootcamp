package Encapsulation;

import java.sql.SQLOutput;

public class Main3
{
    public static void main(String[] args)
    {
        // Create object from the class
        Cars3 car1 = new Cars3();

        // Set & Get the value
        car1.setModel("BMW");
        car1.setSpeed(100);
        System.out.println(car1.getModel());
        System.out.println(car1.getSpeed());
    }
}
