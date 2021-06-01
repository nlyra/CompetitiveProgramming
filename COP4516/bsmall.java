// Nathaniel Lyra
// UCF ID 4214346

import java.util.*;

public class bsmall {

    public static void main(String[] args) {

        Scanner sc =  new Scanner(System.in);
        int numInputs = sc.nextInt();

        for (int i = 0; i < numInputs; i++)
        {
            int numHours = sc.nextInt();
            int dosesPerHour = sc.nextInt();
            int buffer;
            int total = 0;

            int[] numPplPerHour = new int[numHours];

            for (int j = 0; j < numHours; j++)
            {
                for (int k = 0; k < 10; k++)
                {
                    // if it's the first one
                    if (k == 0)
                        numPplPerHour[j] = sc.nextInt();
                    else
                        buffer = sc.nextInt();
                }
            }

            for (int temp: numPplPerHour)
            {
                if (temp > dosesPerHour)
                    total += dosesPerHour;
                else
                    total += temp;
            }

            System.out.println(total);
        }

    }
    
}
