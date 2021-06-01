import java.util.*;

public class christmas {
    final public static int MAX_SIZE = 10000001;
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        long[] sequence = new long[MAX_SIZE];
        long[] gifts = new long[MAX_SIZE];

        sequence[0] = 0;
        gifts[0] = 0;
        for(int i = 1; i < MAX_SIZE; i++)
        {
            gifts[i] = gifts[i-1] + i;
            sequence[i] = gifts[i] + sequence[i-1];
        }
        
        while(true)
        {
            int n = in.nextInt();
            if(n == 0)
                break;
            
            System.out.println(sequence[n]);
        }
    }
}
