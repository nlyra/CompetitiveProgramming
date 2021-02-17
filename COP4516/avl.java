// Nathaniel Lyra
// UCF ID 4214346

import java.util.*;

public class avl {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int inputCases = sc.nextInt();

        for (int i = 0; i < inputCases; i++)
        {
            int size = sc.nextInt();
            avltree tree = new avltree();

            // Insert new nodes to the root each time.
            for (int j = 0; j < size; j++)
            {
                int value = sc.nextInt();
                tree.root = tree.insert(tree.root, value);
            }
            
            // If it requires re-balancing, remove it. Otherwise, keep.
            if (tree.reqBalancing)
                System.out.println("Tree #"+(i+1)+": REMOVE");
            else if (!tree.reqBalancing)
                System.out.println("Tree #"+(i+1)+": KEEP");

        }

    }
    
}

class node {
    int height, value;
    node left, right;

    node(int v) {
        this.height = 1;
        this.value = v;
    }
}

class avltree {
    
    public boolean reqBalancing = false;
    node root;

    // Return height of node
    int height(node n) {
        
        if (n == null)
            return 0;

        return n.height;
    }

    // Returns the node's balance factor
    int balance(node n) {
        
        if (n == null)
            return 0;

        return height(n.left) - height(n.right);
    }

    node insert(node rootNode, int val) {

        // If null, create new node with given value
        if (rootNode == null)
            return (new node(val));

        // If the value is less than the current node's value, recursively call insert on
        // the left subtree of the node.
        if (val < rootNode.value)
            rootNode.left = (insert(rootNode.left, val));
        // Else if the value is greater than current node's value, recursively call insert on
        // the right subtree of the node.
        else if (val > rootNode.value)
            rootNode.right = (insert(rootNode.right, val));
        // Otherwise simply return new node (if values are equal).
        else
            return rootNode;

        // We need to update the height of this current note, wherever it may be
        // in this recursion process.
        rootNode.height = Integer.max(height(rootNode.left), height(rootNode.right)) + 1;

        // Now we check if there is any imbalance. If so, set global flag to true.
        int bal = Math.abs(balance(rootNode));
        if (bal > 1)
            reqBalancing = true;

        // Return the same node after alterations on its subtrees.
        return rootNode;
    }
}
