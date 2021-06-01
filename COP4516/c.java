//Nathaniel Lyra
// UCF ID 4214346

import java.util.*;

public class c {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numInput = sc.nextInt();

        for (int i = 0; i < numInput; i++)
        {
            int maxVolume = sc.nextInt();
            int currVolume = sc.nextInt();
            int increasesBy = sc.nextInt();
            int decreasesBy = sc.nextInt();
            int numButtonPresses = sc.nextInt();

            for (int j = 0; j < numButtonPresses; j++)
            {
                String button = sc.next();
                
                if (button.equals("UP"))
                {
                    currVolume += increasesBy;

                    if (currVolume > maxVolume)
                    {
                        currVolume = maxVolume;
                    }
                }
                else if (button.equals("DOWN"))
                {
                    currVolume -= decreasesBy;

                    if (currVolume < 0)
                    {
                        currVolume = 0;
                    }
                }
            }

            System.out.println(currVolume);
        }
        
    }
    
}
