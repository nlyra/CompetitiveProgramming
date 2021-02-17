// Nathaniel Lyra
// UCF ID 4214346

import java.util.*;
import java.math.*;

public class paper {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numInputs = sc.nextInt();
        int totalSheets = 0;

        for (int i = 0; i < numInputs; i++)
        {
            int numExams = sc.nextInt();

            for (int j = 0; j < numExams; j++)
            {
                int numStudents = sc.nextInt();
                int numPages = sc.nextInt();
                double numSheets = 4;

                int temp = (int)Math.ceil(numPages/numSheets);
                temp *= numStudents;
                totalSheets += temp;
            }

            System.out.println(totalSheets);
            totalSheets = 0;
        }

    }

}