// Nathaniel Lyra
// UCF ID 4214346

import java.text.*;
import java.util.*;

public class triathlon {

    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        int numRaces = sc.nextInt();

        for (int i = 0; i < numRaces; i++)
        {
            int numCompetitors = sc.nextInt();
            float milesSwim = sc.nextFloat();
            float milesBike = sc.nextFloat();
            float milesRun = sc.nextFloat();

            // Instantiate all contestants in our contestant array.
            List<contestant> contestants = new ArrayList<contestant>();
            for (int j = 0; j < numCompetitors; j++)
            {
                String lastName = sc.next();
                String firstName = sc.next();
                int age = sc.nextInt();
                float timeSwim = sc.nextFloat();
                float timeBike = sc.nextFloat();
                float timeRun = sc.nextFloat();
                contestants.add(new contestant(lastName, firstName, age, timeSwim, timeBike, timeRun));

                // Perform the calculations.
                float calc1 = milesSwim/timeSwim;
                float calc2 = milesBike/timeBike;
                float calc3 = milesRun/timeRun;
                float res = calc1 + calc2 + calc3;

                // Add result to contestant object.
                contestants.get(j).finishTime = res;
            }

            // Sort them by using our comparable implementation.
            Collections.sort(contestants);

            System.out.println("Race "+(i+1)+":");

            for (int j = 0; j < numCompetitors; j++)
                contestants.get(j).printMe();
            
            System.out.println();
        }
    }

    // Contestant class
    // Sort by finished time. 
    // If tie, sort by age (younger first).
    // If same age, sort alphabetically by last name, then first name.
    public static class contestant implements Comparable<contestant> {

        int age;
        String firstName;
        String lastName;
        float timeSwim;
        float timeBike;
        float timeRun;
        float finishTime;

        public contestant(String ln, String fn, int a, float ts, float tb, float tr) {
            this.age = a;
            this.firstName = fn;
            this.lastName = ln;
            this.timeSwim = ts;
            this.timeBike = tb;
            this.timeRun = tr;
        }

        public void printMe()
        {
            System.out.printf("%s %s %.3f\n", this.lastName, this.firstName, this.finishTime);
        }

        @ Override
        public int compareTo(contestant other) {

            if (this.finishTime > other.finishTime)
                return 1;
            else if (this.finishTime < other.finishTime)
                return -1;
            // Otherwise they're equal times.
            else
            {
                // Sort by age instead.
                if (this.age > other.age)
                    return 1;
                else if (this.age < other.age)
                    return -1;
                // Otherwise they're the same age too, sort alphabetically.
                else
                {
                    // Compare last names.
                    String tempLastNameThis = this.lastName.toLowerCase();
                    String tempLastNameOther = other.lastName.toLowerCase();
                    int compareToResult = tempLastNameThis.compareTo(tempLastNameOther);

                    // If they're the same last name, we compare by first name instead..
                    if (compareToResult == 0)
                    {
                        // Return which first name comes first.
                        String tempFirstNameThis = this.firstName.toLowerCase();
                        String tempFirstNameOther = other.firstName.toLowerCase();
                        return (tempFirstNameThis.compareTo(tempFirstNameOther));
                    }
                    // Otherwise they don't have the same last name, and return the compareTo result.
                    else
                        return compareToResult;

                }
            } 
        }
    }
}
