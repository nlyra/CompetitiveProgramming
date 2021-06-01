// Nathaniel Lyra
// UCF ID 4214346

import java.util.*;

public class consecutive {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numInput = sc.nextInt();

        for (int i = 0; i < numInput; i++)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();

            List<Integer> listy = new ArrayList<>(n); // ordered cows
            List<List<Integer>> groupy = new ArrayList<List<Integer>>(); // groups of cows

            // add cows' skill levels
            for (int j = 0; j < n; j++)
                listy.add(sc.nextInt());

            if (k == 0)
            {
                System.out.println("0");
                continue;
            }
            
            Collections.sort(listy, Collections.reverseOrder()); // sort skill levels

            // pointer
            int y = (n-1);

            // Loop through ordered list of cows' skills and put them in groups!
            for (int x = 0; x < n; x++)
            {
                // Add biggest number for a team
                groupy.add(new ArrayList<Integer>());
                groupy.get(x).add(listy.get(x));
                
                // Go through potential number of cows per team
                for (int kay = 1; kay < k; kay++)
                {
                    if (x == y) break; // if our pointers meet, break out of loop

                    groupy.get(x).add(listy.get(y));
                    y--;
                }

                if (x == y) break; // if our pointers meet, break out of loop
                //if (listy.get(x) == listy.get(y)) break; // if our pointers meet, break out of loop
            }

            long sum = 0;

            // Go through each row in the list, and through each integer in each row
            for (List<Integer> row : groupy)
            {
                // Get the max number of that row
                int maxy = Collections.max(row);
                
                // Make every value in that row the max value
                for (Integer inty : row)
                {   
                    inty = maxy;
                    sum += inty;
                }
            }

            System.out.println(sum);
        }

    }
}
