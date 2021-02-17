// Nathaniel Lyra
// UCF ID 4214346

import java.util.*;

public class sameletters {

    public static void main(String[] args) {

        Scanner sc = new Scanner (System.in);
        String input1 = sc.next();
        int caseNum = 1;

        while (!input1.equals("END"))
        {
            String input2 = sc.next();
            doTheThing(input1, input2, caseNum);
            caseNum++;
            input1 = sc.next(); // Check next one.
        }

    }

    public static void doTheThing(String input1, String input2, int caseNum) {

        int len1 = input1.length();
        int len2 = input2.length();

        // Base case, if the lengths are different.
        if (len1 != len2)
        {
            System.out.println("Case "+caseNum+": different");
            return;
        }

        Map<Character, Integer> charFreq = new HashMap<>();

        // Initialize our frequency hashmap.
        for (int i = 0; i < len1; i++)
        {
            // If our map already contains this letter, just increment its frequency.
            if (charFreq.containsKey(input1.charAt(i)))
                charFreq.put(input1.charAt(i), charFreq.get(input1.charAt(i)) + 1);
            // New letter, not yet seen.
            else
                charFreq.put(input1.charAt(i), 1);
        }

        // Go through the second input, and decrement hashmaps count.
        for (int i = 0; i < len2; i++)
        {
            // If our map contains this letter from input 2, decrement its count.
            if (charFreq.containsKey(input2.charAt(i)))
                charFreq.put(input2.charAt(i), charFreq.get(input2.charAt(i)) - 1);
            // Else there is no such letter in our freq array, return.
            else
            {
                System.out.println("Case "+caseNum+": different");
                return;
            }
        }

        // Finally, let's check the case for having the same letters, but not the same count of them.
        for (int i = 0; i < len1; i++)
        {
            // If there are any frequencies left in our map.
            if (charFreq.get(input1.charAt(i)) > 0)
            {
                System.out.println("Case "+caseNum+": different");
                return;
            }
        }

        // Else we return true.
        System.out.println("Case "+caseNum+": same");
    }
    
}
