// Nathaniel Lyra
// UCF ID 4214346

import java.util.*;

public class excel {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numInputs = sc.nextInt();

        for (int i = 0; i < numInputs; i++)
        {
            int n = sc.nextInt(); // number of non-null entries
            int h = sc.nextInt(); // height in pixels
            int w = sc.nextInt(); // default width in pixels
            int d = sc.nextInt(); // size of each character in pixels

            int maxRow = 1;
            int maxCol = 1;
            int nullSize = w * h;
            double[] alphabet = new double[27];

            // from row 1 to the number of rows
            for (int j = 1; j <= n; j++)
            {
                int r = sc.nextInt(); // row number
                char L = sc.next().charAt(0); // column letter
                String s = sc.next(); // string
                double size = 0;

                // Get max number of rows
                if (r > maxRow)
                    maxRow = r;

                // Get max number of columns
                if ((L - 'A' + 1) > maxCol)
                    maxCol = L - 'A' + 1; 

                // If the new width is greater than the default width..
                if ((s.length() * d) > w)
                    size = (s.length() * d) * h;
                else
                    size = w * h;

                // If there was already a word in that column that was bigger, use that larger size instead
                // If it's the first time we have seen this column (first word in this column)..
                if (alphabet[L - 'A' + 1] == 0)
                {
                    alphabet[L - 'A' + 1] = size;
                }
                // Otherwise we already have a word in there, check if it's bigger than what we had previously
                else
                {
                    if (alphabet[L - 'A' + 1] < size)
                        alphabet[L - 'A' + 1] = size;
                } 
            }

            int total = 0;

            for (double test : alphabet)
            {
                total += test * maxRow;
                if (test != 0)
                    maxCol--;
            }

            // Add in null columns now
            total += maxCol * maxRow * nullSize;

            // Print output
            System.out.println(total);
        }

    }
    
}
