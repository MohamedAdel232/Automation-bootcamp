package Encapsulation;

import java.sql.SQLOutput;

// Create a class
public class Cars3
{
    // Class Attributes
    private String Model;
    private int Speed;

    // Class Methods
    public void PrintCarInfo ()
    {
        System.out.println("Car model: " + Model + ", Car Speed: " + Speed);
    }

    // Setters
    public void setModel (String Model)
    {
        this.Model = Model;
    }

    public void setSpeed(int Speed)
    {
        if (Speed > 0)
        {
            this.Speed = Speed;
        }
        else
        {
            System.out.println("Invalid!");
        }
    }

    // Getters
    public String getModel ()
    {
        return Model;
    }

    public int getSpeed()
    {
        return Speed;
    }
}
