// Nathaniel Lyra
// UCF ID 4214346

import java.util.*;

public class cowstalls {

    public static int count = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numCows = sc.nextInt();
        int[] cowHeights = new int[numCows];
        int[] stallHeights = new int[numCows];
        int[] perms = new int[numCows];
        boolean[] used = new boolean[numCows];
        for (int i = 0; i < numCows; i++)
            cowHeights[i] = sc.nextInt();
        for (int i = 0; i < numCows; i++)
            stallHeights[i] = sc.nextInt();

        // // Debug
        // for (int test : cowHeights)
        //     System.out.print(test + " ");
        // System.out.println();
        // for (int test : stallHeights)
        //     System.out.print(test + " ");
        // System.out.println();

        int k = 0;
        printPerms(cowHeights, stallHeights, perms, used, k);
        System.out.println(count);
    }

    // Recursive function to calculate permutation.
    public static void printPerms(int[] cowHeights, int[] stallHeights, int[] perms, boolean[] used, int k) {

        boolean flag = true;

        // We have filled out a permutation, increase the count.
        if (k == cowHeights.length)
        {
            for (int i = 0; i < perms.length; i++)
            {
                if (perms[i] > stallHeights[i])
                    flag = false;
            }

            if (flag)
                count++;
        }

        // Try each unused item in slot k.
        for (int i = 0; i < cowHeights.length; i++)
        {
            // If it has not yet been used and the cow fits in the stall..
            if (!used[i])
            {
                used[i] = true;
                perms[k] = cowHeights[i];

                printPerms(cowHeights, stallHeights, perms, used, k+1);

                used[i] = false;
            }


        }
    }
    
}
