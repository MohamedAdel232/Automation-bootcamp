package HandleException;

public class Excep
{
    public static void main(String[] args)
    {
        int n1 = 5;
        int n2 = 0;
        try
        {
            System.out.println(n1/n2);
        }
        catch (Exception exception)
        {
            System.out.println(exception.getMessage());
        }
        finally
        {

        }
    }
}
