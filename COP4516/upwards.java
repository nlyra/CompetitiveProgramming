// Nathaniel Lyra
// UCF ID 4214346

import java.util.*;

public class upwards {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numWords = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < numWords; i++)
        {
            String word = sc.nextLine();
            if (isUp(word)) System.out.println("YES");
            else System.out.println("NO");
        }

        sc.close();
    }

    public static boolean isUp(String word) {

        for (int i = 0; i < word.length() - 1; i++)
        {
            if ((word.charAt(i) - 'a') < (word.charAt(i + 1) - 'a')) continue;
            else return false;
        }

        return true;
    }
}
