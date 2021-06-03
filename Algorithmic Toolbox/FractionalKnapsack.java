import java.util.*;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0.0;
        int n=values.length;
        double ar[]=new double[n];
        for(int i=0;i<n;i++)
        ar[i]=((values[i]*1.0)/weights[i]);
        while(capacity>0){
            double max=0.0;
            int j=0;
            for(int i=0;i<n;i++){
                if(ar[i]>max){
                    max=ar[i];
                    j=i;
                }
            }
            int w=Math.min(weights[j],capacity);
            value+=(w*ar[j]);
            capacity-=w;
            ar[j]=0;
        }
        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
