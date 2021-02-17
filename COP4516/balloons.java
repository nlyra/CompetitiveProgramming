// Nathaniel Lyra
// UCF ID 4214346

import java.util.*;
import java.lang.*;

public class balloons {


    public static int totalCount = 0;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numTeams = sc.nextInt(), balloonsA = sc.nextInt(), balloonsB = sc.nextInt();

        while (true)
        {
            if (numTeams == 0 && balloonsA == 0 && balloonsB == 0)
                break;

            ArrayList<team> teamsArr = new ArrayList<team>(numTeams);

            for (int i = 0; i < numTeams; i++)
            {
                int n = sc.nextInt(), d1 = sc.nextInt(), d2 = sc.nextInt();
                teamsArr.add(i, (new team(n, d1, d2, Math.abs(d1 - d2))));
            }
    
            // Sort array descending for priority
            Collections.sort(teamsArr);
            //Collections.reverse(teamsArr);
    
            // // Debug
            // for (team test : teamsArr)
            // {
            //     test.printPriority();
            // }
    
            for (team contestants : teamsArr)
            {
                // If distance to A is shorter
                if (contestants.DA < contestants.DB)
                {
                    // If we have enough balloons at that location for the amount needed.
                    if (balloonsA >= contestants.numBalloonsNeeded)
                    {
                        totalCount += (contestants.DA * contestants.numBalloonsNeeded);
                        balloonsA -= contestants.numBalloonsNeeded;
                        contestants.numBalloonsNeeded = 0;
                    }
                    // Otherwise we don't have enough, and can only take some.
                    else if (balloonsA < contestants.numBalloonsNeeded)
                    {
                        // Take some, zero out balloons for that room.
                        totalCount += (contestants.DA * balloonsA);
                        contestants.numBalloonsNeeded -= balloonsA;
                        balloonsA = 0;

                        // Try to take some from the other room..
                        if (balloonsB >= contestants.numBalloonsNeeded)
                        {
                            totalCount += (contestants.DB * contestants.numBalloonsNeeded);
                            balloonsB -= contestants.numBalloonsNeeded;
                            contestants.numBalloonsNeeded = 0;
                        }
                        // Otherwise we don't have enough, take what we can.
                        else if (balloonsB < contestants.numBalloonsNeeded)
                        {
                            totalCount += (contestants.DB * balloonsB);
                            contestants.numBalloonsNeeded -= balloonsB;
                            balloonsB = 0;
                        }
                    }
                }
                else
                {
                    // If we have enough balloons at that location for the amount needed.
                    if (balloonsB >= contestants.numBalloonsNeeded)
                    {
                        totalCount += (contestants.DB * contestants.numBalloonsNeeded);
                        balloonsB -= contestants.numBalloonsNeeded;
                        contestants.numBalloonsNeeded = 0;
                    }
                    // Otherwise we don't have enough, and can only take some.
                    else if (balloonsB < contestants.numBalloonsNeeded)
                    {
                        // Take some, zero out balloons for that room.
                        totalCount += (contestants.DB * balloonsB);
                        contestants.numBalloonsNeeded -= balloonsB;
                        balloonsB = 0;

                        // Try to take some from the other room..
                        if (balloonsA >= contestants.numBalloonsNeeded)
                        {
                            totalCount += (contestants.DA * contestants.numBalloonsNeeded);
                            balloonsA -= contestants.numBalloonsNeeded;
                            contestants.numBalloonsNeeded = 0;
                        }
                        // Otherwise we don't have enough, take what we can.
                        else if (balloonsA < contestants.numBalloonsNeeded)
                        {
                            totalCount += (contestants.DB * balloonsB);
                            contestants.numBalloonsNeeded -= balloonsA;
                            balloonsA = 0;
                        }
                    }
                }
            }

            System.out.println(totalCount);

            // Get next input test case
            numTeams = sc.nextInt();
            balloonsA = sc.nextInt();
            balloonsB = sc.nextInt();
            totalCount = 0;
        }

    }
    
}

class team implements Comparable<team>{

    public int numBalloonsNeeded, DA, DB, priorityAbs;

    public team(int n, int da, int db, int priority)
    {
        this.numBalloonsNeeded = n;
        this.DA = da;
        this.DB = db;
        this.priorityAbs = priority;
    }

    // Debug
    public void printMe() {
        System.out.print(this.numBalloonsNeeded + " ");
        System.out.print(this.DA + " ");
        System.out.print(this.DB);
        System.out.println();
    }

    public void printPriority() {
        System.out.println(this.priorityAbs);
    }

    public int compareTo(team other) {
        return other.priorityAbs - this.priorityAbs;
    }

}
