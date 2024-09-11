package Collections;

import java.util.ArrayList;
import java.util.List;

public class ListCollection
{
    public static void main(String[] args)
    {
        List<Integer> list = new ArrayList<>(2);
        list.add(4);
        list.add(2);

        for (int i : list)
        {
            System.out.println(i);
        }
    }
}
