// Nathaniel Lyra
// UCF ID 4214346

import java.util.*;

public class game {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numInputs = sc.nextInt();
        List<String> cases = new ArrayList<>();
        

        for (int i = 0; i < numInputs; i++)
            cases.add(sc.next());

        for (String casey : cases)
        {
            int finalMax = 0, currMove = 0;
            for (int i = 0; i < casey.length(); i++)
            {
                if (casey.charAt(i) == 'v')
                {
                    currMove++;
                    if (currMove >= finalMax)
                        finalMax = currMove;
                }
                    
                else if (casey.charAt(i) == '^')
                    currMove--;
            }

            System.out.println(finalMax);
        }
    }
}
