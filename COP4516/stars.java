// Nathaniel Lyra
// UCF ID 4214346

import java.util.*;

public class stars {

    public static int numConstellations = 0;
    public static int numFixes = 0;
    public static int starCount = 0;
    public static int edgeCount = 0;
    public static boolean needsFixing = false;
    public static List<Integer> brokenNums = new ArrayList<>();

    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        int numNightSkies = sc.nextInt();

        for (int i = 0; i < numNightSkies; i++)
        {
            int numStars = sc.nextInt();
            int numTotalEdges = sc.nextInt();

            // Create our list of stars
            star[] stars = new star[numStars];
            for (int j = 0; j < numStars; j++)
                stars[j] = new star(j);

            // Go through each pair
            for (int j = 0; j < numTotalEdges; j++)
            {
                // Read in the pairs
                int inta = sc.nextInt();
                int intb = sc.nextInt();

                // Add relationship to each other.
                stars[inta-1].connection.add(stars[intb-1]);
                stars[intb-1].connection.add(stars[inta-1]);
            }

            // Go through each star and check connections.
            for (int j = 0; j < numStars; j++)
            {
                // If it's not a broken number (number in a constellation that needs fixing).
                if (!brokenNums.contains(j))
                {
                    // Add all number in this current constellation, if any this constellation is broken, blacklist them all.
                    ArrayList<Integer> maybeBroken = new ArrayList<>();

                    // Single star with no connections.
                    if (stars[j].connection.isEmpty())
                        continue;

                    // If the star exists and it hasn't been seen yet..
                    if (stars[j].seen == false)
                    {
                        stars[j].seen = true; // It has now been seen.
                        starCount++; // We have our first star, but no edges yet.
                        numConstellations++; // We have a new constellation.
                        maybeBroken.add(stars[j].identifier);
                        doTheThing(stars[j], stars[j], maybeBroken);
                    }
                    else
                    {
                        starCount = 0; // New constellation, reset count.
                        needsFixing = false;
                        continue;
                    }

                    // If the number of edges in this constellation is not v - 1, it needs fixing.
                    if (needsFixing)
                    {
                        numFixes++;
                        needsFixing = false;
                    }
                }
            }

            // Print results
            System.out.println("Night sky #"+(i+1)+": "+(numConstellations)+" constellations, of which "+(numFixes)+" need to be fixed.");
            System.out.println();

            // Reset variables for next night sky.
            numConstellations = 0;
            numFixes = 0;
            starCount = 0;
            edgeCount = 0;
            needsFixing = false;
            brokenNums.clear();
        }
    }

    // Recursive method to traverse through star nodes and mark them as visited.
    public static void doTheThing(star starry, star prev, ArrayList<Integer> maybeBroken)
    {
        maybeBroken.add(starry.identifier);
        maybeBroken.add(prev.identifier);

        // Base case (no connections, end of constellation).
        if (starry.connection.isEmpty())
            return;

        // Otherwise the star does have connections..
        else
        {
            // Go through each of its connections, and make recursive calls on it.
            for (star child : starry.connection)
            {
                // If we haven't yet seen that child..
                if (child.seen == false)
                {
                    starCount++;
                    edgeCount++; // Increase our edge count.
                    child.seen = true; // Mark this star as seen.
                    doTheThing(child, starry, maybeBroken); // Recursive call on that child node to check its connections.
                }
                // If the child node has already been seen, but it's not the node we came from, it's a cycle.
                else if (child.identifier != prev.identifier)
                {
                    needsFixing = true;
                    brokenNums.addAll(maybeBroken); // This constellation is broken, blacklist all numbers.
                    return;
                }
                
            }
        }
    }


    public static class star {
        int identifier;
        List<star> connection = new ArrayList<>();
        boolean seen;

        public star(int id) {
            this.identifier = id;
            seen = false;
        }
    }
    
}