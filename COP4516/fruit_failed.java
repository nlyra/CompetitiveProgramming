// Nathaniel Lyra
// UCF ID 4214346

import java.util.*;

public class fruit_failed {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numStands = sc.nextInt();

        // Loop through number of fruit stands
        for (int i = 0; i < numStands; i++)
        {
            // Loop through number of days we sold fruit for that stand
            int numDays = sc.nextInt();
            int[] sales = new int[numDays];
            for (int j = 0; j < numDays; j++)
            {
                sales[j] = sc.nextInt();
            }

            figureItOut(sales);
        }
    }

    public static void figureItOut(int[] sales)
    {
        int minOrder = sales[0];
        int maxStore = 0;
        int prevMaxStore = 0;
        boolean enough = false;
        ArrayList<result> results = new ArrayList<result>(); // Realize now I don't need an array for this!

        for (int i = 0; i < sales.length; i++)
        {
            prevMaxStore = maxStore;
            maxStore = maxStore + (minOrder - sales[i]);
            // if (i == sales.length -1)
            //     prevMaxStore = maxStore;
            if (maxStore >= 0)
                enough = true;
            else
                enough = false;
            
            // If our minimum daily order + the leftovers isn't enough to cover daily sales..
            if ((minOrder + maxStore) < sales[i] && (!enough))
            {
                // Increment our minumum order, reset loop and variables.
                minOrder++;
                i = -1;
                maxStore = 0;
                //enough = false;
                continue;
            }
            

            // If our i is equal to the length of the number of days..
            if (i == (sales.length - 1))
            {
                // If our results array is not empty..
                if (!results.isEmpty())
                {
                    // And if our current result in our results array is better than the current iteration's result,
                    // print and return.
                    if ((results.get(0).minimumOrder < minOrder) && (results.get(0).maximumStorage < prevMaxStore))
                    {
                        System.out.println(results.get(0).minimumOrder + " " + results.get(0).maximumStorage);
                        return;
                    }
                }

                // Else, replace that result with the current result in the array, go back to the first day,
                // increment our minOrder, reset our maxStore
                results.add(0, new result(minOrder, prevMaxStore)); // prevMax?
                // if (enough)
                // results.add(0, new result(minOrder, maxStore)); // prevMax?
                minOrder++;
                maxStore = 0;
                i = -1;
            }
        }
        
    }
    
}

class result implements Comparable<result>{
    public int minimumOrder;
    public int maximumStorage;

    public result(int minOrder, int maxStore) {
        this.minimumOrder = minOrder;
        this.maximumStorage = maxStore;
    }

    public int compareTo(result other) {

        return this.minimumOrder - other.minimumOrder;
    }
}
