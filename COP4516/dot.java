// Nathaniel Lyra
// UCF ID 4214346

import java.util.*;

import javax.lang.model.util.ElementScanner6;

public class dot {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int numInputs = sc.nextInt();

        for (int i = 0; i < numInputs; i++)
        {
            int myDot = sc.nextInt();
            int numDots = sc.nextInt();

            if (numDots == 0)
            {
                System.out.println(0);
                continue;
            }
            int count = 0;
            TreeMap<Integer, Integer> dots = new TreeMap<>();

            for (int j = 0; j < numDots; j++)
            {
                int temp = sc.nextInt();
                if (dots.containsKey(temp))
                {
                    int freq = dots.get(temp);
                    dots.put(temp, freq + 1);
                }
                else
                {
                    dots.put(temp, 1);
                }
            }

            int maxDot = dots.lastKey();
            //System.out.println(dots.lastKey());
            //System.out.println("Max: "+maxDot);
            //dots.remove(maxDot);

            // If my dot is greater than the max dot, return count (0).
            if (myDot > maxDot)
            {
                System.out.println(count);
                continue;
            }

            // While the dots treeset is not empty..
            while (!dots.isEmpty() && myDot <= maxDot)
            {
                Integer curr = dots.floorKey(myDot - 1);

                // If all other dots are greater than my dot (there is no floor).
                if (curr == null)
                {
                    System.out.println(-1);
                    break;
                }
                else
                {
                    myDot += curr;
                    count++;

                    if (dots.get(curr) - 1 == 0)
                        dots.remove(curr); // pop from stack, already used, decrement frequency.
                    else
                        dots.put(curr, (dots.get(curr) - 1));

                    // If our dot is now the new max, print count and get out.
                    if (myDot > maxDot)
                    {
                        System.out.println(count);
                        break;
                    }
                    // If there are no more dots and my dot is still less than the max dot.
                    else if (dots.isEmpty() && (myDot < maxDot))
                    {
                        System.out.println(-1);
                        break;
                    }
                    else if (myDot == maxDot && dots.isEmpty()) // if we have a tie
                    {
                        System.out.println(-1);
                        break;
                    }
                }
            }
        }
    }
}

// class dotty{
    
//     public int size;
//     public int ID;

//     public dotty(int i, int s)
//     {
//         this.size = s;
//         this.ID = i;
//     }

//     public int compareTo(dotty other)
//     {
//         if (this.size > other.size)
//             return 1;
//         else if (this.size < other.size)
//             return -1;
//         else
//             return 0;
//     }
// }
