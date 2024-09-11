package Collections;

import java.util.HashSet;
import java.util.Set;

public class SetCollection
{
    public static void main(String[] args)
    {
        Set<Integer> set = new HashSet<>();

        set.add(1);

        for (int i : set)
        {
            System.out.println(i);
        }
    }
}
