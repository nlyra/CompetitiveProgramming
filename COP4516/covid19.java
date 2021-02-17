// Nathaniel Lyra
// UCF ID 4214346

import java.util.*;

public class covid19 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numFamilies = sc.nextInt();
        int[] countArr = new int[numFamilies];
        sc.nextLine();

        // Loop through number of families
        for (int i = 0; i < numFamilies; i++)
        {
            // Loop through number of family members per family
            int numMembers = sc.nextInt();
            for (int j = 0; j < numMembers; j++)
            {
                sc.nextLine();
                int b = sc.nextInt();
                int a = sc.nextInt();

                // If after minus before is exactly 19, increment the array.
                if ((a - b) == 19) countArr[i]++;
            }
        }

        for (int i = 0; i < numFamilies; i++) System.out.println(countArr[i]);

    }
    
}
