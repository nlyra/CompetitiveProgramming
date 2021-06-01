// Nathaniel Lyra
// UCF ID 4214346

import java.util.*;

public class perfect {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long numInput = sc.nextLong();

        for (int i = 0; i < numInput; i++)
        {
            long b = sc.nextLong(); 
            long z = sc.nextLong();
            boolean flag = false;

            for (int k = 2; k < z; k++)
            {
                if (Math.pow(b, k) > z) break;
                
                if (Math.pow(b, k) == z)
                {
                    System.out.println("YES");
                    flag = true;
                }
            }

            if (!flag) System.out.println("NO");
        }
    }
    
}
