// Nathaniel Lyra
// UCF ID 4214346

import java.util.*;

public class squirrels {

    public static void main(String[] agrs) {

        Scanner sc = new Scanner(System.in);
        int numInputs = sc.nextInt();

        for (int input = 1; input <= numInputs; input++)
        {
            int t = sc.nextInt();
            List<Double> results = new ArrayList<>();
            List<pointy> points = new ArrayList<>(t);
            //double[][] points = new double[t][2]; // t rows with 2 points (2 columns)

            // Initialize our 2d points array
            for (int tree = 0; tree < t; tree++)
            {
                // Get both points.
                pointy temp = new pointy(sc.nextInt(), sc.nextInt());
                points.add(temp);
            }

            // Calculate results for distances between all points
            for (int i = 0; i < t-1; i++)
            {
                for (int j = i+1; j < t; j++)
                {
                    double tempRes = distance(points.get(i), points.get(j));
                    tempRes = Math.pow((tempRes/2), 2) * Math.PI;
                    results.add(tempRes);
                }
            }

            double output = Collections.min(results);

            System.out.println("Campus #"+input+":");
            System.out.printf("Maximum territory area = %.3f\n\n", output);
        }
    }
    
    public static double distance(pointy a, pointy b)
    {
        return Math.sqrt((b.x - a.x) * (b.x - a.x) + (b.y - a.y) * (b.y - a.y));
    }
    
}

class pointy
{
    int x;
    int y;

    public pointy (int a, int b)
    {
        this.x = a;
        this.y = b;
    }
}
