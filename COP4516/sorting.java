// Nathaniel Lyra
// UCF ID 4214346

import java.util.*;

public class sorting {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numInputs = sc.nextInt();

        for (int i = 0; i < numInputs; i++)
        {
            int numStacks = sc.nextInt();
            PriorityQueue<Integer> stacks = new PriorityQueue<>();
            for (int j = 0; j < numStacks; j++)
            {
                stacks.add(sc.nextInt());
            }

            doTheThing(stacks);
        }

    }

    public static void doTheThing(PriorityQueue<Integer> stacks)
    {
        if (stacks.isEmpty() || stacks.size() == 1)
        {
            System.out.println(0);
            return;
        }
        
        int total = 0;

        // Until there is only one element left in the PQ
        while (stacks.size() > 1)
        {
            int temp1 = stacks.poll();
            int temp2 = stacks.poll();
            total += (temp1 + temp2);

            stacks.add(temp1 + temp2);

        }

        System.out.println(total);

    }
    
}
