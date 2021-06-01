// Nathaniel Lyra
// UCF ID 4214346

import java.util.*;

public class fact {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numInput = sc.nextInt();

        for (int i = 0; i < numInput; i++)
        {
            int n = sc.nextInt();
            int temp = n;
            boolean[] primes = primeSieve(n);

            for (int p = 0; p <= n; p++)
            {
                int sum = 0;
                int e = 1;

                if (primes[p] == true)
                {
                    while(temp > 0)
                    {
                        temp = n; // Reset
                        sum += n/(Math.pow(p, e));
                        temp = n/(int)(Math.pow(p, e));
                        e++;
                    }

                    System.out.print(sum+" ");
                    temp = n; // Reset for next prime number
                }
            }

            System.out.println();
        }

    }

    // Code taken from Arup Guha, MathStuff.java
    // Returns an array of size n+1 such that array[i] = true iff i is prime.
    public static boolean[] primeSieve(int n) {

        // Initialize.
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        // Run really basic sieve.
        for (int i=2; i*i<=n; i++)
            for (int j=2*i; j<=n; j+=i)
                isPrime[j] = false;

        // Here is our array.
        return isPrime;
    }
    
}
