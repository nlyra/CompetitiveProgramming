import java.util.*;

public class tri {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numInputs = sc.nextInt();
        int caseNum = 1;

        while (numInputs != 0)
        {
            // Read in the graph.
            int[][] graph = new int[numInputs][3];
            for (int i = 0; i < numInputs; i++)
            {
                graph[i][0] = sc.nextInt();
                graph[i][1] = sc.nextInt();
                graph[i][2] = sc.nextInt();
            }
    
            // The first row you cannot go from the middle node to the left node, so the first case is different from the rest.
            int node1 = Integer.MAX_VALUE;
            int node2 = graph[0][1];
            int node3 = graph[0][1] + graph[0][2]; // The cost of going from the middle node to the right node.
    
            // For each subsequent row, figure out the minimum cost to travel to each node.
            for (int i = 1; i < numInputs; i++)
            {
                // Shortest weight between previous first two nodes plus itself.
                int weight1 = Integer.min(node1, node2);
                weight1 += graph[i][0]; // Plus its own weight.
    
                // Shortest weight between the previous calculation and the first node, and the 2nd and 3rd nodes.
                int weight2 = Integer.min(Integer.min(weight1, node1), Integer.min(node2, node3));
                weight2 += graph[i][1]; // Plus its own weight.
    
                // Shortest weight between the previous calculation and the second node, and the 3rd node.
                int weight3 = Integer.min(Integer.min(weight2, node2), node3);
                weight3 += graph[i][2]; // Plus its own weight.
    
                // Update next row of nodes.
                node1 = weight1;
                node2 = weight2; // Middle node.
                node3 = weight3;
            }

            System.out.println(caseNum+". "+node2);
            caseNum++;
            numInputs = sc.nextInt();
        }
    }
}
