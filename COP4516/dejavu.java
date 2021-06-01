// Nathaniel Lyra
// UCF ID 4214346

import java.util.*;

public class dejavu {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numInputs = sc.nextInt();

        for (int input = 0; input < numInputs; input++)
        {
            String word = sc.next();
            String a = "a";
            String result;
            boolean flag = true;

            // Check base case
            result = a.concat(word);

            // if(!result.equals(new StringBuilder(result).reverse().toString()))
            // {
            //     System.out.println("YES");
            //     System.out.println(result);
            //     continue;
            // }
            
            if (!isPalindrome(result))
            {
                System.out.println("YES");
                System.out.println(result);
                continue;
            }

            // Loop until out i index reaches the last index of the string
            int i = 1;
            while (i < word.length())
            {
                String temp1 = word.substring(0, i);
                String temp2 = word.substring(i, word.length());

                temp1 = temp1.concat(a);
                temp1 = temp1.concat(temp2);

                // if(!temp1.equals(new StringBuilder(temp1).reverse().toString()))
                // {
                //     System.out.println("YES");
                //     System.out.println(temp1);
                //     flag = false;
                //     break;
                // }

                if (!isPalindrome(temp1))
                {
                    System.out.println("YES");
                    System.out.println(temp1);
                    flag = false;
                    break;
                }

                i++;
            }

            if (flag)
            {
                System.out.println("NO");
            }
        }

    }

    public static boolean isPalindrome(String letters)
    {
        int i = 0, j = letters.length() - 1;

        while (i < j)
        {
            if (letters.charAt(i) != letters.charAt(j))
                return false;

            i++;
            j--;
        }

        return true;
    }
    
}
