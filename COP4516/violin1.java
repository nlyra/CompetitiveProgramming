// Nathaniel Lyra
// UCF ID 4214346

import java.util.*;

public class violin1 {

    public static int count = 0;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numInputs = sc.nextInt();

        for (int i = 0; i < numInputs; i++)
        {
            int numNotes = sc.nextInt();

            int[] notesArr = new int[numNotes];
            for (int j = 0; j < numNotes; j++)
            {
                notesArr[j] = sc.nextInt();
            }

            // // Debug
            // for (int num : notesArr)
            //     System.out.println(num);

            doTheThing(notesArr, numNotes);
            System.out.println(count);
            count = 0;
        }
    }

    public static void doTheThing(int[] notesArr, int numNotes) {

        // Initialize our fingers boolean array, size 5 (fingers 0-4), all initialized to false at first.
        boolean[] fingers = new boolean[5];

        // Go through each of the notes given.
        for (int note : notesArr)
        {
            // Put all higher note fingers down.
            putHigherFingersDown(note, fingers);

            // If that note is not yet down, put it down and mark all others above it to false.
            if (!fingers[note] && note != 0)
            {
                fingers[note] = true;
                count++;
            }
        }
    }

    // Helper method to put higher note fingers down.
    public static void putHigherFingersDown(int note, boolean[] fingers) {
        
        // Put every finger higher than note down
        for (int i = note + 1; i < 5; i++)
        {
            if (fingers[i])
            {
                fingers[i] = false;
                count++;
            }
        }
    }
}
