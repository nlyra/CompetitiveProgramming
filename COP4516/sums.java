// Nathaniel Lyra
// UCF ID 4214346

import java.util.*;

public class sums {

    public static int answer = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numInputs = sc.nextInt();

        for (int i = 0; i < numInputs; i++)
        {
            int n = sc.nextInt();
            int res = w(n);
            System.out.println((i+1)+" "+n+" "+answer); // Print solution
            answer = 0; // Reset answer variable
        }
    }

    public static int w(int n) {

        if (n == 0)
            return 0;

        for (int i = 1; i <= n; i++)
        {
            answer += i * t(i+1);
        }

        return answer;
    }

    public static int t(int n) {

        if (n == 0)
            return 0;
        
        int sum = 0;

        for (int i = 1; i<= n; i++)
        {
            sum += i;
        }

        return sum;
    }
    
}
