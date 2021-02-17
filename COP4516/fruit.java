// Nathaniel Lyra
// UCF ID 4214346

import java.util.*;
import java.lang.Math;

public class fruit {

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

    public static void figureItOut(int[] sales) {

        int maxCeiling = 0;
        int totalFruitsSoldSoFar = 0;
        double day = 1; // Start at day 1

        // Get the number of fruits we need for each day to make all the sales.
        for (int i = 0; i < sales.length; i++)
        {
            totalFruitsSoldSoFar += sales[i];
            int tempCalc = (int)Math.ceil(totalFruitsSoldSoFar/day);
            if (tempCalc > maxCeiling)
                maxCeiling = tempCalc;
            
            day++;
        }

        int maxLeftOver = 0;
        int currLeftOver = 0;

        // Rerun the simulation getting this many fruits each morning and store max leftover.
        for (int i = 0; i < sales.length; i++)
        {
            currLeftOver += (maxCeiling - sales[i]);

            if (currLeftOver > maxLeftOver)
                maxLeftOver = currLeftOver;
        }

        System.out.println(maxCeiling + " " + maxLeftOver);
    }

    
}
