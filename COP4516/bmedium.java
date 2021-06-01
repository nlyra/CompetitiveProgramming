// Nathaniel Lyra
// UCF ID 4214346

import java.util.*;

public class bmedium {

    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        int numInput = sc.nextInt();

        // Handle input.
        for (int x = 0; x < numInput; x++)
        {
            int arrivalHours = sc.nextInt();
            int dosesPerHour = sc.nextInt();

            int[][] matrix = new int[arrivalHours][10];

            for (int j = 0; j < arrivalHours; j++)
            {
                for (int k = 0; k < 10; k++)
                {
                    matrix[j][k] = sc.nextInt();
                }
            }

            // Go through matrix and solve problem.
            for (int i = 0; i < arrivalHours; i++)
            {
                for (int j = 0; j < 10; j++)
                {
                    if (matrix[i][j])
                }
            }
        }

    }
    
}
