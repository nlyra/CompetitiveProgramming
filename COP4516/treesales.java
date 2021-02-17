// Nathaniel Lyra
// UCF ID 4214346

import java.util.*;

public class treesales {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numCompanies = sc.nextInt();

        for (int i = 0; i < numCompanies; i++)
        {
            System.out.println("COMPANY " + (i+1));
            HashMap<String, TreeNode> mappy = new HashMap<>();
            int numOperations = sc.nextInt();

            for (int j = 0; j < numOperations; j++)
            {
                String operation = sc.next();

                if (operation.equals("ADD"))
                {
                    String parent = sc.next();
                    String child = sc.next();

                    if (parent.equals("ROOT"))
                    {
                        TreeNode root = new TreeNode();
                        root.name = child;
                        root.parent = null;
                        mappy.put(child, root);
                        continue;
                    }
                    else
                    {
                        TreeNode current = new TreeNode();
                        current.name = child;
                        current.parent = mappy.get(parent);
                        mappy.put(child, current);

                    }
                }
                else if (operation.equals("SALE"))
                {
                    String employee = sc.next();
                    int value = sc.nextInt();

                    // Increment value for that employee
                    TreeNode temp = mappy.get(employee);
                    temp.sales += value;

                    // Increment value for all of that employee's parent nodes
                    while(temp.parent != null)
                    {
                        temp = temp.parent;
                        temp.sales += value;
                    }

                }
                else if (operation.equals("QUERY"))
                {
                    String employee = sc.next();

                    // Print that employee's sales
                    System.out.println(mappy.get(employee).sales);
                }
            }
        }


    }    
}

class TreeNode
{
    String name;
    TreeNode parent;
    int sales;
}