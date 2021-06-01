// Nathaniel Lyra
// UCF ID 4214346

import java.util.*;

public class perfect_old {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numInput = sc.nextInt();

        for (int i = 0; i < numInput; i++)
        {
            long number = sc.nextLong();
            long result = doTheThing(number);

            if (result < number) System.out.println("defective");
            else if (result > number) System.out.println("abundant");
            else System.out.println("perfect");
        }
    }

    public static long doTheThing(long x)
    {
        // Null check
        if (x < 1)
            return 0;
        
        if (x == 1)
            return 1;

        // Numbers that divide into x.
        List<Long> listy = new ArrayList<>();
        long sum = 0;

        // Add numbers that divide into x to our arraylist.
        for (long i = 1; i < Math.sqrt(x); i++)
        {
            if (x % i == 0)
            {
                if (x/i == i)
                    listy.add(i);
                else
                {
                    listy.add(i);
                    listy.add(x/i);
                }
            }
        }

        // Remove itself
        Collections.sort(listy);
        listy.remove(listy.size() - 1);

        for (Long current: listy)
        {
            //System.out.println(current);
            sum += current;
        }

        return sum;
    }
    
}
