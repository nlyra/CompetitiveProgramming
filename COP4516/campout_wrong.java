// Nathaniel Lyra
// UCF ID 4214346

import java.util.*;

public class campout_wrong {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int inputs = 0; inputs < n; inputs++)
        {
            int[][] schedule = new int[7][24];
            boolean flag = true;
            //student[] students = new student[10];
            // 10 students in each group
            for (int s = 0; s < 10; s++)
            {
                int numIntervals = sc.nextInt();
                //students[s].numBusyIntervals = numIntervals;
                // Go through however many number of intervals this student is busy with
                for (int b = 0; b < numIntervals; b++)
                {
                    // Capture the days they're busy, the start, and the end.
                    int day = sc.nextInt() - 1;
                    int start = sc.nextInt();
                    int end = sc.nextInt();
                    //students[s].d = day;
                    //students[s].s = start;
                    //students[s].e = end;

                    // Increment number of frequency for those hours that a student is busy
                    for (int x = start; x < end; x++)
                    {
                        
                        schedule[day][x] += 1;
                    }
                }
            }

            for (int i = 0; i < 7; i++)
            {
                for (int j = 0; j < 24; j++)
                {
                    if (schedule[i][j] > 7)
                    {
                        System.out.println("Case #"+(inputs+1)+": NO");
                        System.out.println();
                        flag = false;
                        break;
                    }
                }
                if (!flag)
                    break;
            }

            if (flag)
            {
                System.out.println("Case #"+(inputs+1)+": YES");
                System.out.println();
            }
        }
    }
    
}

class student {
    int numBusyIntervals;
    int d, s, e;

    // public student(int b, int d, int s, int e)
    // {
    //     this.numBusyIntervals = b;
    //     this.
    // }
}

