// Nathaniel Lyra
// UCF ID: 4214346

import java.util.*;

public class relatives {

    public static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int networkNum = 1;

        int numPeople = sc.nextInt();
        int numConnections = sc.nextInt();

        while (numPeople != 0 && numConnections != 0)
        {
            int ID = 0;
            HashMap<String, Integer> mappy = new HashMap<>();
            Integer[][] adj = new Integer[numPeople][numPeople];
            int maxDistance = 0;
            boolean disconnected = false;

            // Go through each pair of connections and add distance of 1 (to represent an edge between each connection).
            for (int i = 0; i < numConnections; i++)
            {
                String name1 = sc.next();
                String name2 = sc.next();

                // Put them in a hashmap if they don't yet exist so we can get a unique int identifier.
                if (!mappy.containsKey(name1))
                    mappy.put(name1, ID++);
                
                if (!mappy.containsKey(name2))
                    mappy.put(name2, ID++);

                // Add to adjacency matrix.
                adj[mappy.get(name1)][mappy.get(name2)] = 1;
                adj[mappy.get(name2)][mappy.get(name1)] = 1;
            }

            // Initialize values to themselves as 0, and all others to INF
            for (int i = 0; i < numPeople; i++)
                for (int j = 0; j < numPeople; j++)
                {
                    // Set weight to self as 0.
                    if (i == j)
                        adj[i][j] = 0;

                    // If value is null, set it to infinity.
                    if (adj[i][j] == null)
                        adj[i][j] = INF;
                }

            // Run floyd's algo on adjacency matrix.
            for (int k = 0; k < numPeople; ++k)
                for (int i = 0; i < numPeople; ++i)
                    for (int j = 0; j < numPeople; ++j)
                        if (adj[i][j] > adj[i][k] + adj[k][j] && adj[i][k] < INF && adj[k][j] < INF)
                        {
                            // Using node k helps, update the weight and the predecessor of i -> j
                            adj[i][j] = adj[i][k] + adj[k][j];
                        }

            // Go through our new adjacency matrix and check for max distance and if there are any disconnects.
            for (int i = 0; i < numPeople; i++)
            {   
                for (int j = 0; j < numPeople; j++)
                {
                    // If there's a disconnect (infinity), flag and break.
                    if (adj[i][j] == INF)
                    {
                        disconnected = true;
                        break;
                    }
                    else if (adj[i][j] > maxDistance)
                    {
                        maxDistance = adj[i][j];
                    }
                }

                // If there's a disconnect (infinity), flag and break.
                if (disconnected)
                    break;
            }

            // Print output
            if (disconnected)
            {
                System.out.println("Network "+networkNum+": DISCONNECTED");
            }
            else
            {
                System.out.println("Network "+networkNum+": "+maxDistance);
            }
            System.out.println();

            // Read next network.
            numPeople = sc.nextInt();
            numConnections = sc.nextInt();
            networkNum++;
        }
        
    }
    
}
