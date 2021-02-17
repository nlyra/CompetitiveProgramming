// Nathaniel Lyra
// UCF ID 4214346

import java.util.*;

public class cowphotos {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numCows = sc.nextInt();
        int[] breedID = new int[numCows];
        int maxGroups = 0;
        int even = 0, odd = 0; // Keep track of # of odd and even numbers.
        int j = 0; // To keep track of which type we need now. We start with even, so zero.

        // Get our number of odds and evens, and fill up the array with the IDs.
        for (int i = 0; i < numCows; i++)
        {
            breedID[i] = sc.nextInt();

            if (breedID[i] % 2 == 0)
                even++;
            else
                odd++;

        }

        // // Debug
        // for (int test: breedID)
        //     System.out.println(test);

        // If we don't have any odds, then the max number is 1.
        if (odd == 0)
        {
            maxGroups++;
            System.out.println(maxGroups);
            return;
        }

        // Since we always start with even, loop until there are no more odds.
        // You can make an even with two odds, but can't make an odd with two evens. So, if we run out of odds,
        // we break out of the loop.
        while (odd != 0)
        {
            // If we need an even right now..
            if (j % 2 == 0)
            {
                // If we have evens to give right now..
                if (even != 0)
                {
                    // Take an even straight up and group it, increment num of groups, and next j.
                    even--;
                    maxGroups++;
                    j++; // Now we need an odd, so increment j.
                }
                // If we need an even, but don't have any to give..
                else
                {
                    // If we have at least 2 odds, group them to make an even.
                    if (odd >= 2)
                    {
                        odd -= 2;
                        maxGroups++;
                        j++; // Now we need an odd, so increment j.

                        // If we only had 2 left, and now we have zero, let's print it out.
                        if (odd == 0)
                        {
                            System.out.println(maxGroups);
                            j++;
                            return;
                        }
                    }
                    // Otherwise we only have 1 odd left, so we need to group the previous ones..
                    else
                    {
                        maxGroups--; // To simulate grouping of previous ones.
                        odd--; // Now there are no more odds, we should break!!

                        // Print our answer.
                        System.out.println(maxGroups);
                        j++;
                        return;
                    }
                }
            }
            // Otherwise we need an odd right now..
            else if (j % 2 != 0)
            {
                // If we have odds to give, give them.
                if (odd > 0)
                {
                    odd--;
                    maxGroups++;
                    j++;

                    // If we only had one left, and that one needed to be an odd number,
                    // and we had no evens left after that (so, last odd and last number).
                    if (odd == 0 && even == 0)
                    {
                        System.out.println(maxGroups);
                        return;
                    }
                    // Otherwise we have no odds left, but do have 1 or more evens left..
                    // Our j was incremented above, so we're now on even number needed.
                    else if (odd == 0 && even > 0)
                    {
                        even--;
                        maxGroups++;
                        j++;

                        // We have no more odds, so print maxGroups.
                        System.out.println(maxGroups);
                        return;
                    }
                }
            }
        }
    }
}
