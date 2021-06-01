// Nathaniel Lyra
// UCF ID 4214346

import java.util.*;

public class dsmall {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numInput = sc.nextInt();

        for (int i = 0; i < numInput; i++)
        {
            int maxVolume = sc.nextInt();
            int currVolume = sc.nextInt();
            int desiredVolume = sc.nextInt();
            int increasesBy = sc.nextInt();
            int decreasesBy = sc.nextInt();
            int count = 0;
            boolean broke = false;

            // Try it until it breaks!
            while (true)
            {
                // If we reached desired volume.
                if (currVolume == desiredVolume)
                {
                    System.out.println(count);
                    break;
                }

                // If current volume is higher than desired volume..
                if ((currVolume > desiredVolume))
                {
                    // As long as subtracting it won't make it go below desired.
                    if (currVolume - decreasesBy > desiredVolume)
                    {
                        // Keep looping while curr volume is still higher than desired.
                        while (currVolume > desiredVolume)
                        {
                            currVolume -= decreasesBy;
                            count++;
                        }

                    }

                }


                // If current volume is less than desired volume..
                if ((currVolume < desiredVolume))
                {
                    // As long as adding it won't make it go over desired.
                    if (currVolume + increasesBy < desiredVolume)
                    {
                        // Keep looping while curr volume is still less than desired.
                        while ((currVolume < desiredVolume))
                        {
                            currVolume += increasesBy;
                            count++;
                        }
                    }
                    // Otherwise it will make it go over, so decrease again.
                    else
                    {
                        currVolume -= decreasesBy;
                        count++;

                        // If it's gone below 0, set it to 0.
                        if (currVolume < 0)
                            currVolume = 0;
                    }

                    // Check if it's an impossible case
                    // (If we can't subtract any longer and adding one doesn't get us to the desired volume)
                    if ((currVolume == 0) && (currVolume + increasesBy != desiredVolume))
                    {
                        System.out.println(-1);
                        break;
                    }

                }

            }
            
        }

    }
    
}
