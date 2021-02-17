// Nathaniel Lyra
// UCF ID 4214346

import java.util.*;

public class cowphabet {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String cowphabet = sc.nextLine();
        String lettersHeard = sc.nextLine();
        int totalCount = 0;
        int i = 0;

        // // Debug
        // System.out.println(cowphabet);
        // System.out.println(lettersHeard);

        while (true)
        {
            for (int j = 0; j < cowphabet.length(); j++)
            {
                // If the letter heard matches the current index of the cowphabet, increment to the next index.
                if (cowphabet.charAt(j) == lettersHeard.charAt(i))
                {
                    i++;

                    if (i == lettersHeard.length())
                    {
                        totalCount++;
                        System.out.println(totalCount);
                        return;
                    }
                }

                // If we're at the last letter of the cowphabet, we have gone through it once.
                if (j == cowphabet.length() - 1)
                    totalCount++;
            }

            // If we have reached the end of the word Farmer John heard.
            if (i == lettersHeard.length())
                break;
        }

        System.out.println(totalCount);
    }
    
}
