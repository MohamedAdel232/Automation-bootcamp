package Polymorphism;

public class Main5
{
    public static void main(String[] args)
    {
        Student per1 = new Student();
        Teacher per2 = new Teacher("Adel", 33);

        per1.Name = "Muhamed";
        per1.ID = 23;

        System.out.println(per1.Name + " " + per1.ID);
        System.out.println(per2.Name + " " + per2.ID);

        per1.IDCalc();
        per2.IDCalc();
    }
}
