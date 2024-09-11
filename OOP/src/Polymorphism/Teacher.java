package Polymorphism;

// Create a class that inherit from another class
public class Teacher extends Person implements TestInterface
{
    // Create a construction that inherit from parent class
    public Teacher(String Name, int ID)
    {
        super(Name, ID);
    }

    public void IDCalc ()
    {
        System.out.println(ID * 10);
    }
}
