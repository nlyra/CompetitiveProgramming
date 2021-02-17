// Nathaniel Lyra
// UCF ID 4214346

import java.util.*;

public class passwords {

    //final public static int MAX_RANKINGS = 1048576;
    public static int count = 0;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numOfInputs = sc.nextInt();
        //String[] rankings = new String[MAX_RANKINGS];

        for (int i = 0; i < numOfInputs; i++)
        {
            int numPossibles = sc.nextInt();
            String[] possibles = new String[numPossibles];
            sc.nextLine();

            for (int j = 0; j < numPossibles; j++)
            {
                possibles[j] = sc.nextLine();
            }

            int rank = sc.nextInt();
            int k = 0;
            char[] printMe = new char[numPossibles];

            crackTheCode(possibles, rank, k, printMe);
            //System.out.println(count);
            count = 0;
        }

    }

    public static void crackTheCode(String[] possibles, int rank, int k, char[] printMe) {

        if (k == possibles.length || count >= rank) return;

        // Try each possible letter in each slot "k"
        for (int i = 0; i < possibles[k].length(); i++)
        {
            printMe[k] = possibles[k].charAt(i);
            crackTheCode(possibles, rank, k+1, printMe);
            count++;

            if (rank == count)
            {
                System.out.println(new String(printMe));
                return;
            } 
        }

        count--;
    }
}
