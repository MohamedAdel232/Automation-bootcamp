package Constructions;

public class Main2
{
    public static void main(String[] args)
    {
        // Create object from the class
        Cars2 car1 = new Cars2("BMW", 100);
        Cars2 car2 = new Cars2("FIAT");
        Cars2 car3 = new Cars2();

        car1.PrintCarInfo();

        car2.Speed = 40;
        car2.PrintCarInfo();

        car3.Model = "Firari";
        car3.Speed = 120;
        car3.PrintCarInfo();

        Cars2.PrintNumberOfObject();
    }
}
