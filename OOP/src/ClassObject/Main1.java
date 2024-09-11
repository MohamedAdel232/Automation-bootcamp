package ClassObject;

public class Main1
{
    public static void main(String[] args)
    {
        // Create object from the class
        Cars1 car1 = new Cars1();
        Cars1 car2 = new Cars1();
        Cars1 car3 = new Cars1();

        car1.Model = "BMW";
        car1.Speed = 100;
        car1.PrintCarInfo();

        car2.Model = "FIAT";
        car2.Speed = 40;
        car2.PrintCarInfo();

        car3.PrintCarInfo();
    }
}
