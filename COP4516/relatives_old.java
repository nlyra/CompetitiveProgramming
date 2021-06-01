// Nathaniel Lyra
// UCF ID: 4214346

import java.util.*;

public class relatives_old {

    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);

        int numPeople = sc.nextInt();
        int numConnections = sc.nextInt();
        boolean broken = false;
        String buffer;
        int id = 1;
        int count = 0;

        // Name and number of connections
        Map<String, person> mappy = new HashMap<>();

        //Create our array of people objects, each person with a unique identifier.
        //ArrayList<person> mappy = new ArrayList<>();
        ArrayList<String> uniqueNames = new ArrayList<>();

        while (numConnections != 0 && numPeople != 0) {

            // Go through each pair of relatives
            for (int i = 0; i < numConnections; i++) {
                // Read in the pairs
                String name1 = sc.next();
                String name2 = sc.next();
                //buffer = sc.next();

                // Update our unique names array list.
                if (!uniqueNames.contains(name1))
                    uniqueNames.add(name1);
                if (!uniqueNames.contains(name2))
                    uniqueNames.add(name2);

                // Create objects for those names.
                person person1 = new person(name1);
                person person2 = new person(name2);

                // If person1 has not yet been seen..
                if (!mappy.containsKey(name1)) {
                    // Add person to map with new connection as well.
                    mappy.put(name1, person1);
                    mappy.get(name1).connections.add(person2);
                }
                // Else, person1 has already been seen, let's update their connections.
                else {
                    mappy.get(name1).connections.add(person2);
                }

                // Do the same thing for person2..
                if (!mappy.containsKey(name2)) {
                    mappy.put(name2, person2);
                    mappy.get(name2).connections.add(person1);
                } else {
                    mappy.get(name2).connections.add(person1);
                }
            }

            // Now that we have our networks created.. let's implement our logic.
            for (String name : uniqueNames) {
                // If the current name does not have any connections
                if (mappy.get(name).connections.isEmpty())
                    broken = true;

            }

            if (broken)
            {
                System.out.println("Network "+id+": DISCONNECTED");
            }
            else {
                System.out.println("Network "+id+": "+count);
            }

            id++;
        }

    }

    public static class person {
        //int id;
        String name;
        List<person> connections = new ArrayList<>();

        public person(String n) {
            this.name = n;
        }

        // Comparing person objects by the name.
        @ Override
        public boolean equals(Object obj) {

            if (obj == null)
                return false;

            if (obj.getClass() != this.getClass())
                return false;

            final person other = (person) obj;

            if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name))
                return false;
            
            return true;
        }
    }
    
}
