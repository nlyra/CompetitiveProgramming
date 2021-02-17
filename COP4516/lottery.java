// Nathaniel Lyra
// UCF ID 4214346

import java.util.*;

public class lottery {

    final static int ALPHABET_SIZE = 26;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numInputs = sc.nextInt();

        // Go through each lottery
        for (int i = 0; i < numInputs; i++)
        {
            System.out.println("Lottery #"+(i+1)+":");

            // Create our trie node roots for forward and reverse, as well as a flag.
            TrieNode forwardRoot = new TrieNode();
            TrieNode reverseRoot = new TrieNode();
            boolean isReversed = false;
            
            // Go through each query in the lottery
            int numQueries = sc.nextInt();
            for (int j = 0; j < numQueries; j++)
            {
                int query = sc.nextInt();

                // Given s, add a participant with name s
                if (query == 1)
                {
                    String word = sc.next();

                    if (!isReversed)
                    {
                        forwardRoot.insert(word, forwardRoot);
                        StringBuilder tempBuilder = new StringBuilder();
                        tempBuilder.append(word);
                        tempBuilder.reverse();
                        word = tempBuilder.toString();
                        reverseRoot.insert(word, reverseRoot);
                    }
                    else
                    {
                        reverseRoot.insert(word, reverseRoot);
                        StringBuilder tempBuilder = new StringBuilder();
                        tempBuilder.append(word);
                        tempBuilder.reverse();
                        word = tempBuilder.toString();
                        forwardRoot.insert(word, forwardRoot);
                    }
                }
                // Given s, generate a string s in the draw and print the number of winners
                else if (query == 2)
                {
                    String prefix = sc.next();
                    // If we are in reverse mode
                    if (isReversed)
                    {
                        System.out.println(reverseRoot.queryPrefix(prefix, reverseRoot));
                    }
                    // Otherwise we are in the forward trie
                    else
                    {
                        System.out.println(forwardRoot.queryPrefix(prefix, forwardRoot));
                    }
                }
                // Reverse the name of all participants added
                else if (query == 3)
                {
                    // If it's flagged, unflag it.
                    if (isReversed)
                        isReversed = false;
                    // Else it's unflagged, so flag it.
                    else
                        isReversed = true;
                }
            }

            System.out.println();
        }
    }

    public static class TrieNode {
        // Member variables for a new trie node.
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        int numWords;
    
        // Constructor
        TrieNode() {
            // Create new instantiation of a trie node.
            numWords = 0;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                children[i] = null;
        }

        // Insert function
        public void insert(String key, TrieNode root) {

            int currIndex;
            int wordSize = key.length();
            TrieNode wizard = root;

            for (int level = 0; level < wordSize; level++)
            {
                currIndex = key.charAt(level) - 'a'; // Get numeric representation of letter.
                if (wizard.children[currIndex] == null)
                {
                    wizard.children[currIndex] = new TrieNode();
                } 
                
                // Our wizard will jump there now!
                wizard.children[currIndex].numWords++;
                wizard = wizard.children[currIndex];
            }
        }

        // Query function, to see how many winners in this lottery there are.
        public int queryPrefix(String key, TrieNode root) {

            int currIndex;
            int wordSize = key.length();
            TrieNode wizard = root;

            for (int level = 0; level < wordSize; level++)
            {
                currIndex = key.charAt(level) - 'a';
                if (wizard.children[currIndex] == null) 
                    return 0;
                
                // Move our wizard
                wizard = wizard.children[currIndex];
            }

            // If we are done looping, it means we have reached the end of the key and have found
            // all children nodes. If we are at the leaf, return true. Otherwise, false.
            if (wizard != null)
                return wizard.numWords;
            else
                return 0;
        }
    }
    
}
