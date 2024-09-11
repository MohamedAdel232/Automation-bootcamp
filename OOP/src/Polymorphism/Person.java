package Polymorphism;

public abstract class Person
{
    String Name;
    int ID;


    // Create constructions for parent class
    public Person ()
    {

    }

    public Person (String Name, int ID)
    {
        this.Name = Name;
        this.ID = ID;
    }

    // Create a function for polymorphism
    public abstract void IDCalc ();
}
