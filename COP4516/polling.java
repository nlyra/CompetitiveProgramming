// Nathaniel Lyra
// UCF ID 4214346

import java.util.*;

public class polling {

    public int maxVotes = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numInputs = sc.nextInt();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        //sc.nextLine();

        for (int i = 0; i < numInputs; i++)
        {
            // Gets new input
            String name = sc.next();

            // If candidate is already in our map, increment num of votes
            if (map.containsKey(name))
            {
                map.put(name, map.get(name) + 1);
            }
            else
            {
                // Add new candidate and count 1 vote
                map.put(name, 1);
            }
        }

        // We create an ArrayList to put the Hashmap objects inside of (for purposes of sorting)
        // using a new class Candidate
        ArrayList<Candidate> list = new ArrayList<Candidate>();

        // For each key of the hashmap set, we add to our list
        for (String name : map.keySet())
            list.add(new Candidate(name, map.get(name)));

        // Using java API, we can sort the list
        Collections.sort(list);

        int max = 0;
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).getVotes() > max)
                max = list.get(i).getVotes();
        }

        ArrayList<String> names = new ArrayList<String>();
        
        // Get the max of the candidates
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).getVotes() == max)
                names.add(list.get(i).getName());
        }

        for (String name: names)
            System.out.println(name);
    }
    
}

// New class to represent each unique candidate and their votes
class Candidate implements Comparable<Candidate> {

    private String name;
    private int numVotes;

    public Candidate(String name, int votes) {
        this.name = name;
        this.numVotes = votes;
    }

    public int compareTo(Candidate other) {

        // If they are not a tie
        if (this.numVotes != other.numVotes)
        {
            return this.numVotes - other.numVotes;
        }
        // If they are a tie for votes, go by alphabetical order
        else
        {
            return this.name.compareTo(other.name);
        }

    }

    public String getName() {
        return this.name;
    }

    public int getVotes() {
        return this.numVotes;
    }
}
