// Nathaniel Lyra
// UCF ID 4214346

import java.util.*;

public class security {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numInputs = sc.nextInt();

        for (int input = 0; input < numInputs; input++)
        {
            int n = sc.nextInt(); // Number of rooms
            int a = sc.nextInt(); // First constant
            int b = sc.nextInt(); // Second constant

            // Read input for president's party's rooms
            ArrayList<Integer> rooms = new ArrayList<>();
            for (int i = 0; i < n; i++)
                rooms.add(sc.nextInt());

            // Runs prims algo on rooms
            int res = runPrims(rooms, n, a, b);

            // Print output
            System.out.println(res);
        }
    }

    // Prim's algo
    public static int runPrims(ArrayList<Integer> rooms, int n, int a, int b)
    {
        boolean[] used = new boolean[n];
        used[0] = true; // Initialize the first one

        // Add edges to priority queue
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 1; i < n; i++)
        {
            int weight = calculate(rooms.get(0), rooms.get(i), a, b);
            pq.offer(new Edge(0, i, weight));
        }

        int mstWeight = 0;

        // Implement algo in loop
        for (int i = 1; i < n; i++)
        {
            Edge curr = pq.poll();

            // Move our edge
            while (used[curr.vtx1] && used[curr.vtx2])
                curr = pq.poll();

            // Update the weight
            mstWeight += curr.w;

            // Declar new vertex
            int unseen;

            // Set it to the one that has not yet been seen
            if (!used[curr.vtx1]) unseen = curr.vtx1;
            else unseen = curr.vtx2;

            // Add to pq
            for (int j = 0; j < n; j++)
            {
                // If it's new and unseen, instantiate a new one
                if (j != unseen)
                {
                    if (!used[j])
                    {
                        int tempWeight = calculate(rooms.get(unseen), rooms.get(j), a, b);
                        pq.offer(new Edge(unseen, j, tempWeight));
                    }
                }
                // Mark as used
                used[unseen] = true;
            }
        }

        return mstWeight;
    }

    public static int calculate(int firstRoom, int secondRoom, int a, int b)
    {
        // Implement formula from solution sketch
        return a*Math.abs(firstRoom % 100 - secondRoom % 100) + b * Math.abs(firstRoom / 100 - secondRoom / 100);
    }
    
}

class Edge implements Comparable<Edge> {

    public int w;
    public int vtx1;
    public int vtx2;

    public Edge(int first, int last, int w)
    {
        this.w = w;
        this.vtx1 = first;
        this.vtx2 = last;
    }

    public int compareTo(Edge other) {
		return this.w - other.w;
	}
}
