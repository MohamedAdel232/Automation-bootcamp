package Constructions;

// Create a class
public class Cars2
{
    // Class Attributes
    String Model;
    int Speed;

    // Static Attribute
    static int Counter = 0;

    // Class default (empty) constructions
    public Cars2 ()
    {
        System.out.println("This object is empty");

        // Increment every time an object is made
        Counter++;
    }

    // Class Parametized constructions
    public Cars2 (String Model)
    {
        this.Model = Model;
        // Increment every time an object is made
        Counter++;
    }

    public Cars2 (String Model, int Speed)
    {
        this.Model = Model;
        this.Speed = Speed;
        // Increment every time an object is made
        Counter++;
    }

    // Class Methods
    public void PrintCarInfo ()
    {
        System.out.println("Car model: " + Model + ", Car Speed: " + Speed);
    }

    public static void PrintNumberOfObject()
    {
        System.out.println(Counter);
    }
}
